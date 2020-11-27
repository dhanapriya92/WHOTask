package com.who.carousal.model

import com.google.gson.GsonBuilder

class Attributes {
    var CumCase: Double? = null
    var CumDeath: Double? = null



override fun toString(): String {
    return GsonBuilder().serializeNulls().create().toJson(this)
}
}
