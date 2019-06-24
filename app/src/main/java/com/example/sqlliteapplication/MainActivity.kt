package com.example.sqlliteapplication

import android.content.Context
import android.database.DatabaseErrorHandler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.support.v7.app.AppCompatViewInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun saverecord(view: View) {
    val id = personid.text.toString()
        val f_name = firstname.text.toString()
        val l_name = lastname.text.toString()
        val databasehandler: DatabaseHandler = DatabaseHandler(this)
        if (id.trim()!=="" && f_name.trim()!=="" && l_name.trim()!=="")
        {
            val status = databaseHandler.addEmployee(EmpModelClass(Integer.parseInt(id),f_name, l_name))
            if (status > -1)
            {
                Toast.makeText(applicationContext, "Record Save",Toast.LENGTH_SHORT).show()
              id.text.clear()
                f_name.text.clear()
                l_name.text.clear()
            }
        }
        else
        {
            Toast.makeText(applicationContext, "Record Not Save",Toast.LENGTH_SHORT).show()
        }
    }
}
