package aiss.model.resource;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.search.Search;

public class SearchResource {
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	private final String access_token;
	private final String uri = "https://www.googleapis.com/youtube/v3/search";

	public SearchResource(String token) {
		this.access_token = token;
	}
	
	public Search getSearch(String busqueda) {
		
		ClientResource cr = null;
		Search res = null;
		String query = uri + "?access_token=" + access_token + "&part=snippet&maxResults=5&q=" + busqueda;
		try {
			cr = new ClientResource(query);
			res = cr.get(Search.class);
		} catch (ResourceException re) {
			log.warning("Error when searching video: " + cr.getResponse().getStatus());
		}
		return res;
	}

}
