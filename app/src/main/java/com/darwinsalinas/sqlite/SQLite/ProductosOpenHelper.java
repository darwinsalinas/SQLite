package com.darwinsalinas.sqlite.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductosOpenHelper extends SQLiteOpenHelper {

    public ProductosOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE productos(codigo INTEGER PRIMARY KEY, nombre TEXT, precio REAL, cantidad INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS productos");
        sqLiteDatabase.execSQL("CREATE TABLE productos(codigo INTEGER PRIMARY KEY, nombre TEXT, precio REAL, cantidad INTEGER)");
    }
}
