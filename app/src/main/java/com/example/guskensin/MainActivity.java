package com.example.guskensin;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.db_library.DBHelper;


@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper = new DBHelper(this);
   // DB_Create db_create = new DB_Create(this);
    Drawing drawing = new Drawing(this);
   // DB_Adapter db_adapter = new DB_Adapter(MainActivity.this);
   // DBHelper_HYOF dbHelper_hyof = new DBHelper_HYOF(this);


    Calc calc = new Calc(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Down = findViewById(R.id.down);
        Button Up   = findViewById(R.id.up);
        Button button6 = findViewById(R.id.button6);
        final EditText Row1 = findViewById(R.id.Row1_Text);


        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        @SuppressLint("Recycle") final Cursor c = db.rawQuery("SELECT /*i:0*/C_name1 , /*i:1*/C_name2 , /*i:2*/customer , /*i:3*/P_name , /*i:4*/L_T_pointer  ,/*i:5*/T_T_pointer ,/*i:6*/company  , place FROM TB1", null);

        /*―――――CSV読みこみ　データベース構築―――――――――――――――――――――――――――――――――――――――*/

        //db_create.CSV_Reader(this);

        /*―――――描画―――――――――――――――――――――――――――――――――――――――――――――――――――*/

        drawing.Draw(MainActivity.this);
        drawing.First(MainActivity.this,"First",c);

        Down.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          String str = Row1.getText().toString();
                                          ContentValues values = new ContentValues();  //ContextValuesでデータを設定する
                                        //  if(!str.equals("")) {
                                         try {
                                             values.put("T_T_pointer", Float.parseFloat(str));
                                             db.update("TB1", values, " company = ?  AND  customer = ?  AND place = ? ", new String[]{c.getString(6), c.getString(2), c.getString(7)});  //レコード登録
                                         }
                                         catch (NumberFormatException e){
                                             Log.d("error","error");
                                         }

                                          drawing.First(MainActivity.this, "Down", c);
                                      }
                                  });
        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    drawing.First(MainActivity.this, "Up",c);

            }
        });

        /*―――――CSV入力ボタン―――――――――――――――――――――――――――――――――――――――――――――――*/

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new Push_class(MainActivity.this).button6(MainActivity.this , c);
            }
        });
        /*――――――――――――――――――――――――――――――――――――――――――――――――――――――――――*/

        /*―――――使用量計算――――――――――――――――――――――――――――――――――――――――――――――――*/
 //       final EditText Row1 = findViewById(R.id.Row1_Text);
        Row1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                    if (actionId == EditorInfo.IME_ACTION_GO) {
                        try {
                           // String str = Row1.getText().toString();
                           //  db_adapter.openDB();

                            //  db_adapter.closeDB();
                            String str = Row1.getText().toString();

                            calc.Calc_used(MainActivity.this, str, c);

                        }catch (NumberFormatException e){
                            new AlertDialog.Builder(MainActivity.this).setTitle("確認ダイアログ")
                                    .setMessage("数字以外が入力されました")
                                    .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    }).show();
                        }
                    }
                    return true;
            }
        });

        /*――――――――――――――――――――――――――――――――――――――――――――――――――――――――――*/


        /*――――数値入力フォーム―――――――――――――――――――――――――――――――――――――――――――――――*/
   /*     EditText editText = findViewById(R.id.Row1_Text);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Ten_Key.class);
                startActivity(intent);
            }
        }); */

    }
}