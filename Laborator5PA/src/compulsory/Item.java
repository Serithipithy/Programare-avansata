package compulsory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String location; //file name or Web page

    private Map<String, Object> tags = new HashMap<>();

    // constructors

    public Item(String id, String name, String location) {

    }

    public Item() {

    }

    // setters and getters

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidItemData {
        if (id == null) throw new InvalidItemData(" id.");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidItemData {
        if (id == null) throw new InvalidItemData(" name.");
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) throws InvalidItemData {
        if (!location.contains("https") && !location.contains("D:")) throw new InvalidItemData(" wrong path format.");
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}
