package com.elegantwizardry.onlineattendanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class AttendanceSubmission extends AppCompatActivity{

    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_submission);

        name = findViewById(R.id.name);


        StoresViewModel storesViewModel = ViewModelProviders.of(this).get(StoresViewModel.class);
        storesViewModel.sViewModel();

        storesViewModel.getStoresMutableLiveData().observe(this, stores -> {
            if(stores != null && stores.getDataList() != null){
                Log.d("name","name coming");
                name.setText(stores.getDataList().get(0).getName());
                Intent intent = new Intent();
                intent.putExtra("name_update_success", "Name changed Successfully");
                setResult(RESULT_OK, intent);
            }

        });
    }
}

