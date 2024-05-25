package com.example.clase_1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class uConexion(

    context: Context?,

) : SQLiteOpenHelper(context, "InventarioProveedores.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?){
        db?.execSQL("CREATE TABLE proveedores(" +
                "correlativo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombreproveedor TEXT," +
                "direccion TEXT," +
                "empresa TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}


