package aiss.model.resources;

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import aiss.model.games.GameApiSearch;
import aiss.model.games.GameSearch;


public class GameResource {
	private static final String API_KEY = "k91k14kjbhma8gc3srtu1mrh8ss1y2";
    private static final Logger log = Logger.getLogger(UserResource.class.getName());
    private String access_token = "";
    public GameResource(String access_token) {
        this.access_token = access_token;
    }
    
    public GameSearch getGame(String query, String type) throws UnsupportedEncodingException {
        
    	String queryFormatted = URLEncoder.encode(query, "UTF-8");
        String uri = "https://api.twitch.tv/helix/games" + "?"+type +"=" + queryFormatted;
        log.log(Level.FINE, "URI: " + uri);
        
        ClientResource cr = null;
        GameSearch gameSearch = null;
        
        try {
        	cr = new ClientResource(uri);
            addHeader(cr, "Client-ID", API_KEY);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
            gameSearch = cr.get(GameSearch.class);
            
        }catch (ResourceException re) {
    		System.err.println("Error getting game from "+type+"; " + cr.getResponse().getStatus());
			throw re;
		}
        
         
        return gameSearch;
    }
    
public List<GameApiSearch> getGameData(String query) throws UnsupportedEncodingException {
        
    	String queryFormatted = URLEncoder.encode(query, "UTF-8");
        String uri = "http://socialstats-2020.appspot.com/api/games?name="+ queryFormatted;
        log.log(Level.FINE, "URI: " + uri);
        
        ClientResource cr = null;
        GameApiSearch [] gameSearch = null;
        
        try {
        	cr = new ClientResource(uri);
            addHeader(cr, "Client-ID", API_KEY);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
            gameSearch = cr.get(GameApiSearch[].class);
            
        }catch (ResourceException re) {
    		System.err.println("Error getting game from name: "+query+"; " + cr.getResponse().getStatus());
			throw re;
		}
        
         
        return Arrays.asList(gameSearch);
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
