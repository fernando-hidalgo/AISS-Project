package aiss.controller.Tumblr;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.TumblrResource;
import aiss.model.Tumblr.BlogInfo.BlogInfo;
import aiss.model.Tumblr.Likes.TumblrLikes;

public class BlogInfoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BlogInfoController.class.getName());
	
    public BlogInfoController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		log.log(Level.FINE, "Searching for Tumblr blogs that contain " + query);
		TumblrResource bi = new TumblrResource();
		BlogInfo biresult = bi.getBlogInfo(query);
		
		if(biresult!=null && biresult.getResponse().getBlog().getShareLikes()) {
			log.log(Level.FINE, "Searching for Tumblr likes that contain " + query);
			TumblrResource likes = new TumblrResource();
			TumblrLikes likesResult = likes.getLikes(query);

			if (biresult!=null && likesResult!=null){
				rd = request.getRequestDispatcher("/successBI.jsp");
				request.setAttribute("BlogInfo", biresult.getResponse().getBlog());
				request.setAttribute("TumblrLikes", likesResult.getResponse().getLikedCount());
			} else {
				log.log(Level.SEVERE, "Tumblr object: " + biresult);
				log.log(Level.SEVERE, "Tumblr object: " + likesResult);
				rd = request.getRequestDispatcher("/error.jsp");
			}
		}else {
			rd = request.getRequestDispatcher("/successBI.jsp");
			request.setAttribute("BlogInfo", biresult.getResponse().getBlog());
			request.setAttribute("TumblrLikes", "No puedes ver los likes de este usuario");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
