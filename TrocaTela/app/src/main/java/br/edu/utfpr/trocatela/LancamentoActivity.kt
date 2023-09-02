package br.edu.utfpr.trocatela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LancamentoActivity : AppCompatActivity() {
    private  lateinit var  etCode: EditText;
    private  lateinit var  etQtd: EditText;
    private  lateinit var  etValor: EditText;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento)

        etCode = findViewById(R.id.etCodLancamento)
        etQtd = findViewById(R.id.etQtdeLancamento)
        etValor = findViewById(R.id.etValorLancamento)
    }

    fun limparLancamentoOnClick(view: View) {}
    fun btConfirmarLancamento(view: View) {
        val intent = Intent(this, ConfirmarActivity::class.java)
        intent.putExtra("cod", etCode.text.toString())
        intent.putExtra("qtd", etQtd.text.toString())
        intent.putExtra("valor", etValor.text.toString())
        startActivity(intent)
    }
}