package java;

public class Enum {

    //枚举介绍
    /**
     在JDK1.5之前，我们定义常量都是：public static fianl....。有了枚举之后，我们可以把相关的常量定义到一个枚举类里
     public enum EnumTest {
        MON, TUE, WED, THU, FRI, SAT, SUN;
     }

     enum这个关键字，包含了：继承Enum类，定义当前类 的意思，所创建的类型都是 java.lang.Enum 类的子类。

     虽然都是定义类，但是enum关键字和class关键字的约束行为不同，class定义的类，通过new操作创建对象，想new几个就
     几个，而enum关键字定义的类，其实例对象，只能在这个enum类中定义好。

     如果我们不自定义枚举类的成员变量和构造方法，只定义枚举实例，则枚举实例内容都将以字符串的形式存在，在类加载的时
     候会通过 protected Enum(String name, int ordinal) 构造函数被创建为基本的Enum实例。
     public enum EnumTest {
        MON, TUE, WED, THU, FRI, SAT, SUN;
     }
     其解释过程为：
     new Enum<EnumTest>("MON",0);
     new Enum<EnumTest>("TUE",1);
     new Enum<EnumTest>("WED",2);
     ... ...
     也就是说，这段代码实际上调用了7次 Enum(String name, int ordinal)。
     枚举类经过编译器编译之后产生的是一个class文件，该class文件经过反编译可以看到实际上是生成了一个类，该类继承了
     java.lang.Enum<E>。
     也就是说，enum 实际上就是一个 class，只不过 java 编译器帮我们做了语法的解析和编译而已，我们的枚举值也被解释
     成了static final修饰的常量。
     public class com.hmw.test.EnumTest extends java.lang.Enum{
     　　//我们可以看到：定义的时候的枚举值，被实例化了
        public static final com.hmw.test.EnumTest MON;
        public static final com.hmw.test.EnumTest TUE;
        public static final com.hmw.test.EnumTest WED;
        public static final com.hmw.test.EnumTest THU;
        public static final com.hmw.test.EnumTest FRI;
        public static final com.hmw.test.EnumTest SAT;
        public static final com.hmw.test.EnumTest SUN;

        static {};
        public int getValue();
        public boolean isRest();
        public static com.hmw.test.EnumTest[] values();
        public static com.hmw.test.EnumTest valueOf(java.lang.String);
        com.hmw.test.EnumTest(java.lang.String, int, int, com.hmw.test.EnumTest);
     }
     */

    //枚举中自定义属性、方法、构造方法
    /**
    public enum Color {
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);  //定义枚举实例

        // 自定义成员变量
        private String name;
        private int index;

        // 定义构造方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 添加方法
        public static String getName(int index) {
            for (Color c : Color.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }
    */

    //枚举类型是线程安全的
    /**
     枚举类反编译得到的代码我们可以看到，枚举类编译出来的属性都是static类型的，而static类型的属性会在类被加载之后
     初始化，而Java类的加载和初始化过程都是线程安全的，所以创建一个enum类型是线程安全的。
     */
}
