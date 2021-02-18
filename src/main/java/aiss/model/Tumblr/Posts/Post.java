
package aiss.model.Tumblr.Posts;

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
    "type",
    "blog_name",
    "blog",
    "id",
    "id_string",
    "post_url",
    "slug",
    "date",
    "timestamp",
    "state",
    "format",
    "reblog_key",
    "tags",
    "short_url",
    "summary",
    "should_open_in_legacy",
    "recommended_source",
    "recommended_color",
    "post_author",
    "note_count",
    "title",
    "body",
    "dialogue",
    "can_like",
    "can_reblog",
    "can_send_in_message",
    "can_reply",
    "display_avatar",
    "reblog",
    "trail"
})
public class Post {

    @JsonProperty("type")
    private String type;
    @JsonProperty("blog_name")
    private String blogName;
    @JsonProperty("blog")
    private Blog_ blog;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("id_string")
    private String idString;
    @JsonProperty("post_url")
    private String postUrl;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("date")
    private String date;
    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonProperty("state")
    private String state;
    @JsonProperty("format")
    private String format;
    @JsonProperty("reblog_key")
    private String reblogKey;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("short_url")
    private String shortUrl;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("should_open_in_legacy")
    private Boolean shouldOpenInLegacy;
    @JsonProperty("recommended_source")
    private Object recommendedSource;
    @JsonProperty("recommended_color")
    private Object recommendedColor;
    @JsonProperty("post_author")
    private String postAuthor;
    @JsonProperty("note_count")
    private Integer noteCount;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
    @JsonProperty("dialogue")
    private List<Dialogue> dialogue = null;
    @JsonProperty("can_like")
    private Boolean canLike;
    @JsonProperty("can_reblog")
    private Boolean canReblog;
    @JsonProperty("can_send_in_message")
    private Boolean canSendInMessage;
    @JsonProperty("can_reply")
    private Boolean canReply;
    @JsonProperty("display_avatar")
    private Boolean displayAvatar;
    @JsonProperty("reblog")
    private Reblog reblog;
    @JsonProperty("trail")
    private List<Trail> trail = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("blog_name")
    public String getBlogName() {
        return blogName;
    }

    @JsonProperty("blog_name")
    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    @JsonProperty("blog")
    public Blog_ getBlog() {
        return blog;
    }

    @JsonProperty("blog")
    public void setBlog(Blog_ blog) {
        this.blog = blog;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("id_string")
    public String getIdString() {
        return idString;
    }

    @JsonProperty("id_string")
    public void setIdString(String idString) {
        this.idString = idString;
    }

    @JsonProperty("post_url")
    public String getPostUrl() {
        return postUrl;
    }

    @JsonProperty("post_url")
    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("timestamp")
    public Integer getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("reblog_key")
    public String getReblogKey() {
        return reblogKey;
    }

    @JsonProperty("reblog_key")
    public void setReblogKey(String reblogKey) {
        this.reblogKey = reblogKey;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("short_url")
    public String getShortUrl() {
        return shortUrl;
    }

    @JsonProperty("short_url")
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("should_open_in_legacy")
    public Boolean getShouldOpenInLegacy() {
        return shouldOpenInLegacy;
    }

    @JsonProperty("should_open_in_legacy")
    public void setShouldOpenInLegacy(Boolean shouldOpenInLegacy) {
        this.shouldOpenInLegacy = shouldOpenInLegacy;
    }

    @JsonProperty("recommended_source")
    public Object getRecommendedSource() {
        return recommendedSource;
    }

    @JsonProperty("recommended_source")
    public void setRecommendedSource(Object recommendedSource) {
        this.recommendedSource = recommendedSource;
    }

    @JsonProperty("recommended_color")
    public Object getRecommendedColor() {
        return recommendedColor;
    }

    @JsonProperty("recommended_color")
    public void setRecommendedColor(Object recommendedColor) {
        this.recommendedColor = recommendedColor;
    }

    @JsonProperty("post_author")
    public String getPostAuthor() {
        return postAuthor;
    }

    @JsonProperty("post_author")
    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    @JsonProperty("note_count")
    public Integer getNoteCount() {
        return noteCount;
    }

    @JsonProperty("note_count")
    public void setNoteCount(Integer noteCount) {
        this.noteCount = noteCount;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("dialogue")
    public List<Dialogue> getDialogue() {
        return dialogue;
    }

    @JsonProperty("dialogue")
    public void setDialogue(List<Dialogue> dialogue) {
        this.dialogue = dialogue;
    }

    @JsonProperty("can_like")
    public Boolean getCanLike() {
        return canLike;
    }

    @JsonProperty("can_like")
    public void setCanLike(Boolean canLike) {
        this.canLike = canLike;
    }

    @JsonProperty("can_reblog")
    public Boolean getCanReblog() {
        return canReblog;
    }

    @JsonProperty("can_reblog")
    public void setCanReblog(Boolean canReblog) {
        this.canReblog = canReblog;
    }

    @JsonProperty("can_send_in_message")
    public Boolean getCanSendInMessage() {
        return canSendInMessage;
    }

    @JsonProperty("can_send_in_message")
    public void setCanSendInMessage(Boolean canSendInMessage) {
        this.canSendInMessage = canSendInMessage;
    }

    @JsonProperty("can_reply")
    public Boolean getCanReply() {
        return canReply;
    }

    @JsonProperty("can_reply")
    public void setCanReply(Boolean canReply) {
        this.canReply = canReply;
    }

    @JsonProperty("display_avatar")
    public Boolean getDisplayAvatar() {
        return displayAvatar;
    }

    @JsonProperty("display_avatar")
    public void setDisplayAvatar(Boolean displayAvatar) {
        this.displayAvatar = displayAvatar;
    }

    @JsonProperty("reblog")
    public Reblog getReblog() {
        return reblog;
    }

    @JsonProperty("reblog")
    public void setReblog(Reblog reblog) {
        this.reblog = reblog;
    }

    @JsonProperty("trail")
    public List<Trail> getTrail() {
        return trail;
    }

    @JsonProperty("trail")
    public void setTrail(List<Trail> trail) {
        this.trail = trail;
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
