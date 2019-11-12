package android;

public class Logcat {

    //Logcat中每条日志消息的各个部分代表的什么意思
    /**
     * 2019-08-11 13:08:44.382 1083-1257/com.example.myapplication A/libc: Fatal signal 6 (SIGABRT),
     * code -6 (SI_TKILL) in tid 1257 (BootAnimation::), pid 1083 (bootanimation)
     * 2019-08-11：日期
     * 13:08:44.382：时间
     * 1083：PID，app运行时，在系统中唯一的标识
     * 1257：TID，一个PID可以对应多个TID，因为进程中支持多线程，每个线程对应一个TID
     * com.example.myapplication：应用名称
     * A：日志级别，日志级别有6个
     * libc：标签
     * Fatal signal 6 (SIGABRT), code -6 (SI_TKILL) in tid 1257 (BootAnimation::), pid 1083 (bootanimation)：日志内容
     */

    //常见adb命令
    /**
     * adb devices: 显示当前运行的全部模拟器
     * adb -s 设备名：指定该设备为命令目标
     * adb shell:进入模拟器的shell模式
     * adb shell pm list packages
     * adb shell pm list packages -s：系统应用
     * adb shell pm list packages -3：第三方应用
     * adb shell pm list packages mazhuang：包名包含mazhuang的应用
     * adb shell pm list packages | grep mazhuang：同上
     * adb install 安装包路径：给手机安装apk，这个安装包路径为电脑上的apk路径
     * adb uninstall 包名：通过包名卸载手机上的软件
     * adb shell pm clear <packagename>：清楚包名为packagename应用的缓存
     * adb pull <设备里的文件路径> [电脑上的目录]：将手机上的内容拷贝到电脑上，电脑目录可省略，则表示复制到当前目录
     * adb push <电脑上的文件路径> <设备里的目录>：复制电脑里的文件到设备
     * adb start-server：开启adb服务
     * adb kill-server：关闭adb服务
     * adb logcat -d ：打印出手机log到控制台，不一直打印
     * adb logcat | grep MyApp：打印带有MyApp字段的log
     * adb logcat | grep -i myapp：打印带有MyApp字段的log，忽略大小写
     */

    //什么是logcat缓冲区
    /**
     * android log输出量巨大，特别是通信系统的log，因此，android把log输出到不同的缓冲区中，目前定义了四个log缓冲区：
     * 1）Radio：输出通信系统的log
     * 2）System：输出系统组件的log
     * 3）Event：输出事件event模块的log，该缓冲区中可能包含应用崩溃信息
     * 4）Main：所有java层的log。
     *
     * adb logcat为默认log输出，输出的是System和main缓冲区的log，输出的日志大致如下：
     * beginning of system
     * ....
     * beginning of main
     * ....
     *
     * adb logcat –b radio：输出缓冲区radio的日志
     * adb logcat –b system
     * adb logcat –b events
     * adb logcat –b main
     * adb logcat -c：清除缓冲区的日志，可以清除手机中的logcat，避免太多日志
     * adb logcat -d：将缓冲区的log转存到屏幕中然后退出
     * adb logcat -g：打印日志缓冲区的大小并退出，占用内存大小
     */

    //根据不同条件筛选日志，可以根据PID、TID、日志级别、日志标签、日志内容等条件筛选日志
    /**
     * 根据日志级别筛选：adb logcat *:W  W表示日志的级别
     * 根据日志标签筛选：adb logcat System:* *:s  第一个星号表示不匹配日志级别， *:S用于设置所有标记的日志优先
     * 级为S，System表示日志标签。
     * 根据PID（应用包名）筛选：由于应用每次启动后，系统分配的PID都不一样，因此，需要根据包名或UID筛选日志时，需要
     * 先启动应用，再使用命令adb shell dumpsys meminfo 包名 查看到UID信息，最后根据PID筛选日志，adb logcat | grep 18270 18270表示PID
     */

}
