package com.example.guskensin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;

import androidx.appcompat.app.AlertDialog;

@SuppressLint("Registered")
public class Push_class extends DB_Create {

    Push_class(Context context) {
        super(context);
    }

    void button6(final Context context , final Cursor c) {
 //       final DB_Create db_create = new DB_Create(context);
 //       final Drawing drawing = new Drawing(context);
        /* ――――――CSV出力――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――*/
        /*――――確認ダイアログ(YESの時）―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――*/
        new AlertDialog.Builder(context)
                .setTitle("確認ダイアログ")
                .setMessage("CSVを取り込みますか？")
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new AlertDialog.Builder(context).setTitle("確認ダイアログ")
                                .setMessage("CSVの取込をｷｬﾝｾﾙしました")
                                .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }).show();
                    }
                }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                DB_Create db_create = new DB_Create(context);
                db_create.CSV_Reader(context);

                new AlertDialog.Builder(context).setTitle("確認ダイアログ")
                        .setMessage("CSVを取り込みました")
                        .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                /*
                                取り込んだ後のテキスト処理
                                 */
                                Drawing drawing = new Drawing(context);
                                drawing.First((MainActivity) context,"First",c);
                            }
                        }).show();
                /*―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――*/
            }
        }).show();
    }
}
