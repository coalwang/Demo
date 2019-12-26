package android;

public class Thread {

    //进程与线程的区别
    /**
     * 进程为资源分配的基本单元。
     * 线程为CPU调用的基本单元。
     * 一个进程中可以有多个线程。
     */

    //线程的状态
    /**
     * 新建状态，New：
     * 线程在被创建后Thread t = new Thread()，在被调用start()之前都处于新建状态。
     * 运行状态，Runnable：
     * 调用t.start()之后，进入运行状态。
     * 阻塞状态，Blocked：
     *
     */

    //怎么理解线程中断
    /**
     * 先理解中断相关的三个方法：
     * 1. interrupt()方法，该方法会将线程的中断标识位置为false，中断标识为原来为true（这里的标识为native，暂时
     * 看不到），该方法的作用是请求中断线程。
     * 2. isInterrupted()方法：调用该方法可以判断该线程是否为置位了。
     * 3. interrupted()方法：调用该方法后，会对标识符进行复位。
     *
     * 调用了interrupt()，请求了线程中断后，线程会不会中断？
     * 不会，但是中断标识会改变。
     *
     * 什么时候会抛出线程中断异常？
     * 如果一个线程处于阻塞状态，线程在检查中断标识位时如果发生标识位为true，则在阻塞方法调用处抛出InterruptedException
     * 异常，备注：线程本身在运行过程中会不断的自己去检查自己的标识位。
     */
}
