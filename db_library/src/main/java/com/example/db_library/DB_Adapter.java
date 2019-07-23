package com.example.db_library;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DB_Adapter extends DB_Create{
    private SQLiteDatabase db = null;
    private DBHelper dbHelper;
    public Context context ;

    public DB_Adapter(Context context) {
        this.context = context;
        dbHelper = new DBHelper(this.context);
    }

    /*DBの読み書き
    OpenDB()
     */
    public void openDB() {
        db = (SQLiteDatabase) dbHelper.getWritableDatabase();
    }   //DBの読み書き



    /*
    DBを閉じる closeDB()
     */
    public void closeDB() {
        db.close();
        db = null;
    }

    /*
    DBのれこーどへ登録
    saveDB()
     */
    public void saveDB(String stx, String type, String co_code, String cu_code, String p_code, String p_name, String kensin, String kensinjun, String c_name1,
                       String c_name2, String p_section, String p_table, String u_price, String s_usage, String l_kensin, String l_pointer, String l_usage, String t_kensin,
                       String t_pointer, String t_usage, String g_price, String s_price, String m_c_price, String a_price, String b_amount, String c_tax, String t_rate,
                       String t_biling, String m_e_flag, String m_e_data, String m_e_usage, String t_re1, String t_re2, String t_re3, String t_re4, String t_re5, String t_re6,
                       String t_re7, String t_re8, String t_re9, String t_re10, String t_re11, String t_re12, String c_tant, String g_code, String t_c_table, String c_filler,
                       String p_flag, String l_t_b_r1, String l_t_b_r2, String c_sale, String c_sale_t, String t_id,String etx, String e_code) {
        try {
            ContentValues values = new ContentValues();  //ContextValuesでデータを設定する
            values.put(COL_STX, stx);
            values.put(COL_TYPE, type);
            values.put(COL_COMPANY_CODE,co_code);
            values.put(COL_CUSTOMER_CODE, cu_code);
            values.put(COL_PLACE_CODE, Integer.parseInt(p_code));                                //5番目
            values.put(COL_PLACE_NAME, p_name);
            values.put(COL_KENSIN, Integer.parseInt( kensin));
            values.put(COL_KENSINJUN,Double.parseDouble( kensinjun));
            values.put(COL_CUSTOMER_NAME1, c_name1);
            values.put(COL_CUSTOMER_NAME2, c_name2);                                            //10番目
            values.put(COL_GAS_PRICE_SECTION, p_section);
            values.put(COL_GAS_PRICE_TABLE, p_table);
            values.put(COL_UNIT_PRICE,Double.parseDouble( u_price));
            values.put(COL_STANDARD_USAGE,Double.parseDouble( s_usage));
            values.put(COL_LAST_TIME_KENSIN, l_kensin);                         //15番目
            values.put(COL_LAST_TIME_POINTER,Double.parseDouble( l_pointer));
            values.put(COL_LAST_TIME_USAGE,Double.parseDouble( l_usage));
            values.put(COL_THIS_TIME_KENSIN,t_kensin);
            values.put(COL_THIS_TIME_POINTER,Double.parseDouble( t_pointer));
            values.put(COL_THIS_TIME_USAGE,Double.parseDouble( t_usage));                         //20番目
            values.put(COL_GAS_PRICE,Integer.parseInt( g_price));
            values.put(COL_STANDARD_PRICE,Integer.parseInt( s_price));
            values.put(COL_MICRO_COMPUTER_PRICE,Integer.parseInt( m_c_price));
            values.put(COL_ALARM_PRICE,Integer.parseInt( a_price));
            values.put(COL_BILLING_AMOUNT,Integer.parseInt( b_amount));                         //25番目
            values.put(COL_GAS_CONSUMPTION_TAX,Double.parseDouble( c_tax));
            values.put(COL_GAS_TAX_RATE,Double.parseDouble(t_rate));
            values.put(COL_THIS_TIME_BILLING,Integer.parseInt(t_biling));
            values.put(COL_MATER_EXCHANGE_FLAG, m_e_flag);
            values.put(COL_MATER_EXCHANGE_DATE, m_e_data);    //30番目
            values.put(COL_MATER_EXCHANGE_USAGE,Double.parseDouble( m_e_usage));
            values.put(COL_TENKEN_RESULT01,Integer.parseInt( t_re1));
            values.put(COL_TENKEN_RESULT02,Integer.parseInt( t_re2));
            values.put(COL_TENKEN_RESULT03,Integer.parseInt( t_re3));
            values.put(COL_TENKEN_RESULT04,Integer.parseInt( t_re4));
            values.put(COL_TENKEN_RESULT05,Integer.parseInt( t_re5));
            values.put(COL_TENKEN_RESULT06,Integer.parseInt( t_re6));
            values.put(COL_TENKEN_RESULT07,Integer.parseInt( t_re7));
            values.put(COL_TENKEN_RESULT08,Integer.parseInt( t_re8));
            values.put(COL_TENKEN_RESULT09,Integer.parseInt( t_re9));
            values.put(COL_TENKEN_RESULT10,Integer.parseInt( t_re10));
            values.put(COL_TENKEN_RESULT11,Integer.parseInt( t_re11));
            values.put(COL_TENKEN_RESULT12,Integer.parseInt( t_re12));
            values.put(COL_TANTOUSYA, c_tant);
            values.put(COL_GROUP_CODE, g_code);
            values.put(COL_TAX_CALCULATION_TABLE, t_c_table);
            values.put(COL_FILLER, c_filler);
            values.put(COL_PROBED_FLAG, p_flag);
            values.put(COL_LAST_TIME__BILLING_REMAINDER,Integer.parseInt( l_t_b_r1));
            values.put(COL_LAST_TIME__BILLING_REMAINDER_tax,Integer.parseInt( l_t_b_r2));
            values.put(COL_OTHER_SALES,Integer.parseInt( c_sale));
            values.put(COL_OTHER_SALES_TAX,Integer.parseInt( c_sale_t));
            values.put(COL_TERMINAL_ID, t_id);
            values.put(COL_ETX,etx);
            values.put(COL_END_CODE, e_code);

            db.insert("TB1", null, values); //レコード登録

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void allDelete() {

        db.beginTransaction();                      // トランザクション開始
        try {
            // deleteメソッド DBのレコードを削除
            // 第1引数：テーブル名
            // 第2引数：削除する条件式 nullの場合は全レコードを削除
            // 第3引数：第2引数で?を使用した場合に使用
            db.delete("TB1", null, null);        // DBのレコードを全削除
            db.setTransactionSuccessful();          // トランザクションへコミット
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();                    // トランザクションの終了
        }
    }
}
