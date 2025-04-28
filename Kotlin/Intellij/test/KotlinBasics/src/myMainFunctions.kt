fun main(){
    fun happyBirthday(name: String, age: Int):String{
        return "Happy ${age}th birthday, $name!"
    }
    fun happyBirthday1(name: String, age: Int) =
        "Happy ${age}th birthday, $name!"

    fun happyBirthdayWithoutParams(){
        println ("Happy birthday!")
    }

    println( happyBirthday("Michelle", 23))
    var congrats = happyBirthday("Michelle", 23)
    println("Hello! $congrats")
    happyBirthdayWithoutParams()

}