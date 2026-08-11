package com.google.android.common;

/* JADX INFO: loaded from: classes.dex */
final class e implements Runnable {
    private /* synthetic */ SwipeySwitcher a;

    e(SwipeySwitcher swipeySwitcher) {
        this.a = swipeySwitcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVarA;
        if (this.a.b != null) {
            for (int i = 0; i < this.a.a.length; i++) {
                h hVar = this.a.a[i];
                if (this.a.q.a(hVar) && hVar.c() != null && (hVarA = this.a.b.a()) != null) {
                    if (this.a.getChildCount() > i) {
                        this.a.a[i].a();
                        this.a.removeViewAt(i);
                    }
                    this.a.a(hVarA, i);
                }
            }
        }
    }
}
