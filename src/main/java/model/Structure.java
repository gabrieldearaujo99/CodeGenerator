package model;

public class Structure {
    protected final String id;
    protected final String name;

    public Structure(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
