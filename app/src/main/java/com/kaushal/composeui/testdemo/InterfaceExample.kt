package com.kaushal.composeui.testdemo

 interface InterfaceExample {

     fun move() {
         val numbers1 = mutableListOf(1, 2, 3, 4, 5, 6)
         val newnum = numbers1.run {
             removeAll { it % 2 == 0 } // modify the list in place
             this // return the modified list itself
         }
         println(newnum) // Output: [1, 3, 5]

         val numbers2 = mutableListOf(1, 2, 3, 4, 5, 6)
         val res = numbers2.let {
             it.removeAll { it % 2 == 0 } // modify the list in place // return the modified list itself
             it
         }
         println("original number : $numbers2")
         print("new number ${res.toString()}")
     }
}

open class Bird() {
    open fun move() {
        System.out.print("this bird can fly\n")
    }
}

class FlyingBird(private val name: String) : InterfaceExample {
    override fun move() {
        System.out.print("this bird can fly : $name\n")
    }

}

class NonFlyingBird(private val name: String) : InterfaceExample {
    override fun move() {
        //System.out.print("this bird cannot fly : $name\n")
        super.move()
    }

}

/*fun main(args: Array<String>) {
    val example1: InterfaceExample = FlyingBird("Eagle")
    example1.move()

    val example2: InterfaceExample = NonFlyingBird("Ostrich")
    example2.move()
}*/

fun testDemo1(str: String): Double {
    val data = str.split("\n").drop(1)
    var totalRevenue = 0.0
    data.forEach { row ->
        val values = row.split(",")
        if(values.size == 3) {
            val(_, quantityStr, priceStr) = values
            val quantity = quantityStr.toDoubleOrNull()
            val price = priceStr.toDoubleOrNull()
            if(quantity != null && price != null) {
                totalRevenue += quantity * price
            }
        }
    }

    print("totalRevenue:$totalRevenue")
    return totalRevenue
}

fun main() {
    //val csv = "Product, Quantity, price\nApple,10,30\nOrange,5,20\nbanana,6,25"
    val csv1 = "Product, Quantity, price\nApple,10,30\nOrange,5,20\nbanana,6,25"
    val totalRevenue = testDemo1(csv1)
    print("final revenue:$totalRevenue")

    val csv2 = "Student, Subject, Grade\nJohn, Math, 90\nAlice, Science, 85\nJohn, Science, 92\nAlice, Math, 88"
    val avgGrade = testDemo2(csv2)
    print("average grade $avgGrade")

    val csv3 = "Name, Age, Department\nJohn, 30, IT\nAlice, 40, HR\nBob, 35, Finance"
    val oldestEmp = testDemo3(csv3)
    print("Oldest Employee $oldestEmp")

    val csv4= "Product, Stock\nApple, 100\nBanana, 150\nOrange, 120"
    val highestStock = testDemo4(csv4)
    print("Highest Employee $highestStock")

    val csv5 = "Name, Salary\nJohn, 50000\nAlice, 60000\nBob, 75000"
    val avgSalary = testDemo5(csv5)
    print("Average EmpSalary $avgSalary")

    val csv6 = "Product, Price\nApple, 1.5\nBanana, 0.75\nOrange, 1.0"
    val highestPricedItem = testDemo6(csv6)
    print("Highest priced Item $highestPricedItem")
}

fun testDemo2(str: String): MutableMap<String, Double> {
    val data = str.split("\n").drop(1)
    val mutableMap = mutableMapOf<String, Pair<Double, Int>>()
    data.forEach { row ->
        val values = row.split(",")
        //if(values.size == 3) {
            val(name, _, marksStr) = values
            val marks = marksStr.toDoubleOrNull()
            if(marks != null) {
               val (totalMarks, count) = mutableMap.getOrPut(name) { Pair(0.0, 0) }
               mutableMap[name] = Pair(totalMarks + marks, count+1)
            }
       // }
    }

    val avgGradeMap = mutableMapOf<String, Double>()
    mutableMap.forEach {(student , pair) ->
        val (totalGrade, count) = pair
        val avgGrade = totalGrade/count
        avgGradeMap[student] = avgGrade
    }

    print("avgGrade:$avgGradeMap")
    return avgGradeMap
}

fun testDemo3(str: String) : String {
    val data = str.split("\n").drop(1)
    var oldestEmp = ""
    var maxAge = Int.MIN_VALUE
    data.forEach { row ->
        val (name, age, _) = row.split(",").map { it.trim() }
        val empAge = age.toInt()
        if(empAge > maxAge) {
            maxAge = empAge
            oldestEmp = name
        }
    }

    return oldestEmp
}

fun testDemo4(str: String) : String {
    val data = str.split("\n").drop(1)
    var highestStockItem = ""
    var highestStock = Int.MIN_VALUE
    data.forEach { row ->
        val (item, stock) = row.split(",").map { it.trim() }
        val itemStock = stock.toInt()
        if(itemStock > highestStock) {
            highestStock = itemStock
            highestStockItem = item
        }
    }

    return highestStockItem
}

fun testDemo5(str: String) : Double {
    val data = str.split("\n").drop(1)
    var totalSalary = 0
    data.forEach { row ->
        val (name, salary) = row.split(",").map { it.trim() }
        totalSalary += salary.toInt()
    }

    val avgSalary = totalSalary/data.size.toDouble()

    return avgSalary
}

fun testDemo6(str: String) : String {
    val data = str.split("\n").drop(1)
    var highestPrice = Double.MIN_VALUE
    var highestPricedItem = ""
    data.forEach { row ->
        val (productStr, priceStr) = row.split(",").map { it.trim() }
        val price = priceStr.toDouble()
        if(price > highestPrice) {
            highestPrice = price
            highestPricedItem = productStr
        }
    }


    return highestPricedItem
}


/*
interface IOrdersRepository {
    suspend fun getProductDetails(productId: Long): ProductDto
}

class MyOrdersRepository(
    val delegate: IOrdersRepository
) : IOrdersRepository {


}listof what class*/
