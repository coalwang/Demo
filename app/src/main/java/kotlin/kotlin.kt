//package kotlin

class kotlin {

    //定义一个没有返回类型的函数，Unit可以省略
    fun sum(a: Int): Unit {
        print("test")
    }

    //顶层变量，kotlin可以在类的外部定义变量

    //空值与 null 检测：当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空
    //变量可为null，返回值可为null
    fun sum(a: Int?, b: Int?): Int? {
        return null
    }

    //类型检测与自动类型转换
    /**
     * is 运算符检测一个表达式是否某类型的一个实例。 如果一个不可变的局部变量或属性已经判断出为某类型，那么检测后的
     * 分支中可以直接当作该类型使用，无需显式转换：
     * if (str is String) {
     *      int t = s.length
     * }
     */

    //流程控制when
    /**
     * when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // 注意这个块
            print("x is neither 1 nor 2")
        }
       }
     * when将它的参数与所有的分支条件顺序比较，直到某个分支满足条件，如果其他分支都不满足条件将会求值 else 分支，
     * 也可以不要else分支。
     * 如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
     * when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
       }
     */

    //流程控制For循环，关键字in
    /**
     1. for 循环可以对任何提供迭代器（iterator）的对象进行遍历：
     for(object in Object) {
        //操作object
     }

     2. 如果想通过索引遍历一个数组或者list
     for(i in myList.indices) {
        //操作i，i为索引
     }
     */

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


}