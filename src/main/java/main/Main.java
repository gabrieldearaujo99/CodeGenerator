package main;

import java.util.ArrayList;

import model.Class;

public class Main {
    public static void main(String[] args) {
        Parser.run("in/JsonSimples.mdj");
        ArrayList<Class> classes = Parser.getArrayListClasses();

        for(Class aClass : classes) System.out.println(aClass);
    }
}