package com.example.guskensin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.EditText;

import com.example.db_library.DBHelper;


class Calc extends DBHelper {
    Calc(Context context) {
        super(context);
    }

    void Calc_used(MainActivity mainActivity , String str , Cursor c){

        float num3 = Float.parseFloat(String.valueOf(str)) - Float.parseFloat(c.getString(4));
        @SuppressLint("DefaultLocale") String num = String.format("%.1f", num3);

        EditText used = mainActivity.findViewById(R.id.Row2_Text);
        used.setText(String.valueOf(num));

    }
}
