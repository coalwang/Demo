package android;

public class OOM {

    //内存泄漏
    /**
     当一个对象已经不需要再使用本该被回收时，另外一个正在使用的对象持有它的引用从而导致它不能被回收，这导致本该被回
     收的对象不能被回收而停留在堆内存中，这就产生了内存泄漏。
     */

    //activity中常见内存泄露
    /**
     * 1. 不合理的单例模式
     * 单例在实例化时，持有activity的引用。
     *
     * 2. 持有Activity内的静态View
     * 如单例实例化时，持有activity中view的引用，view又持有activity的引用。
     *
     * 3. activity中有较长生命周期的匿名内部类
     * 如在activity中开启一个线程，activity关闭时，线程还没执行完毕：
     * new Thread(new Runnable() {
     *             @Override
     *             public void run() {
     *                 SystemClock.sleep(200000);
     *             }
     * }).start();
     *
     * 4. Handler中有生命周期较长的匿名内部类
     * 如：
     * mHandler.post(new Runnable() {
     *             @Override
     *             public void run() {
     *                 SystemClock.sleep(200000);
     *             }
     * });
     *
     * 5. 资源未关闭造成的内存泄漏
     * 如：cursor.close()，file.close()，bitmap.recycle()
     */
}
