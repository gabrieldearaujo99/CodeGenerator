package model;

public class Attribute extends Structure {
    private String visibility;
    private String type;

    public Attribute(String name, String visibility, String type) {
        super(name);
        this.visibility = visibility;
        this.type = type;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
