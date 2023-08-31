package br.edu.utfpr.crud_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btListarOnClick(view: View) {}
    fun btPesquisarOnClick(view: View) {}
    fun btExcluirOnClick(view: View) {}
    fun btAlterarOnClick(view: View) {}
    fun btIncluirOnClick(view: View) {}
}