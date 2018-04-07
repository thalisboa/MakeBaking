package com.example.android.makeabakingapp.recipes;


import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Ingredients {

    @SerializedName("ingredient")

    String name;

    String quantity;

    String measure;

    public Ingredients(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {return name;}

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
