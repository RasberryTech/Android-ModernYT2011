package defpackage;

import java.util.List;

/* JADX INFO: renamed from: ag, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0007ag implements I {
    private /* synthetic */ I a;

    C0007ag(C0006af c0006af, I i) {
        this.a = i;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        List list = (List) obj;
        gq.a(list.size() == 1);
        this.a.a(list.get(0), exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        gq.a(list.size() == 1);
        if (list2.size() == 0) {
            this.a.a(list.get(0), C0003ac.b());
        } else {
            this.a.a(list.get(0), list2.get(0));
        }
    }
}
