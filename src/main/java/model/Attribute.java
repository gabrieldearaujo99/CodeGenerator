package model;

public class Attribute extends Structure {
    private final String visibility;
    private final String type;

    public Attribute(String id, String name, String visibility, String type) {
        super(id, name);
        this.visibility = visibility;
        this.type = type;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", visibility='" + visibility + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
