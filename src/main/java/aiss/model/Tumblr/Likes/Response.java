
package aiss.model.Tumblr.Likes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "liked_posts",
    "liked_count",
    "_links"
})
public class Response {

    @JsonProperty("liked_posts")
    private List<LikedPost> likedPosts = null;
    @JsonProperty("liked_count")
    private Long likedCount;
    @JsonProperty("_links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("liked_posts")
    public List<LikedPost> getLikedPosts() {
        return likedPosts;
    }

    @JsonProperty("liked_posts")
    public void setLikedPosts(List<LikedPost> likedPosts) {
        this.likedPosts = likedPosts;
    }

    @JsonProperty("liked_count")
    public Long getLikedCount() {
        return likedCount;
    }

    @JsonProperty("liked_count")
    public void setLikedCount(Long likedCount) {
        this.likedCount = likedCount;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
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
