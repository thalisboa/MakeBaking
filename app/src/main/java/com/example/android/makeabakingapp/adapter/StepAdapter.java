package com.example.android.makeabakingapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.recipes.Steps;

import java.util.List;


public class StepAdapter extends RecyclerView.Adapter<StepAdapter.RecipeDetailHolder> {

    private List<Steps> steps;
    private Context context;

    public StepAdapter(List<Steps> steps, Context context) {

        this.steps = steps;
        this.context = context;

    }

    @Override
    public RecipeDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new RecipeDetailHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_recipes_details_item, parent, false));

    }

    @Override
    public void onBindViewHolder(RecipeDetailHolder holder, int position) {

        if (!steps.isEmpty()) {

            holder.mId.setText(context.getString(R.string.step)+ ": "+ steps.get(position).getId());
            holder.mShortDescription.setText(steps.get(position).getShortDescription());

        }
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public class RecipeDetailHolder extends RecyclerView.ViewHolder {

        private TextView mId;
        private TextView mShortDescription;


        public RecipeDetailHolder(View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.tv_step_number);
            mShortDescription = itemView.findViewById(R.id.tv_short_description);

        }
    }
}
