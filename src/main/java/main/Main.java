package main;

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
        ArrayList<String> arrayListClasses = getNameClasses(jsonArrayClasses);

        for (String arrayListClass : arrayListClasses)
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

    static ArrayList<String> getNameClasses(JSONArray jsonArrayClasses) {
        ArrayList<String> arrayListClasses = new ArrayList<>();
        for(int i = 0; i < jsonArrayClasses.length(); ++i)
            arrayListClasses.add(jsonArrayClasses.getJSONObject(i).getString("name"));
        return arrayListClasses;
    }
}