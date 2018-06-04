package com.example.eric.testeandroidsantander.webservices.investiments.month

import com.google.gson.annotations.SerializedName

class TwelveMonths(var fund: Double,
                   @SerializedName("CDI") var cdi: Double)