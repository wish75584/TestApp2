package com.androidbatch.testapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.RecyclerViewHolder> {

    Context context;
    List<Model> list;

    public ImagesAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        RecyclerViewHolder imgviewholder = new RecyclerViewHolder(view);
        return imgviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesAdapter.RecyclerViewHolder holder, int position) {
        Model m_list = list.get(position);

        Glide.with(context)
                .load(m_list.getRestaurant_image())
                .centerCrop()
                .into(holder.iv_image);

        holder.tv__restaurant_name.setText(m_list.getRestaurant_name());
        holder.tv_lattitude.setText(m_list.getLatitude());
        holder.tv_longitude.setText(m_list.getLongitude());

        Log.e("data ",m_list.restaurant_name);
        Toast.makeText(context, ""+m_list.restaurant_name, Toast.LENGTH_SHORT).show();

        holder.img_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.img_heart.setImageResource(R.drawable.ic_pink_heart);

                SQLiteHelper dbHelper = new SQLiteHelper(context);
                final SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();
                contentValues.put("restaurant_name", m_list.getRestaurant_name());

                long rowId = db.insert("POST", null, contentValues);

                if (rowId >= 1) {
                    Toast.makeText(context, "data uploaded susccessfully", Toast.LENGTH_SHORT).show();
                }
                Log.e(String.valueOf(db.insert("TEST", null, contentValues)), "onClick:querry ");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tv__restaurant_name, tv_lattitude, tv_longitude;
        ImageView iv_image, img_heart;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            tv__restaurant_name = itemView.findViewById(R.id.tv__restaurant_name);
            tv_lattitude = itemView.findViewById(R.id.tv_lattitude);
            tv_longitude = itemView.findViewById(R.id.tv_longitude);
            iv_image = itemView.findViewById(R.id.iv_image);
            img_heart = itemView.findViewById(R.id.img_heart);
        }
    }
}
