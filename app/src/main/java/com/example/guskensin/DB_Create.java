package com.example.guskensin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;

import com.example.db_library.DB_Adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SuppressLint("Registered")
public class DB_Create extends DB_Adapter {

    public DB_Create(Context context) {
        super(context);
    }

    public void  CSV_Reader(Context context) {
        AssetManager assetManager = context.getResources().getAssets();
        try {
            InputStream inputStream = assetManager.open("TOKUIF_2.TSV");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            String line;

            super.openDB();
            super.allDelete();
            while ((line = bufferReader.readLine()) != null) {
                //TAB区切りで１つずつ配列にいれる
                String[] RowData = line.split("\t", -1);
                super.saveDB(RowData[0], RowData[1], RowData[2], RowData[3], RowData[4], RowData[5], RowData[6], RowData[7], RowData[8], RowData[9], RowData[10]
                        , RowData[11], RowData[12], RowData[13], RowData[14], RowData[15], RowData[16], RowData[17], RowData[18], RowData[19], RowData[20], RowData[21]
                        , RowData[22], RowData[23], RowData[24], RowData[25], RowData[26], RowData[27], RowData[28], RowData[29], RowData[30], RowData[31], RowData[32]
                        , RowData[33], RowData[34], RowData[35], RowData[36], RowData[37], RowData[38], RowData[39], RowData[40], RowData[41], RowData[42], RowData[43]
                        , RowData[44], RowData[45], RowData[46], RowData[47], RowData[48], RowData[49], RowData[50], RowData[51], RowData[52], RowData[53], RowData[54]);
            }
        } catch(
                IOException e) {
            e.printStackTrace();
        }
        super.closeDB();
    }
}
