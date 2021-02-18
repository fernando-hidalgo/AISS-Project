package aiss.controller.oauth.Tumblr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.scribejava.apis.TumblrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

public class GenericAuth1Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
//	private static Logger log=Logger.getLogger(GenericAuth1Controller.class.getName());

	private static final String MY_CONSUMER_KEY = "hY82rTRY0FiUNBCrZAbFHZf25eqQz3wGcsK2IBsEfT03Ve3Wld";
	private static final String MY_CONSUMER_SECRET = "NxK9F59cD4qPif136E6Hi5abC7xBiYGW3zjRwUHX0dBkIPs5Ve";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final OAuth10aService service = new ServiceBuilder(MY_CONSUMER_KEY).apiSecret(MY_CONSUMER_SECRET)
				//				.callback("http://www.tumblr.com/connect/login_success.html").build(TumblrApi.instance());
				.callback("http://localhost:8090/oauth1callback/Tumblr").build(TumblrApi.instance());
		
		// ESTE CODIGO IRIA EN CUALQUIER RECURSO QUE NECESITE OAUTH

		// ES LA PRIMERA LLAMADA (EL USUARIO AUN NO HA AUTORIZADO NADA)
		try {
			System.out
			.println("=== Tumblr's OAuth Workflow (generating redirect uri for user authorization)===");
			System.out.println();

			// Obtain the Request Token
			System.out.println("Fetching the Request Token...");
			final OAuth1RequestToken requestToken = service.getRequestToken();

			System.out.println("Got the Request Token!");
			System.out.println();

			System.out.println("Now go and authorize ScribeJava here:");
			System.out.println(service.getAuthorizationUrl(requestToken));

			System.out.println("Saving in session requestToken=: " + requestToken.getToken());
			System.out.println("Saving in session requestTokenSecret=: " + requestToken.getTokenSecret());
			System.out.println("Saving in session requestRawResponse=: " + requestToken.getRawResponse());

			request.getSession().setAttribute(("requestToken"), requestToken.getToken());
			request.getSession().setAttribute(("requestTokenSecret"), requestToken.getTokenSecret());
			request.getSession().setAttribute(("requestRawResponse"), requestToken.getRawResponse());
			
			response.sendRedirect(service.getAuthorizationUrl(requestToken));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
//		log.log(Level.INFO, "ESTOY EN OAUTH 1 CONTROLLER");
//		return OAuthRegistry.initializeFlow(getInitParameter("provider"));
//	}
//
//	@Override
//	protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
//		String provider=getInitParameter("provider");
//		GenericUrl url = new GenericUrl(req.getRequestURL().toString());
//		url.setRawPath("/oauth1callback/"+provider);
//		return url.build();
//	}
//
//	@Override
//	protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
//		return UUID.randomUUID().toString();
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
