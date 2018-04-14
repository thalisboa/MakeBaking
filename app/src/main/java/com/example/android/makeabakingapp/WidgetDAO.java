package com.example.android.makeabakingapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.android.makeabakingapp.recipes.Ingredients;
import com.example.android.makeabakingapp.recipes.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thais.nonato on 4/14/2018.
 */
public class WidgetDAO {

    private static final String WIDGET_SP_NAME = "widgets.info";

    private static final String RECIPE_NAME_SUFFIX = ":R";
    private static final String INGREDIENTS_SUFFIX = ":I";

    private static final String SEPARATOR_ITEM = "#::#";
    private static final String SEPARATOR_VALUE = "&::&";

    // Persist data as Shared preference for each widget
    public static void saveIngredients(Context context, int widgetId, Recipe recipe) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(WIDGET_SP_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();

        StringBuilder sb = new StringBuilder();

        // Persist as string, using separator for each item and for each ingredient field
        for (Ingredients ingredient : recipe.getIngredients()) {
            sb.append(formatToString(ingredient));
            sb.append(SEPARATOR_ITEM);
        }

        sharedEditor.putString(widgetId + RECIPE_NAME_SUFFIX, recipe.getName());
        sharedEditor.putString(widgetId + INGREDIENTS_SUFFIX, sb.toString());

        sharedEditor.apply();

    }

    // Restore data from Shared preference
    public static List<Ingredients> restoreIngredients(Context context, int widgetId) {
        ArrayList<Ingredients> ingredients = null;

        SharedPreferences sharedPreferences =
                context.getSharedPreferences(WIDGET_SP_NAME, Context.MODE_PRIVATE);

        String savedIngredients = sharedPreferences.getString(widgetId + INGREDIENTS_SUFFIX, null);

        // Split and convert to object
        if (savedIngredients != null) {
            String[] sIngredients = savedIngredients.split(SEPARATOR_ITEM);

            ingredients = new ArrayList<>(sIngredients.length);

            for (String sIngredient : sIngredients) {
                ingredients.add(getFromString(sIngredient));
            }
        }

        return ingredients != null ? ingredients : null;

    }

    public static String restoreRecipeName(Context context, int widgetId) {

        SharedPreferences sharedPreferences =
                context.getSharedPreferences(WIDGET_SP_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getString(widgetId + RECIPE_NAME_SUFFIX, null);

    }

    // Convert Ingredient object to String with separator
    private static String formatToString(Ingredients ingredient) {
        return ingredient.getQuantity()
                + SEPARATOR_VALUE
                + ingredient.getMeasure()
                + SEPARATOR_VALUE
                + ingredient.getName();
    }

    // Convert String to Ingredient object
    private static Ingredients getFromString(String ingredientStr) {
        String[] sValues = ingredientStr.split(SEPARATOR_VALUE);

        Ingredients ingredient1 = new Ingredients();
        ingredient1.setName(sValues[2]);
        ingredient1.setMeasure(sValues[1]);
        ingredient1.setQuantity(sValues[0]);

        return ingredient1;
    }
}