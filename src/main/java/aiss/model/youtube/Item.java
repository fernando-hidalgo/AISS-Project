
package aiss.model.youtube;

import java.util.HashMap;
import java.util.Map;

public class Item {

    private String kind;
    private String etag;
    private String id;
    private Snippet snippet;
    private Statistics statistics;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
