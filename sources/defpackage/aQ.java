package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class aQ {
    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList("next", "previous")));

    private aQ() {
    }

    public static aP a() {
        return a("/feed");
    }

    public static aP a(String str) {
        gq.a((Object) str, (Object) "prefix can't be null");
        aP aPVar = new aP();
        aPVar.a(str, new aV()).a(str + "/openSearch:totalResults", new aU()).a(str + "/openSearch:startIndex", new aT()).a(str + "/openSearch:itemsPerPage", new aS()).a(str + "/link", new aR());
        return aPVar;
    }
}
