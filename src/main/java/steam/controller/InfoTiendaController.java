package steam.controller;
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

import steam.model.AchievementTienda;
import steam.model.AchievementsGlobal;
import steam.model.InfoTienda;
import steam.model.NewNotes;
import steam.model.ResultadoRest;
import steam.resources.ApiResource;
import steam.resources.SteamResource;
/**
 * Servlet implementation class SearchController
 */
public class InfoTiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(InfoTiendaController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoTiendaController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//String query = request.getParameter("id_buscado");
		String query = (String) request.getSession().getAttribute("nombre_juego");
		RequestDispatcher rd = null;
		ApiResource api_resource = new ApiResource();
		List<ResultadoRest> info_api = new ArrayList<ResultadoRest>();

        if(query!=null) {
            info_api = api_resource.getInformacion(query);
        }
		
		if(info_api.isEmpty()) {
			rd = request.getRequestDispatcher("/error_vacio.jsp");
		}else {
			String id_steam = info_api.get(0).getIdSteam();
			
			// Search for store info of game in Steam
			SteamResource steam_resource = new SteamResource();
			InfoTienda info = steam_resource.getInformacionT(id_steam);
			
			//Search for news of game in Steam
			NewNotes noticias = steam_resource.getNoticias(id_steam);
			
			//Search for global achievements stats for game
			AchievementsGlobal porcentaje_logros = new AchievementsGlobal();
			int size;
			try {
				porcentaje_logros = steam_resource.getPocentajeLogros(id_steam);
				size =  porcentaje_logros.getAchievementpercentages().getAchievements().size();
			} catch (Exception e) {
				size=0;
			}
			
			//Bindeo de parametros y redireccion a success o error
			if (info!=null && noticias!=null && porcentaje_logros!=null){
				rd = request.getRequestDispatcher("/success3.jsp");
				request.setAttribute("id", info.getAppid());
				request.setAttribute("nombre", info.getName());
				request.setAttribute("developer", info.getDeveloper());
				request.setAttribute("reviews_positivas", info.getPositive());
				request.setAttribute("reviews_negativas", info.getNegative());
				request.setAttribute("propietarios", info.getOwners());
				
				Double precio = Double.parseDouble(info.getPrice())/100;
				if(precio==0.0) {
					request.setAttribute("precio", "Gratis");
				}else {
					request.setAttribute("precio", precio+"€");
				}
				
				request.setAttribute("idiomas", info.getLanguages());
				request.setAttribute("generos", info.getGenre());
				request.setAttribute("generos", info.getGenre());
				request.setAttribute("lista_noticias", noticias.getAppnews().getNewsitems());
				
				if(size>0) {
					List<AchievementTienda> logros = porcentaje_logros.getAchievementpercentages().getAchievements();
					request.setAttribute("nombre_mas_porc", logros.get(0).getName());
					request.setAttribute("numero_mas_porc", round(logros.get(0).getPercent(), 2)+"%");
					request.setAttribute("nombre_menos_porc", logros.get(size-1).getName());
					request.setAttribute("numero_menos_porc", round(logros.get(size-1).getPercent(), 2)+"%");
				}else {
					request.setAttribute("nombre_mas_porc", "No encontrado");
					request.setAttribute("numero_mas_porc", "No encontrado");
					request.setAttribute("nombre_menos_porc", "No encontrado");
					request.setAttribute("numero_menos_porc", "No encontrado");
				}
			}else{
				log.log(Level.SEVERE, "ERROR : " + info);
				rd = request.getRequestDispatcher("/error.jsp");
			}
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}