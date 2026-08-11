package com.google.android.youtube.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Scroller;
import com.google.android.youtube.player.YouTubePlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Workspace extends ViewGroup {
    private int a;
    private boolean b;
    private int c;
    private int d;
    private Scroller e;
    private VelocityTracker f;
    private float g;
    private float h;
    private float i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private TabRow p;
    private Drawable q;
    private Runnable r;

    public static void setTabRowToWorkspace(Activity activity, int i, int i2, int i3) {
        TabRow tabRow = (TabRow) activity.findViewById(i);
        Workspace workspace = (Workspace) activity.findViewById(i2);
        workspace.setTabRow(tabRow);
        View viewFindViewById = workspace.findViewById(i3);
        if (viewFindViewById != null) {
            int iIndexOfChild = workspace.indexOfChild(viewFindViewById);
            tabRow.focusTab(iIndexOfChild, false);
            workspace.setCurrentScreen(iIndexOfChild);
        }
    }

    public static void setTabRowToWorkspace(Activity activity, int i, int i2) {
        setTabRowToWorkspace(activity, i, i2, 0);
    }

    public Workspace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
        this.d = -1;
        this.j = 0;
        this.k = true;
        this.o = -1;
        this.r = new aa(this);
        this.a = 0;
        setHapticFeedbackEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        this.e = new Scroller(getContext());
        this.c = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.l = viewConfiguration.getScaledTouchSlop();
        this.m = 50;
        this.n = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void setTabRow(TabRow tabRow) {
        this.p = tabRow;
        updateTabRow();
        tabRow.setOnTabClickListener(new Z(this));
    }

    public void updateTabRow() {
        this.p.removeAllTabs();
        for (int i = 0; i < getChildCount(); i++) {
            this.p.addTab(getChildAt(i).getTag().toString());
        }
        if (this.c < 0 || this.c > getChildCount()) {
            this.c = 0;
        }
        if (this.p != null) {
            this.p.focusTab(this.c, true);
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        view.setClickable(true);
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        view.setClickable(true);
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        view.setClickable(true);
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        view.setClickable(true);
        super.addView(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        view.setClickable(true);
        super.addView(view, layoutParams);
    }

    public int getCurrentScreen() {
        return this.c;
    }

    private int a() {
        int childCount = getChildCount();
        if (this.q != null) {
            return (childCount + 1) / 2;
        }
        return childCount;
    }

    final View a(int i) {
        return this.q == null ? getChildAt(i) : getChildAt(i << 1);
    }

    private int b() {
        int width = getWidth();
        if (this.q != null) {
            return width + this.q.getIntrinsicWidth();
        }
        return width;
    }

    public void setCurrentScreen(int i) {
        if (!this.e.isFinished()) {
            this.e.abortAnimation();
        }
        this.c = Math.max(0, Math.min(i, a() - 1));
        scrollTo(this.c * b(), 0);
        invalidate();
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        int iA = a();
        for (int i = 0; i < iA; i++) {
            a(i).setOnLongClickListener(onLongClickListener);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e.computeScrollOffset()) {
            scrollTo(this.e.getCurrX(), this.e.getCurrY());
            postInvalidate();
        } else if (this.d != -1) {
            this.c = Math.max(0, Math.min(this.d, a() - 1));
            this.d = -1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.j != 1 && this.d == -1) {
            drawChild(canvas, a(this.c), getDrawingTime());
            return;
        }
        long drawingTime = getDrawingTime();
        if (this.d >= 0 && this.d < a() && Math.abs(this.c - this.d) == 1) {
            drawChild(canvas, a(this.c), drawingTime);
            drawChild(canvas, a(this.d), drawingTime);
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            drawChild(canvas, getChildAt(i), drawingTime);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setCurrentScreen(this.c);
        if (this.p != null) {
            this.p.focusTab(this.c, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Workspace can only be used in EXACTLY mode.");
        }
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException("Workspace can only be used in EXACTLY mode.");
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (this.q != null && (i3 & 1) == 1) {
                getChildAt(i3).measure(this.q.getIntrinsicWidth(), i2);
            } else {
                getChildAt(i3).measure(i, i2);
            }
        }
        if (this.b) {
            setHorizontalScrollBarEnabled(false);
            int size = View.MeasureSpec.getSize(i);
            if (this.q != null) {
                size += this.q.getIntrinsicWidth();
            }
            scrollTo(size * this.c, 0);
            setHorizontalScrollBarEnabled(true);
            this.b = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild == this.c && this.e.isFinished()) {
            return false;
        }
        snapToScreen(iIndexOfChild);
        return true;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        if (this.d != -1) {
            i2 = this.d;
        } else {
            i2 = this.c;
        }
        View viewA = a(i2);
        if (viewA != null) {
            viewA.requestFocus(i, rect);
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        if (i == 17) {
            if (getCurrentScreen() > 0) {
                snapToScreen(getCurrentScreen() - 1);
                return true;
            }
        } else if (i == 66 && getCurrentScreen() < a() - 1) {
            snapToScreen(getCurrentScreen() + 1);
            return true;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        a(this.c).addFocusables(arrayList, i);
        if (i == 17) {
            if (this.c > 0) {
                a(this.c - 1).addFocusables(arrayList, i);
            }
        } else if (i == 66 && this.c < a() - 1) {
            a(this.c + 1).addFocusables(arrayList, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void focusableViewAvailable(View view) {
        View viewA = a(this.c);
        for (View view2 = view; view2 != viewA; view2 = (View) view2.getParent()) {
            if (view2 == this || !(view2.getParent() instanceof View)) {
                return;
            }
        }
        super.focusableViewAvailable(view);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.j != 0) {
            return true;
        }
        switch (action & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.g = x;
                this.h = x;
                this.i = y;
                this.o = motionEvent.getPointerId(0);
                this.k = true;
                this.j = this.e.isFinished() ? 0 : 1;
                break;
            case YouTubePlayer.PREPARED /* 1 */:
            case YouTubePlayer.PAUSED /* 3 */:
                this.j = 0;
                this.k = false;
                this.o = -1;
                break;
            case YouTubePlayer.PLAYING /* 2 */:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.o);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float y2 = motionEvent.getY(iFindPointerIndex);
                int iAbs = (int) Math.abs(x2 - this.h);
                int iAbs2 = (int) Math.abs(y2 - this.i);
                int i = this.l;
                boolean z = iAbs > this.m;
                boolean z2 = iAbs > i;
                boolean z3 = iAbs2 > i;
                if (z2 || z3) {
                    if (z) {
                        this.j = 1;
                        this.h = x2;
                    }
                    if (this.k) {
                        this.k = false;
                        a(this.c).cancelLongPress();
                    }
                }
                break;
            case YouTubePlayer.ENDED /* 6 */:
                a(motionEvent);
                break;
        }
        return this.j != 0;
    }

    private void a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() >> 8) & 255;
        if (motionEvent.getPointerId(action) == this.o) {
            int i = action == 0 ? 1 : 0;
            float x = motionEvent.getX(i);
            this.g = x;
            this.h = x;
            this.i = motionEvent.getY(i);
            this.o = motionEvent.getPointerId(i);
            if (this.f != null) {
                this.f.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0 && !isInTouchMode()) {
            snapToScreen(iIndexOfChild);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f == null) {
            this.f = VelocityTracker.obtain();
        }
        this.f.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (!this.e.isFinished()) {
                    this.e.abortAnimation();
                }
                float x = motionEvent.getX();
                this.h = x;
                this.g = x;
                this.o = motionEvent.getPointerId(0);
                return true;
            case YouTubePlayer.PREPARED /* 1 */:
                if (this.j == 1) {
                    int i = this.o;
                    float x2 = motionEvent.getX(motionEvent.findPointerIndex(i));
                    VelocityTracker velocityTracker = this.f;
                    velocityTracker.computeCurrentVelocity(1000, this.n);
                    int xVelocity = (int) velocityTracker.getXVelocity(i);
                    boolean z = Math.abs(this.g - x2) > 100.0f;
                    int width = getWidth();
                    int scrollX = (getScrollX() + (width / 2)) / width;
                    if (z && xVelocity > 500 && this.c > 0) {
                        snapToScreen(Math.min(scrollX, this.c - 1));
                    } else if (z && xVelocity < -500 && this.c < getChildCount() - 1) {
                        snapToScreen(Math.max(scrollX, this.c + 1));
                    } else {
                        int iB = b();
                        snapToScreen((getScrollX() + (iB / 2)) / iB);
                    }
                    if (this.f != null) {
                        this.f.recycle();
                        this.f = null;
                    }
                }
                this.j = 0;
                this.o = -1;
                return true;
            case YouTubePlayer.PLAYING /* 2 */:
                if (this.j == 1) {
                    float x3 = motionEvent.getX(motionEvent.findPointerIndex(this.o));
                    int i2 = (int) (this.h - x3);
                    this.h = x3;
                    int scrollX2 = getScrollX();
                    if (i2 < 0) {
                        if (scrollX2 > 0) {
                            scrollBy(Math.max(-scrollX2, i2), 0);
                        }
                    } else if (i2 > 0) {
                        int right = (getChildAt(getChildCount() - 1).getRight() - scrollX2) - getWidth();
                        if (right > 0) {
                            scrollBy(Math.min(right, i2), 0);
                        }
                    } else {
                        awakenScrollBars();
                    }
                }
                return true;
            case YouTubePlayer.PAUSED /* 3 */:
                this.j = 0;
                this.o = -1;
                return true;
            case YouTubePlayer.STOPPED /* 4 */:
            case YouTubePlayer.PROGRESS /* 5 */:
            default:
                return true;
            case YouTubePlayer.ENDED /* 6 */:
                a(motionEvent);
                return true;
        }
    }

    public void snapToScreen(int i) {
        int iMax = Math.max(0, Math.min(i, a() - 1));
        int iAbs = Math.abs(iMax - this.c);
        this.d = iMax;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && iAbs != 0 && focusedChild == a(this.c)) {
            focusedChild.clearFocus();
        }
        int iB = iMax * b();
        int scrollX = getScrollX();
        int i2 = iB - scrollX;
        int i3 = iAbs * 300;
        awakenScrollBars(i3);
        int iAbs2 = i3 == 0 ? Math.abs(i2) : i3;
        if (this.d != this.c) {
            a(this.c).dispatchDisplayHint(4);
            removeCallbacks(this.r);
            postDelayed(this.r, iAbs2 + 10);
        }
        if (!this.e.isFinished()) {
            this.e.abortAnimation();
        }
        this.e.startScroll(scrollX, 0, i2, 0, iAbs2);
        this.p.focusTab(iMax, true);
        invalidate();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        ab abVar = new ab(super.onSaveInstanceState());
        abVar.a = this.c;
        return abVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        ab abVar = (ab) parcelable;
        super.onRestoreInstanceState(abVar.getSuperState());
        this.c = abVar.a;
        if (this.c < 0 || this.c > getChildCount()) {
            this.c = 0;
        }
        if (this.p != null) {
            this.p.focusTab(this.c, true);
        }
    }

    public void scrollLeft() {
        if (this.e.isFinished()) {
            if (this.c > 0) {
                snapToScreen(this.c - 1);
            }
        } else if (this.d > 0) {
            snapToScreen(this.d - 1);
        }
    }

    public void scrollRight() {
        if (this.e.isFinished()) {
            if (this.c < getChildCount() - 1) {
                snapToScreen(this.c + 1);
            }
        } else if (this.d < getChildCount() - 1) {
            snapToScreen(this.d + 1);
        }
    }

    public int getScreenForView(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (parent == getChildAt(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean allowLongPress() {
        return this.k;
    }

    public void setSeparator(int i) {
        if (this.q != null && i == 0) {
            this.q = null;
            for (int childCount = getChildCount() - 2; childCount > 0; childCount -= 2) {
                removeViewAt(childCount);
            }
            requestLayout();
            return;
        }
        if (i != 0) {
            if (this.q == null) {
                int childCount2 = getChildCount();
                this.q = getResources().getDrawable(i);
                int i2 = 1;
                for (int i3 = 1; i3 < childCount2; i3++) {
                    View view = new View(getContext());
                    view.setBackgroundDrawable(this.q);
                    view.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
                    addView(view, i2);
                    i2 += 2;
                }
                requestLayout();
                return;
            }
            this.q = getResources().getDrawable(i);
            for (int childCount3 = getChildCount() - 2; childCount3 > 0; childCount3 -= 2) {
                getChildAt(childCount3).setBackgroundDrawable(this.q);
            }
            requestLayout();
        }
    }
}
