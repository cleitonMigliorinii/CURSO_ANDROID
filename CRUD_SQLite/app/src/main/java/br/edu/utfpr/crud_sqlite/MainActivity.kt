package br.edu.utfpr.crud_sqlite

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

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

    fun btListarOnClick(view: View) {}
    fun btPesquisarOnClick(view: View) {}
    fun btExcluirOnClick(view: View) {}
    fun btAlterarOnClick(view: View) {}
    fun btIncluirOnClick(view: View) {}
}