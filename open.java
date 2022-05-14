package com.tmall.ultraviewpager;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}

package com.tmall.ultraviewpager;

import android.graphics.Bitmap;

/**
 * Created by mikeafc on 15/11/25.
 */
public interface IUltraIndicatorBuilder {
    /**
     * Set focused color for indicator.
     * @param focusColor
     * @return
     */
    IUltraIndicatorBuilder setFocusColor(int focusColor);

    /**
     * Set normal color for indicator.
     * @param normalColor
     * @return
     */
    IUltraIndicatorBuilder setNormalColor(int normalColor);

    /**
     * Set stroke color for indicator.
     * @param strokeColor
     * @return
     */
    IUltraIndicatorBuilder setStrokeColor(int strokeColor);

    /**
     * Set stroke width for indicator.
     * @param strokeWidth
     * @return
     */
    IUltraIndicatorBuilder setStrokeWidth(int strokeWidth);

    /**
     * Set spacing between indicator item ，the default value is item's height.
     * @param indicatorPadding
     * @return
     */
    IUltraIndicatorBuilder setIndicatorPadding(int indicatorPadding);

    /**
     * Set the corner radius of the indicator item.
     * @param radius
     * @return
     */
    IUltraIndicatorBuilder setRadius(int radius);

    /**
     * Sets the orientation of the layout.
     * @param orientation
     * @return
     */
    IUltraIndicatorBuilder setOrientation(UltraViewPager.Orientation orientation);

    /**
     * Set the location at which the indicator should appear on the screen.
     *
     * @param gravity android.view.Gravity
     * @return
     */
    IUltraIndicatorBuilder setGravity(int gravity);

    /**
     * Set focused resource ID for indicator.
     * @param focusResId
     * @return
     */
    IUltraIndicatorBuilder setFocusResId(int focusResId);

    /**
     * Set normal resource ID for indicator.
     * @param normalResId
     * @return
     */
    IUltraIndicatorBuilder setNormalResId(int normalResId);

    /**
     * Set focused icon for indicator.
     * @param bitmap
     * @return
     */
    IUltraIndicatorBuilder setFocusIcon(Bitmap bitmap);

    /**
     * Set normal icon for indicator.
     * @param bitmap
     * @return
     */
    IUltraIndicatorBuilder setNormalIcon(Bitmap bitmap);

    /**
     * Set margins for indicator.
     * @param left   the left margin in pixels
     * @param top    the top margin in pixels
     * @param right  the right margin in pixels
     * @param bottom the bottom margin in pixels
     * @return
     */
    IUltraIndicatorBuilder setMargin(int left, int top, int right, int bottom);

    /**
     * Combine all of the options that have been set and return a new IUltraIndicatorBuilder object.
     */
    void build();
}


package com.tmall.ultraviewpager;

import android.graphics.Bitmap;
import android.util.SparseIntArray;

/**
 * Created by mikeafc on 15/11/30.
 */
interface IUltraViewPagerFeature {
    /**
     * Constructs a indicator with no options. this indicator support set-Method in chained mode.
     * meanwhile focusColor and normalColor are necessary,or the indicator won't be show.
     */
    IUltraIndicatorBuilder initIndicator();

    /**
     * Set options for indicator
     *
     * @param focusColor    defines the color when indicator is focused.
     * @param normalColor   defines the color when indicator is in the default state (not focused).
     * @param radiusInPixel defines the radius of indicator item.
     * @param gravity       specifies how to align the indicator. for example, using Gravity.BOTTOM | Gravity.RIGHT
     */
    IUltraIndicatorBuilder initIndicator(int focusColor, int normalColor, int radiusInPixel, int gravity);

    /**
     * Set options for indicator
     *
     * @param focusColor    defines the color when indicator is focused.
     * @param normalColor   defines the color when indicator is in the default state (not focused).
     * @param strokeColor   stroke color
     * @param strokeWidth   stroke width
     * @param radiusInPixel the radius of indicator item.
     * @param gravity       specifies how to align the indicator. for example, using Gravity.BOTTOM | Gravity.RIGHT
     */
    IUltraIndicatorBuilder initIndicator(int focusColor, int normalColor, int strokeColor, int strokeWidth, int radiusInPixel, int gravity);

    /**
     * Set options for indicator
     *
     * @param focusResId  defines the resource id when indicator is focused.
     * @param normalResId defines the resource id  when indicator is in the default state (not focused).
     * @param gravity     specifies how to align the indicator. for example, using Gravity.BOTTOM | Gravity.RIGHT
     */
    IUltraIndicatorBuilder initIndicator(int focusResId, int normalResId, int gravity);

    /**
     * @param focusBitmap  defines the bitmap when indicator is focused
     * @param normalBitmap defines the bitmap when indicator is in the default state (not focused).
     * @param gravity      specifies how to align the indicator. for example, using Gravity.BOTTOM | Gravity.RIGHT
     * @return
     */
    IUltraIndicatorBuilder initIndicator(Bitmap focusBitmap, Bitmap normalBitmap, int gravity);

    /**
     * Remove indicator
     */
    void disableIndicator();

    /**
     * Enable auto-scroll mode
     *
     * @param intervalInMillis The interval time to scroll in milliseconds.
     */
    void setAutoScroll(int intervalInMillis);

    /**
     * Enable auto-scroll mode with special interval times
     * @param intervalInMillis The default time to scroll
     * @param intervalArray The special interval to scroll, in responding to each frame
     */
    void setAutoScroll(int intervalInMillis, SparseIntArray intervalArray);

    /**
     * Disable auto-scroll mode
     */
    void disableAutoScroll();

