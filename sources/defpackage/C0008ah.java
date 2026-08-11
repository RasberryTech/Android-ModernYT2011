package defpackage;

import com.google.android.youtube.R;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: ah, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0008ah implements InterfaceC0004ad {
    private final InterfaceC0004ad a;
    private final InterfaceC0004ad b;
    private final InterfaceC0004ad c;
    private final String d;
    private final ConcurrentHashMap e;

    @Override // defpackage.InterfaceC0004ad
    public final /* bridge */ /* synthetic */ void a(Object obj, I i) {
        U u = (U) obj;
        HashMap map = new HashMap();
        if (u.b == null) {
            U uA = V.a(W.RECENTLY_FEATURED, null, this.d, null);
            map.put(uA, Integer.valueOf(R.string.from_featured));
            U uA2 = V.a(W.MOST_POPULAR, null, this.d, X.THIS_WEEK);
            map.put(uA2, Integer.valueOf(R.string.from_most_popular));
            U uA3 = V.a(W.MOST_DISCUSSED, null, this.d, X.THIS_WEEK);
            map.put(uA3, Integer.valueOf(R.string.from_most_discussed));
            C0009ai c0009ai = new C0009ai(i, u, map, this.e, null);
            this.a.a(uA, c0009ai);
            this.a.a(uA2, c0009ai);
            this.a.a(uA3, c0009ai);
            return;
        }
        String lastPathSegment = u.a.getLastPathSegment();
        fH fHVar = new fH(lastPathSegment, u.b, lastPathSegment);
        U uH = V.h(fHVar);
        map.put(uH, Integer.valueOf(R.string.from_recommended));
        U uG = V.g(fHVar);
        map.put(uG, Integer.valueOf(R.string.from_subscriptions));
        U uA4 = V.a(W.MOST_POPULAR, null, this.d, X.THIS_WEEK);
        map.put(uA4, Integer.valueOf(R.string.from_most_popular));
        C0009ai c0009ai2 = new C0009ai(i, u, map, this.e, uG);
        this.c.a(uH, c0009ai2);
        this.b.a(uG, c0009ai2);
        this.a.a(uA4, c0009ai2);
    }

    public C0008ah(InterfaceC0005ae interfaceC0005ae, String str) {
        gq.a(interfaceC0005ae);
        this.a = interfaceC0005ae.s();
        this.b = interfaceC0005ae.p();
        this.c = interfaceC0005ae.q();
        this.d = str;
        this.e = new ConcurrentHashMap();
    }

    public final ConcurrentHashMap a() {
        return this.e;
    }
}
