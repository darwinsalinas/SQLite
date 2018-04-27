package com.darwinsalinas.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.darwinsalinas.sqlite.SQLite.ProductosOpenHelper;

import java.util.ArrayList;

public class ListaProductosActivity extends AppCompatActivity {

    ListView lvProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        ArrayList<String> listaProductos = getProductos();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProductos);
        lvProductos = (ListView) findViewById(R.id.lvProductos);
        lvProductos.setAdapter(adapter);
    }

    private ArrayList<String> getProductos() {
        ProductosOpenHelper admin = new ProductosOpenHelper(this, "inventario", null, 1);
        String[] resutlColumns = new String[] {"nombre"};
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor filas = bd.query(true, "productos", resutlColumns, null, null, null, null, null, null );

        ArrayList<String> lista = new ArrayList<String>();
        if(filas.moveToFirst()){
            do {
                String nombre=filas.getString(0);
                Log.e("nombre",nombre);
                lista.add(nombre);
            }while (filas.moveToNext());
        }
        return lista;
    }
}
