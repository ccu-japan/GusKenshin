package com.example.db_library;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.db_library.DB_Create.COL_COMPANY_CODE;
import static com.example.db_library.DB_Create.COL_CUSTOMER_CODE;
import static com.example.db_library.DB_Create.COL_PLACE_CODE;
import static com.example.db_library.DB_Create.DB_TABLE;
import static com.example.db_library.DB_Create_HYOF.No1;
import static com.example.db_library.DB_Create_HYOF.No10;
import static com.example.db_library.DB_Create_HYOF.No11;
import static com.example.db_library.DB_Create_HYOF.No12;
import static com.example.db_library.DB_Create_HYOF.No13;
import static com.example.db_library.DB_Create_HYOF.No14;
import static com.example.db_library.DB_Create_HYOF.No15;
import static com.example.db_library.DB_Create_HYOF.No16;
import static com.example.db_library.DB_Create_HYOF.No17;
import static com.example.db_library.DB_Create_HYOF.No18;
import static com.example.db_library.DB_Create_HYOF.No19;
import static com.example.db_library.DB_Create_HYOF.No2;
import static com.example.db_library.DB_Create_HYOF.No20;
import static com.example.db_library.DB_Create_HYOF.No3;
import static com.example.db_library.DB_Create_HYOF.No4;
import static com.example.db_library.DB_Create_HYOF.No5;
import static com.example.db_library.DB_Create_HYOF.No6;
import static com.example.db_library.DB_Create_HYOF.No7;
import static com.example.db_library.DB_Create_HYOF.No8;
import static com.example.db_library.DB_Create_HYOF.No9;

public class DBHelper_HYOF extends SQLiteOpenHelper {

    public DBHelper_HYOF(Context context){
        super(context,"Create.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTbl = "CREATE TABLE " + DB_TABLE + " ("
                + No1 + " TEXT ,"
                + No2 + " TEXT ,"
                + No3 + " INTEGER ,"
                + No4 + " TEXT ,"
                + No5 + " INTEGER ,"
                + No6 + " INTEGER ,"
                + No7 + " INTEGER ,"
                + No8 + " INTEGER ,"
                + No9 + " INTEGER ,"
                + No10 + " INTEGER ,"
                + No11 + " INTEGER ,"
                + No12 + " INTEGER ,"
                + No13 + " INTEGER ,"
                + No14 + " INTEGER ,"
                + No15 + " INTEGER ,"
                + No16 + " INTEGER ,"
                + No17 + " INTEGER ,"
                + No18 + " TEXT ,"
                + No19 + " TEXT,"
                + No20 + " TEXT,"
                + "PRIMARY KEY("+ No3+" ,"+ No4 +",  "+ No5 +")"
                + ");";
        db.execSQL(createTbl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS 11");

        onCreate(db);

    }
}
