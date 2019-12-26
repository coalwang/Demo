package kotlin;

public class Kotlin {

    //问号?
    /**
     * 定义变量时，可在类型后面加一个问号?，表示该变量是Nullable，不加表示该变量不可为null。如下：
     * var s:String? = null
     * var s2:String = "xxx" //如果该变量被赋值为null，则编译不通过
     * 对于可以为null的变量，在使用该变量的时候，必须用变量名+?(如上面的s?)的形式进行调用，表示如果该变量为null，
     * 则不执行该变量调用的方法。如：
     * s = "yyy" //赋值时不需要使用s?形式
     * var l= s?.length //如果s为null，则不执行length方法
     */

    //感叹号!! 非空断言运算符
    /**
     * 通知编译器不做非空校验。如果运行时发现变量为空，就扔出异常
     * val l = b!!.length
     */

    //如何创建一个可以为null的String类型的变量
    /**
     * var name: String?
     */


     //高阶函数定义
    /**
     * 如果一个函数的参数为函数或者一个函数的返回值为函数，则该函数为高阶函数。
     */

    //Any
    /**
     * 相当于java中的Object，Map<String, Any> map = new HashMap()<>，表明键元素可以为任何类型。
     */

    //object的作用
    /**
     * 1. 实现单例：修饰一个类实现一个类的单例
     *     object Manager{
     *         fun add(){
     *         }
     *     }
     *
     * 2. companion object 可以在其内部定义类的静态变量和静态方法
     *     class A {
     *         companion object {
     *         const val = "xx"
     *             fun add() {
     *             }
     *         }
     *
     * 3. 实现匿名类的实例化
     *     java匿名类实例化
     * button.setOnClickListener (new OnClickListener) {
     *     }
     *     kotlin匿名类实例化
     * button.setOnClickListener (object : OnClickListener) {
     *     }
     *
     */

    //如何给一个类创建静态变量
    /**
     * 使用companion object
     */

    //判断某一个对象是否为某一个类的示例
    /**
     * 使用is或者!is，kotlin中判断为一个对象为某一个类的实例后，使用时可以智能转换成该类型，不需要像java中那么进
     * 行强制转换：
     *     if (o is String) {
     *         0.length()
     *     }
     *
     */

}
