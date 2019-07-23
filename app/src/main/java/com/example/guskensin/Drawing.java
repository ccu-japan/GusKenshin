package com.example.guskensin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.widget.TextView;
import android.widget.Toast;
import com.example.db_library.DBHelper;
import java.text.SimpleDateFormat;
import java.util.Date;

class Drawing extends DBHelper {

    Drawing(Context context) {
        super(context);
    }

    @SuppressLint("SetTextI18n")
    void Draw(MainActivity mainActivity) {
       Date d = new Date();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        TextView textView = mainActivity.findViewById(R.id.date_now);
        textView.setText(sdf.format(d));
    }

    @SuppressLint("SetTextI18n")
     void First(MainActivity mainActivity, String click_button, Cursor c) {
        TextView name = mainActivity.findViewById(R.id.name);
        TextView code = mainActivity.findViewById(R.id.code);
        TextView used = mainActivity.findViewById(R.id.Row1_Text2);
        TextView now  = mainActivity.findViewById(R.id.Row1_Text);

        try {
            switch (click_button) {
                case "First":
                    c.moveToFirst();
                    name.setText(c.getString(0) + c.getString(1));
                    code.setText(c.getString(2) + c.getString(3));
                    used.setText(c.getString(4));
                   // now.setText(c.getString(5));

                    break;
                case "Down":
                    c.moveToNext();
                    name.setText(c.getString(0) + c.getString(1));
                    code.setText(c.getString(2) + c.getString(3));
                    used.setText(c.getString(4));
            //        now.setText(c.getString(5));
                    now.setText("");
                    break;

                case "Up":
                    c.moveToPrevious();
                    name.setText(c.getString(0) + c.getString(1));
                    code.setText(c.getString(2) + c.getString(3));
                    used.setText(c.getString(4));
              //      now.setText(c.getString(5));
                    now.setText("");

                    break;
            }
        }
        catch(IndexOutOfBoundsException e) {
            if(c.getPosition() < 0) {
                Toast.makeText(mainActivity, "このレコードは先頭です", Toast.LENGTH_SHORT).show();
                c.moveToFirst();
            } else{
                Toast.makeText(mainActivity, "このレコードは最終です", Toast.LENGTH_SHORT).show();
                c.moveToLast();
            }
        }
    }
}
