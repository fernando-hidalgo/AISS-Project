package aiss.controller.Tumblr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Tumblr.PostsByTag.PostsByTag;
import aiss.model.Tumblr.PostsByTag.Response;
import aiss.model.resources.TumblrResource;

public class SearchByTagController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SearchByTagController.class.getName());
	
	public SearchByTagController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = (String) request.getSession().getAttribute("nombre_juego");
		RequestDispatcher rd = null;
		
		log.log(Level.FINE, "Searching for Tumblr Posts that contain " + query);
		TumblrResource posts = new TumblrResource();
		PostsByTag postsResults=posts.getPostByTag(query);
		
		if (postsResults!=null){
			List<Response> pText=new ArrayList<Response>();
			List<Response> pPhoto=new ArrayList<Response>();
			List<Response> pVideo=new ArrayList<Response>();
			for(int i=0;i<postsResults.getResponse().size();i++) {
				String type=postsResults.getResponse().get(i).getType();
				if(type.equals("text")) {
					pText.add(postsResults.getResponse().get(i));
				}else if(type.equals("photo")) {
					pPhoto.add(postsResults.getResponse().get(i));
				} else if(type.equals("video")) {
					pVideo.add(postsResults.getResponse().get(i));
				}
			}
			rd = request.getRequestDispatcher("/successPBT.jsp");
			request.setAttribute("name", query);
			request.setAttribute("PText", pText);
			request.setAttribute("PPhoto", pPhoto);
			request.setAttribute("PVideo", pVideo);
//			request.setAttribute("Text", "text");
//			request.setAttribute("Photo", "photo");
//			request.setAttribute("Video", "video");
		} else {
			log.log(Level.SEVERE, "Tumblr object: " + postsResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
