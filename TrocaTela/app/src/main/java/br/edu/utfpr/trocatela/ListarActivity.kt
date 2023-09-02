package br.edu.utfpr.trocatela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListarActivity : AppCompatActivity() {

    private lateinit var lvProduto: ListView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        lvProduto = findViewById(R.id.lvProdutos)
        lvProduto.setOnItemClickListener { adapterView, view, pos, l ->

            val cod = pos.inc().toString();
            Intent().apply {
                putExtra("codRetorno", cod)
                setResult(RESULT_OK, this)
            }

            finish()
        }
    }
}