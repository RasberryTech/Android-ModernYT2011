package com.google.android.common;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.google.android.youtube.player.YouTubePlayer;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SwipeySwitcher extends ViewGroup {
    private static int[] s = {1, 2, 0};
    private static int[] t = {1, 0, 2};
    private h[] a;
    private f b;
    private int c;
    private Context d;
    private int e;
    private boolean f;
    private Handler g;
    private GestureDetector h;
    private Scroller i;
    private i j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;
    private k p;
    private k q;
    private Runnable r;
    private HashMap u;
    private j v;

    static /* synthetic */ boolean b(SwipeySwitcher swipeySwitcher, boolean z) {
        swipeySwitcher.k = true;
        return true;
    }

    static /* synthetic */ boolean c(SwipeySwitcher swipeySwitcher, boolean z) {
        swipeySwitcher.l = true;
        return true;
    }

    static /* synthetic */ void e(SwipeySwitcher swipeySwitcher) {
        if (swipeySwitcher.b != null && swipeySwitcher.b.c() == 2 && swipeySwitcher.p.a(swipeySwitcher.a[2])) {
            swipeySwitcher.b();
        }
    }

    static /* synthetic */ void f(SwipeySwitcher swipeySwitcher) {
        if (swipeySwitcher.b != null && swipeySwitcher.b.c() == 2 && swipeySwitcher.p.a(swipeySwitcher.a[0])) {
            swipeySwitcher.b();
        }
    }

    public void clear() {
        for (int i = 0; i < this.a.length; i++) {
            h hVar = this.a[i];
            if (hVar != null) {
                hVar.a();
                this.a[i] = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.i.startScroll(getScrollX(), 0, getWidth() - getScrollX(), 0);
        this.g.post(this.v);
    }

    private int a(int i) {
        int iC;
        if (this.b != null && (iC = this.b.c()) != 0) {
            return (i < 0 ? iC - ((-i) % iC) : i) % iC;
        }
        return i;
    }

    private void a(boolean z, Runnable runnable, int i) {
        this.e = z ? this.c + 1 : this.c - 1;
        this.v.a = runnable;
        if (!z) {
            this.i.startScroll(getScrollX(), 0, -getScrollX(), 0, i);
            this.g.post(this.v);
        } else {
            this.i.startScroll(getScrollX(), 0, (getWidth() * 2) - getScrollX(), 0, i);
            this.g.post(this.v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        a(z, (Runnable) null, 400);
    }

    public void selectNext(boolean z, Runnable runnable, int i) {
        a(z, runnable, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        h hVar = this.a[0];
        this.a[0] = this.a[2];
        this.a[2] = hVar;
        requestLayout();
    }

    public SwipeySwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new h[3];
        this.f = true;
        this.g = new Handler();
        this.p = new k(this, new b(this));
        this.q = new k(this, new c(this));
        this.r = new e(this);
        this.u = new HashMap();
        this.v = new j(this);
        a(context);
    }

    public SwipeySwitcher(Context context) {
        super(context);
        this.a = new h[3];
        this.f = true;
        this.g = new Handler();
        this.p = new k(this, new b(this));
        this.q = new k(this, new c(this));
        this.r = new e(this);
        this.u = new HashMap();
        this.v = new j(this);
        a(context);
    }

    private void a(Context context) {
        this.h = new GestureDetector(this.d, new d(this));
        this.i = new Scroller(context);
        this.d = context;
        this.n = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    public void setOnTouchCallback(i iVar) {
        this.j = iVar;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        setMeasuredDimension(size, size2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, int i) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View viewB = hVar.b();
        addViewInLayout(viewB, i, layoutParams, true);
        viewB.layout(width * i, 0, width + (width * i), height);
        this.a[i] = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Intent intentC;
        int width = getWidth();
        int iC = this.b != null ? this.b.c() : 0;
        removeAllViews();
        if (this.b != null) {
            this.c = this.e;
            HashMap map = this.u;
            map.clear();
            for (int i5 = 0; i5 < 3; i5++) {
                h hVar = this.a[i5];
                this.a[i5] = null;
                if (hVar != null && (intentC = hVar.c()) != null) {
                    map.put(intentC.getDataString(), hVar);
                }
            }
            for (int i6 : getScrollX() > getWidth() ? s : t) {
                Intent intentB = this.b.b();
                if (intentB != null) {
                    String dataString = intentB.getDataString();
                    h hVar2 = (h) map.get(dataString);
                    if (hVar2 != null) {
                        map.remove(dataString);
                        this.a[i6] = hVar2;
                    }
                }
            }
            if (map.size() > 0) {
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    ((h) map.get((String) it.next())).a();
                }
            }
            for (int i7 = -1; i7 <= 1; i7++) {
                int i8 = i7 + 1;
                h hVarA = this.a[i8];
                if (hVarA == null) {
                    boolean z2 = false;
                    switch (iC) {
                        case YouTubePlayer.PREPARED /* 1 */:
                            z2 = i7 != 0;
                            break;
                        case YouTubePlayer.PLAYING /* 2 */:
                            if (i7 == -1) {
                                z2 = this.a[2] != null && !this.p.a(this.a[2]);
                            } else if (i7 == 1) {
                                z2 = this.a[0] != null && !this.p.a(this.a[0]);
                            }
                            break;
                        default:
                            z2 = false;
                            break;
                    }
                    if (z2) {
                        hVarA = this.p.a((Intent) null);
                    } else {
                        if (i7 == 0 && iC > 0) {
                            hVarA = this.b.a();
                        }
                        if (hVarA == null) {
                            hVarA = this.q.a(this.b.b());
                        }
                    }
                    this.a[i7 + 1] = hVarA;
                }
                a(hVarA, i8);
            }
            if (this.f) {
                scrollTo(width, 0);
            }
            this.g.post(this.r);
            if (this.l) {
                this.k = false;
                this.l = false;
            }
        }
    }

    public void foreachView(m mVar) {
    }

    public int getCount() {
        return getAdapter().c();
    }

    public View getSelectedViewAdjacent(boolean z) {
        h hVar = this.a[z ? (char) 2 : (char) 0];
        if (hVar != null) {
            return hVar.b();
        }
        return null;
    }

    public View getSelectedView() {
        if (this.a[1] != null) {
            return this.a[1].b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View selectedView = getSelectedView();
        return selectedView != null ? selectedView.dispatchKeyEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    private float c() {
        int width = getWidth();
        return (getScrollX() - width) / width;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.k) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.h.onTouchEvent(motionEvent);
                break;
            case YouTubePlayer.PLAYING /* 2 */:
                int x = (int) motionEvent.getX();
                int i = x - this.m;
                this.h.onTouchEvent(motionEvent);
                if (Math.abs(i) > this.n) {
                    this.m = x;
                    this.o = true;
                    this.f = false;
                }
                break;
        }
        return this.o;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.k) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.h.onTouchEvent(motionEvent);
                this.m = (int) motionEvent.getX();
                this.o = true;
                this.f = false;
                break;
            case YouTubePlayer.PREPARED /* 1 */:
            case YouTubePlayer.PAUSED /* 3 */:
                if (this.o) {
                    this.f = true;
                    if (!this.h.onTouchEvent(motionEvent)) {
                        float fC = c();
                        if (fC > 0.5f) {
                            a(true);
                        } else if (fC < -0.5f) {
                            a(false);
                        } else {
                            a();
                        }
                    }
                    this.o = false;
                }
                break;
            case YouTubePlayer.PLAYING /* 2 */:
                if (this.o) {
                    this.h.onTouchEvent(motionEvent);
                    if (this.j != null) {
                        c();
                        getScrollX();
                        getWidth();
                    }
                }
                break;
        }
        return true;
    }

    public f getAdapter() {
        return this.b;
    }

    public void setAdapter(f fVar) {
        this.b = fVar;
        if (fVar == null) {
            for (int i = 0; i < 3; i++) {
                if (this.a[i] != null) {
                    this.a[i].a();
                    this.a[i] = null;
                }
            }
        }
        this.e = 0;
        this.c = 0;
        requestLayout();
        this.g.removeCallbacks(this.v);
    }

    public int getSelectedItemPosition() {
        return a(this.e);
    }

    public void setSelection(int i) {
        if (this.b != null) {
            this.e = i;
            this.f = true;
            requestLayout();
        }
    }
}
