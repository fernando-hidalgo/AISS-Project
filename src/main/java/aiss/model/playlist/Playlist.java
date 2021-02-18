
package aiss.model.playlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {

    private String kind;
    private String etag;
    private String id;
    private Snippet snippet;
    private PageInfo pageInfo;
    private List<Item> items = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
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

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
	public String toString() {
		return "Playlist [items=" + items + "]";
	}

	public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
