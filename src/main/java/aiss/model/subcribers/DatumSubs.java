
package aiss.model.subcribers;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "broadcaster_id",
    "broadcaster_name",
    "is_gift",
    "tier",
    "plan_name",
    "user_id",
    "user_name"
})
public class DatumSubs {

    @JsonProperty("broadcaster_id")
    private String broadcasterId;
    @JsonProperty("broadcaster_name")
    private String broadcasterName;
    @JsonProperty("is_gift")
    private Boolean isGift;
    @JsonProperty("tier")
    private String tier;
    @JsonProperty("plan_name")
    private String planName;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("broadcaster_id")
    public String getBroadcasterId() {
        return broadcasterId;
    }

    @JsonProperty("broadcaster_id")
    public void setBroadcasterId(String broadcasterId) {
        this.broadcasterId = broadcasterId;
    }

    @JsonProperty("broadcaster_name")
    public String getBroadcasterName() {
        return broadcasterName;
    }

    @JsonProperty("broadcaster_name")
    public void setBroadcasterName(String broadcasterName) {
        this.broadcasterName = broadcasterName;
    }

    @JsonProperty("is_gift")
    public Boolean getIsGift() {
        return isGift;
    }

    @JsonProperty("is_gift")
    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    @JsonProperty("tier")
    public String getTier() {
        return tier;
    }

    @JsonProperty("tier")
    public void setTier(String tier) {
        this.tier = tier;
    }

    @JsonProperty("plan_name")
    public String getPlanName() {
        return planName;
    }

    @JsonProperty("plan_name")
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("user_name")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
