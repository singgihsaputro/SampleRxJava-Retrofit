package com.example.singgihsaputro.samplerxwithretrofit.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by singgihsaputro on 10/20/16.
 */

public class Utils {
    public static void showToast(Context context, String text, int duration) {
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
