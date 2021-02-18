
package aiss.model.Tumblr.BlogInfo;

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
    "ask",
    "ask_anon",
    "ask_page_title",
    "avatar",
    "can_chat",
    "can_subscribe",
    "description",
    "is_nsfw",
    "name",
    "posts",
    "share_likes",
    "submission_page_title",
    "subscribed",
    "theme",
    "title",
    "total_posts",
    "updated",
    "url",
    "uuid",
    "is_optout_ads"
})
public class Blog {

    @JsonProperty("ask")
    private Boolean ask;
    @JsonProperty("ask_anon")
    private Boolean askAnon;
    @JsonProperty("ask_page_title")
    private String askPageTitle;
    @JsonProperty("avatar")
    private List<Avatar> avatar = null;
    @JsonProperty("can_chat")
    private Boolean canChat;
    @JsonProperty("can_subscribe")
    private Boolean canSubscribe;
    @JsonProperty("description")
    private String description;
    @JsonProperty("is_nsfw")
    private Boolean isNsfw;
    @JsonProperty("name")
    private String name;
    @JsonProperty("posts")
    private Integer posts;
    @JsonProperty("share_likes")
    private Boolean shareLikes;
    @JsonProperty("submission_page_title")
    private String submissionPageTitle;
    @JsonProperty("subscribed")
    private Boolean subscribed;
    @JsonProperty("theme")
    private Theme theme;
    @JsonProperty("title")
    private String title;
    @JsonProperty("total_posts")
    private Integer totalPosts;
    @JsonProperty("updated")
    private Integer updated;
    @JsonProperty("url")
    private String url;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("is_optout_ads")
    private Boolean isOptoutAds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ask")
    public Boolean getAsk() {
        return ask;
    }

    @JsonProperty("ask")
    public void setAsk(Boolean ask) {
        this.ask = ask;
    }

    @JsonProperty("ask_anon")
    public Boolean getAskAnon() {
        return askAnon;
    }

    @JsonProperty("ask_anon")
    public void setAskAnon(Boolean askAnon) {
        this.askAnon = askAnon;
    }

    @JsonProperty("ask_page_title")
    public String getAskPageTitle() {
        return askPageTitle;
    }

    @JsonProperty("ask_page_title")
    public void setAskPageTitle(String askPageTitle) {
        this.askPageTitle = askPageTitle;
    }

    @JsonProperty("avatar")
    public List<Avatar> getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(List<Avatar> avatar) {
        this.avatar = avatar;
    }

    @JsonProperty("can_chat")
    public Boolean getCanChat() {
        return canChat;
    }

    @JsonProperty("can_chat")
    public void setCanChat(Boolean canChat) {
        this.canChat = canChat;
    }

    @JsonProperty("can_subscribe")
    public Boolean getCanSubscribe() {
        return canSubscribe;
    }

    @JsonProperty("can_subscribe")
    public void setCanSubscribe(Boolean canSubscribe) {
        this.canSubscribe = canSubscribe;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("is_nsfw")
    public Boolean getIsNsfw() {
        return isNsfw;
    }

    @JsonProperty("is_nsfw")
    public void setIsNsfw(Boolean isNsfw) {
        this.isNsfw = isNsfw;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("posts")
    public Integer getPosts() {
        return posts;
    }

    @JsonProperty("posts")
    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    @JsonProperty("share_likes")
    public Boolean getShareLikes() {
        return shareLikes;
    }

    @JsonProperty("share_likes")
    public void setShareLikes(Boolean shareLikes) {
        this.shareLikes = shareLikes;
    }

    @JsonProperty("submission_page_title")
    public String getSubmissionPageTitle() {
        return submissionPageTitle;
    }

    @JsonProperty("submission_page_title")
    public void setSubmissionPageTitle(String submissionPageTitle) {
        this.submissionPageTitle = submissionPageTitle;
    }

    @JsonProperty("subscribed")
    public Boolean getSubscribed() {
        return subscribed;
    }

    @JsonProperty("subscribed")
    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    @JsonProperty("theme")
    public Theme getTheme() {
        return theme;
    }

    @JsonProperty("theme")
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("total_posts")
    public Integer getTotalPosts() {
        return totalPosts;
    }

    @JsonProperty("total_posts")
    public void setTotalPosts(Integer totalPosts) {
        this.totalPosts = totalPosts;
    }

    @JsonProperty("updated")
    public Integer getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("is_optout_ads")
    public Boolean getIsOptoutAds() {
        return isOptoutAds;
    }

    @JsonProperty("is_optout_ads")
    public void setIsOptoutAds(Boolean isOptoutAds) {
        this.isOptoutAds = isOptoutAds;
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
