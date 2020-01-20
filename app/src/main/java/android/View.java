package android;

public class View {

    //onTouchEvent的返回值对down、move、up事件的影响
    /**
     * onInterceptTouchEvent方法对触屏事件的拦截处理需要和onTouchEvent方法配合使用，down事件首先传递到
     * onInterceptTouchEvent方法中，onInterceptTouchEvent返回false表示将down事件交由子View来处理，若某一层
     * 子View的onTouchEvent返回了true，后续的move、up等事件都将先传递到ViewGroup的onInterceptTouchEvent的
     * 方法，并继续层层传递下去，交由子View处理；若子View的onTouchEvent都返回了false，则down事件将交由该
     * ViewGroup的onTouchEvent来处理；如果ViewGroup的onTouchEvent返回false，down传递给父ViewGroup，后续事
     * 件不再传递给该ViewGroup；如果ViewGroup的onTouchEvent返回true，后续事件不再经过该ViewGroup的
     * onInterceptTouchEvent方法，直接传递给onTouchEvent方法处理，onInterceptTouchEvent返回ture，down事件
     * 将转交该ViewGroup的onTouchEvent来处理；若onTouchEvent返回true，后续事件将不再经过该ViewGroup的
     * onInterceptTouchEvent方法，直接交由该ViewGroup的onTouchEvent方法处理；若onTouchEvent方法返回false，
     * 后续事件都将交由父ViewGroup处理，不再经过该ViewGroup的onInterceptTouchEvent方法和onTouchEvent方法，
     * onInterceptTouchEvent的ACTION_MOVE事件不执行的原因就是子view的down事件返回了fasle，然后ViewGroup的
     * onTouchEvent 的down事件返回false，后续事件不再传递给该ViewGroup了。
     */

    //android中屏幕坐标系
    /**
     * 屏幕左上角为原点
     * 屏幕上方为x轴
     * 屏幕下方为y轴
     * 任意触摸屏幕上任意一点：MotionEvent.getRawX()为x坐标，MotionEvent.getRawY()为y坐标
     */

    //view的坐标系及getTop()、getBottom()、getRight()、getLeft()
    /**
     * 原点：view的左上角
     * x坐标：MotionEvent.getX()
     * y坐标：MotionEvent.getY()
     * getTop()：view的上边界到它的父容器（ViewGroup）上边界的距离
     * getBottom()：view的下边界到它的父容器上边界的距离
     * getLeft()：view的左边界到它的父容器左边界的距离
     * getRight()：view的右边界到它的父容器左边界的距离
     */

    //view滑动的几种方式
    /**
     * 第一种：调用view自身的layout()方法，重新布局当前view的位置
     *
     * 第二种：调用view的下述方法：
     * offsetTopAndBottom(int offset)：值为正，向下移动，值为负，向上移动。
     * offsetLeftAndRight(int offset): 值为正，像右移动，值为负，向左移动。
     *
     * 第三种：LayoutParams，
     * LayoutParams 保存了一个 View 的布局参数，所以通过改变 LayoutParams 来动态修改一个布局的位置参数，从而达
     * 到改变 View 位置的效果。
     * LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getLayoutParams();
     * layoutParams.leftMargin = getLeft() + offsetX;
     * layoutParams.topMargin = getTop() + offsetY;
     * setLayoutParams(layoutParams);
     * 所以，其实我们改变的是这个 View 的 Margin 属性。
     * LinearLayout.LayoutParams继承自ViewGroup.MarginLayoutParams。
     *
     * 第四种：调用view的scrollTo 和 scrollBy：
     * scrollTo(x, y) 移动到一个具体的坐标点。
     * scrollBy(dx, dy) 移动的增量为 dx, dy。
     * scrollTo 和 scrollBy 移动的是 View 的内容。即：对 TextView 使用的话，则是移动它的文本；对 ViewGroup
     * 使用的话，则移动的是所有的子 View。所以，一般不对 View 使用这两个方法，而是对 ViewGroup 使用。
     *
     * 第五种：调用view的setTranslationX(float translationX)，setTranslationY(float translationY)：
     *    public void setTranslationX(float translationX) {
     *         if (translationX != getTranslationX()) {
     *             invalidateViewProperty(true, false);
     *             mRenderNode.setTranslationX(translationX);
     *             invalidateViewProperty(false, true);
     *
     *             invalidateParentIfNeededAndWasQuickRejected();
     *             notifySubtreeAccessibilityStateChangedIfNeeded();
     *         }
     *     }
     * 第一次调用setTranslationX(float translationX)会平移距离，如果后续传入的translationX与第一次相同，则不
     * 会再平移，每次传入的translationX需要不同，另外每次平移的起点为上一次平移后的位置，每次平移的距离为本地的
     * translationX值与上一次translationX的值得差。
     *
     * 第六种：动画
     *
     * 第七种：Scroller
     */

    //view的事件分发机制
    /**
     * 用户触摸屏幕，事件首先由硬件捕获，传递过程：硬件——ViewRootImpl——DecorView——PhoneWindow——Activity，
     * ViewRootImpl的dispatchInputEvent()方法，DecorView的dispatchTouchEvent()方法，PhoneWindow的
     * dispatchTouchEvent()方法，Activity的dispatchTouchEvent()方法。
     *
     */

