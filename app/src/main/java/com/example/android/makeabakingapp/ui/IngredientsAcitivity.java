package com.example.android.makeabakingapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.adapter.IngredientsAdapter;
import com.example.android.makeabakingapp.recipes.Ingredients;

import org.parceler.Parcels;

import java.util.List;

public class IngredientsAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final List<Ingredients> ingredients = Parcels.unwrap(getIntent().getParcelableExtra("ingredients"));


        RecyclerView mRecyclerView = findViewById(R.id.rv_ingredients);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(ingredients, this);

        mRecyclerView.setAdapter(ingredientsAdapter);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
