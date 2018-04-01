package com.example.android.makeabakingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.makeabakingapp.adapter.RecipeAdapter;
import com.example.android.makeabakingapp.network.Service;
import com.example.android.makeabakingapp.recipes.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final Object TAG = "test";
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_recipes);

        Service service = Service.retrofit.create(Service.class);
        Call<List<Recipe>> requestCatalog = service.listRecipes();

        requestCatalog.enqueue(new Callback<List<Recipe>>() {

            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                List<Recipe> recipes = response.body();

                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                RecipeAdapter recipeAdapter = new RecipeAdapter(MainActivity.this, recipes);
                mRecyclerView.setAdapter(recipeAdapter);

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

            }
        });
    }

    private void setupRecyclerView(List<Recipe> recipes) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecipeAdapter recipeAdapter = new RecipeAdapter(MainActivity.this, recipes);
        mRecyclerView.setAdapter(recipeAdapter);
    }
}