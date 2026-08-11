package defpackage;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0224p extends Thread {
    private /* synthetic */ ContentResolver a;

    C0224p(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Looper.prepare();
        this.a.registerContentObserver(C0223o.a, true, new C0225q(this, new Handler(Looper.myLooper())));
        Looper.loop();
    }
}
