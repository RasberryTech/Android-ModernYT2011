package com.google.android.youtube;

import android.net.Uri;
import android.os.Handler;
import android.view.View;
import com.google.android.youtube.ui.C0093f;
import com.google.android.youtube.ui.InterfaceC0104q;
import defpackage.C0200fv;
import defpackage.InterfaceC0021au;
import defpackage.U;
import defpackage.V;
import defpackage.fH;
import defpackage.fK;
import defpackage.fM;
import defpackage.fO;
import defpackage.gk;
import defpackage.gl;
import defpackage.gp;
import defpackage.gv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class D implements View.OnClickListener, InterfaceC0021au, com.google.android.youtube.player.a, com.google.android.youtube.player.b, InterfaceC0104q {
    final /* synthetic */ WatchActivity a;
    private String b;
    private fM c;
    private fK d;
    private boolean e;
    private Uri f;
    private boolean g;
    private Uri h;
    private int i;
    private final defpackage.I l;
    private final defpackage.I m;
    private final defpackage.I k = new E(this);
    private final Handler n = new H(this);
    private final List j = new LinkedList();

    static /* synthetic */ void a(D d, fM fMVar) {
        fMVar.toString();
        d.c = fMVar;
        if (fMVar.s != fO.PLAYABLE) {
            d.a.A.a(gl.NOT_PLAYABLE);
            d.a.y.showErrorMessage(fMVar.s.s);
        } else {
            if (fMVar.t != null && fMVar.t.contains(gv.d(d.a))) {
                d.a.A.a(gl.COUNTRY_RESTRICTED);
                d.a.y.showErrorMessage(R.string.video_not_available_in_your_country);
            } else if (d.a.M) {
                d.a.y.showReplay();
            } else if (fMVar.u) {
                d.a.I.b();
            } else {
                d.b();
            }
        }
        d.a.a(fMVar);
    }

    static /* synthetic */ void a(D d, C0200fv c0200fv) {
        d.h = c0200fv.c;
        Iterator it = c0200fv.iterator();
        while (it.hasNext()) {
            d.j.add(((fM) it.next()).a);
        }
        if (d.j.size() <= 0) {
            d.a.finish();
            return;
        }
        List list = d.j;
        int i = d.i + 1;
        d.i = i;
        d.a((String) list.get(i));
    }

    static /* synthetic */ void a(D d, Exception exc) {
        d.a.e.a(C0093f.a(d.a, exc));
        d.a.y.hide();
    }

    static /* synthetic */ void a(D d, boolean z) {
        String.valueOf(z);
        d.e = false;
        d.a.w.setAd(false);
        d.a.x.setVisibility(8);
        if (z) {
            return;
        }
        d.a.y.showLoading();
        d.a.K.a();
        d.i();
    }

    static /* synthetic */ void b(D d) {
        String.valueOf(d.a.M);
        if (!(d.f != null && (d.i < d.j.size() - 1 || d.h != null)) || d.a.e.b()) {
            d.a.y.showReplay();
        } else {
            d.a.y.showLoading();
            d.c();
        }
    }

    public D(WatchActivity watchActivity) {
        this.a = watchActivity;
        this.l = new defpackage.E(this.a, new F(this));
        this.m = new defpackage.E(this.a, new G(this));
        watchActivity.v.addListener(this.n);
    }

    public final void a(String str) {
        this.b = str;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a.v.stopVideo();
        this.a.w.setAd(false);
        this.a.x.setVisibility(8);
        this.a.y.showLoading();
        this.a.a();
        this.a.j.a(V.b(str), new defpackage.E(this.a, this.k));
    }

    public final void b() {
        boolean z;
        fM fMVar = this.c;
        String strD = gv.d(this.a);
        if (fMVar.x != null) {
            z = fMVar.w != fMVar.x.contains(strD);
        } else {
            z = fMVar.w;
        }
        if (z) {
            this.a.K.a(this.a.b);
            this.a.K.a(this.c.a, this.l);
        } else {
            a(this.c.a, (fK) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, fK fKVar) {
        if (this.c != null && this.c.a.equals(str)) {
            if (fKVar != null) {
                fKVar.toString();
            }
            this.d = fKVar;
            this.a.H.a(this.c, fKVar);
            if (fKVar != null && fKVar.b != null) {
                this.e = true;
                this.a.w.setAd(true);
                this.a.x.setAd(this.d);
                this.a.x.setVisibility(0);
                this.a.v.loadVideo(this.d.b);
                j();
                this.a.G.b();
                return;
            }
            i();
            return;
        }
        C0081l.b("ignoring late ad response");
    }

    private void i() {
        Uri uriA = WatchActivity.a(this.a, this.c, this.d != null);
        this.d = null;
        if (uriA != null) {
            this.a.v.loadVideo(uriA);
            j();
            this.a.w.setHQ(this.a.c);
            this.a.G.b();
            return;
        }
        this.a.A.a(gl.NO_VALID_STREAM);
        this.a.y.showErrorMessage(R.string.video_not_available);
    }

    private void j() {
        this.a.A.a(this.a.c ? gk.MP4_600 : gk.MP4_256, gv.c(this.a));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.y.showLoading();
        if (this.a.M) {
            WatchActivity.a(this.a, false);
            b();
        } else {
            i();
        }
    }

    @Override // com.google.android.youtube.ui.InterfaceC0104q
    public final void a_() {
        if (this.b != null) {
            a(this.b);
        } else if (this.f != null) {
            a(this.f, this.g);
        } else {
            C0081l.b("can't retry");
        }
    }

    public final void a(Uri uri, boolean z) {
        uri.toString();
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = uri;
        this.g = z;
        this.h = null;
        this.i = -1;
        this.j.clear();
        l();
        this.a.G.c();
    }

    private Uri k() {
        return this.h != null ? this.h : this.f;
    }

    private void l() {
        if (this.g) {
            this.a.B.a(this.a, this);
        } else {
            this.a.k.a(U.a(k()), this.m);
        }
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.a.l.a(U.a(k(), fHVar.b), this.m);
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(Exception exc) {
        C0081l.a("error authenticating for playlist request", exc);
        this.a.finish();
    }

    @Override // defpackage.InterfaceC0021au
    public final void a() {
        this.a.finish();
    }

    @Override // com.google.android.youtube.player.b
    public final void c() {
        if (this.i < this.j.size() - 1) {
            this.a.b("player: next");
            List list = this.j;
            int i = this.i + 1;
            this.i = i;
            a((String) list.get(i));
            return;
        }
        if (this.h != null) {
            this.a.b("player: next");
            l();
        }
    }

    @Override // com.google.android.youtube.player.b
    public final void d() {
        if (this.i > 0) {
            this.a.b("player: previous");
            List list = this.j;
            int i = this.i - 1;
            this.i = i;
            a((String) list.get(i));
        }
    }

    @Override // com.google.android.youtube.player.b
    public final void e() {
        this.a.b("player: HQ button");
        this.a.b = !this.a.c;
        Uri uriA = WatchActivity.a(this.a, this.c, false);
        this.a.y.showLoading();
        this.a.v.loadVideo(uriA, this.a.v.getCurrentPosition());
        this.a.w.setHQ(this.a.c);
    }

    @Override // com.google.android.youtube.player.b
    public final void f() {
        this.a.b("player: CC button");
        this.a.D.a(this.c.a);
    }

    @Override // com.google.android.youtube.player.b
    public final void g() {
        this.a.setRequestedOrientation(this.a.getResources().getConfiguration().orientation == 1 ? 0 : 1);
        this.a.L.enable();
    }

    @Override // com.google.android.youtube.player.a
    public final void h() {
        if (this.d.h != null) {
            this.a.K.a();
            this.a.H.b();
            gp.a(this.a, this.d.h);
        }
    }
}
