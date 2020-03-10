package com.example.crudammi.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudammi.api.ApiConfig;
import com.example.crudammi.api.ApiInterface;
import com.example.crudammi.R;
import com.example.crudammi.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //inisialisasi progress dialog sebelum dipanggil
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Mengambil data...");
        progressDialog.setCancelable(false);

        //inisialisasi button dan apa yang terpanggil kalau di klik
        Button getAllUserData = findViewById(R.id.getAllUserButton);
        getAllUserData.setOnClickListener( v-> {
              getAllUserData();
        });

        Button getSingleUserData = findViewById(R.id.getSingleUserButton);
        EditText idInput = findViewById(R.id.idInput);
        getSingleUserData.setOnClickListener(v->{
            //kalo kosong kasi peringatan, kalo tidakmi panggil api nya
            String id = idInput.getText().toString();
            if (id.equals("")) {
                idInput.setError("Ini tidak boleh kosong");
            } else {
                getSingleUser(id);
            }
        });

        Button addUser = findViewById(R.id.addUserData);
        addUser.setOnClickListener(v-> {
            Intent intent = new Intent(UserActivity.this, AddUserAcitivty.class);
            startActivity(intent);
        });

    }

    public void setData(List<User> userResponse) {
        //inisialisasi adapter untuk daftar user lalu pasang data datanya
        UserListAdapter adapter = new UserListAdapter(
                userResponse,
                this
        );
        RecyclerView rv = findViewById(R.id.userRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }

    public void getAllUserData() {
        //Creating Retrofit rest adapter
        //Creating an object of our api interface
        ApiInterface api = new ApiConfig().instance();
        Call<ArrayList<User>> call = api.getAllUsers();

        //munculkan progres dialog
        progressDialog.show();

        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                //pasang data dan matikan progress dialog kalau sudah ada responnya server
                setData(response.body());
                progressDialog.hide();
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                //kalo ada error ini yang terpanggil
                progressDialog.hide();
                Toast.makeText(getBaseContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getSingleUser(String userId) {
        //Creating Retrofit rest adapter
        //Creating an object of our api interface
        ApiInterface api = new ApiConfig().instance();
        Call<ArrayList<User>> call = api.getSingleUser(userId);

        //munculkan progres dialog
        progressDialog.show();

        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                //pasang data dan matikan progress dialog kalau sudah ada responnya server
                setData(response.body());
                progressDialog.hide();
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                //kalo ada error ini yang terpanggil
                progressDialog.hide();
                Toast.makeText(getBaseContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
