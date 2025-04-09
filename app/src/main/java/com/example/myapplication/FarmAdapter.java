package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FarmAdapter extends RecyclerView.Adapter<FarmAdapter.FarmViewHolder> implements Filterable {

    private List<Farm> farmList;
    private Context context;
    private List<Farm> fullList;


    public FarmAdapter(List<Farm> farmList, Context context) {
        this.farmList = farmList;
        this.context = context;
        this.fullList = new ArrayList<>(farmList);
    }

    @NonNull
    @Override
    public FarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_farm, parent, false);
        return new FarmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmViewHolder holder, int position) {
        Farm farm = farmList.get(position);
        holder.nameTextView.setText(farm.getName());
        holder.descriptionTextView.setText(farm.getDescription());
        holder.imageView.setImageResource(farm.getImageResId(context));

        // OnClick: Open Farm Details Activity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FarmDetailsActivity.class);
            intent.putExtra("farm", farm);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return farmList.size();
    }


        public static class FarmViewHolder extends RecyclerView.ViewHolder {
            TextView nameTextView;
            TextView descriptionTextView;
            ImageView imageView;

            public FarmViewHolder(@NonNull View itemView) {
                super(itemView);
                nameTextView = itemView.findViewById(R.id.farmName);
                descriptionTextView = itemView.findViewById(R.id.farmDescription);
                imageView = itemView.findViewById(R.id.farmImage);
            }
        }


    private final Filter farmFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Farm> filtered = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filtered.addAll(fullList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Farm farm : fullList) {
                    if (farm.getName().toLowerCase().contains(filterPattern)) {
                        filtered.add(farm);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filtered;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            farmList.clear();
            farmList.addAll((List<Farm>) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return farmFilter;
    }

}


