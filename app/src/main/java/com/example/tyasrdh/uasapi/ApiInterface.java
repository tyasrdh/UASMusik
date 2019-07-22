package com.example.tyasrdh.uasapi;

import com.example.tyasrdh.uasapi.model.DataResponse;
import com.example.tyasrdh.uasapi.model.ErrorMessage;
import com.example.tyasrdh.uasapi.model.Musik;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("musik")
    Call<DataResponse> getData();
    @FormUrlEncoded

    @POST("musik")
    Call<ErrorMessage> tambahMusik(@Field("musik_title") String musik_title,
                                   @Field("musik_genre") String musik_genre,
                                   @Field("awards") String awards,
                                   @Field("label") String label,
                                   @Field("singer") String singer,
                                   @Field("release_year") String release_year,
                                   @Field("musik_writer") String musik_writer
    );
   @FormUrlEncoded

    @PUT("musik/{id}")
    Call<ErrorMessage> ubahMusik(@Path("id") Integer id,
                                   @Field("musik_title") String musik_title,
                                   @Field("musik_genre") String musik_genre,
                                   @Field("awards") String awards,
                                   @Field("label") String label,
                                   @Field("singer") String singer,
                                   @Field("release_year") String release_year,
                                   @Field("musik_writer") String musik_writer
    );

    @DELETE("musik/{id}")
    Call<ErrorMessage> hapusMusik(@Path("id") Integer id);
}
