
package steam.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "achievements"
})
public class Achievementpercentages {

    @JsonProperty("achievements")
    private List<AchievementTienda> achievements = null;

    @JsonProperty("achievements")
    public List<AchievementTienda> getAchievements() {
        return achievements;
    }

    @JsonProperty("achievements")
    public void setAchievements(List<AchievementTienda> achievements) {
        this.achievements = achievements;
    }

}
