package br.edu.utfpr.atividade_abastecimento

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var etCodigoCombustivel: EditText;
    private lateinit var etCidadeAbastecimento: EditText;
    private lateinit var etQuantidadeLitros: EditText;

    private  lateinit var  banco : SQLiteDatabase;
    private val combustiveis = HashMap<String, Double>()

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

    fun pesquisarCombustiveisOnClick(view: View) {

        val combustiveis = arrayOf(
            "1 - Gasolina",
            "2 - Etanol",
            "3 - Diesel",
            "4 - Gás Natural"
        )

        alertUtil("Total por combustíveis", combustiveis);
    }
    fun incluirRegistroOnClick(view: View) {

        if(validarCamposVazios(etCodigoCombustivel) || validarCamposVazios(etCidadeAbastecimento) ||
            validarCamposVazios(etQuantidadeLitros) ){

            Toast.makeText(this, "Preencha todos os campos para continuar", Toast.LENGTH_LONG).show();
            return
        }

        if(obterNomeCombustivelPorCodigo(etCodigoCombustivel.text.toString().toInt()) == "Error"){
            Toast.makeText(this, "Código de combústivel não encontrado", Toast.LENGTH_LONG).show();
            return
        }

        val registro = ContentValues()
        registro.put("codigo_combustivel", etCodigoCombustivel.text.toString());
        registro.put("cidade_abastecimento", etCidadeAbastecimento.text.toString())
        registro.put("quantidade_litros", etQuantidadeLitros.text.toString())

        banco.insert("abastecimento", null, registro )

        Toast.makeText(this, "Abastecimento registrado com sucesso", Toast.LENGTH_SHORT).show();

    }
    fun visualizarDadosOnClick(view: View) {

        this.buscarQuantidadeLitrosProCombustivel();
        exibirDadosCombustiveis()
    }


    private fun validarCamposVazios(editText: EditText) : Boolean{

        val isEmpty = editText.text.toString().isEmpty();

        if(isEmpty) {
            editText.error = "Preencha o campo"
        };

        return isEmpty;

    }
    private fun buscarQuantidadeLitrosProCombustivel() {

        val cursor: Cursor = banco.rawQuery(
            "SELECT codigo_combustivel, SUM(quantidade_litros) AS total_litros FROM abastecimento GROUP BY codigo_combustivel",
            null
        )

        if (cursor.moveToFirst()) {
            do {
                val codigoCombustivel = cursor.getInt(0)
                val totalLitros = cursor.getDouble(1)

                val nomeCombustivel = obterNomeCombustivelPorCodigo(codigoCombustivel)

                combustiveis[nomeCombustivel] = totalLitros
            } while (cursor.moveToNext())
        }
        cursor.close()
    }
    private fun obterNomeCombustivelPorCodigo(codigo: Int): String {

        return when (codigo) {
            1 -> "Gasolina"
            2 -> "Etanol"
            3 -> "Diesel"
            4 -> "Gás Natural"
            else -> "Error"
        }
    }
    private fun exibirDadosCombustiveis() {
        val totais = mutableListOf<String>()

        for ((combustivel, litros) in combustiveis) {
            totais.add("$combustivel: ${litros.roundToInt()} litros");
        }

        alertUtil("Total por combustíveis", totais.toTypedArray());

    }
    private fun alertUtil(title: String, items: Array<String>) {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle(title);

        alertBuilder.setItems(items) { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.dismiss()
        }

        alertBuilder.create().show()
    }


}