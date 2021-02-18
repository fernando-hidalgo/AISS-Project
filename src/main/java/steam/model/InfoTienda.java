
package steam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appid",
    "name",
    "developer",
    "publisher",
    "score_rank",
    "positive",
    "negative",
    "userscore",
    "owners",
    "average_forever",
    "average_2weeks",
    "median_forever",
    "median_2weeks",
    "price",
    "initialprice",
    "discount",
    "languages",
    "genre",
    "ccu",
    "tags"
})
public class InfoTienda {

    @JsonProperty("appid")
    private Integer appid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("developer")
    private String developer;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("score_rank")
    private String scoreRank;
    @JsonProperty("positive")
    private Integer positive;
    @JsonProperty("negative")
    private Integer negative;
    @JsonProperty("userscore")
    private Integer userscore;
    @JsonProperty("owners")
    private String owners;
    @JsonProperty("average_forever")
    private Integer averageForever;
    @JsonProperty("average_2weeks")
    private Integer average2weeks;
    @JsonProperty("median_forever")
    private Integer medianForever;
    @JsonProperty("median_2weeks")
    private Integer median2weeks;
    @JsonProperty("price")
    private String price;
    @JsonProperty("initialprice")
    private String initialprice;
    @JsonProperty("discount")
    private String discount;
    @JsonProperty("languages")
    private String languages;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("ccu")
    private Integer ccu;
    @JsonProperty("tags")
    private Tags tags;

    @JsonProperty("appid")
    public Integer getAppid() {
        return appid;
    }

    @JsonProperty("appid")
    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("developer")
    public String getDeveloper() {
        return developer;
    }

    @JsonProperty("developer")
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("score_rank")
    public String getScoreRank() {
        return scoreRank;
    }

    @JsonProperty("score_rank")
    public void setScoreRank(String scoreRank) {
        this.scoreRank = scoreRank;
    }

    @JsonProperty("positive")
    public Integer getPositive() {
        return positive;
    }

    @JsonProperty("positive")
    public void setPositive(Integer positive) {
        this.positive = positive;
    }

    @JsonProperty("negative")
    public Integer getNegative() {
        return negative;
    }

    @JsonProperty("negative")
    public void setNegative(Integer negative) {
        this.negative = negative;
    }

    @JsonProperty("userscore")
    public Integer getUserscore() {
        return userscore;
    }

    @JsonProperty("userscore")
    public void setUserscore(Integer userscore) {
        this.userscore = userscore;
    }

    @JsonProperty("owners")
    public String getOwners() {
        return owners;
    }

    @JsonProperty("owners")
    public void setOwners(String owners) {
        this.owners = owners;
    }

    @JsonProperty("average_forever")
    public Integer getAverageForever() {
        return averageForever;
    }

    @JsonProperty("average_forever")
    public void setAverageForever(Integer averageForever) {
        this.averageForever = averageForever;
    }

    @JsonProperty("average_2weeks")
    public Integer getAverage2weeks() {
        return average2weeks;
    }

    @JsonProperty("average_2weeks")
    public void setAverage2weeks(Integer average2weeks) {
        this.average2weeks = average2weeks;
    }

    @JsonProperty("median_forever")
    public Integer getMedianForever() {
        return medianForever;
    }

    @JsonProperty("median_forever")
    public void setMedianForever(Integer medianForever) {
        this.medianForever = medianForever;
    }

    @JsonProperty("median_2weeks")
    public Integer getMedian2weeks() {
        return median2weeks;
    }

    @JsonProperty("median_2weeks")
    public void setMedian2weeks(Integer median2weeks) {
        this.median2weeks = median2weeks;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("initialprice")
    public String getInitialprice() {
        return initialprice;
    }

    @JsonProperty("initialprice")
    public void setInitialprice(String initialprice) {
        this.initialprice = initialprice;
    }

    @JsonProperty("discount")
    public String getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @JsonProperty("languages")
    public String getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty("ccu")
    public Integer getCcu() {
        return ccu;
    }

    @JsonProperty("ccu")
    public void setCcu(Integer ccu) {
        this.ccu = ccu;
    }

    @JsonProperty("tags")
    public Tags getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

}
