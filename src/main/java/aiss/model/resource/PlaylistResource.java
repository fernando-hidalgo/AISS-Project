package aiss.model.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.playlist.Item;
import aiss.model.playlist.Playlist;
import aiss.model.youtube.Channel;

public class PlaylistResource {

	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	private final String access_token;
	private final String uri = "https://www.googleapis.com/youtube/v3/";

	public PlaylistResource(String token) {
		this.access_token = token;
	}

	public Playlist getPlaylist() {
		ClientResource cr = null;
		Playlist playlist = null;
		try {
			String query = uri + "playlists?access_token=" + access_token + "&part=snippet&mine=true";
			cr = new ClientResource(query);
			playlist = cr.get(Playlist.class);

		} catch (ResourceException re) {
			log.warning("Error when retrieving playlist: " + cr.getResponse().getStatus());
		}
		return playlist;
	}

	public Representation addVideoPlaylist(String idPlaylist, String idVideo) {
		ClientResource cr = null;
		Representation res = null;

		Map<String, Map<String, Object>> req = new HashMap<>();
		Map<String, Object> snippet = new HashMap<>();

		snippet.put("playlistId", idPlaylist);
		snippet.put("position", "0");

		Map<String, String> resourceId = new HashMap<>();

		resourceId.put("kind", "youtube#video");
		resourceId.put("kind", "youtube#video");
		resourceId.put("videoId", idVideo);

		snippet.put("resourceId", resourceId);

		req.put("snippet", snippet);

		JSONObject json = new JSONObject();
		json.putAll(req);

		String query = uri + "playlistItems?access_token=" + access_token + "&part=snippet";
		try {
			cr = new ClientResource(query);
			System.out.println(json);
			res = cr.post(json);
		} catch (ResourceException re) {
			log.warning("Error when adding video to playlist: " + cr.getResponse().getStatus());
		}
		return res;
	}

	public String getFavoritePlaylistId() {

		ClientResource cr = null;
		String favorite = null;
		String query = uri + "playlists?access_token=" + access_token + "&part=snippet&mine=true";
		try {
			cr = new ClientResource(query);
			Playlist playlist = cr.get(Playlist.class);
			for (Item item : playlist.getItems()) {
				System.out.println(item.getSnippet().getTitle());
				if (item.getSnippet().getTitle().equals("Favorites")) {
					System.out.println("funciona");
					favorite = item.getId();
				}
			}
		} catch (ResourceException re) {
			log.warning("Error when retrieving favorite playlistID: " + cr.getResponse().getStatus());
		}
		return favorite;
	}

	public Playlist addFavoritePlaylist() {
		ClientResource cr = null;
		Playlist res = null;
		Map<String, String> snippet = new HashMap<>();
		snippet.put("title", "Favorites");
		Map<String, Map<String, String>> mapa = new HashMap<>();
		mapa.put("snippet", snippet);

		JSONObject json = new JSONObject();
		json.putAll(mapa);
		String query = uri + "playlists?access_token=" + access_token + "&part=snippet";
		try {
			cr = new ClientResource(query);
			res = cr.post(json, Playlist.class);
		} catch (ResourceException re) {
			log.warning("Error creating Favorites playlist: " + cr.getResponse().getStatus());
		}
		return res;

	}

	public boolean favoriteExists(Playlist playlist) {
		boolean res = false;
		if (!(playlist.getItems() == null || playlist.getItems().isEmpty())) {
			for (Item item : playlist.getItems()) {
				String playlistName = item.getSnippet().getTitle();
				if (playlistName.equals("Favorites")) {
					res = true;
				}
			}
		}
		return res;
	}
}
