
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
    "admin",
    "ask",
    "ask_anon",
    "ask_page_title",
    "avatar",
    "can_chat",
    "can_send_fan_mail",
    "can_subscribe",
    "description",
    "drafts",
    "facebook",
    "facebook_opengraph_enabled",
    "followed",
    "followers",
    "is_blocked_from_primary",
    "is_nsfw",
    "likes",
    "messages",
    "name",
    "posts",
    "primary",
    "queue",
    "share_likes",
    "subscribed",
    "theme",
    "title",
    "total_posts",
    "tweet",
    "twitter_enabled",
    "twitter_send",
    "type",
    "updated",
    "url",
    "uuid"
})
public class Blog {

    @JsonProperty("admin")
    private Boolean admin;
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
    @JsonProperty("can_send_fan_mail")
    private Boolean canSendFanMail;
    @JsonProperty("can_subscribe")
    private Boolean canSubscribe;
    @JsonProperty("description")
    private String description;
    @JsonProperty("drafts")
    private Long drafts;
    @JsonProperty("facebook")
    private String facebook;
    @JsonProperty("facebook_opengraph_enabled")
    private String facebookOpengraphEnabled;
    @JsonProperty("followed")
    private Boolean followed;
    @JsonProperty("followers")
    private Long followers;
    @JsonProperty("is_blocked_from_primary")
    private Boolean isBlockedFromPrimary;
    @JsonProperty("is_nsfw")
    private Boolean isNsfw;
    @JsonProperty("likes")
    private Long likes;
    @JsonProperty("messages")
    private Long messages;
    @JsonProperty("name")
    private String name;
    @JsonProperty("posts")
    private Long posts;
    @JsonProperty("primary")
    private Boolean primary;
    @JsonProperty("queue")
    private Long queue;
    @JsonProperty("share_likes")
    private Boolean shareLikes;
    @JsonProperty("subscribed")
    private Boolean subscribed;
    @JsonProperty("theme")
    private Theme theme;
    @JsonProperty("title")
    private String title;
    @JsonProperty("total_posts")
    private Long totalPosts;
    @JsonProperty("tweet")
    private String tweet;
    @JsonProperty("twitter_enabled")
    private Boolean twitterEnabled;
    @JsonProperty("twitter_send")
    private Boolean twitterSend;
    @JsonProperty("type")
    private String type;
    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("url")
    private String url;
    @JsonProperty("uuid")
    private String uuid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("admin")
    public Boolean getAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

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

    @JsonProperty("can_send_fan_mail")
    public Boolean getCanSendFanMail() {
        return canSendFanMail;
    }

    @JsonProperty("can_send_fan_mail")
    public void setCanSendFanMail(Boolean canSendFanMail) {
        this.canSendFanMail = canSendFanMail;
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

    @JsonProperty("drafts")
    public Long getDrafts() {
        return drafts;
    }

    @JsonProperty("drafts")
    public void setDrafts(Long drafts) {
        this.drafts = drafts;
    }

    @JsonProperty("facebook")
    public String getFacebook() {
        return facebook;
    }

    @JsonProperty("facebook")
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @JsonProperty("facebook_opengraph_enabled")
    public String getFacebookOpengraphEnabled() {
        return facebookOpengraphEnabled;
    }

    @JsonProperty("facebook_opengraph_enabled")
    public void setFacebookOpengraphEnabled(String facebookOpengraphEnabled) {
        this.facebookOpengraphEnabled = facebookOpengraphEnabled;
    }

    @JsonProperty("followed")
    public Boolean getFollowed() {
        return followed;
    }

    @JsonProperty("followed")
    public void setFollowed(Boolean followed) {
        this.followed = followed;
    }

    @JsonProperty("followers")
    public Long getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    @JsonProperty("is_blocked_from_primary")
    public Boolean getIsBlockedFromPrimary() {
        return isBlockedFromPrimary;
    }

    @JsonProperty("is_blocked_from_primary")
    public void setIsBlockedFromPrimary(Boolean isBlockedFromPrimary) {
        this.isBlockedFromPrimary = isBlockedFromPrimary;
    }

    @JsonProperty("is_nsfw")
    public Boolean getIsNsfw() {
        return isNsfw;
    }

    @JsonProperty("is_nsfw")
    public void setIsNsfw(Boolean isNsfw) {
        this.isNsfw = isNsfw;
    }

    @JsonProperty("likes")
    public Long getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Long likes) {
        this.likes = likes;
    }

    @JsonProperty("messages")
    public Long getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(Long messages) {
        this.messages = messages;
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
    public Long getPosts() {
        return posts;
    }

    @JsonProperty("posts")
    public void setPosts(Long posts) {
        this.posts = posts;
    }

    @JsonProperty("primary")
    public Boolean getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @JsonProperty("queue")
    public Long getQueue() {
        return queue;
    }

    @JsonProperty("queue")
    public void setQueue(Long queue) {
        this.queue = queue;
    }

    @JsonProperty("share_likes")
    public Boolean getShareLikes() {
        return shareLikes;
    }

    @JsonProperty("share_likes")
    public void setShareLikes(Boolean shareLikes) {
        this.shareLikes = shareLikes;
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
    public Long getTotalPosts() {
        return totalPosts;
    }

    @JsonProperty("total_posts")
    public void setTotalPosts(Long totalPosts) {
        this.totalPosts = totalPosts;
    }

    @JsonProperty("tweet")
    public String getTweet() {
        return tweet;
    }

    @JsonProperty("tweet")
    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    @JsonProperty("twitter_enabled")
    public Boolean getTwitterEnabled() {
        return twitterEnabled;
    }

    @JsonProperty("twitter_enabled")
    public void setTwitterEnabled(Boolean twitterEnabled) {
        this.twitterEnabled = twitterEnabled;
    }

    @JsonProperty("twitter_send")
    public Boolean getTwitterSend() {
        return twitterSend;
    }

    @JsonProperty("twitter_send")
    public void setTwitterSend(Boolean twitterSend) {
        this.twitterSend = twitterSend;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("updated")
    public Long getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Long updated) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
