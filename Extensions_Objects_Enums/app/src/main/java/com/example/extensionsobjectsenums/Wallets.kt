package com.example.extensionsobjectsenums

 sealed class Wallets {
     abstract fun moneyInUSD(): Double
     class VirtualWallet(): Wallets(){
         private var virtualRUB = 0.00
         private var virtualUSD = 0.00
         private var virtualEURO = 0.00

         fun addMoney(type: Currency, quantity: Double){
             when(type){
                 Currency.RUBLE -> virtualRUB += quantity
                 Currency.DOLLAR -> virtualUSD += quantity
                 Currency.EURO -> virtualEURO += quantity
             }
         }

         override fun moneyInUSD(): Double {
             val convertInUSD = virtualUSD + virtualEURO*CurrencyConverter.euro+virtualRUB*CurrencyConverter.ruble
             return convertInUSD
         }
     }
     class RealWallet():Wallets(){
         var realRUB: MutableMap<Int, Int> = mutableMapOf()
         var realUSD: MutableMap<Int, Int> = mutableMapOf()
         var realEURO: MutableMap<Int, Int> = mutableMapOf()

         fun addMoney(type:Currency, naminal:Int, quantity: Int){
             when(type){
                 Currency.RUBLE -> realRUB.put(naminal, quantity)
                 Currency.DOLLAR -> realUSD.put(naminal, quantity)
                 Currency.EURO -> realEURO.put(naminal, quantity)
             }
         }

         override fun moneyInUSD(): Double {
             var convertInUSDRUB = 0.0
             var convertInUSDEURO = 0.0
             var convertInUSDUSD = 0.0

             for ((key, value) in realRUB) {
                 convertInUSDRUB = key * value * CurrencyConverter.ruble
             }
             for ((key, value) in realUSD) {
                 convertInUSDUSD = key * value * CurrencyConverter.dollar
             }
             for ((key, value) in realEURO) {
                 convertInUSDEURO = key * value * CurrencyConverter.euro
             }
             return convertInUSDRUB + convertInUSDUSD + convertInUSDEURO
         } }}
