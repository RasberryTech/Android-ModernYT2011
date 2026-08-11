package com.google.android.youtube;

import android.content.SharedPreferences;
import android.net.Uri;
import defpackage.C0186fh;
import defpackage.InterfaceC0004ad;
import defpackage.gn;
import defpackage.gq;

/* JADX INFO: renamed from: com.google.android.youtube.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0070a implements defpackage.I, InterfaceC0004ad {
    private final SharedPreferences a;
    private final InterfaceC0004ad b;
    private final InterfaceC0004ad c;
    private final InterfaceC0004ad d;
    private defpackage.I e;
    private final gn f;
    private long g;
    private int h;
    private int i;
    private boolean j;

    static /* synthetic */ boolean a(Uri uri) {
        return uri != null && uri.toString().startsWith("http://www.youtube");
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error retrieving ad tag", exc);
        this.e.a(obj, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        String str = (String) obj;
        C0186fh c0186fh = (C0186fh) obj2;
        if (c0186fh == null) {
            this.e.a(str, (Object) null);
            return;
        }
        this.i = c0186fh.a * 1000;
        this.c.a(c0186fh.b, new C0071b(this, str));
    }

    public C0070a(gn gnVar, SharedPreferences sharedPreferences, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2, InterfaceC0004ad interfaceC0004ad3) {
        this.f = (gn) gq.a(gnVar);
        this.a = (SharedPreferences) gq.a(sharedPreferences);
        this.b = (InterfaceC0004ad) gq.a(interfaceC0004ad);
        this.c = (InterfaceC0004ad) gq.a(interfaceC0004ad2);
        this.d = (InterfaceC0004ad) gq.a(interfaceC0004ad3);
        long jA = gnVar.a();
        this.g = Math.min(jA, sharedPreferences.getLong("last_ad_time", jA));
        this.h = Math.min(600000, sharedPreferences.getInt("last_ad_delay", 0));
    }

    public final void a(boolean z) {
        this.j = z;
    }

    @Override // defpackage.InterfaceC0004ad
    public final void a(String str, defpackage.I i) {
        this.e = (defpackage.I) gq.a(i);
        if (this.f.a() >= this.g + ((long) this.h)) {
            this.b.a(str, this);
        } else {
            i.a(str, (Object) null);
        }
    }

    public final void a() {
        this.g = this.f.a();
        this.h = this.i;
        this.a.edit().putLong("last_ad_time", this.g).putInt("last_ad_delay", this.h).commit();
    }
}
