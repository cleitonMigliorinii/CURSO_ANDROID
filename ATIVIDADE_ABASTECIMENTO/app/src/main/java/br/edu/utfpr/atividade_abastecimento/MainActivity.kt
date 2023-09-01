package br.edu.utfpr.atividade_abastecimento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var etCodigoCombustivel: EditText;
    private lateinit var etCidadeAbastecimento: EditText;
    private lateinit var etQuantidadeLitros: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCodigoCombustivel = findViewById(R.id.etCodigoCombustivel)
        etCidadeAbastecimento = findViewById(R.id.etCidadeAbastecimento)
        etQuantidadeLitros = findViewById(R.id.etQuantidadeLitros)
    }
}