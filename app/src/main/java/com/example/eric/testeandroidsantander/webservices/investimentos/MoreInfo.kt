package com.example.eric.testeandroidsantander.webservices.investimentos

import com.example.eric.classestemp.model.month.TwelveMonths
import com.google.gson.annotations.SerializedName
import java.time.Month
import java.time.Year

class MoreInfo(var month: Month,
               var year: Year,
               @SerializedName("12months") var twelveMonths: TwelveMonths)