package com.darwinsalinas.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.darwinsalinas.sqlite.SQLite.ProductosOpenHelper;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etPrecio, etCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
        etCantidad = (EditText) findViewById(R.id.etCantidad);
    }

    public void btnguardarClick(View view) {
        ProductosOpenHelper admin = new ProductosOpenHelper(this, "inventario", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", etNombre.getText().toString());
        valores.put("precio", etPrecio.getText().toString());
        valores.put("cantidad", etCantidad.getText().toString());

        bd.insert("productos", null, valores);
        bd.close();
        Toast.makeText(this, "Producto Guardado", Toast.LENGTH_LONG).show();

    }

    public void btnShowListClick(View view) {
        Intent intent = new Intent(this, ListaProductosActivity.class);
        startActivity(intent);
    }
}
