package com.example.crudammi.api;

import com.example.crudammi.models.Diet;
import com.example.crudammi.models.IMT;
import com.example.crudammi.models.InputAktifitas;
import com.example.crudammi.models.KeteranganAktifitas;
import com.example.crudammi.models.RiwayatSakit;
import com.example.crudammi.models.User;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    //USERS
    @GET("users")
    Call<ArrayList<User>> getAllUsers();

    @GET("users" + "/{user_id}")
    Call<ArrayList<User>> getSingleUser(@Path("user_id") String userId);

    @POST("users/add")
    Call<User> addUser(@Body JsonObject jsonObject);

    //RIWAYAT SAKIT
    @GET("riwayat_sakit")
    Call<ArrayList<RiwayatSakit>> getAllRiwayatSakit();

    @GET("riwayat_sakit" + "/{id_riwayat_sakit}")
    Call<ArrayList<RiwayatSakit>> getSingleRiwayatSakit(@Path("id_riwayat_sakit") String idRiwayatSakit);

    @POST("riwayat_sakit/add")
    Call<RiwayatSakit> addRiwayatSakit(JsonObject jsonObject);

    //KETERANGAN AKTIFITAS
    @GET("ket_aktivitas")
    Call<ArrayList<KeteranganAktifitas>> getAllKeteranganAktivitas();

    @GET("ket_aktivitas"+ "/{id_ket_aktivitas}")
    Call<ArrayList<KeteranganAktifitas>> getSingleKeteranganAktivitas(@Path("id_ket_aktivitas") String idKetAktivitas);

    @GET("ket_aktifitas/add")
    Call<KeteranganAktifitas> addKeteranganAktivitas(JsonObject jsonObject);

    //INPUT AKTIFITAS
    @GET("input_ak")
    Call<ArrayList<InputAktifitas>> getAllInputAktifitas();

    @GET("input_ak"+ "/{id_input_aktifitas}")
    Call<ArrayList<InputAktifitas>> getSingleInputAktifitas(@Path("id_input_aktifitas") String idInputAktifitas);

    @GET("input_ak/add")
    Call<InputAktifitas> addInputAktivitas(JsonObject jsonObject);

    //INDEKS MASSA TUBUH
    @GET("imt")
    Call<ArrayList<IMT>> getAllIMT();

    @GET("imt"+ "/{id_imt}")
    Call<ArrayList<IMT>> getSingleIMT(@Path("id_imt") String idIMT);

    @GET("imt/add")
    Call<IMT> addIMT(JsonObject jsonObject);

    //POLA DIET
    @GET("diet")
    Call<ArrayList<Diet>> getAlldiet();

    @GET("diet"+ "/{id_diet}")
    Call<ArrayList<Diet>> getSingleDiet(@Path("id_imt") String idIMT);

    @GET("diet/add")
    Call<Diet> addDiet(JsonObject jsonObject);



}
