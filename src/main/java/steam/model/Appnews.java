
package steam.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appid",
    "newsitems",
    "count"
})
public class Appnews {

    @JsonProperty("appid")
    private Integer appid;
    @JsonProperty("newsitems")
    private List<Newsitem> newsitems = null;
    @JsonProperty("count")
    private Integer count;

    @JsonProperty("appid")
    public Integer getAppid() {
        return appid;
    }

    @JsonProperty("appid")
    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    @JsonProperty("newsitems")
    public List<Newsitem> getNewsitems() {
        return newsitems;
    }

    @JsonProperty("newsitems")
    public void setNewsitems(List<Newsitem> newsitems) {
        this.newsitems = newsitems;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

}
