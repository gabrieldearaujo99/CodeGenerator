package model;

import java.util.ArrayList;

public class Class extends Structure {
    private final ArrayList<Attribute> attributes;
    private final ArrayList<Method> methods;
    private final boolean isAbstrasct;

    public Class(String id, String name, ArrayList<Attribute> attributes, ArrayList<Method> methods, boolean isAbstrasct) {
        super(id, name);
        this.attributes = attributes;
        this.methods = methods;
        this.isAbstrasct = isAbstrasct;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public ArrayList<Method> getMethods() {
        return methods;
    }

    public boolean isAbstrasct() {
        return isAbstrasct;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", attributes=" + attributes +
                ", methods=" + methods +
                ", isAbstrasct=" + isAbstrasct +
                '}';
    }
}
