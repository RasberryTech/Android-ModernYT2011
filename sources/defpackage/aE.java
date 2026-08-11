package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class aE implements aJ {
    @Override // defpackage.aJ
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2, aB aBVar) {
        C0010aj c0010aj = (C0010aj) obj2;
        Iterator it = ((List) c0010aj.a).iterator();
        long j = c0010aj.b;
        C0010aj c0010aj2 = new C0010aj(C0003ac.b(), j);
        C0199fu c0199fuA = a(it);
        for (String str : (List) obj) {
            if (c0199fuA == null || !c0199fuA.a.equals(str)) {
                aBVar.a(str, c0010aj2);
            } else {
                aBVar.a(str, new C0010aj(c0199fuA, j));
                c0199fuA = a(it);
            }
        }
    }

    private static C0199fu a(Iterator it) {
        if (it.hasNext()) {
            return (C0199fu) gq.a(it.next());
        }
        return null;
    }
}
