package com.androidbatch.testapp2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShowFavoritesActivity extends AppCompatActivity {

    RecyclerView rv_favs;
    FavoritesAdapter adapter;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_favorites);

        rv_favs = findViewById(R.id.rv_favs);
        rv_favs.setLayoutManager(new LinearLayoutManager(this));

        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
        SQLiteDatabase sqLiteDatabase = sqLiteHelper.getReadableDatabase();

        String cols[] = {"restaurant_name"};
        Cursor cursor = sqLiteDatabase.query("POST", cols, "", null, "", "", "");
        list = new ArrayList<Model>();

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("restaurant_name"));

            Model m1 = new Model("" + name);
            list.add(m1);
        }
        cursor.close();
        adapter = new FavoritesAdapter(this, list);
        rv_favs.setAdapter(adapter);
    }
}