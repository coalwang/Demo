package java;

public class Internet {

    //怎么理解Uri
    /**
     * Uri属于android.net包，URI位于java.net包，Uri为安卓开发设计，扩展了URI的一些功能，安卓开发中使用Uri就好，
     * 另外URL也是java.net中的类，不用管。
     */

    //为什么要使用URLEncoder.encode()，URLDecoder.decode()
    /**
     针对“name1=value1&name2=value2”我们来说一下客户端到服务端的概念上解析过程:
     上述字符串在计算机中用ASCII吗表示为：
     6E616D6531 3D 76616C756531 26 6E616D6532 3D 76616C756532。
     6E616D6531：name1
     3D：=
     76616C756531：value1
     26：&
     6E616D6532：name2
     3D：=
     76616C756532：value2
     服务端在接收到该数据后就可以遍历该字节流，首先一个字节一个字节的吃，当吃到3D这字节后，服务端就知道前面吃得字节
     表示一个key，再想后吃，如果遇到26，说明从刚才吃的3D到26子节之间的是上一个key的value，以此类推就可以解析出客
     户端传过来的参数。
     现在有这样一个问题，如果我的参数值中就包含=或&这种特殊字符的时候该怎么办。
     比如说“name1=value1”,其中value1的值是“va&lu=e1”字符串，那么实际在传输过程中就会变成这样“name1=va&lu=e1”。
     我们的本意是就只有一个键值对，但是服务端会解析成两个键值对，这样就产生了奇异。
     如何解决上述问题带来的歧义呢？解决的办法就是对参数进行URL编码
     URL编码只是简单的在特殊字符的各个字节前加上%，例如，我们对上述会产生奇异的字符进行URL编码后结果：
     “name1=va%26lu%3D”，这样服务端会把紧跟在“%”后的字节当成普通的字节，就是不会把它当成各个参数或键值对的分隔符。
     原因就是：如果url参数值含有特殊字符时，需要使用 url 编码。
     编码：URLEncoder.encode("xxx", "utf-8")
     解码：URLDecoder.decode(param, "utf-8")
     对url中的哪部分进行编码：一般只对url中的键元素和值元素进行编码
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
