package com.example.android.makeabakingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.makeabakingapp.R;
import com.example.android.makeabakingapp.recipes.Steps;
import com.example.android.makeabakingapp.ui.StepActivity;

import org.parceler.Parcels;

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
            holder.mLayoutItem.setOnClickListener(holder);

        }
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public class RecipeDetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mId;
        private TextView mShortDescription;
        private LinearLayout mLayoutItem;


        public RecipeDetailHolder(View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.tv_step_number);
            mShortDescription = itemView.findViewById(R.id.tv_short_description);
            mLayoutItem = itemView.findViewById(R.id.rv_recipes_details);
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, StepActivity.class);

            intent.putExtra("steps", Parcels.wrap(steps.get(getAdapterPosition())));

            context.startActivity(intent);
        }
    }


}
