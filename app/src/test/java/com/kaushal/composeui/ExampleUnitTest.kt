package com.kaushal.composeui

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

/*
 * Given an array with temperatures in Celsius and Fahrenheit scale (e.g., -2C, 23F, etc).
 * Write code that calculates the average temperature in Celsius.
 * Subtract the average from the source array items.
 * Return the results in the same format, preserving Celsius and Fahrenheit scale.
 *
 * Formula for conversion from Fahrenheit to Celsius: C = (F - 32) * 5/9
 *
 * Example:
 * input: ["10C", "9C", "7C", "4.5C", "-2C", "23F", "0C", "-1.5C", "41F", "3C"]
 * average temperature: 3C
 * output: ["7C", "6C", "4C", "1.5C", "-5C", "17.6F", "-3C", "-4.5C", "35.6F", “0C"]
 */
 // final Array:[7.0C, 6.0C, 4.0C, 1.5C, -5.0C, 17.6F, -3.0C, -4.5C, 35.6F, 0.0C]
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        recalculate()
    }

    val temperatures = arrayOf("10C", "9C", "7C", "4.5C", "-2C", "23F", "0C", "-1.5C", "41F", "3C")

    fun recalculate() {
        // solution

        val tempArr = mutableMapOf<Int, Pair<String, Double>>()
        temperatures.forEachIndexed { index , value ->
                val temp = value.dropLast(1)
                if(value.contains("F")) {
                    val tempInCelsius = (temp.toDouble() - 32) * 5/9
                    tempArr[index] = Pair("F", tempInCelsius)
                } else tempArr[index] = "C" to temp.toDouble()


        }

        var sum = 0.0
        tempArr.forEach { (_, pair) ->
            sum += pair.second
        }

        val avgOfArr = sum/tempArr.size
        print("avgOfArr:$avgOfArr")
        tempArr.forEach {  index, (scale, value) ->
                val newPair = Pair(scale, value - avgOfArr)
            tempArr[index] = newPair
        }

        print("tempArr:$tempArr")
        val updatedArray = arrayListOf<String>()
        tempArr.forEach { (_, pair) ->
            val temp = pair.second.toString()
            if(pair.first == "F") {
                val tempInFaranheit = (temp.toDouble() * 9/5) + 32
                //  C = (F - 32) * 5/9
                // F = C * 9/5 + 32
                val newVal = tempInFaranheit.toString() + "F"
                updatedArray.add(newVal)
            } else updatedArray.add(temp + "C")
        }

        print("final Array:$updatedArray")
    }
}