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
}
