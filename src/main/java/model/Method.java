package model;

public class Method extends Structure {
    private final String visibility;
    private final String stereotype;

    public Method(String id, String name, String visibility, String stereotype) {
        super(id, name);
        this.visibility = visibility;
        this.stereotype = stereotype;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getStereotype() {
        return stereotype;
    }

    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ", visibility='" + visibility + '\'' +
                ", stereotype='" + stereotype + '\'' +
                '}';
    }
}
