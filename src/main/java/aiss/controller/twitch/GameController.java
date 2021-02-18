package aiss.controller.twitch;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Users.MeUserSearch;
import aiss.model.clips.ClipCreation;
import aiss.model.clips.ClipSearch;
import aiss.model.clips.DatumClipCreation;
import aiss.model.games.GameApiSearch;
import aiss.model.games.GameSearch;
import aiss.model.resources.ClipResource;
import aiss.model.resources.GameResource;
import aiss.model.resources.StreamResource;
import aiss.model.resources.SubsResource;
import aiss.model.resources.UserResource;
import aiss.model.resources.VideoResource;
import aiss.model.streams.StreamSearch;
import aiss.model.subcribers.SubcribersSearch;
import aiss.model.videos.VideoSearch;

/**
 * Servlet implementation class SearchController
 */
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(GameController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String accessToken = (String) request.getSession().getAttribute("Twitch-token");
		String query = (String) request.getSession().getAttribute("nombre_juego");
		RequestDispatcher rd = null;
		
		if (accessToken != null && !"".equals(accessToken)) {
			
			// Search for movies in OMDb
			log.log(Level.FINE, "Searching for user with name");
			GameResource game = new GameResource(accessToken);
			StreamResource stream = new StreamResource(accessToken);
			VideoResource video = new VideoResource(accessToken);
			ClipResource clip = new ClipResource(accessToken);
			
			List<GameApiSearch> gameApiResults = game.getGameData(query);
			
			if(gameApiResults != null && gameApiResults.size()>0) {
				String gameName = gameApiResults.get(0).getName();
				String gameIdTwitch = gameApiResults.get(0).getIdTwitch();
				if(gameIdTwitch != null && gameName != null) {
				log.log(Level.SEVERE, "Game id: " + gameIdTwitch);
				GameSearch gameResults = game.getGame(gameName, "name");
				StreamSearch streamResults = stream.getStreamsFromGameId(gameIdTwitch);
				VideoSearch videoResults = video.getVideos(gameIdTwitch, "?game_id=");
				VideoSearch videoTopsResults = video.getVideos(gameIdTwitch, "?sort=views&game_id=");
				ClipSearch clipResults = clip.getClip(gameIdTwitch, "game_id");
			
			if (gameResults!=null && streamResults!=null && videoResults!=null && videoTopsResults!=null && clipResults!=null){
				
			String foto = gameResults.getData().get(0).getBoxArtUrl().replace("{width}", "150");
			foto = foto.replace("{height}", "150");
			gameResults.getData().get(0).setBoxArtUrl(foto);
			
			
			request.setAttribute("datosApi", gameApiResults.get(0).getName());
			request.setAttribute("datosClip", clipResults.getData());
			request.setAttribute("datosVideos", videoResults.getData());
			request.setAttribute("datosVideosTop", videoTopsResults.getData());
			request.setAttribute("datosStream", streamResults.getData());
			request.setAttribute("datosGame", gameResults.getData());
			
			rd = request.getRequestDispatcher("/successGames.jsp");
			} else {
				log.log(Level.SEVERE, "OMDb object: " + gameResults);
				rd = request.getRequestDispatcher("/errorTwitch.jsp");
			}
			}else {
					log.log(Level.SEVERE, "El nombre de juego: " + gameApiResults + " no se encuentra en el repositorio busque otro");
					rd = request.getRequestDispatcher("/errorTwitch.jsp");
			}
			}else {
				log.log(Level.SEVERE, "El nombre de juego: " + gameApiResults + " no se encuentra en el repositorio busque otro");
				rd = request.getRequestDispatcher("/errorTwitch.jsp");
			}
			rd.forward(request, response);
		} else {
			log.info("Trying to access Twitch without an access token, redirecting to OAuth servlet");
			request.getRequestDispatcher("/AuthController/Twitch").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
