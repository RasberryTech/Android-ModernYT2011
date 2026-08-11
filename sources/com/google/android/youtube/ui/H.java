package com.google.android.youtube.ui;

import com.google.android.youtube.C0081l;
import defpackage.C0199fu;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class H implements defpackage.I {
    private /* synthetic */ G a;

    /* synthetic */ H(G g) {
        this(g, (byte) 0);
    }

    private H(G g, byte b) {
        this.a = g;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.b("MusicVideosRequester failed", exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        for (C0199fu c0199fu : (List) obj2) {
            String str = c0199fu.a + " is a music video";
            this.a.c.a(c0199fu.a);
        }
    }
}
