fun main(){
    var x = 5
    while (x > 0){
        println(x)
        x--
    }
    x = 0
    do{
        println( "$x, do while")
        x--
    } while ( x > 0)

}