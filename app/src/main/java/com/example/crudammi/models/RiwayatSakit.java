package com.example.crudammi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RiwayatSakit {
    @SerializedName("id_riwayat_penyakit")
    @Expose
    String idRiwayatPenyakit;

    @SerializedName("id_user")
    @Expose
    String idUser;

    @SerializedName("nama_riwayat_penyakit")
    @Expose
    String namaRiwayatPenyakit;

    public String getIdRiwayatPenyakit() {
        return idRiwayatPenyakit;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getNamaRiwayatPenyakit() {
        return namaRiwayatPenyakit;
    }
}
