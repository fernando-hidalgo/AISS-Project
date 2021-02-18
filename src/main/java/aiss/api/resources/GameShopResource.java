package aiss.api.resources;

import java.net.URI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorNameGameShop;
import aiss.api.resources.comparators.ComparatorNameGameShopReversed;
import aiss.model.api.Game;
import aiss.model.api.GameShop;
import aiss.model.repository.GameShopRepository;
import aiss.model.repository.MapGameShopRepository;


@Path("/gameShops")
public class GameShopResource {
	
	/* Singleton */
	private static GameShopResource _instance=null;
	GameShopRepository repository;
	
	private GameShopResource() {
		repository=MapGameShopRepository.getInstance();

	}
	
	public static GameShopResource getInstance()
	{
		if(_instance==null)
				_instance=new GameShopResource();
		return _instance;
	}
	
	
    @GET
    @Produces("application/json")
    public Collection<GameShop> getAll(@QueryParam("order") String order,
            @QueryParam("isEmpty") Boolean isEmpty, @QueryParam("name") String name)
    {
        List<GameShop> result = new ArrayList<GameShop>();
            
        for (GameShop gameShop: repository.getAllGameShops()) {
            if (name == null || gameShop.getName().equals(name)) { // Name filter
                if (isEmpty == null // Empty gameShop filter
                        || (isEmpty && (gameShop.getGames() == null || gameShop.getGames().size() == 0))
                        || (!isEmpty && (gameShop.getGames() != null && gameShop.getGames().size() > 0))) {
                    result.add(gameShop);
                }
            }
        }
            
        if (order != null) { // Order results
            if (order.equals("name")) {
                Collections.sort(result, new ComparatorNameGameShop());
            } else if (order.equals("-name")) {
                Collections.sort(result, new ComparatorNameGameShopReversed());
            } else {
                throw new BadRequestException("The order parameter must be 'name' or '-name'.");
            }
        }

        return result;
    }
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public GameShop getGameShop(@PathParam("id") String id)
	{
		GameShop list = repository.getGameShop(id);
		
		if (list == null) {
			throw new NotFoundException("The game shop with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGameShop(@Context UriInfo uriInfo, GameShop gameShop) {
		if (gameShop.getName() == null || "".equals(gameShop.getName()))
			throw new BadRequestException("The name of the game shop must not be null");
		
		if (gameShop.getGames()!=null)
			throw new BadRequestException("The games property is not editable.");

		repository.addGameShop(gameShop);

		// Builds the response. Returns the game shop the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(gameShop.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(gameShop);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateGameShop(GameShop gameShop) {
		GameShop oldGameShop = repository.getGameShop(gameShop.getId());
		if (oldGameShop == null) {
			throw new NotFoundException("The gameShop with id="+ gameShop.getId() +" was not found");			
		}
		
		if (gameShop.getGames()!=null)
			throw new BadRequestException("The games property is not editable.");
		
		// Update name
		if (gameShop.getName()!=null)
			oldGameShop.setName(gameShop.getName());
		
		// Update description
		if (gameShop.getDescription()!=null)
			oldGameShop.setDescription(gameShop.getDescription());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeGameShop(@PathParam("id") String id) {
		GameShop toberemoved=repository.getGameShop(id);
		if (toberemoved == null)
			throw new NotFoundException("The game shop with id="+ id +" was not found");
		else
			repository.deleteGameShop(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{gameShopId}/{gameId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo,@PathParam("gameShopId") String gameShopId, @PathParam("gameId") String gameId)
	{				
		
		GameShop gameShop = repository.getGameShop(gameShopId);
		Game song = repository.getGame(gameId);
		
		if (gameShop==null)
			throw new NotFoundException("The game shop with id=" + gameShopId + " was not found");
		
		if (song == null)
			throw new NotFoundException("The game with id=" + gameId + " was not found");
		
		if (gameShop.getGame(gameId)!=null)
			throw new BadRequestException("The game is already included in the Game Shop.");
			
		repository.addGame(gameShopId, gameId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(gameShopId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(gameShop);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{gameShopId}/{gameId}")
	public Response removeGameGameShop(@PathParam("gameShopId") String gameShopId, @PathParam("gameId") String gameId) {
		GameShop gameShop = repository.getGameShop(gameShopId);
		Game game = repository.getGame(gameId);
		
		if (gameShop==null)
			throw new NotFoundException("The playlist with id=" + gameShopId + " was not found");
		
		if (game == null)
			throw new NotFoundException("The song with id=" + gameId + " was not found");
		
		
		repository.removeGame(gameShopId, gameId);		
		
		return Response.noContent().build();
	}
}
