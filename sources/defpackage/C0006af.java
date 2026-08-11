package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: af, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0006af implements InterfaceC0004ad {
    private final InterfaceC0004ad a;

    public C0006af(InterfaceC0004ad interfaceC0004ad) {
        this.a = (InterfaceC0004ad) gq.a(interfaceC0004ad);
    }

    @Override // defpackage.InterfaceC0004ad
    public final void a(Object obj, I i) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(obj);
        this.a.a(arrayList, new C0007ag(this, i));
    }
}
