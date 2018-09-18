package day02



/**
  * Created by qiaozhiquan on 2018/9/10.
  */
object FunctionTest{
  def main(args: Array[String]): Unit = {
//    for (seasn <- List("fall","winter","spring"))
//      println(seasn)

//    val oneHalf = new Rational(1,2)
    //    val twoThirds = new Rational(2,3)
//    println(increase(10))
//    println(increaseBy(12))
    val someNumbers = List(-11,-10,0,5,10)
//    someNumbers.foreach((x:Int) => println(x))

//    someNumbers.filter((x:Int) => x > 0)
//    someNumbers.filter(x=>x >0).foreach(x => println(x))
//    someNumbers.filter(_ >0).foreach(x => println(x))
//    someNumbers.foreach(println _)

    def sum(a:Int,b:Int,c:Int) = a+b+c
    val a = sum _
    println(a(1,2,3))
    val b = sum(1,_:Int ,3)
    /**
      * 占位符语法
        * 如果想让函数字面量更简洁，可以吧下滑吸纳当作一个或更多的参数占位符，只要每个阐述再数字字面量仅出现一次
        * 可以把下划线看作表达式需要被“填入”的“空白”。这个空白再每次调用的时候用函数的参数填入。
        * _ > 0 相当于 x => x > 0
      *
      * 部分应用函数
      *   可以用下滑吸纳替代整个参数列表，
      */


  }

  /**
    * scala 中的函数是头等函数，不仅可以定义和调用和定义函数，还可以把他们做为字面量（Literal）.并吧它们作为值传递。
    *
    */
  val increase  = (x:Int) => x+1

  val  increaseBy = (x:Int) =>{
    println("We")
    println("are")
    println("here")
//    x + 1
//    List(1,2,4,5,6,7.).map()

  }

  /**
    * 闭包
    */
}
