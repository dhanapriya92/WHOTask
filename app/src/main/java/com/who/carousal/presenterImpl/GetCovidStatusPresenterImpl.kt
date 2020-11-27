package com.who.carousal.presenterImpl

import android.content.Context
import com.who.carousal.iPresenter.GetCovidStatusPresenter
import com.who.carousal.responsepresenter.FinishListner
import com.who.carousal.task.Covidtask

class GetCovidStatusPresenterImpl : GetCovidStatusPresenter{
    override fun getCovidStatus(
        loginInput: HashMap<String, String>,
        context: Context,
        finishListner: FinishListner
    ) {
        val covidtask = Covidtask(context, finishListner)
        covidtask.getCovidStatus(loginInput)
    }

}