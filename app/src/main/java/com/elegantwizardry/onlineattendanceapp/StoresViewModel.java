package com.elegantwizardry.onlineattendanceapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidnetworking.error.ANError;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class StoresViewModel extends ViewModel {

    private StoresService storesService = new StoresService();
    private Gson gson = new Gson();

    private MutableLiveData<Stores> storesMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorResponse = new MutableLiveData<>();

    public void sViewModel(){

        storesService.StService(new JSONObjectHandler() {
            @Override
            public void onComplete(JSONObject response, ANError error) {
                if(response != null){

                    Stores stores = gson.fromJson(response.toString(), Stores.class);
                    storesMutableLiveData.setValue(stores);

                } else if(error != null){

                    if (error.getErrorCode() != 0) {
                        try {
                            JSONObject jsonObject = new JSONObject(error.getErrorBody());
                            errorResponse.setValue(jsonObject.getJSONObject("error").getString("message"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        errorResponse.setValue(error.getErrorDetail());
                    }

                }
            }
        });
    }


    public MutableLiveData<Stores> getStoresMutableLiveData() {
        return storesMutableLiveData;
    }

    public MutableLiveData<String> getErrorResponse() {
        return errorResponse;
    }
}


