package android;

public class CC {

    //Android打包流程
    /**
     * 1. 通过aapt打包res资源文件，生成R.java、resources.arsc和res文件（二进制 & 非二进制如res/raw和pic保持原样）
     * 2. 处理.aidl文件，生成对应的Java接口文件
     * 3. 通过Java Compiler编译R.java、Java接口文件、Java源文件，生成.class文件
     * 4. 通过dex命令，将.class文件和第三方库中的.class文件处理生成classes.dex，dex文件指Dalvik Executable文件
     * 5. 通过apkbuilder工具，将aapt生成的resources.arsc和res文件、assets文件和classes.dex一起打包生成apk
     * 6. 通过Jarsigner工具，对上面的apk进行debug或release签名
     * 7. 通过zipalign工具，将签名后的apk进行对齐处理。
     */

    //创建一个基本gradle插件的方式
    /**
     * 1. 在项目根目录新建文件夹buildSrc
     * 2. 在buildSrc下新建文件build.gradle，添加以下代码：
     *    plugin插件也可以用java代码来写，需要在build.gradle中添加java插件依赖apply plugin: 'java'
     * buildscript {
     *     ext.android_gradle_plugin_version = '3.1.3'
     *     repositories {
     *         jcenter()
     *         google()
     *     }
     *     dependencies {
     *     }
     * }
     *
     * repositories {
     *     jcenter()
     *     google()
     * }
     *
     * apply plugin: 'java'
     * apply plugin: 'groovy'
     *
     * dependencies {
     *     implementation gradleApi()
     *     implementation localGroovy()
     *     implementation "com.android.tools.build:gradle:$android_gradle_plugin_version"
     *     implementation "com.android.tools.build:gradle-api:$android_gradle_plugin_version"
     * }
     * 3. 在buildSrc下新建文件夹java，在该文件夹下新建一个类继承自Plugin，实现apply方法
     * 4. 在buildSrc下新建文件夹resources，继续在resouces下新建文件夹META-INF，继续在META-INF下新建文件夹gradle-plugins
     * 5. 在文件夹gradle-plugins下新建文件buildsrc.properties，其中buildsrc为我们的插件名，可以随意命名
     * 6. 在文件buildsrc.properties中添加内容implementation-class=CustomPlugin，CustomPlugin为java文件夹下继承自Plugin的类
     */

    //什么是Transform
    /**
     * Transfom是gradle插件中的一个api，主要在android工程打包过程中起作用，例如混淆处理（ProGuardTransform），
     * class文件转dex文件（DexTransform）都是Transform的实现类完成的。
     */

    //Transform原理
    /**
     * https://juejin.im/post/5cbffc7af265da03a97aed41
     */

    //模块化和组件化区别
    /**
     * 项目根据不同的业务拆分成不同的模块，不同模块可以单独运行则可称为组件
     */

    //CC如何实现模块之间完全隔离
    /**
     * 使用代码隔离和依赖注入。
     * 如何实现代码隔离：
     * 1. addComponent是一个自定义的 lamda 表达式，源码在cc-settings.gradle 中
     * 2.  通过过滤筛选出 `assemble` 和 `install` 的 task，表明此刻进行的 task 是生成 apk 的 task（而不是
     * sync 之类的）
     * 3.  将 addComponent替换为 api或 compile
     * 4. 通过addComponent就实现了编写代码阶段不能随意使用其他模块的代码和资源，在编译时再换成依赖，实现代码隔离
     */

    //CC原理
    /**
     * https://juejin.im/post/5a2b92e4f265da430d57f047
     */

    //CC缺点
    /**
     * 创建组件类时的代码为：
     * public class CheckExport implements IComponent {
     *     @Override
     *     public String getName() {
     *         return "check";
     *     }
     *
     *     @Override
     *     public boolean onCall(CC cc) {
     *         String actionName = cc.getActionName();
     *
     *         switch (actionName) {
     *             case "showCheckActivity":
     *                 CheckActivity.startCheckActivity();
     *                 //返回处理结果给调用方
     *                 CC.sendCCResult(cc.getCallId(), CCResult.success());
     *                 return false;
     *             default:
     *                 return false;
     *         }
     *     }
     * }
     * 如果check组件中需要向其他组件暴露100个方法，那么switch的分支就需要100个，
     * 解决方案：
     *
     */


}
