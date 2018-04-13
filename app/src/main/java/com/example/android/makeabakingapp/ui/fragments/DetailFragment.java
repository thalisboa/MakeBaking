package com.example.android.makeabakingapp.ui.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.adapter.StepAdapter;
import com.example.android.makeabakingapp.recipes.Recipe;
import com.example.android.makeabakingapp.ui.IngredientsAcitivity;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private View mRootView;
    private Recipe mRecipe;
    private RecyclerView mRecyclerView;
    private Context context;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Button btn = mRootView.findViewById(R.id.btn_ing);

        mRecyclerView = mRootView.findViewById(R.id.rv_step);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        StepAdapter stepAdapter = new StepAdapter(mRecipe.getSteps(), getActivity());

        mRecyclerView.setAdapter(stepAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, IngredientsAcitivity.class);

                intent.putExtra("ingredients", Parcels.wrap(mRecipe.getIngredients()));
                startActivity(intent);
            }
        });


        return mRootView;
    }

}
