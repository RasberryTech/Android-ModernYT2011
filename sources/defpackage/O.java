package defpackage;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
final class O implements gr {
    private /* synthetic */ Uri a;

    O(N n, Uri uri) {
        this.a = uri;
    }

    @Override // defpackage.gr
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return this.a.equals(((U) obj).a);
    }
}
