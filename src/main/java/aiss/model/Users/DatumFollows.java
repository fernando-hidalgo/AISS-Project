
package aiss.model.Users;

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
    "from_id",
    "from_name",
    "to_id",
    "to_name",
    "followed_at"
})
public class DatumFollows {

    @JsonProperty("from_id")
    private String fromId;
    @JsonProperty("from_name")
    private String fromName;
    @JsonProperty("to_id")
    private String toId;
    @JsonProperty("to_name")
    private String toName;
    @JsonProperty("followed_at")
    private String followedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("from_id")
    public String getFromId() {
        return fromId;
    }

    @JsonProperty("from_id")
    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    @JsonProperty("from_name")
    public String getFromName() {
        return fromName;
    }

    @JsonProperty("from_name")
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @JsonProperty("to_id")
    public String getToId() {
        return toId;
    }

    @JsonProperty("to_id")
    public void setToId(String toId) {
        this.toId = toId;
    }

    @JsonProperty("to_name")
    public String getToName() {
        return toName;
    }

    @JsonProperty("to_name")
    public void setToName(String toName) {
        this.toName = toName;
    }
    
    @JsonProperty("followed_at")
    public String getFollowedAt() {
        return followedAt;
    }

    @JsonProperty("followed_at")
    public void setFollowedAt(String followedAt) {
        this.followedAt = followedAt;
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
