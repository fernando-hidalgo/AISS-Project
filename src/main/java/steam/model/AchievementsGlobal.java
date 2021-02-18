
package steam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "achievementpercentages"
})
public class AchievementsGlobal {

    @JsonProperty("achievementpercentages")
    private Achievementpercentages achievementpercentages;

    @JsonProperty("achievementpercentages")
    public Achievementpercentages getAchievementpercentages() {
        return achievementpercentages;
    }

    @JsonProperty("achievementpercentages")
    public void setAchievementpercentages(Achievementpercentages achievementpercentages) {
        this.achievementpercentages = achievementpercentages;
    }

}
