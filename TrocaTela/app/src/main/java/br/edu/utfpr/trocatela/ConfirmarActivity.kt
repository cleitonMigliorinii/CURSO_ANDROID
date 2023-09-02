package br.edu.utfpr.trocatela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ConfirmarActivity : AppCompatActivity() {

    private  lateinit var  etCode: TextView;
    private  lateinit var  etQtd: TextView;
    private  lateinit var  etValor: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar)

        etCode = findViewById(R.id.etCodConfirmar)
        etQtd = findViewById(R.id.etQtdeConfirmar)
        etValor = findViewById(R.id.etValorConfirmar)

        etCode.setText(intent.getStringExtra("cod"))
        etQtd.setText(intent.getStringExtra("qtd"))
        etValor.setText(intent.getStringExtra("valor"))
    }
}