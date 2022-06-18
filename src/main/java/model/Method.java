package model;

public class Method extends Structure {
    private String visibility;
    private String stereotype;

    public Method(String name, String visibility, String stereotype) {
        super(name);
        this.visibility = visibility;
        this.stereotype = stereotype;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getStereotype() {
        return stereotype;
    }

    public void setStereotype(String stereotype) {
        this.stereotype = stereotype;
    }
}
