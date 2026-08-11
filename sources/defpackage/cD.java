package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class cD implements aM {
    private final String a;
    private final cF b;

    @Override // defpackage.aM
    public final /* bridge */ /* synthetic */ Object b(Object obj) {
        return this.b.b(fY.e().a(this.a).a((List) obj).a());
    }

    public cD(String str, int i, String str2) {
        this.a = str2.toUpperCase();
        this.b = new cF(str, 1);
    }
}
