package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: fu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0199fu implements InterfaceC0002ab {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;

    @Override // defpackage.InterfaceC0002ab
    public final /* bridge */ /* synthetic */ Serializable a() {
        return this;
    }

    public C0199fu(String str, String str2, String str3, String str4, String str5, int i) {
        this.a = (String) gq.a((Object) str, (Object) "videoId may not be null");
        this.b = (String) gq.a((Object) str2, (Object) "artistId may not be null");
        this.c = (String) gq.a((Object) str3, (Object) "artistName may not be null");
        this.d = (String) gq.a((Object) str4, (Object) "trackId may not be null");
        this.e = (String) gq.a((Object) str5, (Object) "trackName may not be null");
        this.f = i;
    }
}
