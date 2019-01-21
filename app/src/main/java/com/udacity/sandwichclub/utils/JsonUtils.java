package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        //Variables used for constructing sandwich
        String mainName = "";
        List<String> alsoKnownAs = new ArrayList<>();
        String placeOfOrigin = "";
        String description = "";
        String image = "";
        List<String> ingredients = new ArrayList<>();

        try {
            JSONObject JSONSandwichObject = new JSONObject(json);
            JSONObject JSONName = JSONSandwichObject.getJSONObject("name");

            //Get main name
            mainName = JSONName.getString("mainName");

            //Get other names
            JSONArray JSONAlsoKnownAs = JSONName.getJSONArray("alsoKnownAs");
            if (JSONAlsoKnownAs != null) {
                int length = JSONAlsoKnownAs.length();
                for (int i = 0; i < length; i++)
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
            if (JSONIngredients != null) {
                int length = JSONIngredients.length();
                for (int i = 0; i < length; i++)
                    ingredients.add(JSONIngredients.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAs,
                    placeOfOrigin, description, image, ingredients);


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
