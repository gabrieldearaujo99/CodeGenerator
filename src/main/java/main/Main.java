package main;

import model.Class;
import model.Attribute;
import model.Method;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonObject = readAndReturnJsonObject("in/JsonSimples.mdj");
        JSONArray jsonArrayClasses = getJsonArrayClasses(jsonObject);
        ArrayList<Class> arrayListClasses = getClassInformation(jsonArrayClasses);

        for (Class arrayListClass : arrayListClasses)
            System.out.println(arrayListClass);
    }

    static JSONObject readAndReturnJsonObject(String name) {
        JSONObject json = null;
        try {
            FileReader fileReader = new FileReader(name);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> collect = bufferedReader.lines().collect(Collectors.toList());
            StringBuilder jsonTemp = new StringBuilder();
            for (String s : collect)
                jsonTemp.append(s);
            json = new JSONObject(jsonTemp.toString());
            fileReader.close();
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Não foi possível ler o arquivo json");
        }
        return json;
    }

    static JSONArray getJsonArrayClasses(JSONObject jsonObject){
        JSONArray jsonArray = jsonObject.getJSONArray("ownedElements").getJSONObject(0).getJSONArray("ownedElements");
        JSONArray jsonArraylasses = new JSONArray();
        for(int i = 1; i < jsonArray.length(); ++i)
            jsonArraylasses.put(jsonArray.getJSONObject(i));
        return jsonArraylasses;
    }

    static ArrayList<Class> getClassInformation(JSONArray jsonArrayClasses) {
        ArrayList<Class> arrayListClasses = new ArrayList<>();
        String name;
        ArrayList<Attribute> attributes = null;
        ArrayList<Method> methods = null;
        for(int i = 0; i < jsonArrayClasses.length(); ++i) {
           name = jsonArrayClasses.getJSONObject(i).getString("name");
           arrayListClasses.add(new Class(name, attributes, methods));
        }
        return arrayListClasses;
    }
}