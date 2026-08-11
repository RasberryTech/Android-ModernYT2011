package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class go implements gr {
    private final String a;

    @Override // defpackage.gr
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return ((U) obj).a.getPathSegments().contains(this.a);
    }

    public go(String str) {
        this.a = gq.a(str, (Object) "pathSegment can't be empty");
    }
}
