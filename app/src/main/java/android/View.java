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

}
