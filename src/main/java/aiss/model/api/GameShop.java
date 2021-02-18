package aiss.model.api;

import java.util.ArrayList;
import java.util.List;

public class GameShop {

	private String id;
	private String name;
	private String description;
	private List<Game> games;
	
	public GameShop() {}
	
	public GameShop(String name) {
		this.name = name;
	}
	
	protected void setGames(List<Game> g) {
		games = g;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	public Game getGame(String id) {
		if (games==null)
			return null;
		
		Game game =null;
		for(Game g: games)
			if (g.getId().equals(id))
			{
				game=g;
				break;
			}
		
		return game;
	}
	
	public void addGame(Game g) {
		if (games==null)
			games = new ArrayList<Game>();
		games.add(g);
	}
	
	public void deleteGame(Game s) {
		games.remove(s);
	}
	
	public void deleteGame(String id) {
		Game s = getGame(id);
		if (s!=null)
			games.remove(s);
	}

}
