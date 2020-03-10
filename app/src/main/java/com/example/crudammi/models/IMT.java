package com.example.crudammi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IMT {
    @SerializedName("id_imt")
    @Expose
    String idIMT;

    @SerializedName("id_user")
    @Expose
    String idUser;

    @SerializedName("berat_badan")
    @Expose
    String beratBadan;

    @SerializedName("tinggi_badan")
    @Expose
    String tinggiBadan;

    @SerializedName("lingkar_badan")
    @Expose
    String lingkarBadan;
}
