package aiss.model.repository;

import java.util.Collection;

import java.util.HashMap;
import java.util.Map;

import aiss.model.api.Game;
import aiss.model.api.GameShop;


public class MapGameShopRepository implements GameShopRepository{

	Map<String, GameShop> gameShopMap;
	Map<String, Game> gameMap;
	private static MapGameShopRepository instance=null;
	private int index=0;			// Index to create gameShop and songs' identifiers.
	
	
	public static MapGameShopRepository getInstance() {
		
		if (instance==null) {
			instance = new MapGameShopRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		gameShopMap = new HashMap<String,GameShop>();
		gameMap = new HashMap<String,Game>();
		
		// Create games
		Game valorant=new Game();
		valorant.setName("Valorant");
		valorant.setAñoLanzamiento("2020");
		valorant.setEdadRecomendada("+16");
		valorant.setGenero("Acción, estrategia, tirador táctico");
		valorant.setModoDeJuego("Multijugador");
		valorant.setDesarrollador("Riot Games");
		addGame(valorant);
		
		Game fornite=new Game();
		fornite.setName("Fornite");
		fornite.setAñoLanzamiento("2017");
		fornite.setEdadRecomendada("+12");
		fornite.setGenero("Supervivencia, Mundo abierto, Battle Royale");
		fornite.setModoDeJuego("Un jugador, Multijugador");
		fornite.setDesarrollador("Epic Games");
		addGame(fornite);
		
		Game hearthstone=new Game();
		hearthstone.setName("Hearthstone");
		hearthstone.setAñoLanzamiento("2014");
		hearthstone.setEdadRecomendada("+7");
		hearthstone.setGenero("Collectible card video game");
		hearthstone.setModoDeJuego("Un jugador, Multijugador");
		hearthstone.setDesarrollador("Blizzard Entertainment");
		addGame(hearthstone);
		
		Game tombRaider=new Game();
		tombRaider.setName("Tomb Raider");
		tombRaider.setAñoLanzamiento("2013");
		tombRaider.setEdadRecomendada("+7");
		tombRaider.setGenero("Acción, aventura");
		tombRaider.setModoDeJuego("Un jugador, Multijugador");
		tombRaider.setDesarrollador("Core Design");
		addGame(tombRaider);
		
		Game dota2=new Game();
		dota2.setName("Dota 2");
		dota2.setIdTwitch("29595");
		dota2.setIdSteam("570");
		addGame(dota2);
		
		Game csgo=new Game();
		csgo.setName("Counter Strike");
		csgo.setIdTwitch("32399");
		csgo.setIdSteam("730");
		addGame(csgo);
		
		Game gta=new Game();
		gta.setName("Grand Theft Auto V");
		gta.setIdTwitch("32982");
		gta.setIdSteam("271590");
		addGame(gta);
		
		Game pug=new Game();
		pug.setName("PLAYERUNKNOWN'S BATTLEGROUNDS");
		pug.setIdTwitch("493057");
		pug.setIdSteam("578080");
		addGame(pug);
		
		Game dead=new Game();
		dead.setName("Dead by Daylight");
		dead.setIdTwitch("491487");
		dead.setIdSteam("381210");
		addGame(dead);
		
		Game tom=new Game();
		tom.setName("Tom Clancy's Rainbow Six: Siege");
		tom.setIdTwitch("460630");
		tom.setIdSteam("359550");
		addGame(tom);
		
		Game path=new Game();
		path.setName("Path of Exile");
		path.setIdTwitch("29307");
		path.setIdSteam("238960");
		addGame(path);
		
		Game monster=new Game();
		monster.setName("Monster Hunter World");
		monster.setIdTwitch("497467");
		monster.setIdSteam("582010");
		addGame(monster);
		
		Game sekiro=new Game();
		sekiro.setName("Sekiro: Shadows Die Twice");
		sekiro.setIdTwitch("506415");
		sekiro.setIdSteam("814380");
		addGame(sekiro);
		
		Game rocket=new Game();
		rocket.setName("Rocket League");
		rocket.setIdTwitch("30921");
		rocket.setIdSteam("252950");
		addGame(rocket);
		
		Game factorio=new Game();
		factorio.setName("Factorio");
		factorio.setIdTwitch("130942");
		factorio.setIdSteam("427520");
		addGame(factorio);
		
		Game fantasy=new Game();
		fantasy.setName("FINAL FANTASY XIV Online");
		fantasy.setIdTwitch("24241");
		fantasy.setIdSteam("39210");
		addGame(fantasy);
		
		Game hollow=new Game();
		hollow.setName("Hollow Knight");
		hollow.setIdTwitch("490147");
		hollow.setIdSteam("367520");
		addGame(hollow);
		
		Game dayz=new Game();
		dayz.setName("DayZ");
		dayz.setIdTwitch("497467");
		dayz.setIdSteam("582010");
		addGame(dayz);
		
		Game rust=new Game();
		rust.setName("Rust");
		rust.setIdTwitch("263490");
		rust.setIdSteam("252490");
		addGame(rust);
		
		Game sid=new Game();
		sid.setName("Sid Meier's Civilization VI");
		sid.setIdTwitch("492553");
		sid.setIdSteam("289070");
		addGame(sid);
		
		Game elder=new Game();
		elder.setName("The Elder Scrolls V: Skyrim");
		elder.setIdTwitch("30028");
		elder.setIdSteam("72850");
		addGame(elder);
		
		Game cuphead=new Game();
		cuphead.setName("Cuphead");
		cuphead.setIdTwitch("459064");
		cuphead.setIdSteam("268910");
		addGame(cuphead);
		
		Game vrchat=new Game();
		vrchat.setName("VRChat");
		vrchat.setIdTwitch("499003");
		vrchat.setIdSteam("438100");
		addGame(vrchat);
		
		Game black=new Game();
		black.setName("Black Desert Online");
		black.setIdTwitch("386821");
		black.setIdSteam("582660");
		addGame(black);
		
		Game dark=new Game();
		dark.setName("Dark Souls III");
		dark.setIdTwitch("490292");
		dark.setIdSteam("374320");
		addGame(dark);
		
		Game reddead=new Game();
		reddead.setName("Red Dead Redemption 2");
		reddead.setIdTwitch("493959");
		reddead.setIdSteam("1174180");
		addGame(reddead);
		
		Game fallout=new Game();
		fallout.setName("Fallout 76");
		fallout.setIdTwitch("506246");
		fallout.setIdSteam("1151340");
		addGame(fallout);
		
		Game mirror=new Game();
		mirror.setName("Mirror's Edge");
		mirror.setIdTwitch("19348");
		mirror.setIdSteam("17410");
		addGame(mirror);
		
		
		// Create gameShop
		GameShop game=new GameShop();
		game.setName("Game");
		game.setDescription("Game Shop - Game");
		addGameShop(game);
		
		GameShop cex = new GameShop();
		cex.setName("Cex");
		cex.setDescription("Game shop - Cex");
		addGameShop(cex);
		
		GameShop steam = new GameShop();
		steam.setName("Steam");
		steam.setDescription("Game Shop online - Steam");
		addGameShop(steam);
		
		GameShop fnac = new GameShop();
		fnac.setName("Fnac");
		fnac.setDescription("Shop online - Fnac");
		addGameShop(fnac);
		
		// Add games to gameShops
		addGame(game.getId(), valorant.getId());
		addGame(game.getId(), fornite.getId());
		addGame(cex.getId(), hearthstone.getId());
		addGame(cex.getId(), tombRaider.getId());
		addGame(fnac.getId(), gta.getId());
		addGame(fnac.getId(), tombRaider.getId());
		
		
		
		addGame(steam.getId(), dota2.getId());
		addGame(steam.getId(), csgo.getId());
		addGame(steam.getId(), gta.getId());
		addGame(steam.getId(), pug.getId());
		addGame(steam.getId(), dead.getId());
		addGame(steam.getId(), tom.getId());
		addGame(steam.getId(), path.getId());
		addGame(steam.getId(), monster.getId());
		addGame(steam.getId(), sekiro.getId());
		addGame(steam.getId(), rocket.getId());
		addGame(steam.getId(), factorio.getId());
		addGame(steam.getId(), fantasy.getId());
		addGame(steam.getId(), hollow.getId());
		addGame(steam.getId(), dayz.getId());
		addGame(steam.getId(), rust.getId());
		addGame(steam.getId(), sid.getId());
		addGame(steam.getId(), elder.getId());
		addGame(steam.getId(), cuphead.getId());
		addGame(steam.getId(), vrchat.getId());
		addGame(steam.getId(), black.getId());
		addGame(steam.getId(), dark.getId());
		addGame(steam.getId(), reddead.getId());
		addGame(steam.getId(), fallout.getId());
		addGame(steam.getId(), mirror.getId());
	}
	
	// GameShops related operations
	@Override
	public void addGameShop(GameShop gs) {
		String id = "gs" + index++;	
		gs.setId(id);
		gameShopMap.put(id,gs);
	}
	
	@Override
	public Collection<GameShop> getAllGameShops() {
			return gameShopMap.values();
	}

	@Override
	public GameShop getGameShop(String id) {
		return gameShopMap.get(id);
	}
	
	@Override
	public void updateGameShop(GameShop gs) {
		gameShopMap.put(gs.getId(),gs);
	}

	@Override
	public void deleteGameShop(String id) {	
		gameShopMap.remove(id);
	}
	

	@Override
	public void addGame(String gameShopId, String gameId) {
		GameShop playlist = getGameShop(gameShopId);
		playlist.addGame(gameMap.get(gameId));
	}

	@Override
	public Collection<Game> getAll(String gameShopId) {
		return getGameShop(gameShopId).getGames();
	}

	@Override
	public void removeGame(String gameShopId, String gameId) {
		getGameShop(gameShopId).deleteGame(gameId);
	}

	
	// Game related operations
	
	@Override
	public void addGame(Game g) {
		String id = "g" + index++;
		g.setId(id);
		gameMap.put(id, g);
	}
	
	@Override
	public Collection<Game> getAllGames() {
			return gameMap.values();
	}

	@Override
	public Game getGame(String gameId) {
		return gameMap.get(gameId);
	}

	@Override
	public void updateGame(Game g) {
		Game song = gameMap.get(g.getId());
		song.setName(g.getName());
		song.setAñoLanzamiento(g.getAñoLanzamiento());
		song.setDesarrollador(g.getDesarrollador());
		song.setEdadRecomendada(g.getEdadRecomendada());
		song.setModoDeJuego(g.getModoDeJuego());
	}

	@Override
	public void deleteGame(String gameId) {
		gameMap.remove(gameId);
	}
	
}
