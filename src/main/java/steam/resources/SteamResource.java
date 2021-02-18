package steam.resources;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import steam.model.AchievementsGlobal;
import steam.model.InfoTienda;
import steam.model.NewNotes;

public class SteamResource {
	private static final String STEAM_API_KEY = "A8B9C6112FA70DDD5D34725920BFAA5B";		// TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(SteamResource.class.getName());
		
		//Info de la tienda de un juego
		public InfoTienda getInformacionT(String id)  throws UnsupportedEncodingException{
			String game = URLEncoder.encode(id, "UTF-8");
			ClientResource cr = new ClientResource("https://steamspy.com/api.php?request=appdetails&appid="+game);
			InfoTienda resultado = cr.get(InfoTienda.class);
			log.log(Level.FINE, "Busqueda del juego en la tienda realizada satisfactoriamente");
			return resultado;
		}
	
		//Ultimas noticias del juego
		public NewNotes getNoticias(String id)  throws UnsupportedEncodingException{
			String game = URLEncoder.encode(id, "UTF-8");
			ClientResource cr = new ClientResource("http://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/?appid="+game+"&count=5&maxlength=1000");
			NewNotes resultado = cr.get(NewNotes.class);
			log.log(Level.FINE, "Busqueda de las noticias del juego realizada satisfactoriamente");
			return resultado;
		}
		
		//Porcentaje global de obtención de logros de un juego
		public AchievementsGlobal getPocentajeLogros(String id)  throws UnsupportedEncodingException{
			String game = URLEncoder.encode(id, "UTF-8");
			ClientResource cr = new ClientResource("http://api.steampowered.com/ISteamUserStats/GetGlobalAchievementPercentagesForApp/v0002/?gameid="+game);
			AchievementsGlobal resultado = cr.get(AchievementsGlobal.class);
			log.log(Level.FINE, "Busqueda del porcentaje global de logros del juego realizada satisfactoriamente");
			return resultado;
		}
	
	
	
}

