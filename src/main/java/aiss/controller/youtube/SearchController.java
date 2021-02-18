package aiss.controller.youtube;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.SearchResource;
import aiss.model.resource.YoutubeResource;
import aiss.model.search.Search;
import aiss.model.youtube.Channel;
import aiss.model.youtube.High;
import aiss.model.youtube.Item;

public class SearchController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SearchController.class.getName());

	public SearchController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				String accessToken = (String) request.getSession().getAttribute("Youtube-token");
				if(request.getParameter("name") != null) {
					request.getSession().setAttribute("nombre_juego", request.getParameter("name"));
				}
				String query = (String) request.getSession().getAttribute("nombre_juego");
				if (accessToken != null && !"".equals(accessToken)) {
					
					YoutubeResource ytResource = new YoutubeResource(accessToken);
					SearchResource searchResource = new SearchResource(accessToken);
					Channel channel = ytResource.getChannel();
					Search search = searchResource.getSearch(query);
					
					if (channel != null && search != null) {
						String nombreCanal = channel.getItems().get(0).getSnippet().getTitle();
						request.setAttribute("nombreCanal", nombreCanal);
					
						Item propiedades = channel.getItems().get(0);
						
						High photo = propiedades.getSnippet().getThumbnails().getHigh();
						request.setAttribute("photo", photo);
		
						request.setAttribute("videos", search.getItems()); 
						
						request.getRequestDispatcher("/searchResults.jsp").forward(request, response);
					} else {
						log.info("The search returned is null... probably your token has experied. Redirecting to OAuth servlet.");
						request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
					}
				} else {
					log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
					request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
				}			
			}catch(Exception e) {
				System.out.println(e);
				log.warning("The account selected has no Youtube Channel created.");
				request.getRequestDispatcher("/Error").forward(request, response);
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
