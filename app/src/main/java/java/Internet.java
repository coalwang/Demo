package java;

public class Internet {

    //怎么理解Uri
    /**
     * Uri属于android.net包，URI位于java.net包，Uri为安卓开发设计，扩展了URI的一些功能，安卓开发中使用Uri就好，
     * 另外URL也是java.net中的类，不用管。
     */

    //为什么要使用URLEncoder.encode()，URLDecoder.decode()
    /**
     * 如果一个url = "xxxxx?param=" + "za4T8MHB/6mhmYgXB7IntyyOUL7Cl++0jv5rFxAIFVji8GDrcf+k8g==",这里
     * 键元素含有特殊字符：/ + = 等等，如果不编码，那么在服务端获得 param 会变成类似于下面的值：
     * "za4T8MHB/6mhmYgXB7IntyyOUL7Cl  0jv5rFxAIFVji8GDrcf k8g=="，我们看到 三个 + 号消失了，变成了空格，
     * 原因就是：如果url参数值含有特殊字符时，需要使用 url 编码。
     * 编码：URLEncoder.encode("xxx", "utf-8")
     * 解码：URLDecoder.decode(param, "utf-8")
     * 对url中的哪部分进行编码：一般只对url中的键元素和值元素进行编码
     */

    //一个Uri的组成部分是什么
    /**
     * 一个Uri的基本组成部分包括协议，域名，端口号，路径和查询字符串。路径和查询字符串之间用问号?分离，
     *     例如http://www.java2s.com:8080/yourpath/fileName.htm?stove=10&path=32&id=4#harvic ，
     *     协议scheme：http
     *     域名host：www.java2s.com
     *     端口号port：8080   (authority组成为host:port，对应www.java2s.com:8080)
     *     路径为path：yourpath/fileName.htm
     *     查询字段：stove=10&path=32&id=4
     *     Uri中的部分方法：
     *     getScheme()：返回http
     *     getSchemeSpecificPart()：返回://www.java2s.com:8080/yourpath/fileName.htm?
     *     getFragment():获取Uri中的Fragment部分，即harvic
     *     getAuthority():获取Uri中Authority部分，即www.java2s.com:8080
     *     getPath():获取Uri中path部分，即/yourpath/fileName.htm
     *     getQuery():获取Uri中的query部分，即stove=10&path=32&id=4
     *     getHost():获取Authority中的Host字符串，即www.java2s.com
     *     getPost():获取Authority中的Port字符串，即8080
     *     List< String> getPathSegments()：getPathSegments()的作用就是依次提取出Path的各个部分的字符串，
     *     以字符串数组的形式输出。
     *     getQueryParameter(String key)：作用就是通过传进去path中某个Key的字符串，返回他对应的值。
     */

}
