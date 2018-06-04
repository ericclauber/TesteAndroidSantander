package com.example.eric.testeandroidsantander.webservices.investiments

import com.example.eric.testeandroidsantander.webservices.investiments.month.Month
import com.example.eric.testeandroidsantander.webservices.investiments.month.TwelveMonths
import com.example.eric.testeandroidsantander.webservices.investiments.month.Year
import com.google.gson.annotations.SerializedName


class MoreInfo(var month: Month,
               var year: Year,
               @SerializedName("12months") var twelveMonths: TwelveMonths)