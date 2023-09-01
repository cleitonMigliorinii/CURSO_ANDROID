package br.edu.utfpr.atividade_abastecimento

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etCodigoCombustivel: EditText;
    private lateinit var etCidadeAbastecimento: EditText;
    private lateinit var etQuantidadeLitros: EditText;

    private  lateinit var  banco : SQLiteDatabase;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCodigoCombustivel = findViewById(R.id.etCodigoCombustivel)
        etCidadeAbastecimento = findViewById(R.id.etCidadeAbastecimento)
        etQuantidadeLitros = findViewById(R.id.etQuantidadeLitros)

        banco = SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath("dbFile.sqllite"),
            null)

        banco.execSQL("CREATE TABLE IF NOT EXISTS abastecimento (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                            " codigo_combustivel INTEGER, " +
                                                            " cidade_abastecimento TEXT, " +
                                                            " quantidade_litros INTEGER )")

    }

    fun pesquisarCombustiveisOnClick(view: View) {}
    fun incluirRegistroOnClick(view: View) {

        val registro = ContentValues()
        registro.put("codigo_combustivel", etCodigoCombustivel.text.toString());
        registro.put("cidade_abastecimento", etCidadeAbastecimento.text.toString())
        registro.put("quantidade_litros", etQuantidadeLitros.text.toString())

        banco.insert("abastecimento", null, registro )

        Toast.makeText(this, "Abastecimento registrado com sucesso", Toast.LENGTH_SHORT).show();


    }
}