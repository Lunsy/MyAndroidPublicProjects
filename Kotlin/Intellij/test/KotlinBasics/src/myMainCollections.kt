fun main(){
    val car = mutableMapOf("color" to "red", "model" to "toyota", "year" to "1995")
//    println(map["a"])
//    println(map[2])
    for ((key, value ) in  car){
        println(key)
        println(value)
    }

    val set = mutableSetOf("a", "b", "c")
    set.add("d")
    for (item in set) println(item)
 println()
    val text = "Process finished with exit code 0"
    var letterSet= mutableSetOf<Char>()
    for (letter in text){
        letterSet.add(letter)
    }

    for (letter in letterSet) println(letter)

    println(letterSet.size)
}