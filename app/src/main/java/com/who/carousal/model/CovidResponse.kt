package com.who.carousal.model

import com.google.gson.GsonBuilder

public class CovidResponse {
    var features: Features? = null



    override fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }
}
