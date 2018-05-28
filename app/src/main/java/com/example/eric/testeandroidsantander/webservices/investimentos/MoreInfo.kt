package com.example.eric.testeandroidsantander.webservices.investimentos

import com.example.eric.testeandroidsantander.webservices.investimentos.month.Month
import com.example.eric.testeandroidsantander.webservices.investimentos.month.TwelveMonths
import com.example.eric.testeandroidsantander.webservices.investimentos.month.Year
import com.google.gson.annotations.SerializedName


class MoreInfo(var month: Month,
               var year: Year,
               @SerializedName("12months") var twelveMonths: TwelveMonths)