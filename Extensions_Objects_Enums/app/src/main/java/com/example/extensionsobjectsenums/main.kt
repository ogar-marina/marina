package com.example.extensionsobjectsenums

fun main(){

    val russian = Currency.RUBLE
    val europ = Currency.EURO
    val usa = Currency.DOLLAR

    val a = Currency.RUBLE.convertToDollar(money = 150.0)
    println(a)

    val virtual = Wallets.VirtualWallet()
    val real = Wallets.RealWallet()
    virtual.addMoney(Currency.RUBLE, quantity = 100.0)
    virtual.addMoney(Currency.EURO, quantity = 150.0)
    virtual.addMoney(Currency.DOLLAR, quantity = 200.0)
    println("Виртуальный кошелек хранит: ${virtual.moneyInUSD()} $")

    real.addMoney(Currency.RUBLE, naminal = 100, quantity = 100)
    real.addMoney(Currency.EURO, naminal = 50, quantity = 150)
    real.addMoney(Currency.DOLLAR, naminal = 20, quantity = 200)
    println("Реальный кошелек хранит: ${real.moneyInUSD()} $")

    println(virtual)
    println(real)

}