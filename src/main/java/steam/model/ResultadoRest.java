
package steam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "a\u00f1oLanzamiento",
    "edadRecomendada",
    "genero",
    "desarrollador",
    "modoDeJuego",
    "idSteam",
    "idTwitch"
})
public class ResultadoRest {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("a\u00f1oLanzamiento")
    private Object aOLanzamiento;
    @JsonProperty("edadRecomendada")
    private Object edadRecomendada;
    @JsonProperty("genero")
    private Object genero;
    @JsonProperty("desarrollador")
    private Object desarrollador;
    @JsonProperty("modoDeJuego")
    private Object modoDeJuego;
    @JsonProperty("idSteam")
    private String idSteam;
    @JsonProperty("idTwitch")
    private String idTwitch;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("a\u00f1oLanzamiento")
    public Object getAOLanzamiento() {
        return aOLanzamiento;
    }

    @JsonProperty("a\u00f1oLanzamiento")
    public void setAOLanzamiento(Object aOLanzamiento) {
        this.aOLanzamiento = aOLanzamiento;
    }

    @JsonProperty("edadRecomendada")
    public Object getEdadRecomendada() {
        return edadRecomendada;
    }

    @JsonProperty("edadRecomendada")
    public void setEdadRecomendada(Object edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    @JsonProperty("genero")
    public Object getGenero() {
        return genero;
    }

    @JsonProperty("genero")
    public void setGenero(Object genero) {
        this.genero = genero;
    }

    @JsonProperty("desarrollador")
    public Object getDesarrollador() {
        return desarrollador;
    }

    @JsonProperty("desarrollador")
    public void setDesarrollador(Object desarrollador) {
        this.desarrollador = desarrollador;
    }

    @JsonProperty("modoDeJuego")
    public Object getModoDeJuego() {
        return modoDeJuego;
    }

    @JsonProperty("modoDeJuego")
    public void setModoDeJuego(Object modoDeJuego) {
        this.modoDeJuego = modoDeJuego;
    }

    @JsonProperty("idSteam")
    public String getIdSteam() {
        return idSteam;
    }

    @JsonProperty("idSteam")
    public void setIdSteam(String idSteam) {
        this.idSteam = idSteam;
    }

    @JsonProperty("idTwitch")
    public String getIdTwitch() {
        return idTwitch;
    }

    @JsonProperty("idTwitch")
    public void setIdTwitch(String idTwitch) {
        this.idTwitch = idTwitch;
    }

}
