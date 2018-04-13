package com.example.android.makeabakingapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.recipes.Recipe;
import com.example.android.makeabakingapp.ui.fragments.DetailFragment;

import org.parceler.Parcels;

public class RecipeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Recipe recipe = (Recipe) Parcels.unwrap(getIntent().getParcelableExtra("recipe"));

        Bundle arguments = new Bundle();
        arguments.putParcelable("recipe", getIntent().getParcelableExtra("recipe"));

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.details_container, fragment)
                .commit();

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
