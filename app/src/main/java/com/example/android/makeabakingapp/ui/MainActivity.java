package com.example.android.makeabakingapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.makeabakingapp.R;
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
    private Button mBtRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_recipes);
        mBtRetry = findViewById(R.id.bt_retry);

        final Service service = Service.retrofit.create(Service.class);
        requestRecipes(service);


        mBtRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestRecipes(service);
            }
        });

    }

    private void requestRecipes(Service service) {
        Call<List<Recipe>> requestCatalog = service.listRecipes();

        requestCatalog.enqueue(new Callback<List<Recipe>>() {

            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                List<Recipe> recipes = response.body();

                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                RecipeAdapter recipeAdapter = new RecipeAdapter(MainActivity.this, recipes);
                mRecyclerView.setAdapter(recipeAdapter);

                mRecyclerView.setVisibility(View.VISIBLE);
                mBtRetry.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();

                mRecyclerView.setVisibility(View.GONE);
                mBtRetry.setVisibility(View.VISIBLE);
            }
        });
    }


}