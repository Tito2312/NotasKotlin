package com.lelha.appnotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var nombre:EditText? = null
    var materia: EditText? = null
    var nota1: EditText? = null
    var nota2: EditText? = null
    var nota3: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre= findViewById(R.id.name)
        materia=findViewById(R.id.matter)
        nota1=findViewById(R.id.note1)
        nota2=findViewById(R.id.note2)
        nota3=findViewById(R.id.note3)

        val btnCalculate:Button=findViewById(R.id.calculate)
        btnCalculate.setOnClickListener{onClick()}
    }

    private fun onClick(){
        val intent = Intent(this, Notes::class.java)
        val miBundle:Bundle = Bundle()

        miBundle.putString("Nombre", nombre!!.text.toString())
        miBundle.putString("Materia", materia!!.text.toString())
        miBundle.putString("nota1", nota1!!.text.toString())
        miBundle.putString("nota2", nota2!!.text.toString())
        miBundle.putString("nota3", nota3!!.text.toString())

        intent.putExtras(miBundle)
        startActivity(intent)
    }
}