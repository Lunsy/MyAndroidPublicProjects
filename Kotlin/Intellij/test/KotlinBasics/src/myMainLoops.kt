fun main(){
    val names = arrayOf( "Shena", "Gongo", "Peterson")
    for (name in names)
        println(name)

    for (x in 0..10) println(x)
    for (x in 0 until 10) println(x)
    for (x in 0 until 10 step 2) println(x)
    for (x in 10 downTo  0 step 2) println(x)
    var numbers = 10 downTo  0
    for (x in numbers step 2) println(x)
    numbers = 10 downTo  0
    var number_list = numbers.toList()
    println(number_list)
    numbers = 10 downTo  0 step 2
    number_list = numbers.toList()
    println(number_list)
    println(numbers)
}