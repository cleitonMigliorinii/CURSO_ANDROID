package br.edu.utfpr.trocatela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LancamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento)
    }

    fun limparLancamentoOnClick(view: View) {}
    fun btConfirmarLancamento(view: View) {}
}