package com.who.carousal.iPresenter

import android.content.Context
import com.who.carousal.responsepresenter.FinishListner

interface GetCovidStatusPresenter {
    fun getCovidStatus(loginInput: HashMap<String,String>, context: Context, finishListner: FinishListner)

}