package com.who.carousal.view

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.who.carousal.R
import com.who.carousal.adapter.RecyclerViewAdapter
import com.who.carousal.model.Attributes
import com.who.carousal.presenterImpl.GetCovidStatusPresenterImpl
import com.who.carousal.responsepresenter.FinishListner
import com.who.carousal.util.SnapHelperOneByOne
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), FinishListner {

    var dot_1: ImageView? = null
    var dot_2: ImageView? = null
    var countryCodeValue:String? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val window: Window = getWindow()
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        val recyclerView = findViewById<RecyclerView>(R.id.my_carousal)
        dot_1 = findViewById(R.id.dot_1)
        dot_2 = findViewById(R.id.dot_2)
        val movieList:ArrayList<Attributes> = ArrayList()
        var features =Attributes()
        movieList.add(features)
        movieList.add(features)


       val recyclerViewAdapter = RecyclerViewAdapter()
        recyclerViewAdapter.RecyclerViewAdapter(movieList,this)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        val linearSnapHelper: LinearSnapHelper = SnapHelperOneByOne()
        linearSnapHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                  var position:Int= (recyclerView.getLayoutManager() as LinearLayoutManager)
                        .findFirstVisibleItemPosition()
                    if(position == 0)
                    {
                        dot_1!!.setImageDrawable(this@MainActivity.resources.getDrawable(R.drawable.selected))
                        dot_2!!.setImageDrawable(this@MainActivity.resources.getDrawable(R.drawable.un_selected))
                    }
                    else
                    {
                        dot_2!!.setImageDrawable(this@MainActivity.resources.getDrawable(R.drawable.selected))
                        dot_1!!.setImageDrawable(this@MainActivity.resources.getDrawable(R.drawable.un_selected))

                    }

                }
            }
        })


        val tm = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        countryCodeValue = tm.networkCountryIso
        val getCovidStatusPresenter = GetCovidStatusPresenterImpl()

        // API call not working. backend issue-----------------------
        val params = HashMap<String, String>()
        params["where"] = "ISO_2_CODE = "+countryCodeValue

        params["geometryType"] = "esriGeometryEnvelope"

        params["spatialRel"] = "esriSpatialRelIntersects"
        params["resultType"] = "none"
        params["distance"] = "0.0"
        params["returnGeodetic"] = "false"
        params["outFields"] = "CumCase,CumDeath"
        params["returnHiddenFields"] = "false"
        params["returnGeometry"] = "false"
        params["featureEncoding"] = "esriDefault"
        params["multipatchOption"] = "xyFootprint"
        params["applyVCSProjection"] = "false"
        params["returnIdsOnly"] = "false"
        params["returnUniqueIdsOnly"] = "false"
        params["returnCountOnly"] = "false"
        params["returnExtentOnly"] = "false"
        params["returnQueryGeometry"] = "false"
        params["returnDistinctValues"] = "false"
        params["cacheHint"] = "false"
        params["orderByFields"] = "date_epicrv"

        getCovidStatusPresenter.getCovidStatus(
            params,
            this,
          this
        )

    }

    override fun onFinished(status: Int, method: Int, obj: Any?) {

    }

}
