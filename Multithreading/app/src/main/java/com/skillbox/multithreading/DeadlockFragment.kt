package com.skillbox.multithreading

import android.util.Log
import androidx.fragment.app.Fragment

class DeadlockFragment : Fragment() {

    override fun onResume() {
        super.onResume()

        val friend1 = Person("Вася")
        val friend2 = Person("Петя")

        val thread1 = Thread {
            friend1.throwBallTo(friend2)
        }

        val thread2 = Thread {
            friend2.throwBallTo(friend1)
        }

        thread1.start()
        thread2.start()
    }


    data class Person(
        val name: String
    ) {

        fun throwBallTo(friend: Person) {
            synchronized(this) {
                Log.d(
                    "Person",
                    "$name бросает мяч ${friend.name} на потоке ${Thread.currentThread().name}"
                )
                Thread.sleep(500)
            }
            friend.throwBallTo(this)
        }

    }

    class Account {
        var balance = 0

        fun withDraw(amount: Int) {
            balance -= amount
        }

        fun deposit(amount: Int) {
            balance += amount
        }

        fun transfer(to: Account, amount: Int) {
            synchronized(this) {
                synchronized(to) {
                    this.withDraw(50)
                    to.deposit(50)

                    //
                    println("Bla-bla")
                }
            }
        }
    }
}