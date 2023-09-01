package br.edu.utfpr.crud_sqlite

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var  etCode: EditText;
    private lateinit var  etNome: EditText;
    private lateinit var  etTelefone: EditText;

    private  lateinit var  banco : SQLiteDatabase;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCode = findViewById(R.id.etCod)
        etNome = findViewById(R.id.etNome)
        etTelefone = findViewById(R.id.etTelefone)

        banco = SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath("dbFile.sqllite"),
            null)

        banco.execSQL("CREATE TABLE IF NOT EXISTS aluno (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, telefone TEXT )")
    }

    fun btIncluirOnClick(view: View) {

        val registro = ContentValues()
        registro.put("nome", etNome.text.toString());
        registro.put("telefone", etTelefone.text.toString())

        banco.insert("aluno", null, registro )

        Toast.makeText(this, "Inclusão Efetuada com Sucesso", Toast.LENGTH_SHORT).show();
    }

    fun btListarOnClick(view: View) {}
    fun btPesquisarOnClick(view: View) {}
    fun btExcluirOnClick(view: View) {}
    fun btAlterarOnClick(view: View) {}

}