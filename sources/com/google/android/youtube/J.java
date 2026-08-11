package com.google.android.youtube;

/* JADX INFO: loaded from: classes.dex */
final class J implements Runnable {
    private /* synthetic */ I a;

    J(I i) {
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.v.stopVideo();
        this.a.a.y.showReplay();
    }
}
