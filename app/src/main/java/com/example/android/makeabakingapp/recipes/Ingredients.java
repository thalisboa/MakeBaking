package com.example.android.makeabakingapp.recipes;


import com.google.gson.annotations.SerializedName;

public class Ingredients {

    @SerializedName("ingredient")
    public String name;

    public String quantity;

    public String measure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
