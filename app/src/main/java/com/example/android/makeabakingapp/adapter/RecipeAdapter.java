package com.example.android.makeabakingapp.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.recipes.Recipe;

import java.util.List;


public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {

    private static final String TAG = "thais";

    private List<Recipe> recipes;
    private Context context;

    public RecipeAdapter(Context context, List<Recipe> recipes) {

        this.context = context;
        this.recipes = recipes;

    }

    @Override
    public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Log.i(TAG, "onCreateViewHolder: ");
        
        return new RecipeHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecipeHolder holder, int position) {

        Log.i(TAG, "onBindViewHolder: ");

        if (!recipes.isEmpty()) {

            Log.i(TAG, "onBindViewHolder: is Empty");
            Recipe recipe = recipes.get(position);

            holder.mId.setText(recipe.getId());
            holder.mName.setText(recipe.getName());
            holder.mServings.setText(recipe.getServings());
        }

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeHolder extends RecyclerView.ViewHolder {

        private TextView mId;
        private TextView mName;
        private TextView mServings;


        public RecipeHolder(View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.tv_id);
            mName = itemView.findViewById(R.id.tv_name);
            mServings = itemView.findViewById(R.id.tv_servings);

            Log.i(TAG, "RecipeHolder: Constructor");
        }
    }
}
