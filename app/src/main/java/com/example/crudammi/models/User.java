package com.example.crudammi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id_user")
    @Expose
    String idUser;

    @SerializedName("nama")
    @Expose
    String nama;

    @SerializedName("gender")
    @Expose
    String gender;

    @SerializedName("umur")
    @Expose
    String umur;

    @SerializedName("no_hp")
    @Expose
    String noHp;

    @SerializedName("no_hp_keluarga")
    @Expose
    String noHpKeluarga;

    @SerializedName("alamat")
    @Expose
    String alamat;

    @SerializedName("tahun_jantung")
    @Expose
    String tahunJantung;

    @SerializedName("pendidikan_terakhir")
    @Expose
    String pendidikanTerakhir;

    @SerializedName("penghasilan")
    @Expose
    String penghasilan;

    @SerializedName("pekerjaan")
    @Expose
    String pekerjaan;

    @SerializedName("agama")
    @Expose
    String agama;

    @SerializedName("suku")
    @Expose
    String suku;

    @SerializedName("rokok")
    @Expose
    String rokok;

    public String getIdUser() {
        return idUser;
    }

    public String getNama() {
        return nama;
    }

    public String getGender() {
        return gender;
    }

    public String getUmur() {
        return umur;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getNoHpKeluarga() {
        return noHpKeluarga;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTahunJantung() {
        return tahunJantung;
    }

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public String getPenghasilan() {
        return penghasilan;
    }

    public String getAgama() {
        return agama;
    }

    public String getSuku() {
        return suku;
    }

    public String getRokok() {
        return rokok;
    }
}

