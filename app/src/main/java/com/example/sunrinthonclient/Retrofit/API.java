package com.example.sunrinthonclient.Retrofit;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API  {
    @POST("/account/login")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> login(@Field("username") @NotNull String username, @Field("password") @NotNull String password);

    @POST("/account/register")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> register(@Field("username") @NotNull String username, @Field("password") @NotNull String password,
                                @Field("name") @NotNull String name, @Field("personalID") @NotNull String personalID);
    @POST("/account/certificate")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> certificate(@Field("registerkey") @NotNull String registerkey, @Field("personalID") int personalID);

    @POST("/reservation/reserve")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> reserve(@Field("username") @NotNull String username, @Field("roomnumber")  int roomnumber,
                               @Field("months")  int months, @Field("days")  int days, @Field("time") int time);

    @POST("/admin/cancel")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> cancelByAdmin(@Field("roomnumber")  int roomnumber,
                              @Field("months")  int months, @Field("days")  int days, @Field("time") int time);

    @POST("/admin/getallrooms")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> getallroomsByAdmin(@Field("months")  int months, @Field("days")  int days);

    @POST("/admin/getPenalty")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> getPenalty(@Field("username") @NonNull String username);

    @POST("/admin/addPenalty")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> addPenalty(@Field("username") @NonNull String username);

    @POST("/admin/getrooms")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> getroomsByAdmin(@Field("months")  int months, @Field("days")  int days,
                                @Field("time")  int time);

    @POST("/admin/getroom")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> getroomByAdmin(@Field("months")  int months, @Field("days")  int days,
                               @Field("time")  int time, @Field("roomnumber") int roomnumber);


    @POST("/reservation/cancel")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> cancel(@Field("username") @NotNull String username, @Field("roomnumber") int roomnumber,
                              @Field("months")  int months, @Field("days")  int days, @Field("time") int time);

    @POST("/reservation/getallrooms")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> getallrooms(@Field("months")  int months, @Field("days")  int days);

    @POST("/reservation/getreservedrooms")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> getreservedrooms(@Field("months")  int months, @Field("username")  @NonNull String username);

    @POST("/reservation/getrooms")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> getrooms(@Field("months")  int months, @Field("days")  int days,
                                @Field("time")  int time);

    @POST("/reservation/getroom")
    @FormUrlEncoded
    @NotNull
    Call<ResponseBody> getroom(@Field("months")  int months, @Field("days")  int days,
                               @Field("time")  int time, @Field("roomnumber")  int roomnumber, @Field("username") @NonNull String username);
}
