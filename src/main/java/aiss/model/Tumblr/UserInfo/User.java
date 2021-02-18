
package aiss.model.Tumblr.UserInfo;

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
    "name",
    "likes",
    "following",
    "default_post_format",
    "blogs"
})
public class User {

    @JsonProperty("name")
    private String name;
    @JsonProperty("likes")
    private Long likes;
    @JsonProperty("following")
    private Long following;
    @JsonProperty("default_post_format")
    private String defaultPostFormat;
    @JsonProperty("blogs")
    private List<Blog> blogs = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("likes")
    public Long getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Long likes) {
        this.likes = likes;
    }

    @JsonProperty("following")
    public Long getFollowing() {
        return following;
    }

    @JsonProperty("following")
    public void setFollowing(Long following) {
        this.following = following;
    }

    @JsonProperty("default_post_format")
    public String getDefaultPostFormat() {
        return defaultPostFormat;
    }

    @JsonProperty("default_post_format")
    public void setDefaultPostFormat(String defaultPostFormat) {
        this.defaultPostFormat = defaultPostFormat;
    }

    @JsonProperty("blogs")
    public List<Blog> getBlogs() {
        return blogs;
    }

    @JsonProperty("blogs")
    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
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