    /**
     * Set an infinite loop
     *
     * @param enable enable or disable
     */
    void setInfiniteLoop(boolean enable);

    /**
     * Supply a maximum width for this ViewPager.
     *
     * @param width width
     */
    void setMaxWidth(int width);

    /**
     * Supply a maximum height for this ViewPager.
     *
     * @param height height
     */
    void setMaxHeight(int height);

    /**
     * Set the aspect ratio for UltraViewPager.
     *
     * @param ratio
     */
    void setRatio(float ratio);

    /**
     * Set scroll mode for UltraViewPager.
     *
     * @param scrollMode UltraViewPager.ScrollMode.HORIZONTAL or UltraViewPager.ScrollMode.VERTICAL
     */
    void setScrollMode(UltraViewPager.ScrollMode scrollMode);

    /**
     * Disable scroll direction. the default value is ScrollDirection.NONE
     *
     * @param direction NONE, BACKWARD, FORWARD
     */
    void disableScrollDirection(UltraViewPager.ScrollDirection direction);

    /**
     * Scroll to the last page, and return to the first page when the last page is reached.
     */
    boolean scrollLastPage();

    /**
     * Scroll to the next page, and return to the first page when the last page is reached.
     */
    boolean scrollNextPage();

    /**
     * Set multi-screen mode , the aspect ratio of PageViewer should less than or equal to 1.0f
     */
    void setMultiScreen(float ratio);

    /**
     * Adjust the height of the ViewPager to the height of child automatically.
     */
    void setAutoMeasureHeight(boolean status);

    /**
     * Adjust the height of child item view with aspect ratio.
     *
     * @param ratio aspect ratio
     */
    void setItemRatio(double ratio);

    /**
     * Set the gap between two pages in pixel
     *
     * @param pixel
     */
    void setHGap(int pixel);

    /**
     * Set item margin
     *
     * @param left   the left margin in pixels
     * @param top    the top margin in pixels
     * @param right  the right margin in pixels
     * @param bottom the bottom margin in pixels
     */
    void setItemMargin(int left, int top, int right, int bottom);

    /**
     * Set margins for this ViewPager
     *
     * @param left  the left margin in pixels
     * @param right the right margin in pixels
     */
    void setScrollMargin(int left, int right);

    /**
     * The items.size() would be scale to item.size()*infiniteRatio in fact
     *
     * @param infiniteRatio
     */
    void setInfiniteRatio(int infiniteRatio);
}



package com.tmall.ultraviewpager;

import android.os.Handler;
import android.os.Message;
import android.util.SparseIntArray;

/**
 * Created by mikeafc on 15/11/25.
 */
public class TimerHandler extends Handler {

    public interface TimerHandlerListener {
        int getNextItem();
        void callBack();
    }

    SparseIntArray specialInterval;
    long interval;
    boolean isStopped = true;
    TimerHandlerListener listener;

    static final int MSG_TIMER_ID = 87108;

    public TimerHandler(TimerHandlerListener listener, long interval) {
        this.listener = listener;
        this.interval = interval;
    }

    @Override
    public void handleMessage(Message msg) {
        if (MSG_TIMER_ID == msg.what) {
            if (listener != null) {
                int nextIndex = listener.getNextItem();
                listener.callBack();
                tick(nextIndex);
            }
        }
    }

    public void tick(int index) {
        sendEmptyMessageDelayed(TimerHandler.MSG_TIMER_ID, getNextInterval(index));
    }

    private long getNextInterval(int index) {
        long next = interval;
        if (specialInterval != null) {
            long has = specialInterval.get(index, -1);
            if (has > 0) {
                next = has;
            }
        }
        return next;
    }

    public boolean isStopped() {
        return isStopped;
    }

    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    public void setListener(TimerHandlerListener listener) {
        this.listener = listener;
    }

    public void setSpecialInterval(SparseIntArray specialInterval) {
        this.specialInterval = specialInterval;
    }
}

package com.tmall.ultraviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by mikeafc on 15/10/26.<br>
 * UltraViewPager is a super extension for ViewPager.<br>
 * It's actually a RelativeLayout in order to display indicator, UltraViewPager offers some usual
 * method delegate for ViewPager, you can also invoke more method by call getViewPager() and get the actual
 * ViewPager.
 */
public class UltraViewPager extends RelativeLayout implements IUltraViewPagerFeature {

    public enum ScrollMode {
        HORIZONTAL(0), VERTICAL(1);
        int id;

        ScrollMode(int id) {
            this.id = id;
        }

        static ScrollMode getScrollMode(int id) {
            for (ScrollMode scrollMode : values()) {
                if (scrollMode.id == id)
                    return scrollMode;
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Orientation {
        HORIZONTAL, VERTICAL
    }

    public enum ScrollDirection {
        NONE(0), BACKWARD(1), FORWARD(2);
        int id;

        ScrollDirection(int id) {
            this.id = id;
        }

        static ScrollDirection getScrollDirection(int id) {
            for (ScrollDirection direction : values()) {
                if (direction.id == id)
                    return direction;
            }
            throw new IllegalArgumentException();
        }
    }

    private final Point size;
    private final Point maxSize;

    private float ratio = Float.NaN;

    //Maximum width of child when enable multiScreen.
    private int maxWidth = -1;

    //Maximum height of child when enable multiScreen.
    private int maxHeight = -1;

    private UltraViewPagerView viewPager;
    private UltraViewPagerIndicator pagerIndicator;

    private TimerHandler timer;


    public UltraViewPager(Context context) {
        super(context);
        size = new Point();
        maxSize = new Point();
        initView();
    }

    public UltraViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        size = new Point();
        maxSize = new Point();
        initView();
        initView(context, attrs);
    }

    public UltraViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        size = new Point();
        maxSize = new Point();
        initView();
    }

