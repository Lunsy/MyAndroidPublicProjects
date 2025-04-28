fun main(){
    // array and lists

//    var myArray = arrayOf(1, 3, 7)
//    var myList = listOf(1, 3, 7)

    var mutableList = mutableListOf(1, 6.0, 4, "hello")

    mutableList.add("hi")
    println(mutableList)

    var rainbowColors: Array<String>
    rainbowColors = arrayOf("red", "orange", "yellow", "green",
        "blue", "indigo", "violet")

    var colors = mutableListOf<String>("deep purple", "light orange",
        "dark blue")

    colors.add("red")
    colors.addAll(arrayOf("blue", "green"))

    println(rainbowColors[0])

    println(rainbowColors)
    println(colors)
}