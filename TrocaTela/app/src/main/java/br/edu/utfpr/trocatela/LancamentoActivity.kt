package br.edu.utfpr.trocatela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

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




    fun btListarLancamentoOnClick(view: View) {
        val intent = Intent(this, ListarActivity::class.java).let{
            register.launch(it)
        }
    }

    var register = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
            result : ActivityResult ->

        if (result.resultCode == RESULT_OK){
            result.data?.let {
                if (it.hasExtra("codRetorno")){
                    etCode.setText(it.getStringExtra("codRetorno"))
                }
            }
        }
    }
}