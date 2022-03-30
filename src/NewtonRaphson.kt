import kotlin.math.*


class newtonRaphson {
    val x: Float = 15.0F
    init {
        print(x)
    }

    private fun print(x:Float){
        println(sin(x).absoluteValue)
        println(cos(x).absoluteValue)
    }
}

fun main() {
    newtonRaphson()
}
