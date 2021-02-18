package aiss.controller.oauth.Tumblr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.scribejava.apis.TumblrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

public class OAuth1Callback extends HttpServlet /*extends AbstractAuthorizationCodeCallbackServlet*/ {
	private static final long serialVersionUID = 1L;
//	private static Logger log=Logger.getLogger(OAuth1Callback.class.getName());
	
	private static final String MY_CONSUMER_KEY = "hY82rTRY0FiUNBCrZAbFHZf25eqQz3wGcsK2IBsEfT03Ve3Wld";
	private static final String MY_CONSUMER_SECRET = "NxK9F59cD4qPif136E6Hi5abC7xBiYGW3zjRwUHX0dBkIPs5Ve";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final OAuth10aService service = new ServiceBuilder(MY_CONSUMER_KEY).apiSecret(MY_CONSUMER_SECRET)
				//				.callback("http://www.tumblr.com/connect/login_success.html").build(TumblrApi.instance());
				.callback("http://localhost:8090/oauth1callback/Tumblr").build(TumblrApi.instance());
		
		try {

			System.out.println("=== Tumblr's OAuth Workflow (after user authorization)===");
			System.out.println();

			System.out.println("Fetching the oauth_verifier...");
			String oauthVerifier = request.getParameter("oauth_verifier");
			
			if(oauthVerifier==null || oauthVerifier.isEmpty()) {
				response.sendRedirect("/errorOauth1.jsp");
			}
			
			System.out.println("Got the oauth_verifier!: " + oauthVerifier);

			String token = (String) request.getSession().getAttribute(("requestToken"));
			String tokenSecret = (String) request.getSession().getAttribute(("requestTokenSecret"));
			String rawResponse = (String) request.getSession().getAttribute(("requestRawResponse"));

			System.out.println("Retrieving from session requestToken=: " + token);
			System.out.println("Retrieving from session requestTokenSecret=: " + tokenSecret);
			System.out.println("Retrieving from session requestRawResponse=: " + rawResponse);

			OAuth1RequestToken requestToken = new OAuth1RequestToken(token, tokenSecret, rawResponse);

			// Trade the Request Token and Verfier for the Access Token
			System.out.println("Trading the Request Token for an Access Token...");
			final OAuth1AccessToken accessToken = service.getAccessToken(requestToken, oauthVerifier);
			System.out.println("Got the Access Token!");
			System.out.println("(The raw response looks like this: " + accessToken.getRawResponse() + "')");
			System.out.println();

			System.out.println("Saving in session accessToken=: " + accessToken.getToken());
			System.out.println("Saving in session accessTokenSecret=: " + accessToken.getTokenSecret());
			System.out.println("Saving in session accessTokenRawResponse=: " + accessToken.getRawResponse());

			request.getSession().setAttribute(("accessToken"), accessToken.getToken());
			request.getSession().setAttribute(("accessTokenSecret"), accessToken.getTokenSecret());
			request.getSession().setAttribute(("accessTokenRawResponse"), accessToken.getRawResponse());

			// REDIRIGE AL USARIO AL SITIO QUE QUERIA ACCEDER
//			response.sendRedirect((String) request.getSession().getAttribute("resultadoLlamada"));
			response.sendRedirect("/indexTumblr.html");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

//	@Override
//	protected void onError(HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
//			throws ServletException, IOException {
//		log.warning("ERROR on OAuth Callback! "+errorResponse.getCode()+": "+errorResponse.getError()+". "+errorResponse.getErrorDescription());
//		resp.getWriter().append("ERROR!").append(errorResponse.getCode()).append(": ")
//		.append(errorResponse.getError()).append(errorResponse.getErrorDescription());
//	}
//
//	@Override
//	protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
//		log.log(Level.INFO, "ESTOY EN CALLBACK");
//		return OAuthRegistry.initializeFlow(getInitParameter("provider"));
//	}
//
//	@Override
//	protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
//		GenericUrl url = new GenericUrl(req.getRequestURL().toString());
//		url.setRawPath("http://localhost:8090/oauth1callback/Tumblr"+getInitParameter("provider"));
//		return url.build();
//	}
//
//	@Override
//	protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
//		return UUID.randomUUID().toString();
//	}
	
	
}
