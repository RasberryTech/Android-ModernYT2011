package com.google.android.common;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
final class d implements GestureDetector.OnGestureListener {
    private /* synthetic */ SwipeySwitcher a;

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.a.m = (int) motionEvent.getX();
        return true;
    }

    private boolean a() {
        return (this.a.b != null ? this.a.b.c() : 0) > 1;
    }

    private boolean b() {
        return (this.a.b != null ? this.a.b.c() : 0) > 1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.a.o && f != 0.0f) {
            if (f > 0.0f && !a()) {
                return false;
            }
            if (f < 0.0f && !b()) {
                return false;
            }
            boolean z = f < 0.0f;
            if (z != (this.a.getScrollX() - this.a.getWidth() > 0)) {
                this.a.a();
            } else {
                if (z) {
                    SwipeySwitcher.e(this.a);
                } else {
                    SwipeySwitcher.f(this.a);
                }
                this.a.a(z);
            }
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z;
        if (!this.a.o) {
            return false;
        }
        int scrollX = this.a.getScrollX() + ((int) f);
        if (scrollX < this.a.getWidth() && !a()) {
            scrollX = this.a.getWidth();
        } else if (scrollX > this.a.getWidth() && !b()) {
            scrollX = this.a.getWidth();
        }
        this.a.scrollTo(scrollX, 0);
        if (this.a.b != null && this.a.b.c() == 2) {
            int width = this.a.getWidth();
            if (scrollX >= width || !(this.a.a[0] instanceof l)) {
                z = scrollX > width && (this.a.a[2] instanceof l);
            } else {
                z = true;
            }
            if (z) {
                this.a.b();
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    d(SwipeySwitcher swipeySwitcher) {
        this.a = swipeySwitcher;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
