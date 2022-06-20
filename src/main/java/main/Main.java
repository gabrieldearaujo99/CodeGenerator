package main;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Class;
import model.Attribute;
import model.Method;


public class Main {
    public static void main(String[] args) {
        JSONObject jsonObject = readAndReturnJsonObject("in/ArquivoTeste.mdj");
        JSONArray jsonArrayClasses = getJsonArrayClasses(jsonObject);
        ArrayList<Class> arrayListClasses = getInstanceClass(jsonArrayClasses);

        for(Class arrayListClass : arrayListClasses) {
            System.out.println(arrayListClass);
        }

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

    static JSONArray getJsonArrayClasses(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("ownedElements").getJSONObject(0).getJSONArray("ownedElements");
        JSONArray jsonArraylasses = new JSONArray();
        for(int i = 1; i < jsonArray.length(); ++i)
            jsonArraylasses.put(jsonArray.getJSONObject(i));
        return jsonArraylasses;
    }

    static boolean hasKey(JSONArray jsonArrayClasses, int i, int j, String keyList, String key) {
        return jsonArrayClasses.getJSONObject(i).getJSONArray(keyList).getJSONObject(j).has(key);
    }

    static ArrayList<Attribute> getArrayListAttributes(JSONArray jsonArrayClasses, int i) {
        ArrayList<Attribute> arrayListAttributes = new ArrayList<>();
        String nameAttribute, visibilityAttribute, typeAttribute;
        for(int j = 0; j < jsonArrayClasses.getJSONObject(i).getJSONArray("attributes").length(); ++j) {
            nameAttribute = jsonArrayClasses.getJSONObject(i).getJSONArray("attributes").getJSONObject(j).getString("name");
            visibilityAttribute = hasKey(jsonArrayClasses, i, j, "attributes", "visibility") ?
                    jsonArrayClasses.getJSONObject(i).getJSONArray("attributes").getJSONObject(j).getString("visibility")
                    : "";
            typeAttribute = hasKey(jsonArrayClasses, i, j, "attributes", "type") ?
                    jsonArrayClasses.getJSONObject(i).getJSONArray("attributes").getJSONObject(j).getString("type")
                    : "";
            arrayListAttributes.add(new Attribute(nameAttribute, visibilityAttribute, typeAttribute));
        }
        return arrayListAttributes;
    }

    static ArrayList<Method> getArrayListMethods(JSONArray jsonArrayClasses, int i) {
        ArrayList<Method> arrayListMethods = new ArrayList<>();
        String nameMethod, visibilityMethod, stereotypeMethod;
        for(int j = 0; j < jsonArrayClasses.getJSONObject(i).getJSONArray("operations").length(); ++j) {
            nameMethod = jsonArrayClasses.getJSONObject(i).getJSONArray("operations").getJSONObject(j).getString("name");
            visibilityMethod = hasKey(jsonArrayClasses, i, j, "operations", "visibility") ?
                    jsonArrayClasses.getJSONObject(i).getJSONArray("operations").getJSONObject(j).getString("visibility")
                    : "";
            stereotypeMethod = hasKey(jsonArrayClasses, i, j,"operations", "stereotype") ?
                    jsonArrayClasses.getJSONObject(i).getJSONArray("operations").getJSONObject(j).getString("stereotype")
                    : "";
            arrayListMethods.add(new Method(nameMethod, visibilityMethod, stereotypeMethod));
        }
        return arrayListMethods;
    }

    static ArrayList<Class> getInstanceClass(JSONArray jsonArrayClasses) {
        ArrayList<Class> arrayListClasses = new ArrayList<>();
        ArrayList<Attribute> arrayListAttributes = null;
        ArrayList<Method> arrayListMethods = null;
        String name;
        for(int i = 0; i < jsonArrayClasses.length(); ++i) {
           name = jsonArrayClasses.getJSONObject(i).getString("name");
           if(jsonArrayClasses.getJSONObject(i).has("attributes"))
               arrayListAttributes = getArrayListAttributes(jsonArrayClasses, i);
           if(jsonArrayClasses.getJSONObject(i).has("operations"))
               arrayListMethods = getArrayListMethods(jsonArrayClasses, i);
           arrayListClasses.add(new Class(name, arrayListAttributes, arrayListMethods));
        }
        return arrayListClasses;
    }
}