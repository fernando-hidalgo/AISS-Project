
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
    "header_full_width",
    "header_full_height",
    "avatar_shape",
    "background_color",
    "body_font",
    "header_bounds",
    "header_image",
    "header_image_focused",
    "header_image_poster",
    "header_image_scaled",
    "header_stretch",
    "link_color",
    "show_avatar",
    "show_description",
    "show_header_image",
    "show_title",
    "title_color",
    "title_font",
    "title_font_weight"
})
public class Theme_ {

    @JsonProperty("header_full_width")
    private Integer headerFullWidth;
    @JsonProperty("header_full_height")
    private Integer headerFullHeight;
    @JsonProperty("avatar_shape")
    private String avatarShape;
    @JsonProperty("background_color")
    private String backgroundColor;
    @JsonProperty("body_font")
    private String bodyFont;
    @JsonProperty("header_bounds")
    private String headerBounds;
    @JsonProperty("header_image")
    private String headerImage;
    @JsonProperty("header_image_focused")
    private String headerImageFocused;
    @JsonProperty("header_image_poster")
    private String headerImagePoster;
    @JsonProperty("header_image_scaled")
    private String headerImageScaled;
    @JsonProperty("header_stretch")
    private Boolean headerStretch;
    @JsonProperty("link_color")
    private String linkColor;
    @JsonProperty("show_avatar")
    private Boolean showAvatar;
    @JsonProperty("show_description")
    private Boolean showDescription;
    @JsonProperty("show_header_image")
    private Boolean showHeaderImage;
    @JsonProperty("show_title")
    private Boolean showTitle;
    @JsonProperty("title_color")
    private String titleColor;
    @JsonProperty("title_font")
    private String titleFont;
    @JsonProperty("title_font_weight")
    private String titleFontWeight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("header_full_width")
    public Integer getHeaderFullWidth() {
        return headerFullWidth;
    }

    @JsonProperty("header_full_width")
    public void setHeaderFullWidth(Integer headerFullWidth) {
        this.headerFullWidth = headerFullWidth;
    }

    @JsonProperty("header_full_height")
    public Integer getHeaderFullHeight() {
        return headerFullHeight;
    }

    @JsonProperty("header_full_height")
    public void setHeaderFullHeight(Integer headerFullHeight) {
        this.headerFullHeight = headerFullHeight;
    }

    @JsonProperty("avatar_shape")
    public String getAvatarShape() {
        return avatarShape;
    }

    @JsonProperty("avatar_shape")
    public void setAvatarShape(String avatarShape) {
        this.avatarShape = avatarShape;
    }

    @JsonProperty("background_color")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @JsonProperty("background_color")
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @JsonProperty("body_font")
    public String getBodyFont() {
        return bodyFont;
    }

    @JsonProperty("body_font")
    public void setBodyFont(String bodyFont) {
        this.bodyFont = bodyFont;
    }

    @JsonProperty("header_bounds")
    public String getHeaderBounds() {
        return headerBounds;
    }

    @JsonProperty("header_bounds")
    public void setHeaderBounds(String headerBounds) {
        this.headerBounds = headerBounds;
    }

    @JsonProperty("header_image")
    public String getHeaderImage() {
        return headerImage;
    }

    @JsonProperty("header_image")
    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    @JsonProperty("header_image_focused")
    public String getHeaderImageFocused() {
        return headerImageFocused;
    }

    @JsonProperty("header_image_focused")
    public void setHeaderImageFocused(String headerImageFocused) {
        this.headerImageFocused = headerImageFocused;
    }

    @JsonProperty("header_image_poster")
    public String getHeaderImagePoster() {
        return headerImagePoster;
    }

    @JsonProperty("header_image_poster")
    public void setHeaderImagePoster(String headerImagePoster) {
        this.headerImagePoster = headerImagePoster;
    }

    @JsonProperty("header_image_scaled")
    public String getHeaderImageScaled() {
        return headerImageScaled;
    }

    @JsonProperty("header_image_scaled")
    public void setHeaderImageScaled(String headerImageScaled) {
        this.headerImageScaled = headerImageScaled;
    }

    @JsonProperty("header_stretch")
    public Boolean getHeaderStretch() {
        return headerStretch;
    }

    @JsonProperty("header_stretch")
    public void setHeaderStretch(Boolean headerStretch) {
        this.headerStretch = headerStretch;
    }

    @JsonProperty("link_color")
    public String getLinkColor() {
        return linkColor;
    }

    @JsonProperty("link_color")
    public void setLinkColor(String linkColor) {
        this.linkColor = linkColor;
    }

    @JsonProperty("show_avatar")
    public Boolean getShowAvatar() {
        return showAvatar;
    }

    @JsonProperty("show_avatar")
    public void setShowAvatar(Boolean showAvatar) {
        this.showAvatar = showAvatar;
    }

    @JsonProperty("show_description")
    public Boolean getShowDescription() {
        return showDescription;
    }

    @JsonProperty("show_description")
    public void setShowDescription(Boolean showDescription) {
        this.showDescription = showDescription;
    }

    @JsonProperty("show_header_image")
    public Boolean getShowHeaderImage() {
        return showHeaderImage;
    }

    @JsonProperty("show_header_image")
    public void setShowHeaderImage(Boolean showHeaderImage) {
        this.showHeaderImage = showHeaderImage;
    }

    @JsonProperty("show_title")
    public Boolean getShowTitle() {
        return showTitle;
    }

    @JsonProperty("show_title")
    public void setShowTitle(Boolean showTitle) {
        this.showTitle = showTitle;
    }

    @JsonProperty("title_color")
    public String getTitleColor() {
        return titleColor;
    }

    @JsonProperty("title_color")
    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    @JsonProperty("title_font")
    public String getTitleFont() {
        return titleFont;
    }

    @JsonProperty("title_font")
    public void setTitleFont(String titleFont) {
        this.titleFont = titleFont;
    }

    @JsonProperty("title_font_weight")
    public String getTitleFontWeight() {
        return titleFontWeight;
    }

    @JsonProperty("title_font_weight")
    public void setTitleFontWeight(String titleFontWeight) {
        this.titleFontWeight = titleFontWeight;
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
