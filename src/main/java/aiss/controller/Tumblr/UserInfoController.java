package aiss.controller.Tumblr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.apis.TumblrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;

import aiss.model.Tumblr.BlogFollowers.BlogFollowers;
import aiss.model.Tumblr.UserFollowings.UserFollowings;
import aiss.model.Tumblr.UserInfo.Blog;
import aiss.model.Tumblr.UserInfo.UserInfo;
import aiss.model.resources.TumblrResource;

//import aiss.controller.oauth.OAuth2Callback;
//import aiss.model.Resources.TumblrResource;
//import aiss.model.Tumblr.UserInfo.UserInfo;
//import aiss.utility.OAuthRegistry;

public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(UserInfoController.class.getName());

//	private static final String AUTHORIZE_URL = "https://www.tumblr.com/oauth/authorize";
//	private static final String REQUEST_TOKEN_URL = "https://www.tumblr.com/oauth/request_token";
//	private static final String ACCESS_TOKEN_URL = "https://www.tumblr.com/oauth/access_token";

	private static final String MY_CONSUMER_KEY = "hY82rTRY0FiUNBCrZAbFHZf25eqQz3wGcsK2IBsEfT03Ve3Wld";
	private static final String MY_CONSUMER_SECRET = "NxK9F59cD4qPif136E6Hi5abC7xBiYGW3zjRwUHX0dBkIPs5Ve";

	private static final String PROTECTED_URL_GET_USER = "https://api.tumblr.com/v2/user/info";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final OAuth10aService service = new ServiceBuilder(MY_CONSUMER_KEY).apiSecret(MY_CONSUMER_SECRET)
//				.callback("http://www.tumblr.com/connect/login_success.html").build(TumblrApi.instance());
		 .callback("http://localhost:8090/oauth1callback/Tumblr").build(TumblrApi.instance());

		// ESTE CODIGO IRIA EN CUALQUIER RECURSO QUE NECESITE OAUTH

		String accessTokenSession = (String) request.getSession().getAttribute(("accessToken"));
		String accessTokenSecretSession = (String) request.getSession().getAttribute(("accessTokenSecret"));
		String accessTokenRawResponseSession = (String) request.getSession().getAttribute(("accessTokenRawResponse"));

		System.out.println("Retrieving from session accessToken=: " + accessTokenSession);
		System.out.println("Retrieving from session accessTokenSecret=: " + accessTokenSecretSession);
		System.out.println("Retrieving from session accessTokenRawResponse=: " + accessTokenRawResponseSession);
		
		request.getSession().setAttribute(("resultadoLlamada"), "/UserInfoController");

		// NO HAY TOKEN Y, POR TANTO HAY QUE PEDIRLO
		if ((accessTokenSession == null || accessTokenSession.isEmpty())
				|| (accessTokenSecretSession == null || accessTokenSecretSession.isEmpty())
				|| (accessTokenRawResponseSession == null || accessTokenRawResponseSession.isEmpty())) {
			System.out.println("=== Tumblr's OAuth Workflow (no accesstoken)===");
			
			response.sendRedirect("/oauth1controller/Tumblr");
//
//			// SI HAY TOKEN Y PODEMOS HACER LA PETICION
		} else {

			// Now let's go and ask for a protected resource!
			final OAuth1AccessToken myAccessToken = new OAuth1AccessToken(accessTokenSession, accessTokenSecretSession,
					accessTokenRawResponseSession);

//			System.out.println("Now we're going to access a protected resource...");
//			final OAuthRequest req = new OAuthRequest(Verb.GET, PROTECTED_URL_GET_USER);
//			service.signRequest(myAccessToken, req);
//			try (Response res = service.execute(req)) {
//				System.out.println("Got it! Lets see what we found...");
//				System.out.println();
//				System.out.println(res.getBody());
			
			try {
				TumblrResource tumblrRes=new TumblrResource();
				UserInfo user = tumblrRes.getUserInfo(myAccessToken,service);
				UserFollowings followings = tumblrRes.getUserFollowings(myAccessToken, service);
				
				Long total_post=(long) 0;
				
				List<String> myBlogs=new ArrayList<String>();
				for(int i=0;i<user.getResponse().getUser().getBlogs().size();i++) {
					List<Blog> blogs=user.getResponse().getUser().getBlogs();
					total_post+=blogs.get(i).getTotalPosts();
					myBlogs.add(blogs.get(i).getName());
				}
				
				Long total_followers=(long) 0;
				List<String> followers=new ArrayList<String>();
				for(int i=0;i<myBlogs.size();i++) {
					TumblrResource tumblrResAux=new TumblrResource();
					BlogFollowers fAux=tumblrResAux.getBlogFollowers(myAccessToken, service, myBlogs.get(i));
					total_followers+=fAux.getResponse().getTotalUsers();
					for(int j=0;j<fAux.getResponse().getUsers().size();j++) {
						followers.add(fAux.getResponse().getUsers().get(j).getName());
					}
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/successU.jsp");
				request.setAttribute("User", user.getResponse().getUser());
				request.setAttribute("Avatar", user.getResponse().getUser().getBlogs().get(0).getAvatar().get(1).getUrl());
				request.setAttribute("totalPosts", total_post);
				request.setAttribute("Followings", followings.getResponse());
				request.setAttribute("totalFollowers", total_followers);
//				request.setAttribute("Followers", followers);
				request.setAttribute("Followers", followers);

				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
