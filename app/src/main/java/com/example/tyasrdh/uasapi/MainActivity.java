package com.example.tyasrdh.uasapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.tyasrdh.uasapi.model.DataResponse;
import com.example.tyasrdh.uasapi.model.Musik;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ApiInterface apiInterface;
    private List<Musik> dataList = new ArrayList<>();
    private RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter();
    FloatingActionButton btnFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleViewAdapter);
        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        btnFloat = findViewById(R.id.btnMainFloating);

        btnFloat.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,AddActivity.class)));

        getItem();

        recycleViewAdapter.setOnClickListener(position -> {
            Musik data = dataList.get(position);
            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
            intent.putExtra("musik_title", data.getMusik_title());
            intent.putExtra("musik_genre", data.getMusik_genre());
            intent.putExtra("awards", data.getAwards());
            intent.putExtra("label", data.getLabel());
            intent.putExtra("singer", data.getSinger());
            intent.putExtra("release_year", data.getRelease_year());
            intent.putExtra("musik_writer", data.getMusik_writer());
            intent.putExtra("id", data.getId());
            Log.d(TAG, "onCreate: " + data.getId());
            startActivity(intent);
        });
    }

    public void getItem(){
        Call<DataResponse> dataCall = apiInterface.getData();
        dataCall.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                List<Musik> items = response.body().getData();
                recycleViewAdapter.setDataList(items);
                dataList.addAll(items);
                Log.d(TAG, "onResponse: gg " + dataList);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recycleViewAdapter.clearDataList(dataList);
        getItem();
    }
}
