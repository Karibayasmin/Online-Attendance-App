package com.elegantwizardry.onlineattendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AttendanceInfoSubmit extends AppCompatActivity implements MyClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_attendance_info_submit);
        setContentView(R.layout.attendance_info_submit);

        EditText name = findViewById(R.id.name_edt);
       // EditText id = findViewById(R.id.userid_edt);

        if (getIntent() != null) {
            Stores.Data data = (Stores.Data) getIntent().getSerializableExtra("key_data");

            if (data != null) {
                name.setText(data.getName());
            }
        }
    }

    @Override
    public void myOnClick(Stores.Data data) {
        Intent intent = new Intent(this, AttendanceInfoSubmit.class);
        intent.putExtra("key_data", data);
        startActivity(intent);
    }
}