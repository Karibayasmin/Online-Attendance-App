package com.elegantwizardry.onlineattendanceapp;

import com.androidnetworking.error.ANError;

import org.json.JSONObject;

public interface JSONObjectHandler {

    void onComplete(JSONObject response, ANError error);
}
