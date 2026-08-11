package defpackage;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: renamed from: q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0225q extends ContentObserver {
    C0225q(C0224p c0224p, Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        synchronized (C0223o.class) {
            C0223o.d.clear();
            Object unused = C0223o.e = new Object();
        }
    }
}
