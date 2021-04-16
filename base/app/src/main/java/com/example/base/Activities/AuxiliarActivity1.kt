package com.example.base.Activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import com.example.base.ApiConnection.Conection
import com.example.base.ApiConnection.Response.CachorroResponse
import com.example.base.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast

class AuxiliarActivity1 : AppCompatActivity() {

     var contInd: Int = 0
     var contNaoInd: Int = 0
     var contagemTotal: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auxiliar1)

        val con = Conection.criar()
        con.get().enqueue(object : Callback<List<CachorroResponse>> {
            override fun onResponse(
                call: Call<List<CachorroResponse>>,
                response: Response<List<CachorroResponse>>
            ) {
               if (response.body() != null) {
                   response.body()!!.forEach {
                       val tvDog = TextView(baseContext)
                        if (it.indicadoCriancas) {
                            contInd ++
                        } else {
                            contNaoInd ++
                        }
                       contagemTotal = contInd + contNaoInd
                       tvDog.text = "Raça: ${it.raca} - Preço: ${it.precoMedio} - É Indicado para Crianças: ${it.indicadoCriancas}"
                       findViewById<LinearLayout>(R.id.layout_lista).addView(tvDog)
                   }
               }
            }

            override fun onFailure(call: Call<List<CachorroResponse>>, t: Throwable) {
                Log.println(Log.INFO, "Message", "Erro ao Listar Cachorro!")
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })
        findViewById<TextView>(R.id.tv_cachorrokidContResult).text = contagemTotal.toString()
        findViewById<TextView>(R.id.tv_cachorrokidTrueResult).text = contInd.toString()
        findViewById<TextView>(R.id.tv_cachorrokidFalseResult).text = contNaoInd.toString()
    }


}