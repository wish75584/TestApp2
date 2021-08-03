package com.androidbatch.testapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.RecyclerViewHolder> {

    Context context;
    List<Model> fav_list;


    public FavoritesAdapter(Context context, List<Model> fav_list) {
        this.context = context;
        this.fav_list = fav_list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_favs, parent, false);
        RecyclerViewHolder imgviewholder = new RecyclerViewHolder(view);
        return imgviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Model fv = fav_list.get(position);
        holder.tv__restaurant_name_favs.setText(fv.getRestaurant_name());
    }


    @Override
    public int getItemCount() {
        return fav_list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tv__restaurant_name_favs;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tv__restaurant_name_favs = itemView.findViewById(R.id.tv__restaurant_name_favs);

        }
    }
}
