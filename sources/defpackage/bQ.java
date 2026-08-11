package defpackage;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class bQ implements aM {
    private final EnumC0047bt a;

    @Override // defpackage.aM
    public final /* bridge */ /* synthetic */ Object b(Object obj) {
        Uri uri = (Uri) obj;
        gq.a(uri, "the uri can't be null");
        return this.a.a(uri);
    }

    public bQ(EnumC0047bt enumC0047bt) {
        this.a = (EnumC0047bt) gq.a(enumC0047bt, "method can't be null");
    }
}
