package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class cC {
    private cC() {
    }

    public static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0208gc c0208gc = (C0208gc) it.next();
            arrayList.add(new C0199fu(c0208gc.c(), c0208gc.e(), c0208gc.g(), c0208gc.i(), c0208gc.l(), c0208gc.t()));
        }
        return arrayList;
    }
}
