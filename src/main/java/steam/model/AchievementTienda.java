
package steam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "percent"
})
public class AchievementTienda {

    @JsonProperty("name")
    private String name;
    @JsonProperty("percent")
    private Double percent;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("percent")
    public Double getPercent() {
        return percent;
    }

    @JsonProperty("percent")
    public void setPercent(Double percent) {
        this.percent = percent;
    }

}
