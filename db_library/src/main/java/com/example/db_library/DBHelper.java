package com.example.db_library;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.db_library.DB_Create.COL_ALARM_PRICE;
import static com.example.db_library.DB_Create.COL_BILLING_AMOUNT;
import static com.example.db_library.DB_Create.COL_COMPANY_CODE;
import static com.example.db_library.DB_Create.COL_CUSTOMER_CODE;
import static com.example.db_library.DB_Create.COL_CUSTOMER_NAME1;
import static com.example.db_library.DB_Create.COL_CUSTOMER_NAME2;
import static com.example.db_library.DB_Create.COL_END_CODE;
import static com.example.db_library.DB_Create.COL_ETX;
import static com.example.db_library.DB_Create.COL_FILLER;
import static com.example.db_library.DB_Create.COL_GAS_CONSUMPTION_TAX;
import static com.example.db_library.DB_Create.COL_GAS_PRICE;
import static com.example.db_library.DB_Create.COL_GAS_PRICE_SECTION;
import static com.example.db_library.DB_Create.COL_GAS_PRICE_TABLE;
import static com.example.db_library.DB_Create.COL_GAS_TAX_RATE;
import static com.example.db_library.DB_Create.COL_GROUP_CODE;
import static com.example.db_library.DB_Create.COL_KENSIN;
import static com.example.db_library.DB_Create.COL_KENSINJUN;
import static com.example.db_library.DB_Create.COL_LAST_TIME_KENSIN;
import static com.example.db_library.DB_Create.COL_LAST_TIME_POINTER;
import static com.example.db_library.DB_Create.COL_LAST_TIME_USAGE;
import static com.example.db_library.DB_Create.COL_LAST_TIME__BILLING_REMAINDER;
import static com.example.db_library.DB_Create.COL_LAST_TIME__BILLING_REMAINDER_tax;
import static com.example.db_library.DB_Create.COL_MATER_EXCHANGE_DATE;
import static com.example.db_library.DB_Create.COL_MATER_EXCHANGE_FLAG;
import static com.example.db_library.DB_Create.COL_MATER_EXCHANGE_USAGE;
import static com.example.db_library.DB_Create.COL_MICRO_COMPUTER_PRICE;
import static com.example.db_library.DB_Create.COL_OTHER_SALES;
import static com.example.db_library.DB_Create.COL_OTHER_SALES_TAX;
import static com.example.db_library.DB_Create.COL_PLACE_CODE;
import static com.example.db_library.DB_Create.COL_PLACE_NAME;
import static com.example.db_library.DB_Create.COL_PROBED_FLAG;
import static com.example.db_library.DB_Create.COL_STANDARD_PRICE;
import static com.example.db_library.DB_Create.COL_STANDARD_USAGE;
import static com.example.db_library.DB_Create.COL_STX;
import static com.example.db_library.DB_Create.COL_TANTOUSYA;
import static com.example.db_library.DB_Create.COL_TAX_CALCULATION_TABLE;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT01;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT02;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT03;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT04;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT05;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT06;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT07;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT08;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT09;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT10;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT11;
import static com.example.db_library.DB_Create.COL_TENKEN_RESULT12;
import static com.example.db_library.DB_Create.COL_TERMINAL_ID;
import static com.example.db_library.DB_Create.COL_THIS_TIME_BILLING;
import static com.example.db_library.DB_Create.COL_THIS_TIME_KENSIN;
import static com.example.db_library.DB_Create.COL_THIS_TIME_POINTER;
import static com.example.db_library.DB_Create.COL_THIS_TIME_USAGE;
import static com.example.db_library.DB_Create.COL_TYPE;
import static com.example.db_library.DB_Create.COL_UNIT_PRICE;
import static com.example.db_library.DB_Create.DB_TABLE;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        //第1引数:コンテキスト
        //第2引数:データベース名
        //第3引数:nullで可
        //第4引数:DBのバージョン
        super(context,"Create.db",null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTbl = "CREATE TABLE " + DB_TABLE + " ("
                + COL_STX + "  TEXT ,"
                + COL_TYPE + "  TEXT ,"
                + COL_COMPANY_CODE + "  TEXT ,"
                + COL_CUSTOMER_CODE + "  TEXT  ,"
                + COL_PLACE_CODE + "  INTEGER ,"
                + COL_PLACE_NAME + "  TEXT ,"
                + COL_KENSIN + "  INTEGER ,"
                + COL_KENSINJUN + "  INTEGER ,"
                + COL_CUSTOMER_NAME1 + "  TEXT ,"
                + COL_CUSTOMER_NAME2 + "  TEXT ,"
                + COL_GAS_PRICE_SECTION + "  TEXT ,"
                + COL_GAS_PRICE_TABLE + "  TEXT ,"
                + COL_UNIT_PRICE + "  INTEGER ,"
                + COL_STANDARD_USAGE + "  INTEGER ,"
                + COL_LAST_TIME_KENSIN + " BLOB  ,"
                + COL_LAST_TIME_POINTER + "  INTEGER,"
                + COL_LAST_TIME_USAGE + "  INTEGER ,"
                + COL_THIS_TIME_KENSIN + "  BLOB ,"
                + COL_THIS_TIME_POINTER + "  INTEGER ,"
                + COL_THIS_TIME_USAGE + "  TINTEGEREXT ,"
                + COL_GAS_PRICE + "  INTEGER ,"
                + COL_STANDARD_PRICE + "  INTEGER ,"
                + COL_MICRO_COMPUTER_PRICE + "  INTEGER ,"
                + COL_ALARM_PRICE + "  INTEGER ,"
                + COL_BILLING_AMOUNT + "  INTEGER ,"
                + COL_GAS_CONSUMPTION_TAX + "  INTEGER ,"
                + COL_GAS_TAX_RATE + "  INTEGER ,"
                + COL_THIS_TIME_BILLING + "  INTEGER ,"
                + COL_MATER_EXCHANGE_FLAG + "  TEXT ,"
                + COL_MATER_EXCHANGE_DATE + "  BLOB ,"
                + COL_MATER_EXCHANGE_USAGE + "  INTEGER ,"
                + COL_TENKEN_RESULT01 + "  INTEGER ,"
                + COL_TENKEN_RESULT02 + "  INTEGER ,"
                + COL_TENKEN_RESULT03 + "  INTEGER ,"
                + COL_TENKEN_RESULT04 + "  INTEGER ,"
                + COL_TENKEN_RESULT05 + "  INTEGER ,"
                + COL_TENKEN_RESULT06 + "  INTEGER ,"
                + COL_TENKEN_RESULT07 + "  INTEGER ,"
                + COL_TENKEN_RESULT08 + "  INTEGER ,"
                + COL_TENKEN_RESULT09 + "  INTEGER ,"
                + COL_TENKEN_RESULT10 + "  INTEGER ,"
                + COL_TENKEN_RESULT11 +  " INTEGER ,"
                + COL_TENKEN_RESULT12 + "  INTEGER ,"
                + COL_TANTOUSYA + "  TEXT ,"
                + COL_GROUP_CODE + "  TEXT ,"
                + COL_TAX_CALCULATION_TABLE + "  TEXT ,"
                + COL_FILLER + "  TEXT ,"
                + COL_PROBED_FLAG + "  TEXT ,"
                + COL_LAST_TIME__BILLING_REMAINDER + " INTEGER ,"
                + COL_LAST_TIME__BILLING_REMAINDER_tax + " INTEGER ,"
                + COL_OTHER_SALES + "  INTEGER ,"
                + COL_OTHER_SALES_TAX + "  INTEGER ,"
                + COL_TERMINAL_ID + "  TEXT ,"
                + COL_ETX + " TEXT ,"
                + COL_END_CODE + "  TEXT ,"
                + "PRIMARY KEY("+ COL_COMPANY_CODE+" ,"+ COL_CUSTOMER_CODE +",  "+ COL_PLACE_CODE +")"
                + ");";

        db.execSQL(createTbl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS DB_Create1");

        onCreate(db);

    }


}
