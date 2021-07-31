package com.example.a03_exceptions

fun main() {
    val wheel = Wheel()

    try {
        wheel.setPressure(2.0)
        // wheel.setPressure(6.0)
        // wheel.setPressure(1.0)
        // wheel.setPressure(-5.0)
    } catch (t: Wheel.IncorrectPressure) {
        println(t.message)
    } catch (t: Wheel.TooLowPressure) {
        println(t.message)
    } catch (t: Wheel.TooHighPressure) {
        println(t.message)
    }
}
