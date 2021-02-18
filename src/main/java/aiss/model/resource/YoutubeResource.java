package aiss.model.resource;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.Channel;
public class YoutubeResource {
	
	
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	private final String access_token;
	private final String uri = "https://www.googleapis.com/youtube/v3/";
	
	public YoutubeResource(String token) {
		this.access_token = token;
	}

	public Channel getChannel() {
        ClientResource cr = null;
        Channel channel = null;
        try {
        	String query = uri + "channels?access_token=" + access_token +"&part=snippet,statistics&mine=true";
            cr = new ClientResource(query);
            channel = cr.get(Channel.class);

        } catch (ResourceException re) {
            log.warning("Error when retrieving channel: " + cr.getResponse().getStatus());
        }
        return channel;
	}
	
	
}
