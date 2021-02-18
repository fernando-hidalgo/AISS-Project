
package aiss.model.Tumblr.UserFollowings;

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
    "total_blogs",
    "blogs",
    "_links"
})
public class Response {

    @JsonProperty("total_blogs")
    private Long totalBlogs;
    @JsonProperty("blogs")
    private List<Blog> blogs = null;
    @JsonProperty("_links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total_blogs")
    public Long getTotalBlogs() {
        return totalBlogs;
    }

    @JsonProperty("total_blogs")
    public void setTotalBlogs(Long totalBlogs) {
        this.totalBlogs = totalBlogs;
    }

    @JsonProperty("blogs")
    public List<Blog> getBlogs() {
        return blogs;
    }

    @JsonProperty("blogs")
    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
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
