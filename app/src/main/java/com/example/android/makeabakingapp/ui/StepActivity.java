package com.example.android.makeabakingapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.recipes.Steps;
import com.example.android.makeabakingapp.ui.fragments.StepFragment;

import org.parceler.Parcels;

public class StepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //pegar o objeto
        final Steps steps = (Steps) Parcels.unwrap(getIntent().getParcelableExtra("step"));

        Bundle arguments = new Bundle();
        arguments.putParcelable("step", Parcels.wrap(steps));

        StepFragment fragment = new StepFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.step_container, fragment)
                .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
