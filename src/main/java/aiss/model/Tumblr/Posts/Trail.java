
package aiss.model.Tumblr.Posts;

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
    "blog",
    "post",
    "content_raw",
    "content",
    "is_current_item",
    "is_root_item"
})
public class Trail {

    @JsonProperty("blog")
    private Blog__ blog;
    @JsonProperty("post")
    private Post_ post;
    @JsonProperty("content_raw")
    private String contentRaw;
    @JsonProperty("content")
    private String content;
    @JsonProperty("is_current_item")
    private Boolean isCurrentItem;
    @JsonProperty("is_root_item")
    private Boolean isRootItem;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("blog")
    public Blog__ getBlog() {
        return blog;
    }

    @JsonProperty("blog")
    public void setBlog(Blog__ blog) {
        this.blog = blog;
    }

    @JsonProperty("post")
    public Post_ getPost() {
        return post;
    }

    @JsonProperty("post")
    public void setPost(Post_ post) {
        this.post = post;
    }

    @JsonProperty("content_raw")
    public String getContentRaw() {
        return contentRaw;
    }

    @JsonProperty("content_raw")
    public void setContentRaw(String contentRaw) {
        this.contentRaw = contentRaw;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("is_current_item")
    public Boolean getIsCurrentItem() {
        return isCurrentItem;
    }

    @JsonProperty("is_current_item")
    public void setIsCurrentItem(Boolean isCurrentItem) {
        this.isCurrentItem = isCurrentItem;
    }

    @JsonProperty("is_root_item")
    public Boolean getIsRootItem() {
        return isRootItem;
    }

    @JsonProperty("is_root_item")
    public void setIsRootItem(Boolean isRootItem) {
        this.isRootItem = isRootItem;
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
