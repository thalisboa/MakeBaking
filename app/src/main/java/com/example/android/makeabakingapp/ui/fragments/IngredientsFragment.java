package com.example.android.makeabakingapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.adapter.IngredientsAdapter;
import com.example.android.makeabakingapp.recipes.Ingredients;

import org.parceler.Parcels;

import java.util.List;

public class IngredientsFragment extends Fragment {

    private View mRootView;
    private Context context;
    private List<Ingredients> ingredients;

    public IngredientsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();

        if (getArguments().containsKey("ingredients")) {
            ingredients = Parcels.unwrap(getArguments().getParcelable("ingredients"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_ingredients, container, false);

        RecyclerView mRecyclerView = mRootView.findViewById(R.id.rv_ingredients);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(ingredients, context);

        mRecyclerView.setAdapter(ingredientsAdapter);

        return mRootView;
    }

}
