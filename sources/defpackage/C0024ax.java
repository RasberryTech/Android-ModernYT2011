package defpackage;

import org.apache.http.client.HttpResponseException;

/* JADX INFO: renamed from: ax, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0024ax implements I {
    private boolean a;
    private /* synthetic */ I b;
    private /* synthetic */ U c;
    private /* synthetic */ C0023aw d;

    C0024ax(C0023aw c0023aw, I i, U u) {
        this.d = c0023aw;
        this.b = i;
        this.c = u;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        U u = (U) obj;
        if (!(exc instanceof HttpResponseException) || !C0023aw.a(this.d, (HttpResponseException) exc) || this.a) {
            this.b.a((Object) this.c, exc);
            return;
        }
        this.a = true;
        this.d.b.a(U.a(this.d.a.a(u.b), u), this);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.b.a(this.c, obj2);
    }
}
