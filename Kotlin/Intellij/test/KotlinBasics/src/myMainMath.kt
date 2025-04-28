import kotlin.math.PI
import kotlin.math.pow

fun main(){
    var radius = 7
    var circleArea1 = PI * radius * radius
    var circleArea2 = PI * radius.toDouble().pow(2)

    println(circleArea1)
    println(circleArea2)

}