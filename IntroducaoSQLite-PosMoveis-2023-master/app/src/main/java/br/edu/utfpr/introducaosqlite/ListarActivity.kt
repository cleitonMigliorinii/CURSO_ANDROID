package br.edu.utfpr.introducaosqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import br.edu.utfpr.introducaosqlite.database.DatabaseHandler
import br.edu.utfpr.introducaosqlite.entity.Pessoa

class ListarActivity : AppCompatActivity() {

    private lateinit var lvRegistros : ListView;
    private lateinit var banco: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        banco = DatabaseHandler( this )

        val cursor = banco.listarCursos()

        val adapter = SimpleCursorAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cursor,
            arrayOf("nome"),
            intArrayOf(android.R.id.text1),0
        )

        lvRegistros = findViewById(R.id.lvRegistros)
        lvRegistros.adapter = adapter
    }

   /* fun recuperaArrayString(registros: MutableList<Pessoa>): MutableList<String>{
        val listaNome = mutableListOf<String>()

        for(pessoal in registros){
            listaNome.add(pessoal.nome)
        }

        return  listaNome
    }*/
}