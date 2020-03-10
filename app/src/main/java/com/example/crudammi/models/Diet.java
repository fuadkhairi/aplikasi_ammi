package com.example.crudammi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diet {
    @SerializedName("id_diet")
    @Expose
    String idDiet;

    @SerializedName("id_user")
    @Expose
    String idUser;

    @SerializedName("makanan_kalori")
    @Expose
    String makananKalori;

    @SerializedName("makanan_garam")
    @Expose
    String makananGaram;

    @SerializedName("makanan_lemak")
    @Expose
    String makananLemak;

    public String getIdDiet() {
        return idDiet;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getMakananKalori() {
        return makananKalori;
    }

    public String getMakananGaram() {
        return makananGaram;
    }

    public String getMakananLemak() {
        return makananLemak;
    }
}
