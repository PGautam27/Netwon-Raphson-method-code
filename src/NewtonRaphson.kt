import kotlin.math.*
import kotlin.properties.Delegates


class newtonRaphson(x0: Float, e: Float, n: Int) {
    private var f0 by Delegates.notNull<Float>()
    private var f1 = f(x0)
    private var g0 = g(x0)
    private var x0: Float = x0
    private var x1 by Delegates.notNull<Float>()
    private var e: Float = e
    private var step = 1
    private var n = n

    init {
        raphsonMethod()
    }

    private fun raphsonMethod() {
        println("Step\t\tx0\t\tf(x0)\t\tx1\t\tf(x1)")
        do {
            g0 = g(x0)
            f0 = f(x0)

            if (g0 == 0.0F) {
                println("Mathematical error")
                return
            }

            x1 = x0 - f0 / g0

            println("$step\t\t$x0\t\t$f0\t\t$x1\t\t$f1")
            x0 = x1

            step+=1

            if (step>n){
                println("Not convergent")
                return
            }

            f1 = f(x1)

        } while (f1.absoluteValue > e)

        println("Root is : $x1")
    }


    private fun f(x: Float): Float {
        return 3 * x - cos(x) - 1
    }

    private fun g(x: Float): Float {
        return 3 + sin(x)
    }

}

fun main() {
    var x: Float = 1F
    var e: Float = 0.000001F
    var n: Int = 10
    newtonRaphson(x, e, n)
}
