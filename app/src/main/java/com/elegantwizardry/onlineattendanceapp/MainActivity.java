package com.elegantwizardry.onlineattendanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyClickListener{

    private RecyclerView recyclerView;
    private StoresAdapter storesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        StoresViewModel storesViewModel = ViewModelProviders.of(this).get(StoresViewModel.class);
        storesViewModel.sViewModel();

        storesViewModel.getStoresMutableLiveData().observe(this, stores -> {
            if(stores != null && stores.getDataList() != null){
                storesAdapter = new StoresAdapter(this, stores.getDataList(), this);
                recyclerView.setAdapter(storesAdapter);
                Log.d("issue","Working...");
            }

        });

        storesViewModel.getErrorResponse().observe(this, errorResponse -> {
            Log.d("issue","NotWorking...");
            if (errorResponse != null) {
                Toast.makeText(this, "Error: " + errorResponse, Toast.LENGTH_LONG).show();
            }
        });
    }




    @Override
    public void myOnClick(Stores.Data data) {
        Intent intent = new Intent(this, AttendanceInfoSubmit.class);
        intent.putExtra("key_data", data);
        startActivity(intent);
    }
}
