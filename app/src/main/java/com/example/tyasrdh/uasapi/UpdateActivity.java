package com.example.tyasrdh.uasapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyasrdh.uasapi.model.ErrorMessage;
import com.example.tyasrdh.uasapi.model.Musik;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    private static final String TAG = "UpdateActivity";
    private ApiInterface apiInterface;
    EditText Etmusik_title, Etmusik_genre, Etawards, Etlabel, Etsinger, Etrelease_year, Etmusik_writer;
    Button BbtnAdd,BbtnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_musik);

        Intent intent = getIntent();
        Etmusik_title = findViewById(R.id.musik_title);
        Etmusik_genre = findViewById(R.id.musik_genre);
        Etawards = findViewById(R.id.awards);
        Etlabel = findViewById(R.id.label);
        Etsinger = findViewById(R.id.singer);
        Etrelease_year = findViewById(R.id.release_year);
        Etmusik_writer = findViewById(R.id.musik_writer);
        BbtnAdd = findViewById(R.id.btnAdd);
        BbtnDelete = findViewById(R.id.btnDelete);

        String musik_title = intent.getStringExtra("musik_title");
        String musik_genre = intent.getStringExtra("musik_genre");
        String awards = intent.getStringExtra("awards");
        String label = intent.getStringExtra("label");
        String singer = intent.getStringExtra("singer");
        String release_year= intent.getStringExtra("release_year");
        String musik_writer = intent.getStringExtra("musik_witer");

        int id = intent.getIntExtra("id",0);
        Log.d(TAG, "onCreate: gg " + intent.getStringExtra("musik_title"));
        Log.d(TAG, "onCreate: " + id);

        Etmusik_title.setText(musik_title);
        Etmusik_genre.setText(musik_genre);
        Etawards.setText(awards);
        Etlabel.setText(label);
        Etsinger.setText(singer);
        Etrelease_year.setText(release_year);
        Etmusik_writer.setText(musik_writer);

        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        BbtnAdd.setOnClickListener(view -> updateData(id, Etmusik_title.getText().toString(), (Etmusik_genre.getText().toString()),
                (Etawards.getText().toString()), (Etlabel.getText().toString()),
                (Etsinger.getText().toString()), (Etrelease_year.getText().toString()), (Etmusik_writer.getText().toString())));
        BbtnDelete.setOnClickListener(view -> deleteData(id));
    }

    private void deleteData(int id) {
        Call<ErrorMessage> data = apiInterface.hapusMusik(id);
        data.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(UpdateActivity.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: jj " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }

    private void updateData(Integer id, String musik_title, String musik_genre, String award, String label, String singer,
                            String release_year, String musik_writer) {
        Call<ErrorMessage> dataCall = apiInterface.ubahMusik(id,musik_title, musik_genre, award, label, singer, release_year, musik_writer);
        dataCall.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(UpdateActivity.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Data gagal diupdate", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }
}
