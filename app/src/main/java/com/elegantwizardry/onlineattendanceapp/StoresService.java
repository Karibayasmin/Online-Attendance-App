package com.elegantwizardry.onlineattendanceapp;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

public class StoresService {

    public StoresService(){

    }
        public void StService(final JSONObjectHandler complete) {
            AndroidNetworking.get("http://128.199.215.102:4040/api/stores")
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            complete.onComplete(response, null);

                            Log.d("Kariba","Message comming");

                        }

                        @Override
                        public void onError(ANError anError) {
                            complete.onComplete(null, anError);
                        }
                    });
        }
    }
