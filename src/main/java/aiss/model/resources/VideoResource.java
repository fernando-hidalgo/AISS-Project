package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import aiss.model.games.GameSearch;
import aiss.model.streams.StreamSearch;
import aiss.model.videos.VideoSearch;

public class VideoResource {
	private static final String API_KEY = "k91k14kjbhma8gc3srtu1mrh8ss1y2";
    private static final Logger log = Logger.getLogger(UserResource.class.getName());
    private String access_token = "";
    public VideoResource(String access_token) {
        this.access_token = access_token;
    }
    
    
    public VideoSearch getVideos(String query, String type) throws UnsupportedEncodingException {
       
    	String queryFormatted = URLEncoder.encode(query, "UTF-8");

    	 String uri = "https://api.twitch.tv/helix/videos" + type + queryFormatted+"&first=5";
        log.log(Level.FINE, "URI: " + uri);
        
        ClientResource cr = null;
        VideoSearch videoSearch = null;
        
        try {
        	cr = new ClientResource(uri);
            addHeader(cr, "Client-ID", API_KEY);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
            videoSearch = cr.get(VideoSearch.class);
            
        }catch (ResourceException re) {
    		System.err.println("Error getting video by UserId; " + cr.getResponse().getStatus());
			throw re;
		}
 
        return videoSearch;
    }
    
    

    
    @SuppressWarnings("unchecked")
    public void addHeader(ClientResource cr, String headerName, String headerValue) {
        Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
                .get(HeaderConstants.ATTRIBUTE_HEADERS);
        if (headers == null) {
            headers = new Series<Header>(Header.class);
            cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
        }
        headers.add(headerName, headerValue);
    }
}
