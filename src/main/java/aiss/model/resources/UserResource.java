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

import aiss.model.Users.DatumMeUser;
import aiss.model.Users.DatumUsers;
import aiss.model.Users.MeUserSearch;
import aiss.model.Users.UserFollowSearch;
import aiss.model.Users.UserSearch;

public class UserResource {
    private static final String API_KEY = "k91k14kjbhma8gc3srtu1mrh8ss1y2";
    private static final Logger log = Logger.getLogger(UserResource.class.getName());
    private String access_token = "";
    public UserResource(String access_token) {
        this.access_token = access_token;
    }
    public UserSearch getUser(String query) throws UnsupportedEncodingException {
    	
        String queryFormatted = URLEncoder.encode(query, "UTF-8");
        String uri = "https://api.twitch.tv/helix/users" + "?login=" + queryFormatted;
        log.log(Level.FINE, "URI: " + uri);
        
        ClientResource cr = null;
        UserSearch userSearch = null;
        
        try {
        	cr = new ClientResource(uri);
            addHeader(cr, "Client-ID", API_KEY);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
            userSearch = cr.get(UserSearch.class);
            
        }catch (ResourceException re) {
    		System.err.println("Error getting the user; " + cr.getResponse().getStatus());
			throw re;
		}
        
        return userSearch;
    }
    
    public MeUserSearch getMeUser() throws UnsupportedEncodingException {
        
        String uri = "https://api.twitch.tv/helix/users";
        log.log(Level.FINE, "URI: " + uri);
        
        ClientResource cr = null;
        MeUserSearch MeUserSearch = null;
        
        try {
        	cr = new ClientResource(uri);
            addHeader(cr, "Client-ID", API_KEY);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
            MeUserSearch = cr.get(MeUserSearch.class);
            
        }catch (ResourceException re) {
    		System.err.println("Error getting the MeUser; " + cr.getResponse().getStatus());
			throw re;
		}
        
        return MeUserSearch;
    }
    
    public UserFollowSearch getSeguidores(String query) throws UnsupportedEncodingException {
        String queryFormatted = URLEncoder.encode(query, "UTF-8");
        String uri = "https://api.twitch.tv/helix/users/follows" + "?to_id=" + queryFormatted;
        log.log(Level.FINE, "URI: " + uri);
        
        ClientResource cr = null;
        UserFollowSearch userSearch = null;
        
        try {
        	cr = new ClientResource(uri);
            addHeader(cr, "Client-ID", API_KEY);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
            userSearch = cr.get(UserFollowSearch.class);
            
        }catch (ResourceException re) {
    		System.err.println("Error getting seguidores; " + cr.getResponse().getStatus());
			throw re;
		}
        
        return userSearch;
    }
    
    public UserFollowSearch getSeguidos(String query) throws UnsupportedEncodingException {
    	
        String queryFormatted = URLEncoder.encode(query, "UTF-8");
        String uri = "https://api.twitch.tv/helix/users/follows" + "?from_id=" + queryFormatted+"&first=100";
        log.log(Level.FINE, "URI: " + uri);
        
        ClientResource cr = null;
        UserFollowSearch userSearch = null;
        
        try {
        	cr = new ClientResource(uri);
            addHeader(cr, "Client-ID", API_KEY);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
            userSearch = cr.get(UserFollowSearch.class);
            
        }catch (ResourceException re) {
    		System.err.println("Error getting seguidos; " + cr.getResponse().getStatus());
			throw re;
		}
       
        return userSearch;
    }
    public boolean editUser(DatumMeUser datos) throws UnsupportedEncodingException {

        String uri = "https://api.twitch.tv/helix/users" + "?description=" + datos.getDescription();
        boolean result = true;
        ClientResource cr = null;
        log.log(Level.FINE, "URI: " + uri);
        
        try {
            cr = new ClientResource(uri);
            addHeader(cr, "Client-ID", API_KEY);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);
            cr.put(datos);
            
        } catch (ResourceException re) {
           
        	log.warning("Error when updating user: " + cr.getResponse().getStatus());
            result = false;
        }
        
        return result;
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
