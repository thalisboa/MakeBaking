package com.example.android.makeabakingapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.recipes.Ingredients;

import java.util.List;


public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.RecipeDetailHolder> {

    private List<Ingredients> ingredients;
    private Context context;

    public IngredientsAdapter(List<Ingredients> ingredients, Context context) {

        this.ingredients = ingredients;
        this.context = context;

    }

    @Override
    public RecipeDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new RecipeDetailHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_ing, parent, false));

    }

    @Override
    public void onBindViewHolder(RecipeDetailHolder holder, int position) {

        if (!ingredients.isEmpty()) {


            holder.mId.setText((position+1) + " - ");
            holder.mName.setText(ingredients.get(position).getName());
            holder.mQuantity.setText(ingredients.get(position).getQuantity());
            holder.mMeasure.setText(ingredients.get(position).getMeasure());


        }
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class RecipeDetailHolder extends RecyclerView.ViewHolder {

        private TextView mId;
        private TextView mName;
        private TextView mQuantity;
        private TextView mMeasure;

        public RecipeDetailHolder(View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.tv_ingred_number);
            mName = itemView.findViewById(R.id.tv_ingred_name);
            mQuantity = itemView.findViewById(R.id.tv_quantity);
            mMeasure = itemView.findViewById(R.id.tv_measure);


        }
    }
}
