package aiss.api.resources;

import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorNameGame;
import aiss.api.resources.comparators.ComparatorNameGameReverse;
import aiss.api.resources.comparators.ComparatorGeneroGame;
import aiss.api.resources.comparators.ComparatorGeneroGameReverse;
import aiss.model.api.Game;
import aiss.model.repository.GameShopRepository;
import aiss.model.repository.MapGameShopRepository;


import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Path("/games")
public class GameResource {

	public static GameResource _instance=null;
	GameShopRepository repository;
	
	private GameResource(){
		repository=MapGameShopRepository.getInstance();
	}
	
	public static GameResource getInstance()
	{
		if(_instance==null)
			_instance=new GameResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Game> getAllGames(@QueryParam("order") String order, @QueryParam("q") String q, @QueryParam("name") String name)
	{
		 List<Game> result = new ArrayList<Game>();
         
	        for (Game game: repository.getAllGames()) {
	            if(		(q == null && name == null) 
	            		||q!=null && game.getName()!=null && game.getName().toLowerCase().contains(q.toLowerCase()) 
	            		||q!=null && game.getAñoLanzamiento()!=null && game.getAñoLanzamiento().contains(q.toLowerCase())
	            		||q!=null && game.getDesarrollador()!=null && game.getDesarrollador().contains(q.toLowerCase())
	            		||q!=null && game.getModoDeJuego()!=null && game.getModoDeJuego().contains(q.toLowerCase())
	            		||q!=null && game.getEdadRecomendada()!=null && game.getEdadRecomendada().contains(q.toLowerCase())
	            		||q!=null && game.getGenero()!=null && game.getGenero().contains(q.toLowerCase() )
	            		||name!= null && game.getName()!=null && game.getName().toLowerCase().contains(name.toLowerCase()) ){
	            			
	            	result.add(game);
	            }
	        }
	            
	        if (order != null) { // Order results
	            if (order.equals("name")) {
	                Collections.sort(result, new ComparatorNameGame());
	            } else if (order.equals("-name")) {
	                Collections.sort(result, new ComparatorNameGameReverse());
	            } else if (order.equals("genero")){
	            	Collections.sort(result, new ComparatorGeneroGame());
	            } else if (order.equals("-genero")){
	            	Collections.sort(result, new ComparatorGeneroGameReverse());
	            }
	            else {
	                throw new BadRequestException("The order parameter must be 'desarrollador' or '-desarrollador' or 'genero' or '-genero'.");
	            }
	        }

	        return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Game getGame(@PathParam("id") String gameId)
	{
		Game list = repository.getGame(gameId);
		
		if(list==null) {
			throw new NotFoundException("The game with id= " + gameId +" was nor found");
		}
		return list;
	}
		
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo, Game game) {
		
		if (game.getName() == null || "".equals(game.getName()))
			throw new BadRequestException("The name of the game must not be null");

		repository.addGame(game);

		// Builds the response. Returns the game the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(game.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(game);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateGame(Game game) {
		
		Game oldGame = repository.getGame(game.getId());
		if (oldGame == null) {
			throw new NotFoundException("The game shop with id="+ game.getId() +" was not found");			
		}
		
		// Update name
		if (game.getName()!=null)
			oldGame.setName(game.getName());
		
		// Update añoLanzamiento
				if (game.getAñoLanzamiento()!=null)
					oldGame.setAñoLanzamiento(game.getAñoLanzamiento());
		// Update desarrollador
				if (game.getDesarrollador()!=null)
					oldGame.setDesarrollador(game.getDesarrollador());
		// Update edad recomendada
				if (game.getEdadRecomendada()!=null)
					oldGame.setEdadRecomendada(game.getEdadRecomendada());
		// Update genero
				if (game.getGenero()!=null)
					oldGame.setGenero(game.getGenero());
		// Update modo de juego
				if (game.getModoDeJuego()!=null)
					oldGame.setModoDeJuego(game.getModoDeJuego());
		// Update id_twitch
				if (game.getIdTwitch()!=null)
					oldGame.setIdTwitch(game.getIdTwitch());
		// Update id_steam
				if (game.getIdSteam()!=null)
					oldGame.setIdSteam(game.getIdSteam());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeGame(@PathParam("id") String gameId) {
		Game toberemoved=repository.getGame(gameId);
		if (toberemoved == null)
			throw new NotFoundException("The game shop with id="+ gameId +" was not found");
		else
			repository.deleteGame(gameId);
		
		return Response.noContent().build();
	}
	
}
