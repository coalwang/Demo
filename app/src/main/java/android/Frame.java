package android;

public class Frame {

    //Android屏幕刷新机制
    /**
     * https://www.cnblogs.com/dasusu/p/8311324.html
     */

    //获取某个手机上，刷新一帧所需时间，每个手机刷新一帧所需时间略微不同
    /**
     * adb shell dumpsys SurfaceFlinger --latency -refresh
     */

    //app帧率情况获取命令
    /**
     * adb shell dumpsys gfxinfo sogou.mobile.explorer
     */

    //traceView可以记录每一帧中各个方法的调用时间
    /**
     * 使用traceView记录的方法：
     * 1. cd到目录/android/sdk/platform-tools/systrace
     * 2. 在终端使用命令：python systrace.py -a sogou.mobile.explorer --time=10 sched view wm，此时会在
     * 当前目录先生成一个trace.html文件，备注：
     * -a：指定进程的名字
     * --time：指定追踪的时间，10s
     * view:只追踪UI的变化，忽略系统其它。
     *
     * trace.html文件中各种颜色含义：
     * 绿色F表示渲染正常的帧，红色和黄色代表延迟厉害的帧 。
     *
     * 怎么知道大概是哪些问题导致丢帧：
     * 点击右边侧栏"Alerts",可以看到此处操作产生的丢帧问题：如"Expensive measure/layout pass"表示onMeasure
     * 和onLayout时间过长，"Expensive Bitmap uploads"表示位图过大，交由gpu绘制的时候，耗费时间过长
     *
     * 操作界面的快捷键：
     * W：放大，S：缩小，A：左移，D：右移，M：点击某个方法，按M，可以高亮该方法包含的区域，或者点击圆圈F，按M，高亮
     * 当前帧。
     */

}
