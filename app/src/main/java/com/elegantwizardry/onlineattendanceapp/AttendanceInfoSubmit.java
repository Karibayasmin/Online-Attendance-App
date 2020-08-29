package com.elegantwizardry.onlineattendanceapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AttendanceInfoSubmit extends AppCompatActivity{

    Button Submit;
    private final int UPDATE_NAME_REQUEST_CODE = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_attendance_info_submit);
        setContentView(R.layout.attendance_info_submit);

         Submit = findViewById(R.id.submit);
        EditText name = findViewById(R.id.name_edt);
        EditText id = findViewById(R.id.userid_edt);

        if (getIntent() != null) {
            Stores.Data data = (Stores.Data) getIntent().getSerializableExtra("key_data");

            if (data != null) {
                name.setText(data.getName());
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == UPDATE_NAME_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String nameUdateSuccess = data.getStringExtra("name_udate_success");

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AttendanceInfoSubmit.this, AttendanceSubmission.class);
                startActivityForResult(intent, UPDATE_NAME_REQUEST_CODE);
            }
        });
    }
}