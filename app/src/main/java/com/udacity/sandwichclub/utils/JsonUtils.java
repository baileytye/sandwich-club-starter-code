package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        String mainName = "test";
        List<String> alsoKnownAs = Arrays.asList("also1", "also2", "also3");
        String placeOfOrigin = "Calgary";
        String description = "This is the description";
        String image  = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG";
        List<String> ingredients = Arrays.asList("ing1", "ing2", "ing3");

        try {
            JSONObject JSONSandwichObject = new JSONObject(json);
            JSONObject JSONName = JSONSandwichObject.getJSONObject("name");

            //Get main name
            mainName = JSONName.getString("mainName");

            //Get other names
            JSONArray JSONAlsoKnownAs = JSONName.getJSONArray("alsoKnownAs");
            if(JSONAlsoKnownAs != null){
                alsoKnownAs = new ArrayList<>();
                int length = JSONAlsoKnownAs.length();
                for(int i = 0; i < length; i++)
                    alsoKnownAs.add(JSONAlsoKnownAs.getString(i));
            }

            //Get Description
            description = JSONSandwichObject.getString("description");

            //Get Image URL
            image = JSONSandwichObject.getString("image");

            //Get place of origin
            placeOfOrigin = JSONSandwichObject.getString("placeOfOrigin");


            //Get Ingredients
            JSONArray JSONIngredients = JSONSandwichObject.getJSONArray("ingredients");
            if(JSONIngredients != null){
                ingredients = new ArrayList<>();
                int length = JSONIngredients.length();
                for(int i = 0; i < length; i++)
                    ingredients.add(JSONIngredients.getString(i));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs,
                placeOfOrigin, description, image, ingredients);

        return sandwich;
    }
}
