package com.example.android.makeabakingapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.recipes.Ingredients;
import com.example.android.makeabakingapp.recipes.Steps;

import java.util.List;


public class RecipeAdapterDetail extends RecyclerView.Adapter<RecipeAdapterDetail.RecipeDetailHolder> {

    private List<Steps> steps;
    private Context context;

    RecipeAdapterDetail(List<Ingredients> ingredients, List<Steps> steps, Context context) {


        this.steps = steps;
        this.context = context;

    }

    @Override
    public RecipeDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new RecipeDetailHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_recipes_details, parent, false));

    }

    @Override
    public void onBindViewHolder(RecipeDetailHolder holder, int position) {

        if (!steps.isEmpty()) {

            //holder.mId.setText();
           // holder.mShortDescription.setText();

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecipeDetailHolder extends RecyclerView.ViewHolder {

        private TextView mId;
        private TextView mShortDescription;


        public RecipeDetailHolder(View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.tv_quantity);
            mShortDescription = itemView.findViewById(R.id.tv_measure);

        }
    }
}
