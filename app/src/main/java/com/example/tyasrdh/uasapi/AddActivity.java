package com.example.tyasrdh.uasapi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyasrdh.uasapi.model.ErrorMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {
    private static final String TAG = "AddActivity";
    private ApiInterface apiInterface;
    EditText musik_title, musik_genre, awards, label, singer, release_year, musik_writer;
    Button btnAdd,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_musik);

        musik_title = findViewById(R.id.musik_title);
        musik_genre = findViewById(R.id.musik_genre);
        awards = findViewById(R.id.awards);
        label = findViewById(R.id.label);
        singer = findViewById(R.id.singer);
        release_year = findViewById(R.id.release_year);
        musik_writer = findViewById(R.id.musik_writer);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setVisibility(View.INVISIBLE);

        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        btnAdd.setOnClickListener(view -> addData(musik_title.getText().toString(), (musik_genre.getText().toString()),
                (awards.getText().toString()), (label.getText().toString()),
                (singer.getText().toString()), (release_year.getText().toString()), (musik_writer.getText().toString())));
    }
    public void addData(String musik_title, String musik_genre, String awards, String label, String singer,
                        String release_year, String musik_writer){
        Call<ErrorMessage> dataCall = apiInterface.tambahMusik(musik_title, musik_genre, awards, label, singer, release_year, musik_writer);
        dataCall.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(AddActivity.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(AddActivity.this, "Data gagal ditambahkan", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }
}
