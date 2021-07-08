package com.example.extensionsobjectsenums

enum class Currency {
    RUBLE,
    DOLLAR,
    EURO;

    companion object {
        val NationalCurrency = Currency.DOLLAR
    }
}

fun Currency.isNational(): Boolean {
    return this == Currency.NationalCurrency
}
object CurrencyConverter {
    const val ruble = 0.02
    const val dollar = 1.0
    const val euro = 1.2
}
fun Currency.convertToDollar(money: Double) = when (this){
    Currency.RUBLE -> money* CurrencyConverter.ruble
    Currency.DOLLAR -> money*CurrencyConverter.dollar
    Currency.EURO -> money*CurrencyConverter.euro
}