    private void initView() {
        viewPager = new UltraViewPagerView(getContext());
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            viewPager.setId(viewPager.hashCode());
        } else {
            viewPager.setId(View.generateViewId());
        }

        addView(viewPager, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.UltraViewPager);
        setAutoScroll(ta.getInt(R.styleable.UltraViewPager_upv_autoscroll, 0));
        setInfiniteLoop(ta.getBoolean(R.styleable.UltraViewPager_upv_infiniteloop, false));
        setRatio(ta.getFloat(R.styleable.UltraViewPager_upv_ratio, Float.NaN));
        setScrollMode(ScrollMode.getScrollMode(ta.getInt(R.styleable.UltraViewPager_upv_scrollmode, 0)));
        disableScrollDirection(ScrollDirection.getScrollDirection(ta.getInt(R.styleable.UltraViewPager_upv_disablescroll, 0)));
        setMultiScreen(ta.getFloat(R.styleable.UltraViewPager_upv_multiscreen, 1f));
        setAutoMeasureHeight(ta.getBoolean(R.styleable.UltraViewPager_upv_automeasure, false));
        setItemRatio(ta.getFloat(R.styleable.UltraViewPager_upv_itemratio, Float.NaN));
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!Float.isNaN(ratio)) {
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (widthSize / ratio), MeasureSpec.EXACTLY);
        }
        size.set(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        if (maxWidth >= 0 || maxHeight >= 0) {
            maxSize.set(maxWidth, maxHeight);
            constrainTo(size, maxSize);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(size.x, MeasureSpec.EXACTLY);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(size.y, MeasureSpec.EXACTLY);
        }
        if (viewPager.getConstrainLength() > 0) {
            if (viewPager.getConstrainLength() == heightMeasureSpec) {
                viewPager.measure(widthMeasureSpec, heightMeasureSpec);
                setMeasuredDimension(size.x, size.y);
            } else {
                if (viewPager.getScrollMode() == ScrollMode.HORIZONTAL) {
                    super.onMeasure(widthMeasureSpec, viewPager.getConstrainLength());
                } else {
                    super.onMeasure(viewPager.getConstrainLength(), heightMeasureSpec);
                }
            }
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startTimer();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopTimer();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == VISIBLE) {
            startTimer();
        } else {
            stopTimer();
        }
    }

    @Override
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        stopTimer();
    }

    @Override
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        startTimer();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (timer != null) {
            final int action = ev.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                stopTimer();
            }
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                startTimer();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public IUltraIndicatorBuilder initIndicator() {
        disableIndicator();
        pagerIndicator = new UltraViewPagerIndicator(getContext());
        pagerIndicator.setViewPager(viewPager);
        pagerIndicator.setIndicatorBuildListener(new UltraViewPagerIndicator.UltraViewPagerIndicatorListener() {
            @Override
            public void build() {
                removeView(pagerIndicator);
                addView(pagerIndicator, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
        });
        return pagerIndicator;
    }

    @Override
    public IUltraIndicatorBuilder initIndicator(int focusColor, int normalColor, int radiusInPixel, int gravity) {
        return initIndicator()
                .setFocusColor(focusColor)
                .setNormalColor(normalColor)
                .setRadius(radiusInPixel)
                .setGravity(gravity);
    }

    @Override
    public IUltraIndicatorBuilder initIndicator(int focusColor, int normalColor, int strokeColor, int strokeWidth, int radiusInPixel, int gravity) {
        return initIndicator()
                .setFocusColor(focusColor)
                .setNormalColor(normalColor)
                .setStrokeWidth(strokeWidth)
                .setStrokeColor(strokeColor)
                .setRadius(radiusInPixel)
                .setGravity(gravity);
    }

    @Override
    public IUltraIndicatorBuilder initIndicator(int focusResId, int normalResId, int gravity) {
        return initIndicator()
                .setFocusResId(focusResId)
                .setNormalResId(normalResId)
                .setGravity(gravity);
    }

    @Override
    public IUltraIndicatorBuilder initIndicator(Bitmap focusBitmap, Bitmap normalBitmap, int gravity) {
        return initIndicator()
                .setFocusIcon(focusBitmap)
                .setNormalIcon(normalBitmap)
                .setGravity(gravity);
    }

    @Override
    public void disableIndicator() {
        if (pagerIndicator != null) {
            removeView(pagerIndicator);
            pagerIndicator = null;
        }
    }

    public IUltraIndicatorBuilder getIndicator() {
        return pagerIndicator;
    }

    private TimerHandler.TimerHandlerListener mTimerHandlerListener = new TimerHandler.TimerHandlerListener() {
        @Override
        public int getNextItem() {
            return UltraViewPager.this.getNextItem();
        }

        @Override
        public void callBack() {
            scrollNextPage();
        }
    };

    @Override
    public void setAutoScroll(int intervalInMillis) {
        if (0 == intervalInMillis) {
            return;
        }
        if (timer != null) {
            disableAutoScroll();
        }
        timer = new TimerHandler(mTimerHandlerListener, intervalInMillis);
        startTimer();
    }

    @Override
    public void setAutoScroll(int intervalInMillis, SparseIntArray intervalArray) {
        if (0 == intervalInMillis) {
            return;
        }
        if (timer != null) {
            disableAutoScroll();
        }
        timer = new TimerHandler(mTimerHandlerListener, intervalInMillis);
        timer.specialInterval = intervalArray;
        startTimer();
    }

    @Override
    public void disableAutoScroll() {
        stopTimer();
        timer = null;
    }

    @Override
    public void setScrollMode(ScrollMode scrollMode) {
        viewPager.setScrollMode(scrollMode);
    }

    @Override
    public void setInfiniteLoop(boolean enableLoop) {
        viewPager.setEnableLoop(enableLoop);
    }

    @Override
    public void setMaxWidth(int width) {
        maxWidth = width;
    }

    @Override
    public void setRatio(float ratio) {
        this.ratio = ratio;
        viewPager.setRatio(ratio);
    }

    @Override
    public void setHGap(int pixel) {
        int screenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        viewPager.setMultiScreen((screenWidth - pixel) / (float) screenWidth);
        viewPager.setPageMargin(pixel);
    }

    @Override
    public void setMaxHeight(int height) {
        maxHeight = height;
    }

    @Override
    public void disableScrollDirection(UltraViewPager.ScrollDirection direction) {

    }

    @Override
    public boolean scrollLastPage() {
        boolean isChange = false;
        if (viewPager != null && viewPager.getAdapter() != null && viewPager.getAdapter().getCount() > 0) {
            final int curr = viewPager.getCurrentItemFake();
            int lastPage = 0;
            if (curr > 0) {
                lastPage = curr - 1;
                isChange = true;
            }
            viewPager.setCurrentItemFake(lastPage, true);
        }
        return isChange;
    }

    @Override
    public boolean scrollNextPage() {
        boolean isChange = false;
        if (viewPager != null && viewPager.getAdapter() != null && viewPager.getAdapter().getCount() > 0) {
            final int curr = viewPager.getCurrentItemFake();
            int nextPage = 0;
            if (curr < viewPager.getAdapter().getCount() - 1) {
                nextPage = curr + 1;
                isChange = true;
            }
            viewPager.setCurrentItemFake(nextPage, true);
        }
        return isChange;
    }

    @Override
    public void setMultiScreen(float ratio) {
        if (ratio <= 0 || ratio > 1) {
            throw new IllegalArgumentException("");
        }
        if (ratio <= 1f) {
            viewPager.setMultiScreen(ratio);
        }
    }

    @Override
    public void setAutoMeasureHeight(boolean status) {
        viewPager.setAutoMeasureHeight(status);
    }

    @Override
    public void setItemRatio(double ratio) {
        viewPager.setItemRatio(ratio);
    }

    @Override
    public void setItemMargin(int left, int top, int right, int bottom) {
        viewPager.setItemMargin(left, top, right, bottom);
    }

    @Override
    public void setScrollMargin(int left, int right) {
        viewPager.setPadding(left, 0, right, 0);
    }

    /**
     * delegate viewpager
     */

    public void setAdapter(PagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }

    public void setOffscreenPageLimit(int limit) {
        viewPager.setOffscreenPageLimit(limit);
    }

    public PagerAdapter getAdapter() {
        return viewPager.getAdapter() == null ? null : ((UltraViewPagerAdapter) viewPager.getAdapter()).getAdapter();
    }

    public PagerAdapter getWrapAdapter() {
        return viewPager.getAdapter();
    }

    public void refresh() {
        if (viewPager.getAdapter() != null) {
            viewPager.getAdapter().notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        if (pagerIndicator == null) {
            //avoid registering the same listener twice
            viewPager.removeOnPageChangeListener(listener);
            viewPager.addOnPageChangeListener(listener);
        } else {
            pagerIndicator.setPageChangeListener(listener);
        }
    }

    public void setCurrentItem(int item) {
        viewPager.setCurrentItem(item);
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }

    public int getCurrentItem() {
        return viewPager.getCurrentItem();
    }

    public int getNextItem() {
        return viewPager.getNextItem();
    }

    public void setPageTransformer(boolean reverseDrawingOrder, ViewPager.PageTransformer transformer) {
        viewPager.setPageTransformer(reverseDrawingOrder, transformer);
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    private void constrainTo(Point size, Point maxSize) {
        if (maxSize.x >= 0) {
            if (size.x > maxSize.x) {
                size.x = maxSize.x;
            }
        }
        if (maxSize.y >= 0) {
            if (size.y > maxSize.y) {
                size.y = maxSize.y;
            }
        }
    }

    private void startTimer() {
        if (timer == null || viewPager == null || !timer.isStopped) {
            return;
        }
        timer.listener = mTimerHandlerListener;
        timer.removeCallbacksAndMessages(null);
        timer.tick(0);
        timer.isStopped = false;
    }

    private void stopTimer() {
        if (timer == null || viewPager == null || timer.isStopped) {
            return;
        }
        timer.removeCallbacksAndMessages(null);
        timer.listener = null;
        timer.isStopped = true;
    }

    @Override
    public void setInfiniteRatio(int infiniteRatio) {
        if (viewPager.getAdapter() != null
                && viewPager.getAdapter() instanceof UltraViewPagerAdapter) {
            ((UltraViewPagerAdapter) viewPager.getAdapter()).setInfiniteRatio(infiniteRatio);
        }
    }

}




package com.tmall.ultraviewpager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mikeafc on 15/11/25.
 */
public class UltraViewPagerAdapter extends PagerAdapter {
    public interface UltraViewPagerCenterListener {
        void center();

        void resetPosition();
    }

    private static final int INFINITE_RATIO = 400;

    private PagerAdapter adapter;
    private boolean enableLoop;
    private float multiScrRatio = Float.NaN;
    private boolean hasCentered; //ensure that the first item is in the middle when enabling loop-mode
    private int scrWidth;
    private int infiniteRatio;
    private UltraViewPagerCenterListener centerListener;

    private SparseArray viewArray = new SparseArray();

    public UltraViewPagerAdapter(PagerAdapter adapter) {
        this.adapter = adapter;
        infiniteRatio = INFINITE_RATIO;
    }

    @Override
    public int getCount() {
        int count;
        if (enableLoop) {
            if (adapter.getCount() == 0) {
                count = 0;
            } else {
                count = adapter.getCount() * infiniteRatio;
            }
        } else {
            count = adapter.getCount();
        }
        return count;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition = position;
        //TODO
        if (enableLoop && adapter.getCount() != 0) {
            realPosition = position % adapter.getCount();
        }

        Object item = adapter.instantiateItem(container, realPosition);
        //TODO
        View childView = null;
        if (item instanceof View)
            childView = (View) item;
        if (item instanceof RecyclerView.ViewHolder)
            childView = ((RecyclerView.ViewHolder) item).itemView;

        int childCount = container.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = container.getChildAt(i);
            if (isViewFromObject(child, item)) {
                viewArray.put(realPosition, child);
                break;
            }
        }

        if (isEnableMultiScr()) {
            if (scrWidth == 0) {
                scrWidth = container.getResources().getDisplayMetrics().widthPixels;
            }
            RelativeLayout relativeLayout = new RelativeLayout(container.getContext());

            if (childView.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                        (int) (scrWidth * multiScrRatio),
                        ViewGroup.LayoutParams.MATCH_PARENT);

                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                childView.setLayoutParams(layoutParams);
            }

            container.removeView(childView);
            relativeLayout.addView(childView);

            container.addView(relativeLayout);
            return relativeLayout;
        }

        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int realPosition = position;

        //TODO
        if (enableLoop && adapter.getCount() != 0)
            realPosition = position % adapter.getCount();

        if (isEnableMultiScr() && object instanceof RelativeLayout) {
            View child = ((RelativeLayout) object).getChildAt(0);
            ((RelativeLayout) object).removeAllViews();
            adapter.destroyItem(container, realPosition, child);
        } else {
            adapter.destroyItem(container, realPosition, object);
        }

        viewArray.remove(realPosition);
    }

    public View getViewAtPosition(int position) {
        return (View) viewArray.get(position);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        // only need to set the center position  when the loop is enabled
        if (!hasCentered) {
            if (adapter.getCount() > 0 && getCount() > adapter.getCount()) {
                centerListener.center();
            }
        }
        hasCentered = true;
        adapter.finishUpdate(container);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return adapter.isViewFromObject(view, object);
    }

    @Override
    public void restoreState(Parcelable bundle, ClassLoader classLoader) {
        adapter.restoreState(bundle, classLoader);
    }

    @Override
    public Parcelable saveState() {
        return adapter.saveState();
    }

    @Override
    public void startUpdate(ViewGroup container) {
        adapter.startUpdate(container);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int virtualPosition = position % adapter.getCount();
        return adapter.getPageTitle(virtualPosition);
    }

    @Override
    public float getPageWidth(int position) {
        return adapter.getPageWidth(position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        adapter.setPrimaryItem(container, position, object);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        adapter.unregisterDataSetObserver(observer);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        adapter.registerDataSetObserver(observer);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return adapter.getItemPosition(object);
    }

    public PagerAdapter getAdapter() {
        return adapter;
    }

    public int getRealCount() {
        return adapter.getCount();
    }

    public void setEnableLoop(boolean status) {
        this.enableLoop = status;
        notifyDataSetChanged();
        if (!status) {
            centerListener.resetPosition();
        } else {
            //try {
            //    centerListener.center();
            //} catch (Exception e) {
            //
            //}
        }
    }

    public boolean isEnableLoop() {
        return enableLoop;
    }

    public void setMultiScrRatio(float ratio) {
        multiScrRatio = ratio;
    }

    public boolean isEnableMultiScr() {
        return !Float.isNaN(multiScrRatio) && multiScrRatio < 1f;
    }

    public void setCenterListener(UltraViewPagerCenterListener listener) {
        centerListener = listener;
    }

    public void setInfiniteRatio(int infiniteRatio) {
        this.infiniteRatio = infiniteRatio;
    }
}


package com.tmall.ultraviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

/**
 * Created by mikeafc on 15/11/25.
 */
public class UltraViewPagerIndicator extends View implements ViewPager.OnPageChangeListener, IUltraIndicatorBuilder {
    interface UltraViewPagerIndicatorListener {
        void build();
    }

    private UltraViewPagerView viewPager;
    private ViewPager.OnPageChangeListener pageChangeListener;
    private int scrollState;

    //attr for custom
    private int radius;
    private int indicatorPadding;
    private boolean animateIndicator;
    private int gravity;
    private UltraViewPager.Orientation orientation = UltraViewPager.Orientation.HORIZONTAL;

    private int marginLeft;
    private int marginTop;
    private int marginRight;
    private int marginBottom;
    //for circle
    private int focusColor;
    private int normalColor;
    //for custom icon
    private Bitmap focusBitmap;
    private Bitmap normalBitmap;

    //paint
    private Paint paintStroke;
    private Paint paintFill;

    float pageOffset;
    float defaultRadius;

    //default
    private static final int DEFAULT_RADIUS = 3;

    private UltraViewPagerIndicatorListener indicatorBuildListener;

    public UltraViewPagerIndicator(Context context) {
        super(context);
        init();
    }

    public UltraViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UltraViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paintStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintStroke.setStyle(Paint.Style.STROKE);
        paintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintFill.setStyle(Paint.Style.FILL);
        defaultRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_RADIUS, getResources().getDisplayMetrics());
    }

    public void setViewPager(UltraViewPagerView viewPager) {
        this.viewPager = viewPager;
        this.viewPager.setOnPageChangeListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (viewPager == null || viewPager.getAdapter() == null)
            return;

        final int count = ((UltraViewPagerAdapter) viewPager.getAdapter()).getRealCount();
        if (count == 0)
            return;

        int longSize;
        int shortSize;

        int longPaddingBefore;
        int longPaddingAfter;
        int shortPaddingBefore;
        int shortPaddingAfter;
        if (orientation == UltraViewPager.Orientation.HORIZONTAL) {
            longSize = viewPager.getWidth();
            shortSize = viewPager.getHeight();
            longPaddingBefore = getPaddingLeft() + marginLeft;
            longPaddingAfter = getPaddingRight() + marginRight;
            shortPaddingBefore = getPaddingTop() + marginTop;
            shortPaddingAfter = (int) paintStroke.getStrokeWidth() + getPaddingBottom() + marginBottom;
        } else {
            longSize = viewPager.getHeight();
            shortSize = viewPager.getWidth();
            longPaddingBefore = getPaddingTop() + marginTop;
            longPaddingAfter = (int) paintStroke.getStrokeWidth() + getPaddingBottom() + marginBottom;
            shortPaddingBefore = getPaddingLeft() + marginLeft;
            shortPaddingAfter = getPaddingRight() + marginRight;
        }

        final float itemWidth = getItemWidth();
        final int widthRatio = isDrawResIndicator() ? 1 : 2; //bitmap resource X1 : circle  X2
        if (indicatorPadding == 0) {
            indicatorPadding = (int) itemWidth;
        }

        float shortOffset = shortPaddingBefore;
        float longOffset = longPaddingBefore;

        final float indicatorLength = (count - 1) * (itemWidth * widthRatio + indicatorPadding);

        final int horizontalGravityMask = gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
        final int verticalGravityMask = gravity & Gravity.VERTICAL_GRAVITY_MASK;
        switch (horizontalGravityMask) {
            case Gravity.CENTER_HORIZONTAL:
                longOffset = (longSize - longPaddingBefore - longPaddingAfter - indicatorLength) / 2.0f;
                break;
            case Gravity.RIGHT:
                if (orientation == UltraViewPager.Orientation.HORIZONTAL) {
                    longOffset = longSize - longPaddingAfter - indicatorLength - itemWidth;
                }
                if (orientation == UltraViewPager.Orientation.VERTICAL) {
                    shortOffset = shortSize - shortPaddingAfter - itemWidth;
                }
                break;
            case Gravity.LEFT:
                longOffset += itemWidth;
            default:
                break;
        }

        switch (verticalGravityMask) {
            case Gravity.CENTER_VERTICAL:
                shortOffset = (shortSize - shortPaddingAfter - shortPaddingBefore - itemWidth) / 2;
                break;
            case Gravity.BOTTOM:
                if (orientation == UltraViewPager.Orientation.HORIZONTAL) {
                    shortOffset = shortSize - shortPaddingAfter - getItemHeight();
                }
                if (orientation == UltraViewPager.Orientation.VERTICAL) {
                    longOffset = longSize - longPaddingAfter - indicatorLength;
                }
                break;
            case Gravity.TOP:
                shortOffset += itemWidth;
            default:
                break;
        }

        if (horizontalGravityMask == Gravity.CENTER_HORIZONTAL && verticalGravityMask == Gravity.CENTER_VERTICAL) {
            shortOffset = (shortSize - shortPaddingAfter - shortPaddingBefore - itemWidth) / 2;
        }

        float dX;
        float dY;

        float pageFillRadius = radius;
        if (paintStroke.getStrokeWidth() > 0) {
            pageFillRadius -= paintStroke.getStrokeWidth() / 2.0f; //TODO may not/2
        }

        //Draw stroked circles
        for (int iLoop = 0; iLoop < count; iLoop++) {
            float drawLong = longOffset + (iLoop * (itemWidth * widthRatio + indicatorPadding));

            if (orientation == UltraViewPager.Orientation.HORIZONTAL) {
                dX = drawLong;
                dY = shortOffset;
            } else {
                dX = shortOffset;
                dY = drawLong;
            }

            if (isDrawResIndicator()) {
                if (iLoop == viewPager.getCurrentItem())
                    continue;
                canvas.drawBitmap(normalBitmap, dX, dY, paintFill);
            } else {
                // Only paint fill if not completely transparent
                if (paintFill.getAlpha() > 0) {
                    paintFill.setColor(normalColor);
                    canvas.drawCircle(dX, dY, pageFillRadius, paintFill);
                }

                // Only paint stroke if a stroke width was non-zero
                if (pageFillRadius != radius) {
                    canvas.drawCircle(dX, dY, radius, paintStroke);
                }
            }
        }

        //Draw the filled circle according to the current scroll
        float cx = (viewPager.getCurrentItem()) * (itemWidth * widthRatio + indicatorPadding);
        if (animateIndicator)
            cx += pageOffset * itemWidth;
        if (orientation == UltraViewPager.Orientation.HORIZONTAL) {
            dX = longOffset + cx;
            dY = shortOffset;
        } else {
            dX = shortOffset;
            dY = longOffset + cx;
        }

        if (isDrawResIndicator()) {
            canvas.drawBitmap(focusBitmap, dX, dY, paintStroke);
        } else {
            paintFill.setColor(focusColor);
            canvas.drawCircle(dX, dY, radius, paintFill);
        }
    }

    private boolean isDrawResIndicator() {
        return focusBitmap != null && normalBitmap != null;
    }

    private float getItemWidth() {
        if (isDrawResIndicator()) {
            return Math.max(focusBitmap.getWidth(), normalBitmap.getWidth());
        }
        return radius == 0 ? defaultRadius : radius;
    }

    private float getItemHeight() {
        if (isDrawResIndicator()) {
            return Math.max(focusBitmap.getHeight(), normalBitmap.getHeight());
        }
        return radius == 0 ? defaultRadius : radius;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        pageOffset = positionOffset;
        invalidate();

        if (pageChangeListener != null) {
            pageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (scrollState == ViewPager.SCROLL_STATE_IDLE) {
            invalidate();
        }

        if (pageChangeListener != null) {
            pageChangeListener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        scrollState = state;

        if (pageChangeListener != null) {
            pageChangeListener.onPageScrollStateChanged(state);
        }
    }

    @Override
    public IUltraIndicatorBuilder setOrientation(UltraViewPager.Orientation orien) {
        this.orientation = orien;
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setIndicatorPadding(int indicatorPadding) {
        this.indicatorPadding = indicatorPadding;
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setFocusColor(int focusColor) {
        this.focusColor = focusColor;
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setNormalColor(int normalColor) {
        this.normalColor = normalColor;
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setStrokeColor(int strokeColor) {
        paintStroke.setColor(strokeColor);
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setStrokeWidth(int strokeWidth) {
        paintStroke.setStrokeWidth(strokeWidth);
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setFocusResId(int focusResId) {
        try {
            focusBitmap = BitmapFactory.decodeResource(getResources(), focusResId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setNormalResId(int normalResId) {
        try {
            normalBitmap = BitmapFactory.decodeResource(getResources(), normalResId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setFocusIcon(Bitmap bitmap) {
        focusBitmap = bitmap;
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setNormalIcon(Bitmap bitmap) {
        normalBitmap = bitmap;
        return this;
    }

    @Override
    public IUltraIndicatorBuilder setMargin(int left, int top, int right, int bottom) {
        marginLeft = left;
        marginTop = top;
        marginRight = right;
        marginBottom = bottom;
        return this;
    }

    @Override
    public void build() {
        if (indicatorBuildListener != null) {
            indicatorBuildListener.build();
        }
    }

    public void setPageChangeListener(ViewPager.OnPageChangeListener pageChangeListener) {
        this.pageChangeListener = pageChangeListener;
    }

    public void setIndicatorBuildListener(UltraViewPagerIndicatorListener listener) {
        this.indicatorBuildListener = listener;
    }
}


package com.tmall.ultraviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.tmall.ultraviewpager.transformer.UltraVerticalTransformer;

/**
 * Created by mikeafc on 15/11/25.
 */
public class UltraViewPagerView extends ViewPager implements UltraViewPagerAdapter.UltraViewPagerCenterListener {

    private UltraViewPagerAdapter pagerAdapter;

    //Internal state to schedule a new measurement pass.
    private boolean needsMeasurePage;

    private float multiScrRatio = Float.NaN;
    private boolean enableLoop;
    private boolean autoMeasureHeight;
    private double itemRatio = Double.NaN;
    private int constrainLength;

    private int itemMarginLeft;
    private int itemMarginTop;
    private int itemMarginRight;
    private int itemMarginBottom;

    private float ratio = Float.NaN;

    private UltraViewPager.ScrollMode scrollMode = UltraViewPager.ScrollMode.HORIZONTAL;

    public UltraViewPagerView(Context context) {
        super(context);
        init(context, null);
    }

    public UltraViewPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setClipChildren(false);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        onMeasurePage(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onMeasurePage(int widthMeasureSpec, int heightMeasureSpec) {
        if (pagerAdapter == null) {
            return;
        }
        View child = pagerAdapter.getViewAtPosition(getCurrentItem());
        if (child == null) {
            child = getChildAt(0);
        }
        if (child == null) {
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if ((view.getPaddingLeft() != itemMarginLeft ||
                    view.getPaddingTop() != itemMarginTop ||
                    view.getPaddingRight() != itemMarginRight ||
                    view.getPaddingBottom() != itemMarginBottom)) {
                view.setPadding(itemMarginLeft, itemMarginTop, itemMarginRight, itemMarginBottom);
            }
        }

        ViewGroup.LayoutParams lp = child.getLayoutParams();
        final int childWidthSpec = getChildMeasureSpec(widthMeasureSpec, 0, lp.width);
        final int childHeightSpec = getChildMeasureSpec(heightMeasureSpec, 0, lp.height);

        int childWidth = (int) ((MeasureSpec.getSize(childWidthSpec) - getPaddingLeft() - getPaddingRight()) * pagerAdapter.getPageWidth(getCurrentItem()));
        int childHeight = MeasureSpec.getSize(childHeightSpec) - getPaddingTop() - getPaddingBottom();

        if (!needsMeasurePage || childWidth == 0 && childHeight == 0) {
            return;
        }

        if (!Double.isNaN(itemRatio)) {
            int itemHeight = (int) (childWidth / itemRatio);
            for (int i = 0, childCount = getChildCount(); i < childCount; i++) {
                View view = getChildAt(i);
                view.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(itemHeight, MeasureSpec.EXACTLY));
            }
        } else {
            for (int i = 0, childCount = getChildCount(); i < childCount; i++) {
                View view = getChildAt(i);
                if (pagerAdapter.getPageWidth(getCurrentItem()) != 1) {
                    view.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                } else {
                    view.measure(childWidthSpec, childHeightSpec);
                }
            }
        }

        final boolean isHorizontalScroll = scrollMode == UltraViewPager.ScrollMode.HORIZONTAL;

        childWidth = itemMarginLeft + child.getMeasuredWidth() + itemMarginRight;
        childHeight = itemMarginTop + child.getMeasuredHeight() + itemMarginBottom;

        if (!Float.isNaN(ratio)) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() / ratio), MeasureSpec.EXACTLY);
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
            for (int i = 0, childCount = getChildCount(); i < childCount; i++) {
                View view = getChildAt(i);
                view.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY), heightMeasureSpec);
            }
        } else {
            if (autoMeasureHeight) {
                if (isHorizontalScroll) {
                    constrainLength = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY);
                    setMeasuredDimension(getMeasuredWidth(), childHeight);
                } else {
                    constrainLength = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY);
                    setMeasuredDimension(childWidth, getMeasuredHeight());
                }

                needsMeasurePage = childHeight == itemMarginTop + itemMarginBottom;
            }
        }

        if (!pagerAdapter.isEnableMultiScr()) {
            return;
        }

        int pageLength = isHorizontalScroll ? getMeasuredWidth() : getMeasuredHeight();

        final int childLength = isHorizontalScroll ? child.getMeasuredWidth() : child.getMeasuredHeight();

        // Check that the measurement was successful
        if (childLength > 0) {
            needsMeasurePage = false;
            int difference = pageLength - childLength;
            if (getPageMargin() == 0) {
                setPageMargin(-difference);
            }
            int offscreen = (int) Math.ceil((float) pageLength / (float) childLength) + 1;
            setOffscreenPageLimit(offscreen);
            requestLayout();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Schedule a new measurement pass as the dimensions have changed
        needsMeasurePage = true;
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        if (adapter != null) {
            if (pagerAdapter == null || pagerAdapter.getAdapter() != adapter) {
                pagerAdapter = new UltraViewPagerAdapter(adapter);
                pagerAdapter.setCenterListener(this);
                pagerAdapter.setEnableLoop(enableLoop);
                pagerAdapter.setMultiScrRatio(multiScrRatio);
                needsMeasurePage = true;
                constrainLength = 0;
                super.setAdapter(pagerAdapter);
            }
        } else {
            super.setAdapter(adapter);
        }
    }

    @Override
    public void setCurrentItem(int item) {
        setCurrentItem(item, false);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        if (pagerAdapter.getCount() != 0 && pagerAdapter.isEnableLoop()) {
            item = pagerAdapter.getCount() / 2 + item % pagerAdapter.getRealCount();
        }
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public int getCurrentItem() {
        if (pagerAdapter != null && pagerAdapter.getCount() != 0) {
            int position = super.getCurrentItem();
            return position % pagerAdapter.getRealCount();
        }
        return super.getCurrentItem();
    }

    public int getNextItem() {
        if (pagerAdapter.getCount() != 0) {
            int next = super.getCurrentItem() + 1;
            return next % pagerAdapter.getRealCount();
        }
        return 0;
    }

    /**
     * Set the currently selected page.
     *
     * @param item         Item index to select
     * @param smoothScroll True to smoothly scroll to the new item, false to transition immediately
     */
    public void setCurrentItemFake(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    /**
     * Get the currently selected page.
     */
    public int getCurrentItemFake() {
        return super.getCurrentItem();
    }

    public void setMultiScreen(float ratio) {
        multiScrRatio = ratio;
        if (pagerAdapter != null) {
            pagerAdapter.setMultiScrRatio(ratio);
            needsMeasurePage = true;
        }
        float pageMargin = (1 - ratio) * getResources().getDisplayMetrics().widthPixels;
        if (scrollMode == UltraViewPager.ScrollMode.VERTICAL) {
            setPageMargin((int) pageMargin);
        } else {
            setPageMargin((int) -pageMargin);
        }
    }

    public void setEnableLoop(boolean status) {
        enableLoop = status;
        if (pagerAdapter != null) {
            pagerAdapter.setEnableLoop(enableLoop);
        }
    }

    public void setItemRatio(double itemRatio) {
        this.itemRatio = itemRatio;
    }

    public void setAutoMeasureHeight(boolean autoMeasureHeight) {
        this.autoMeasureHeight = autoMeasureHeight;
    }

    public void setScrollMode(UltraViewPager.ScrollMode scrollMode) {
        this.scrollMode = scrollMode;
        if (scrollMode == UltraViewPager.ScrollMode.VERTICAL)
            setPageTransformer(false, new UltraVerticalTransformer());
    }

    public UltraViewPager.ScrollMode getScrollMode() {
        return scrollMode;
    }

    public int getConstrainLength() {
        return constrainLength;
    }

    public void setItemMargin(int left, int top, int right, int bottom) {
        itemMarginLeft = left;
        itemMarginTop = top;
        itemMarginRight = right;
        itemMarginBottom = bottom;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    @Override
    public void center() {
        setCurrentItem(0);
    }

    @Override
    public void resetPosition() {
        setCurrentItem(getCurrentItem());
    }

    private MotionEvent swapTouchEvent(MotionEvent event) {
        float width = getWidth();
        float height = getHeight();

        float swappedX = (event.getY() / height) * width;
        float swappedY = (event.getX() / width) * height;

        event.setLocation(swappedX, swappedY);

        return event;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (scrollMode == UltraViewPager.ScrollMode.VERTICAL) {
            boolean intercept = super.onInterceptTouchEvent(swapTouchEvent(ev));
            //If not intercept, touch event should not be swapped.
            swapTouchEvent(ev);
            return intercept;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (scrollMode == UltraViewPager.ScrollMode.VERTICAL)
            return super.onTouchEvent(swapTouchEvent(ev));
        return super.onTouchEvent(ev);
    }
}


