
package steam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appnews"
})
public class NewNotes {

    @JsonProperty("appnews")
    private Appnews appnews;

    @JsonProperty("appnews")
    public Appnews getAppnews() {
        return appnews;
    }

    @JsonProperty("appnews")
    public void setAppnews(Appnews appnews) {
        this.appnews = appnews;
    }

}
