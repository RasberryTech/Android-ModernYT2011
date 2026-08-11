package com.google.android.youtube.ui;

/* JADX INFO: loaded from: classes.dex */
final class aa implements Runnable {
    private /* synthetic */ Workspace a;

    aa(Workspace workspace) {
        this.a = workspace;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.a.c).dispatchDisplayHint(0);
    }
}
