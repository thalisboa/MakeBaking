package com.example.android.makeabakingapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.adapter.StepAdapter;
import com.example.android.makeabakingapp.recipes.Recipe;

import org.parceler.Parcels;

public class RecipeDetailsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Recipe recipe = (Recipe) Parcels.unwrap(getIntent().getParcelableExtra("recipe"));

        Button btn = findViewById(R.id.btn_ing);

        mRecyclerView = findViewById(R.id.rv_step);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        StepAdapter stepAdapter = new StepAdapter(recipe.getSteps(), this);

        mRecyclerView.setAdapter(stepAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecipeDetailsActivity.this, IngredientsAcitivity.class);

                intent.putExtra("ingredients", Parcels.wrap(recipe.getIngredients()));
                startActivity(intent);
            }
        });

    }

}
