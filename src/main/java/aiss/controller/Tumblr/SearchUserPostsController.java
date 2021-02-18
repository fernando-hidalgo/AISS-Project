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
import aiss.model.Tumblr.Posts.UserPosts;

public class SearchUserPostsController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SearchUserPostsController.class.getName());
	
	public SearchUserPostsController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("UserQuery");
		String query2 = request.getParameter("TypeQuery");
		String query3 = request.getParameter("TagQuery");
		RequestDispatcher rd = null;
		
		log.log(Level.FINE, "Searching for Tumblr Posts that contain " + query);
		TumblrResource posts = new TumblrResource();
		UserPosts postsResults=posts.getAllPosts(query, query2, query3);
		
		if (postsResults!=null){
			rd = request.getRequestDispatcher("/successUP.jsp");
			request.setAttribute("UserPosts", postsResults.getResponse());
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
