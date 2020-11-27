package com.who.carousal.task

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import com.who.carousal.responsepresenter.FinishListner
import com.who.carousal.util.AppConstant
import com.who.carousal.webcalls.AllWebCalls
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import org.jsoup.Jsoup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*


class Covidtask(context: Context, listener: FinishListner) {

    var mContext: Context? = null

    var loginFinishListener: FinishListner? = null


    fun getCovidStatus(map:HashMap<String,String>) {

        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstant.SERVICE_URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val service = retrofit.create(AllWebCalls::class.java)
        val call = service.getCovidStatus(map)


         call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                try {
                    if (response.isSuccessful()) {
                        val strResponse = response.body()!!.string()
                        val doc = Jsoup.parse(strResponse)
                        val elements = doc.select("button")
                            val mainObject = JSONObject(strResponse)

                    }
                } catch (e: IOException) {

                    e.printStackTrace()
                } catch (e: JSONException) {

                    e.printStackTrace()
                }

            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                t.printStackTrace()

            }
        })


    }
}