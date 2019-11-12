package android;

public class RecyclerView {

    //RecyclerView.LayoutManager，负责item视图的显示管理
    /**
     * 首先是 RecyclerView 继承自ViewGroup，既然是一个 View，那么就不可少的要经历 onMeasure()、onLayout()、
     * onDraw() 这三个方法。 实际上，RecyclerView 就是将 onMeasure()、onLayout() 交给了 LayoutManager 去
     * 处理，因此如果给 RecyclerView 设置不同的 LayoutManager 就可以达到不同的显示效果，因为onMeasure()、
     * onLayout()都不同了。
     */

    //RecyclerView.ItemDecoration，负责每个item的分割线
    /**
     * public abstract static class ItemDecoration {
     * onDraw操作是在RecyclerView所在的画布上绘制内容，也就是在ItemView的背后绘制内容，重叠部分会被ItemView遮挡。
     *      public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull State state) {
     *                  onDraw(c, parent);
     *      }
     *
     * outRect设置top,left,right,bottom有一种padding的效果，但是实际上只是它是ItemView外围的空间，
     * 你可以将其理解成RecyclerView针对每个ItemView设置的Padding，而不是ItemView自身的padding。
     *      @Deprecated
     *      public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
     *                 outRect.set(0, 0, 0, 0);
     *      }
     * }
     */

    //RecyclerView.ViewHolder，

    //RecyclerView.Recycler，ViewHolder的回收与复用
    /**
     * public final class Recycler {
     *      final ArrayList<ViewHolder> mAttachedScrap = new ArrayList<>();
     *      private ArrayList<ViewHolder> mChangedScrap = null;
     *
     *      final ArrayList<ViewHolder> mCachedViews = new ArrayList<ViewHolder>();
     *
     *      private final List<ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(mAttachedScrap);
     *
     *      private RecycledViewPool mRecyclerPool;
     *
     *      private ViewCacheExtension mViewCacheExtension;
     * }
     * 第一级缓存：mAttachedScrap，mChangedScrap，mCachedViews
     * 第二级缓存：mViewCacheExtension，为null，需要调用RecyclerView的setViewCacheExtension()方法设置，由开发者自己维护。
     * 第三级缓存：mRecyclerPool，三级缓存是根据ViewHolder的viewType进行存取的。
     * 什么时候取：从mAttachedScrap，mChangedScrap，mCachedViews，mViewCacheExtension中都没有取到ViewHolder
     * 时，从RecyclerViewPool中取。
     * 什么时候存：
     * //RecycledViewPool为RecyclerView中的静态内部类
     * public static class RecycledViewPool {
     *         private static final int DEFAULT_MAX_SCRAP = 5;
     *         static class ScrapData {
     *         //ViewHolder类型的集合
     *             final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();
     *             int mMaxScrap = DEFAULT_MAX_SCRAP;
     *             long mCreateRunningAverageNs = 0;
     *             long mBindRunningAverageNs = 0;
     *         }
     *         //将集合存储在SparseArray中
     *         SparseArray<ScrapData> mScrap = new SparseArray<>();
     *
     *         //原来每种类型ViewHolder的缓存数量默认为DEFAULT_MAX_SCRAP = 5，这个方法可以设置某种类型ViewHolder
     *         //的缓存数量
     *         public void setMaxRecycledViews(int viewType, int max) {
     *             ScrapData scrapData = getScrapDataForType(viewType);
     *             scrapData.mMaxScrap = max;
     *             final ArrayList<ViewHolder> scrapHeap = scrapData.mScrapHeap;
     *             while (scrapHeap.size() > max) {
     *                 scrapHeap.remove(scrapHeap.size() - 1);
     *             }
     *         }
     *
     *         //通过viewType获取ViewHolder
     *         public ViewHolder getRecycledView(int viewType) {
     *             final ScrapData scrapData = mScrap.get(viewType);
     *             if (scrapData != null && !scrapData.mScrapHeap.isEmpty()) {
     *                 final ArrayList<ViewHolder> scrapHeap = scrapData.mScrapHeap;
     *                 return scrapHeap.remove(scrapHeap.size() - 1);
     *             }
     *             return null;
     *         }
     *
     *        //将ViewHolder存入RecycledViewPool
     *        public void putRecycledView(ViewHolder scrap) {
     *             final int viewType = scrap.getItemViewType();
     *             final ArrayList<ViewHolder> scrapHeap = getScrapDataForType(viewType).mScrapHeap;
     *             if (mScrap.get(viewType).mMaxScrap <= scrapHeap.size()) {
     *                 return;
     *             }
     *             if (DEBUG && scrapHeap.contains(scrap)) {
     *                 throw new IllegalArgumentException("this scrap item already exists");
     *             }
     *             scrap.resetInternal();
     *             scrapHeap.add(scrap);
     *         }
     *
     */
}
