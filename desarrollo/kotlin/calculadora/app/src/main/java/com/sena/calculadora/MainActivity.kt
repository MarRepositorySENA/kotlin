package com.sena.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* //VERSION SENCILLA, PERO LARGA
        // se define la variable
        //se asocia con un objeto de la vista
        // findViewById= Busca de la vista por id
        var btnCalcular: Button=findViewById(R.id.btnSuma)
        var txtNum1: EditText= findViewById(R.id.txtNum1)
        var txtNum2: EditText= findViewById(R.id.txtNum2)
        var lblResultado: TextView = findViewById(R.id.lblResultado)

        btnCalcular.setOnClickListener{
            var num1=txtNum1.text.toString().toInt()
            var num2=txtNum2.text.toString().toInt()
            var resultado= num1+num2
            lblResultado.text=resultado.toString()


            //Toast = es un mensaje temporal que se muestra en la pantalla
            //Toast = Alert en javascript
            Toast.makeText(
                this,
                "El resultado: $resultado",
                Toast.LENGTH_SHORT).show()

         */
    }

        //VERSION CORTA PERO DIFICIL
            fun calcular (view: View){

                var valido=true
                var btn=findViewById<Button>(view.id)
                var operacion=btn.text.toString()
                var txtNum1: EditText = findViewById(R.id.txtNum1)
                var txtNum2: EditText = findViewById(R.id.txtNum2)
                    //para crear un mensaje de alerta para un campo obligatorio
                    if(txtNum1.text.toString().isEmpty()){
                        txtNum1.error="El valor es requerido"
                        valido=false
                    }
                    if(txtNum2.text.toString().isEmpty()){
                        txtNum2.error="El valor es requerido"
                        valido=false
                    }

            if (valido) {

                var lblResultado: TextView = findViewById(R.id.lblResultado)
                var num1 = txtNum1.text.toString().toDouble()
                var num2 = txtNum2.text.toString().toDouble()
                var resultado = 0.0

                when (operacion) {
                    "+" -> {
                        resultado = num1 + num2
                    }

                    "-" -> {
                        resultado = num1 - num2
                    }

                    "*" -> {
                        resultado = num1 * num2
                    }

                    "/" -> {
                        resultado = num1 / num2
                    }
                }
                Toast.makeText(
                    this,
                    "El resultado es: $resultado",
                    Toast.LENGTH_SHORT
                ).show()
                lblResultado.text = resultado.toString()

            }
        }

}