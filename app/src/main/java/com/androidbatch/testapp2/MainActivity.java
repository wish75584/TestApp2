package com.androidbatch.testapp2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_images;
    ImagesAdapter imagesAdapter;
    RetrofitInterface anInterface;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_images = findViewById(R.id.rv_images);
        rv_images.setLayoutManager(new LinearLayoutManager(this));
        anInterface = RetrofitClass.getClient().create(RetrofitInterface.class);

        fetchPost();
    }

    private void fetchPost() {

        Call<List<Model>> getImages = anInterface.getImages();

        getImages.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                list = response.body();
                imagesAdapter = new ImagesAdapter(MainActivity.this, list);
                rv_images.setAdapter(imagesAdapter);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}