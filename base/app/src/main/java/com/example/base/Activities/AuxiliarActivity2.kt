package com.example.base.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.base.ApiConnection.Conection
import com.example.base.ApiConnection.Data.CachorroDataClass
import com.example.base.ApiConnection.Response.CachorroResponse
import com.example.base.MainActivity
import com.example.base.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuxiliarActivity2 : AppCompatActivity() {

    private val apiConnection = Conection.criar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auxiliar2)
    }

    fun cadastrarDog(view: View) {

        val raca: EditText = findViewById(R.id.et_raca)
        val precoMedio: EditText = findViewById(R.id.et_precoMedio)
        val indicadoKid: Switch = findViewById(R.id.sw_indicadoKids)

        val dog = CachorroDataClass(
            raca.text.toString(),
            precoMedio.text.toString().toDouble(),
            indicadoKid.isChecked
        )

        Log.println(Log.INFO, "Message", dog.toString())

        apiConnection.post(dog).enqueue(object : Callback<CachorroResponse> {
            override fun onResponse(call: Call<CachorroResponse>, response: Response<CachorroResponse>) {
                Log.println(Log.INFO, "Message", response.toString())
                val data = response.body()
                val code = response.code()
                if (data != null && code != null) {
                        Log.println(Log.INFO, "Sucesso", response.body().toString())
                        findViewById<ImageView>(R.id.iv_fotoDog).isVisible = true
                }
                Toast.makeText(baseContext, "Cão cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(call: Call<CachorroResponse>, t: Throwable) {
                Log.println(Log.INFO, "Message", "Erro ao Cadastrar Cachorro!")
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun backMain(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

}