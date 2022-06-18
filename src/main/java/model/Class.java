package model;

import java.util.ArrayList;

public class Class extends Structure {
    private ArrayList<Attribute> attributes;
    private ArrayList<Method> methods;

    public Class(String name, String visibility, String type, ArrayList<Attribute> attributes, ArrayList<Method> methods) {
        super(name, visibility, type);
        this.attributes = attributes;
        this.methods = methods;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<Method> getMethods() {
        return methods;
    }

    public void setMethods(ArrayList<Method> methods) {
        this.methods = methods;
    }
}
