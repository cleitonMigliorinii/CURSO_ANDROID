package br.edu.utfpr.crud_sqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context : Context) : SQLiteOpenHelper(context, "banco", null, 1) {

    companion object{
        private val DATABASE_NAME = "dbfile.sqllite"
        private val DATABASE_VERSION = 1
        private val TABLE_NAME = "vendas"
        private val KEY_ID = "_id"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}