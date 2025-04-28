fun main(){

    var age: Int
    var isAdult: Boolean
    var isMan = false

    age = 19
    if(age > 18){
        println("You are adult")
        isAdult = true
    } else {
        println("You aren't adult")
        isAdult = false
    }

    if (isAdult && isMan){
        println("You can go to the party, man")
    } else if(isAdult && !isMan){
        println("You can go to the party, pretty")
    } else {
        println("You can't go to the party")
    }


    var isStud = true
    var hasTicket = false


    if(isStud || hasTicket){
          println("You can go to the party")
    } else {
        println("You can't go to the party")
    }


}