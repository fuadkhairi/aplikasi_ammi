package com.example.crudammi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeteranganAktifitas {
    @SerializedName("id_aktivitas")
    @Expose
    String idAktifitas;

    @SerializedName("ket_aktifitas")
    @Expose
    String ketAktifitas;
}