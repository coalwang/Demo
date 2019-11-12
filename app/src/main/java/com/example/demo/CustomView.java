package com.example.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private float mStartX;
    private float mStartY;

    private Scroller mS;
    private void init() {
        mS = new Scroller(getContext());

    }

    @Override
    public void computeScroll() {
        if (mS.computeScrollOffset()) {
            ((View)getParent()).scrollTo(mS.getCurrX(), mS.getCurrY());
            invalidate();
        }
        super.computeScroll();
    }

    public void smoothScrollTo(int dex, int dey) {
        int sx = getScrollX();
        int d = dex -sx;
        mS.startScroll(sx, 0, d, 0,2000);
    }
}
