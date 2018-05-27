package com.example.eric.testeandroidsantander.webservices.investimentos.month

import com.google.gson.annotations.SerializedName

data class Month(var fund: Double,
                 @SerializedName("CDI") var cdi: Double)