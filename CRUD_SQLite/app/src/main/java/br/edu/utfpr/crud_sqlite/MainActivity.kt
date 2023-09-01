package br.edu.utfpr.crud_sqlite

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.lang.StringBuilder

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

    fun btListarOnClick(view: View) {

        val registros: Cursor =
            banco.query("aluno", null,null,null,null,null,null,)

        var saida = StringBuilder()

        while (registros.moveToNext()){
            saida.append( registros.getInt(0))
            saida.append(" - ")
            saida.append(registros.getString(1))
            saida.append(" - ")
            saida.append(registros.getString(2))
            saida.append(" \n ")
        }

        Toast.makeText(this, saida.toString(), Toast.LENGTH_LONG).show()
    }
    fun btPesquisarOnClick(view: View) {
        val cod = etCode.text.toString();

        val registros: Cursor =
            banco.query("aluno", null,"_id=${cod}",null,null,null,null,)

        if (registros.moveToNext()){
            etNome.setText(registros.getString(1))
            etTelefone.setText(registros.getString(2))
        }else{
            Toast.makeText(this, "Registro não encontrado", Toast.LENGTH_LONG).show()
        }



    }
    fun btExcluirOnClick(view: View) {
        val cod = etCode.text.toString();
        banco.delete("aluno", "_id=${cod}", null )
        Toast.makeText(this, "Excluido com Sucesso", Toast.LENGTH_SHORT).show();
    }
    fun btAlterarOnClick(view: View) {

        val cod = etCode.text.toString();
        val registro = ContentValues()

        registro.put("nome", etNome.text.toString());
        registro.put("telefone", etTelefone.text.toString())

        banco.update("aluno",  registro, "_id=${cod}", null )

        Toast.makeText(this, "Alteração Efetuada com Sucesso", Toast.LENGTH_SHORT).show();

    }

}