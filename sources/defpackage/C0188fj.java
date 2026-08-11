package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: fj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0188fj implements Serializable {
    public final C0187fi a;
    public final List b;
    public final List c;
    public final List d;

    public C0188fj(C0187fi c0187fi, List list, List list2, List list3) {
        this.a = (C0187fi) gq.a(c0187fi, "artist may not be null");
        this.b = Collections.unmodifiableList((List) gq.a(list, "mixTape may not be null"));
        this.c = Collections.unmodifiableList((List) gq.a(list2, "artistTape may not be null"));
        this.d = Collections.unmodifiableList((List) gq.a(list3, "relatedArtists may not be null"));
    }
}
