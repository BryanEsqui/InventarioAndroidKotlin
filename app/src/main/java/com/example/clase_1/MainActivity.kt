package com.example.clase_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var nombre: EditText
    lateinit var direccion: EditText
    lateinit var empresa: EditText
    lateinit var btnGuardar: Button
    lateinit var conexion: uConexion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.campo_nombre)
        direccion = findViewById(R.id.campo_direccion)
        empresa = findViewById(R.id.campo_empresa)
        btnGuardar = findViewById(R.id.btn_guardar)
        conexion = uConexion(this)
        btnGuardar.setOnClickListener{
            val peticion = conexion.writableDatabase
            peticion.execSQL("INSERT INTO proveedores VALUES(null,'" +
                    nombre.text.toString()+"','" +
                    direccion.text.toString()+"','" +
                    empresa.text.toString()+"')")
                    Toast.makeText(this, "Guardado Exitosamente", Toast.LENGTH_LONG).show()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}