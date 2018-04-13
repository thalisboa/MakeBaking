package com.example.android.makeabakingapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.recipes.Ingredients;
import com.example.android.makeabakingapp.ui.fragments.IngredientsFragment;

import org.parceler.Parcels;

import java.util.List;

public class IngredientsAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final List<Ingredients> ingredients = Parcels.unwrap(getIntent().getParcelableExtra("ingredients"));

        Bundle arguments = new Bundle();
        arguments.putParcelable("ingredients", getIntent().getParcelableExtra("ingredients"));
        IngredientsFragment fragment = new IngredientsFragment();

        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.ingredients_container, fragment)
                .commit();


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
