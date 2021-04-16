package com.example.cachorros

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastrarCachorro : AppCompatActivity() {

    //lateinit var etId : EditText
    lateinit var etRaca : EditText
    lateinit var etPrecoMedio : EditText
    lateinit var swIndicadoCrianca : Switch
    lateinit var ivImagem: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_cachorro)

       //etId = findViewById(R.id.et_id)
        etRaca = findViewById(R.id.et_raca)
        etPrecoMedio = findViewById(R.id.et_preco_medio)
        swIndicadoCrianca = findViewById(R.id.sw_indicado_crianca)

        ivImagem= findViewById(R.id.iv_cachorro_feliz)
    }

    fun cadastrarCachorro(view: View) {

        val apiCachorro = ConexaoApi.criar()

        //val id = etId.text.toString().toInt()
        val raca = etRaca.text.toString()
        val precoMedio = etPrecoMedio.text.toString().toDouble()
        val indicadoCrianca  = swIndicadoCrianca.isChecked


        val cachorro = Cachorro(raca,precoMedio,indicadoCrianca)

        apiCachorro.post(cachorro).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {

                Toast.makeText(baseContext, "Cão cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                ivImagem.setImageResource(R.drawable.cachorro)
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }
}