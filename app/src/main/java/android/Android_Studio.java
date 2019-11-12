package android;

public class Android_Studio {

    //项目的build.gradle
    /**
     * buildscript中包括gradle脚本执行所需依赖，包括maven库和插件
     * buildscript {  //maven库
     *     ext.kotlin_version = '1.3.50'
     *     repositories {
     *         google()
     *         jcenter()
     *
     *     }
     *     dependencies {  //插件
     *         classpath 'com.android.tools.build:gradle:3.5.1'     //项目中的build.gradle的依赖使用classpath，module中的依赖不适用classpath
     *         classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
     *         // NOTE: Do not place your application dependencies here; they belong
     *         // in the individual module build.gradle files
     *     }
     * }
     *
     * allprojects中为项目中的依赖的maven库
     * allprojects {
     *     repositories {
     *         google()
     *         jcenter()
     *
     *     }
     * }
     *
     * task clean(type: Delete) {
     *     delete rootProject.buildDir
     * }
     */

}
