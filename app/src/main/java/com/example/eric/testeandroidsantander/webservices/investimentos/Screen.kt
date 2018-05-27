package com.example.eric.testeandroidsantander.webservices.investimentos

data class Screen(var title: String,
                  var fundName: String,
                  var whatIs: String,
                  var definition: String,
                  var riskTitle: String,
                  var risk: Int,
                  var infoTitle: String,
                  var moreInfo: MoreInfo,
                  var info: MutableList<Info>,
                  var downInfo: MutableList<DownInfo>)