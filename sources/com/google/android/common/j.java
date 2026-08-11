package com.google.android.common;

/* JADX INFO: loaded from: classes.dex */
final class j implements Runnable {
    Runnable a;
    private /* synthetic */ SwipeySwitcher b;

    j(SwipeySwitcher swipeySwitcher) {
        this.b = swipeySwitcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.b.i.computeScrollOffset()) {
            this.b.scrollTo(this.b.i.getCurrX(), 0);
            this.b.setSelection(this.b.e);
            SwipeySwitcher.c(this.b, true);
            if (this.a != null) {
                this.a.run();
                return;
            }
            return;
        }
        SwipeySwitcher.b(this.b, true);
        this.b.scrollTo(this.b.i.getCurrX(), 0);
        this.b.postInvalidate();
        this.b.g.post(this);
    }
}
