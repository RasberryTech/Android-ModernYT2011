package com.google.android.youtube;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
final class O extends Thread {
    private /* synthetic */ File[] a;

    O(YouTubeApplication youTubeApplication, File[] fileArr) {
        this.a = fileArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        for (File file : this.a) {
            file.delete();
        }
    }
}
