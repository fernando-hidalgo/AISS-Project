
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
    "caption",
    "original_size",
    "alt_sizes"
})
public class Photo {

    @JsonProperty("caption")
    private String caption;
    @JsonProperty("original_size")
    private OriginalSize originalSize;
    @JsonProperty("alt_sizes")
    private List<AltSize> altSizes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @JsonProperty("original_size")
    public OriginalSize getOriginalSize() {
        return originalSize;
    }

    @JsonProperty("original_size")
    public void setOriginalSize(OriginalSize originalSize) {
        this.originalSize = originalSize;
    }

    @JsonProperty("alt_sizes")
    public List<AltSize> getAltSizes() {
        return altSizes;
    }

    @JsonProperty("alt_sizes")
    public void setAltSizes(List<AltSize> altSizes) {
        this.altSizes = altSizes;
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
