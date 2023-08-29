package br.edu.utfpr.calculaimc_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    /*
    * lateinit é uma palavra-chave usada para declarar uma propriedade
    * não anulável (non-nullable) cujo valor será atribuído posteriormente
    * */
    private lateinit var etPeso: EditText
    private lateinit var etAltura : EditText
    private lateinit var tvResultado : TextView
    private lateinit var btCalcular : Button
    private lateinit var btLimpar : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById( R.id.etPeso )
        etAltura = findViewById( R.id.etAltura )
        tvResultado = findViewById( R.id.tvResultado )
        btCalcular = findViewById( R.id.btCalcular )
        btLimpar = findViewById( R.id.btLimpar )

        btCalcular.setOnClickListener {
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener {
            btLimparOnClick()
        }

        btLimpar.setOnLongClickListener {
            Toast.makeText( this, getString(R.string.long_limpar), Toast.LENGTH_SHORT ).show()
            false
        }
    }

    private fun btLimparOnClick() {
        etPeso.setText( "" )
        etAltura.setText( "" )
        tvResultado.text = getString(R.string.zeros)
        etPeso.requestFocus()
    }

    private fun btCalcularOnClick() {

        if ( etPeso.text.toString().isEmpty() ) {
            etPeso.error = getString(R.string.erro_peso)
            return
        }

        if ( etAltura.text.toString().isEmpty() ) {
            etAltura.error = getString(R.string.erro_altura)
            return
        }

        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        var imc : Double
        var dacimalForamt: DecimalFormat

            if(!Locale.getDefault().language.equals("en")){
            imc = peso / altura.pow( 2.0 )

            dacimalForamt = DecimalFormat("0.0")
        }else{
            imc = 703 * (peso / altura.pow( 2.0 ))

            val numberFormat = NumberFormat.getNumberInstance(Locale.US)
                dacimalForamt = numberFormat as DecimalFormat
        }

        tvResultado.text = dacimalForamt.format( imc )
    }



}