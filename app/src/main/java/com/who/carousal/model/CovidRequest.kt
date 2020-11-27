package com.who.carousal.model

import com.google.gson.GsonBuilder

public class CovidRequest {
    var attributes: ArrayList<Attributes>? = null


    override fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }
}
