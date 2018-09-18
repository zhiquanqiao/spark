package day03

/**
  * Created by qiaozhiquan on 2018/9/14.
  *
  * scala 中定义类用class 修饰，默认有一个空参构造器
  *
  * 定义在类名称的构造器，叫做主构造器
  * 类的主构造器中的属性会定义成类的成员变量 没有var或者是val 对外没有提供get 方法
  * 使用var 修饰成员变量时候对外提供get 和set 方法
  * 使用val 修饰成员变量时候会对外提供get 方法
  * 如果类的属性上没有
  *
  * 类构造器访问权限
  *  在构造器钱加修饰权限
  *  private 在主构造器之前 class Teacher private (var name: String, var age: Int) 该类的主构造器不能访问
  *  主构造器的访问权限也适用于辅助构造器
  *
  *
  *
  */
class Teacher (var name: String, var age: Int) {
  var sex: String = _

  //定义一个构造器（辅助构造器）
  def this(name: String, age: Int, sex: String) {
    //在辅助构造器中必须要先调用主构造器
    this(name, age)
    this.sex = sex
  }


}
/**
  *  object 单例对象，里面定义的成员变量 和方法是静态的static
  *  伴生类对象：
  *   当Object 的名称和类的名称一直的时候，这个对象叫做这个类的伴生对象（俩个都必须在同一个文件中）
  *   apply
  *
  *  class
  *     类 构造器 类名称后面的构造器
  *        辅助构造器 类体中的构造器 def this() 类的辅助构造器，必须要先调用主构造器
  *     成员变量
  *        var  对外提供get set
  *        val  对外提供get
  *     访问权限
  *         成员变量 private 表示外部没有办法访问他的get 或者set 方法
  *         方法  private 表示外部没法调用这个方法
  *         构造器  private 表示在外部无法访问
  *         类  private[包名]  包名表示在这个这个包及其子包下可见可访问
  *             private[this] 只能在当前包下访问 子包不可见
  *
  * 伴生对象可以访问类中的私有方法private ,不能访问private[this]修饰的成员变量和方法
 */
object Teacher {


}


