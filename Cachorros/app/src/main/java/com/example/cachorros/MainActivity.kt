package com.example.cachorros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irCadastroCachorro(view: View) {

        val telaCadastro = Intent(this, CadastrarCachorro::class.java)
        startActivity(telaCadastro)

    }
}