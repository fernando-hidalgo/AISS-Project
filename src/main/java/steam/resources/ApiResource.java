package steam.resources;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import steam.model.ResultadoRest;
public class ApiResource {
	
	private static final Logger log = Logger.getLogger(SteamResource.class.getName());
	
	//Resultado API Rest
	public List<ResultadoRest> getInformacion(String id) throws UnsupportedEncodingException{
		String n_juego = URLEncoder.encode(id, "UTF-8");
		
		log.log(Level.FINE, "Busqueda del usuario realizada satisfactoriamente");
		ResultadoRest [] gameSearch = null;
		
		try {
			ClientResource cr = new ClientResource("http://socialstats-2020.appspot.com/api/games?name="+n_juego);
			gameSearch = cr.get(ResultadoRest[].class);
		}catch (ResourceException e){
			System.err.println("Error al intentar obtener el juego");
			throw e;
		}
		   return Arrays.asList(gameSearch);
	}
}
