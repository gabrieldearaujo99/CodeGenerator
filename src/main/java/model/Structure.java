package model;

public class Structure {
    private String name;
    private String visibility;
    /*Type: String, int ...*/
    private String type;

    public Structure(String name, String visibility, String type) {
        this.name = name;
        this.visibility = visibility;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
