package aiss.model.resources;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;

import aiss.model.Tumblr.BlogFollowers.BlogFollowers;
import aiss.model.Tumblr.BlogInfo.BlogInfo;
import aiss.model.Tumblr.Likes.TumblrLikes;
import aiss.model.Tumblr.Posts.UserPosts;
import aiss.model.Tumblr.PostsByTag.PostsByTag;
import aiss.model.Tumblr.UserFollowings.UserFollowings;
import aiss.model.Tumblr.UserInfo.UserInfo;

public class TumblrResource {

	private static final String TUMBLR_API_KEY="hY82rTRY0FiUNBCrZAbFHZf25eqQz3wGcsK2IBsEfT03Ve3Wld";
	private static final Logger Log=Logger.getLogger(TumblrResource.class.getName());
	
	public BlogInfo getBlogInfo(String query) throws UnsupportedEncodingException {
		String queryFormatted=URLEncoder.encode(query, "UTF-8");
		String uri="http://api.tumblr.com/v2/blog/"+queryFormatted+".tumblr.com/info?api_key="+TUMBLR_API_KEY;
		
		Log.log(Level.FINE,"Tumblr URI: "+uri);
		
		ClientResource cr=new ClientResource(uri);
		BlogInfo blogInf=cr.get(BlogInfo.class);
		return blogInf;
	}
	
	public TumblrLikes getLikes(String query) throws UnsupportedEncodingException {
		String queryFormatted=URLEncoder.encode(query, "UTF-8");
		String uri="http://api.tumblr.com/v2/blog/"+queryFormatted+".tumblr.com/likes?api_key="+TUMBLR_API_KEY;
		
		Log.log(Level.FINE,"Tumblr URI: "+uri);
		
		ClientResource cr=new ClientResource(uri);
		TumblrLikes likes=cr.get(TumblrLikes.class);
		return likes;
	}
	
	public UserPosts getAllPosts(String user, String type, String tag) throws UnsupportedEncodingException {
		String userFormatted=URLEncoder.encode(user, "UTF-8");
		String typeFormatted=URLEncoder.encode(type, "UTF-8");
		String tagFormatted=URLEncoder.encode(tag, "UTF-8");
		
		String uri="http://api.tumblr.com/v2/blog/"+userFormatted+".tumblr.com/posts/"
				+typeFormatted+"?api_key="+TUMBLR_API_KEY;

		if(!tagFormatted.equals("")) {
			uri="http://api.tumblr.com/v2/blog/"+userFormatted+".tumblr.com/posts/"
					+typeFormatted+"?api_key="+TUMBLR_API_KEY+"&tag="+tagFormatted;
		}		
		
		Log.log(Level.FINE,"Tumblr URI: "+uri);
		
		ClientResource cr=new ClientResource(uri);
		UserPosts posts=cr.get(UserPosts.class);
		return posts;
	}
	
	public PostsByTag getPostByTag(String tag) throws UnsupportedEncodingException {
		String tagFormatted=URLEncoder.encode(tag, "UTF-8");
		String uri="http://api.tumblr.com/v2/tagged?tag="+tagFormatted+"&api_key="+TUMBLR_API_KEY+"&filter=text";
		
		Log.log(Level.FINE,"Tumblr URI: "+uri);
		
		ClientResource cr=new ClientResource(uri);
		PostsByTag posts=cr.get(PostsByTag.class);
		return posts;
	}
	
	public UserInfo getUserInfo(OAuth1AccessToken myAccessToken, OAuth10aService service) throws IOException {
		String PROTECTED_URL_GET_USER="https://api.tumblr.com/v2/user/info";

		System.out.println("Now we're going to access a protected resource...");
		final OAuthRequest req = new OAuthRequest(Verb.GET, PROTECTED_URL_GET_USER);
		service.signRequest(myAccessToken, req);
		try (Response res = service.execute(req)) {
			System.out.println("Got it! Lets see what we found...");
			System.out.println();
			System.out.println(res.getBody());

			// Definimos ObjectMapper para extraer el cuerpo de la respuesta:
			ObjectMapper mapper = new ObjectMapper();
			// Extraemos el cuerpo de la respuesta:
			JsonNode jsonNode = mapper.readTree(res.getBody());
			// Y lo convertimos en cadena de texto
			String JSONContent = jsonNode.toString();
			// Finalmente, usamos otro ObjectMapper para convertir el texto en objecto Java
			ObjectMapper mapper2 = new ObjectMapper();
			UserInfo user = mapper2.readValue(JSONContent, UserInfo.class);
			
			return user;

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UserFollowings getUserFollowings(OAuth1AccessToken myAccessToken, OAuth10aService service) throws IOException {
		String PROTECTED_URL_GET_USER="https://api.tumblr.com/v2/user/following";

		System.out.println("Now we're going to access a protected resource...");
		final OAuthRequest req = new OAuthRequest(Verb.GET, PROTECTED_URL_GET_USER);
		service.signRequest(myAccessToken, req);
		try (Response res = service.execute(req)) {
			System.out.println("Got it! Lets see what we found...");
			System.out.println();
			System.out.println(res.getBody());
			
			// Definimos ObjectMapper para extraer el cuerpo de la respuesta:
			ObjectMapper mapper = new ObjectMapper();
			// Extraemos el cuerpo de la respuesta:
			JsonNode jsonNode = mapper.readTree(res.getBody());
			// Y lo convertimos en cadena de texto
			String JSONContent = jsonNode.toString();
			// Finalmente, usamos otro ObjectMapper para convertir el texto en objecto Java
			ObjectMapper mapper2 = new ObjectMapper();
			UserFollowings followings = mapper2.readValue(JSONContent, UserFollowings.class);
			
			return followings;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public BlogFollowers getBlogFollowers(OAuth1AccessToken myAccessToken, OAuth10aService service, String query) throws JsonMappingException, JsonProcessingException, IOException {
		String queryFormatted=URLEncoder.encode(query, "UTF-8");
		
		String PROTECTED_URL_GET_USER="https://api.tumblr.com/v2/blog/"+queryFormatted+"/followers";

		System.out.println("Now we're going to access a protected resource...");
		final OAuthRequest req = new OAuthRequest(Verb.GET, PROTECTED_URL_GET_USER);
		service.signRequest(myAccessToken, req);
		try (Response res = service.execute(req)) {
			System.out.println("Got it! Lets see what we found...");
			System.out.println();
			System.out.println(res.getBody());
			
			// Definimos ObjectMapper para extraer el cuerpo de la respuesta:
			ObjectMapper mapper = new ObjectMapper();
			// Extraemos el cuerpo de la respuesta:
			JsonNode jsonNode = mapper.readTree(res.getBody());
			// Y lo convertimos en cadena de texto
			String JSONContent = jsonNode.toString();
			// Finalmente, usamos otro ObjectMapper para convertir el texto en objecto Java
			ObjectMapper mapper2 = new ObjectMapper();
			BlogFollowers followers = mapper2.readValue(JSONContent, BlogFollowers.class);
			
			return followers;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
