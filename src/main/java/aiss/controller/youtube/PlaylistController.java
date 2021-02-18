package aiss.controller.youtube;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restlet.representation.Representation;

import aiss.model.playlist.Playlist;
import aiss.model.resource.PlaylistResource;

public class PlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(PlaylistController.class.getName());

	public PlaylistController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
		
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		
		if (accessToken != null && !"".equals(accessToken)) {

			PlaylistResource playlistResource = new PlaylistResource(accessToken);
			String videoId = (String) request.getParameter("videoID");
			Playlist playlist = playlistResource.getPlaylist();
			String playlistID = playlistResource.getFavoritePlaylistId();
			if(!playlistResource.favoriteExists(playlist)) {
				Playlist pp = playlistResource.addFavoritePlaylist();
				playlistID = pp.getId();
			}
			
			Representation representation = playlistResource.addVideoPlaylist(playlistID,videoId);
			if (representation != null) {
				log.info("Successfully added to Favorite playlist!");
				request.getRequestDispatcher("/InfoTiendaController").forward(request, response);
			} else {
				log.info("The representation returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
			}
		} else {
			log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
			request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
		}
	}catch (Exception e) {
		log.info("La cuenta no tiene canal de youtube");
		request.getRequestDispatcher("/Error").forward(request, response);
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
