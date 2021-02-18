package aiss.model.repository;

import java.util.Collection;

import aiss.model.api.Game;
import aiss.model.api.GameShop;

public interface GameShopRepository {
	
	
	// Songs
	public void addGame(Game g);
	public Collection<Game> getAllGames();
	public Game getGame(String gameId);
	public void updateGame(Game g);
	public void deleteGame(String gameId);
	
	// Playlists
	public void addGameShop(GameShop gs);
	public Collection<GameShop> getAllGameShops();
	public GameShop getGameShop(String gameShopId);
	public void updateGameShop(GameShop gs);
	public void deleteGameShop(String gameShopId);
	public Collection<Game> getAll(String gameShopId);
	public void addGame(String gameShopId, String gameId);
	public void removeGame(String gameShopId, String gameId); 

	
	
	
	

}
