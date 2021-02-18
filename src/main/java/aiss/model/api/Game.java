package aiss.model.api;

public class Game {

	private String id;
	private String name;
	private String añoLanzamiento;
	private String edadRecomendada;
	private String genero;
	private String desarrollador;
	private String modoDeJuego;
	private String idSteam;
	private String idTwitch;

	public Game() {
	}

	public Game(String name, String añoLanzamiento, String edadRecomendada, String tipo, String categoria, String modoDeJuego, String desarrollador, String idSteam, String idTwitch) {
		this.name = name;
		this.añoLanzamiento = añoLanzamiento;
		this.edadRecomendada = edadRecomendada;
		this.genero = categoria;
		this.modoDeJuego = modoDeJuego;
		this.desarrollador = desarrollador;
		this.idSteam = idSteam;
		this.idTwitch = idTwitch;
	}
	
	public Game(String name, String edadRecomendada, String tipo, String categoria, String modoDeJuego, String desarrollador, String idSteam, String idTwitch) {
		this.name = name;
		this.edadRecomendada = edadRecomendada;
		this.genero = categoria;
		this.modoDeJuego = modoDeJuego;
		this.desarrollador = desarrollador;
		this.idSteam = idSteam;
		this.idTwitch = idTwitch;
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

	public String getAñoLanzamiento() {
		return añoLanzamiento;
	}

	public void setAñoLanzamiento(String añoLanzamiento) {
		this.añoLanzamiento = añoLanzamiento;
	}

	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getModoDeJuego() {
		return modoDeJuego;
	}

	public void setModoDeJuego(String modoDeJuego) {
		this.modoDeJuego = modoDeJuego;
	}
	
	public String getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}
	
	public String getIdSteam() {
		return idSteam;
	}

	public void setIdSteam(String idSteam) {
		this.idSteam = idSteam;
	}
	
	public String getIdTwitch() {
		return idTwitch;
	}

	public void setIdTwitch(String idTwitch) {
		this.idTwitch = idTwitch;
	}

}
