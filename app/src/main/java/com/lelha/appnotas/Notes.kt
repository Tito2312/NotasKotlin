package com.lelha.appnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class Notes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val nombre =findViewById<TextView>(R.id.names)
        val materia = findViewById<TextView>(R.id.matters)
        val nota1 = findViewById<TextView>(R.id.resultNote1)
        val nota2 = findViewById<TextView>(R.id.resultNote2)
        val nota3 = findViewById<TextView>(R.id.resultNote3)
        val promedio = findViewById<TextView>(R.id.average)
        val estado = findViewById<TextView>(R.id.status)
        val btnSalir = findViewById<TextView>(R.id.button)

        var miBundle: Bundle? =this.intent.extras

        if (miBundle != null){
            var resultNota1 =miBundle.getString("nota1")!!.toDouble()
            var resultNota2 =miBundle.getString("nota2")!!.toDouble()
            var resultNota3 =miBundle.getString("nota3")!!.toDouble()

            if (resultNota1 < 0 || resultNota2 < 0 || resultNota3 < 0 || resultNota1 > 5 || resultNota2> 5 || resultNota3 > 5){
                Toast.makeText(this,"las notas deben ser entre 0 y 5 ", Toast.LENGTH_LONG).show()
                finish()
            }else{
                var prom = (resultNota1+resultNota2+resultNota3)/3

                nombre.text ="Nombre: ${miBundle.getString("Nombre")}"
                materia.text = "Materia: ${miBundle.getString("Materia")}"
                nota1.text = "Nota 1: ${resultNota1}"
                nota2.text = "Nota 1: ${resultNota2}"
                nota3.text = "Nota 1: ${resultNota3}"
                promedio.text = "Promedio: ${prom}"
                if (prom >=3.5){
                    estado.text ="Estado: aprobado"
                    estado.setTextColor(ContextCompat.getColor(this, R.color.ganó))
                }else{
                    estado.text = "Estado: Reprobado"
                    estado.setTextColor(ContextCompat.getColor(this, R.color.perdió))
                }
            }
            btnSalir.setOnClickListener{onClick()}
        }

    }

    private fun onClick() {
        finish()
    }


}