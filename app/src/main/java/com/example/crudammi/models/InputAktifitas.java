package com.example.crudammi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputAktifitas {
    @SerializedName("id_aktivitas")
    @Expose
    String idAktifitas;

    @SerializedName("id_user")
    @Expose
    String idUser;

    @SerializedName("waktu_aktivitas")
    @Expose
    String waktuAktifitas;

    public String getIdAktifitas() {
        return idAktifitas;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getWaktuAktifitas() {
        return waktuAktifitas;
    }
}