    //activity、window、decorView、viewRootImpl关系
    /**
     * activity：activity的attach()方法中会实例化一个PhoneWindow，mWindow = new PhoneWindow()，activity
     * 中持有Window的引用。
     * PhoneWindow：PhoneWindow中会实例化一个DecorView，PhoneWindow持有DecorView的引用。
     * DecorView：DecorView将我们setContentView()中的布局添加到自己的布局中，它是顶级视图。
     * DecorView的显示：ActivityThread的handleResumeActivity()方法中先调用了activity的onResume方法，然后
     * 调用activity的makeVisible()方法，此时才能看到界面。
     * ViewRootImpl：上述的makeVisible()方法中会创建一个ViewManager，ViewManager wm = getWindowManager()，
     *     void makeVisible() {
     *         if (!mWindowAdded) {
     *             ViewManager wm = getWindowManager();
     *             wm.addView(mDecor, getWindow().getAttributes());
     *             mWindowAdded = true;
     *         }
     *         mDecor.setVisibility(View.VISIBLE);
     *     }
     * getWindowManager()方法如下：
     *     public WindowManager getWindowManager() {
     *         return mWindowManager;
     *     }
     * WindowManager实现类为WindowManagerImpl，然后调用wm的addView()方法：
     *     public final class WindowManagerImpl implements WindowManager {
     *          private final WindowManagerGlobal mGlobal = WindowManagerGlobal.getInstance();
     *          ...
     *          @Override
     *          public void addView(View view, ViewGroup.LayoutParams params) {
     *              mGlobal.addView(view, params, mDisplay, mParentWindow);
     *          }
     *      }
     * 接着调用WindowManagerGlobal的addView()方法：
     *     public void addView(View view, ViewGroup.LayoutParams params,
     *             Display display, Window parentWindow) {
     *
     *               final WindowManager.LayoutParams wparams = (WindowManager.LayoutParams)params;
     *              ......
     *                  synchronized (mLock) {
     *
     *                  ViewRootImpl root;
     *                   //实例化一个ViewRootImpl对象
     *                  root = new ViewRootImpl(view.getContext(), display);
     *                  view.setLayoutParams(wparams);
     *
     *                 mViews.add(view);
     *                 mRoots.add(root);
     *                 mParams.add(wparams);
     *             }
     *              ......
     *
     *              try {
     *                 //将DecorView交给ViewRootImpl
     *                 root.setView(view, wparams, panelParentView);
     *             }catch (RuntimeException e) {
     *             }
     *
     *             }
     *  }
     * 里面实例化了ViewRootImpl，最终调用了ViewRootImpl的setView方法，接着在setView中调用ViewRootImpl的
     * performTraversals()方法开始绘制view。
     *
     */

    //View.post(Runnable runnable)方法原理
    /**
     * 执行过程是怎么样的？
     * 1. 首先判断View中一个属性mAttachInfo是否为null，注：mAttachInfo中含有一个mHandler，子view的mAttachInfo
     * 和ViewGroup的mAttachInfo是同一个，ViewGroup的mAttachInfo是从ViewRootImpl传过来的，mAttachInfo实例化
     * 发生ViewRootImpl中，mHandler实例化也发生在ViewRootImpl，final ViewRootHandler mHandler = new ViewRootHandler()，
     * 这种方式实例化handler，则handler默认绑定主线程的Looper。
     * 2. mAttachInfo不为null，拿到mHandler直接将消息发送到主线程。
     * 3. mAttachInfo为null，Runnable被存到HandlerActionQueue中，接下来会走到ViewRootImpl的performTraversals()方法，
     * 它中会调用view的dispatchAttachToWindow()，然后dispatchAttachToWindow()方法中会执行从HandlerActionQueue
     * 中取出Runnable并交给mHandler，发送到主线程的Looper处理。
     *
     * ViewRootImpl的performTraversals()方法中以此执行了dispatchAttachToWindow()、performMeasure、performLayout、
     * performDraw，在dispatchAttachToWindow()方法之后进行了view的测量、布局、绘制，那么View.post(runnable)
     * 如何保证runnable操作一定可以拿到view的宽高？
     * android是基于消息机制的，ViewRootImpl的performTraversals()方法是在TraversalRunnable这个消息中执行的，
     * 这个消息执行完后，才会执行view.post()中的Runnable。
     */

    //ViewDragHelper
    /**
     在自定义ViewGroup中完成拖拽功能时使用。

     shouldInterceptTouchEvent(MotionEvent ev)：
     ViewDragHelper中的方法，用来处理事件分发，需要在ViewGroup的onInterceptTouchEvent()方法中调用。

     processTouchEvent(MotionEvent event)：
     ViewDragHelper中的方法。用来处理事件，需要在ViewGroup的onTouchEvent()方法中调用，注意ViewGroup中的
     onTouchEvent()方法一定要返回true。

     实例化方式：
     public static ViewDragHelper create(ViewGroup forParent, Callback cb) {
        return new ViewDragHelper(forParent.getContext(), forParent, cb);
     }
     在拖拽过程中会回调接口Callback中的一些方法。

     public abstract static class Callback {
        //这个方法需要返回true，后续其他方法才能被调用
        //第一个参数：被捕获的view
        //第二个参数：
        public abstract boolean tryCaptureView(View child, int pointerId)；

        //被拖拽的view的状态发生改变时回调的方法
        //三种状态：ViewDragHelper.STATE_IDLE 闲置状态，ViewDragHelper.STATE_DRAGGING 正在拖动，
        //ViewDragHelper.STATE_SETTLING 放置到某个位置
        public void onViewDragStateChanged(int state) {}

        //拖动的view的位置发生变换时调用
        //第一个参数：拖动的view
        //第二个参数：距离左边的距离
        //第三个参数：距离顶部的距离
        //第四个参数：x轴变化量
        //第五个参数：y轴变化量
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {}

        //捕获view时调用的方法
        //第一个参数：被获取的view
        public void onViewCaptured(View capturedChild, int activePointerId) {}

        //view停止拖拽时调用的方法
        //第一个参数：view
        //第二个参数：x轴的拖动速率
        public void onViewReleased(View releasedChild, float xvel, float yvel) {}

     }
     */

}
