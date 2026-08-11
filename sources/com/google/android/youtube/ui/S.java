package com.google.android.youtube.ui;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.WatchActivity;
import defpackage.C0188fj;
import defpackage.C0189fk;
import defpackage.C0199fu;
import defpackage.C0210ge;
import defpackage.C0230v;
import defpackage.C0234z;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.fM;
import defpackage.gq;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class S implements InterfaceC0104q {
    private final WatchActivity a;
    private final C0210ge b;
    private final TabRow c;
    private final Workspace d;
    private final InterfaceC0004ad e;
    private final InterfaceC0004ad f;
    private ListView g;
    private C0230v h;
    private ViewOnClickListenerC0088a i;
    private ListView j;
    private C0234z k;
    private ViewOnClickListenerC0088a l;
    private View m;
    private AbstractViewOnClickListenerC0103p n;
    private C0199fu o;
    private boolean p;
    private String q;
    private String r;
    private String s;

    static /* synthetic */ void a(S s, C0188fj c0188fj) {
        if (s.o == null) {
            C0081l.b("attempt to set artist bundle info without a music video");
            return;
        }
        ((TextView) s.m.findViewById(com.google.android.youtube.R.id.name)).setText(c0188fj.a.b);
        TextView textView = (TextView) s.m.findViewById(com.google.android.youtube.R.id.bio);
        if (TextUtils.isEmpty(c0188fj.a.c)) {
            textView.setText(com.google.android.youtube.R.string.no_bio_available);
        } else {
            textView.setText(c0188fj.a.c.replaceAll("\r\n", "\r\n\r\n"));
        }
        s.n.b();
        s.h.a(s.o);
        s.h.clear();
        if (c0188fj.c.size() == 0) {
            s.i.a(s.r, false);
        } else {
            s.i.a();
            int count = -1;
            for (C0199fu c0199fu : c0188fj.c) {
                if (c0199fu.d.equals(s.o.d)) {
                    count = s.h.getCount();
                }
                s.h.add(c0199fu);
            }
            if (count >= 0) {
                s.g.setSelectionFromTop(count, 50);
            }
        }
        s.k.clear();
        if (c0188fj.d.size() == 0) {
            s.l.a(s.s, false);
            return;
        }
        s.l.a();
        Iterator it = c0188fj.d.iterator();
        while (it.hasNext()) {
            s.k.add((C0189fk) it.next());
        }
    }

    public S(WatchActivity watchActivity, InterfaceC0005ae interfaceC0005ae, C0210ge c0210ge) {
        this.a = watchActivity;
        this.b = c0210ge;
        this.c = (TabRow) this.a.findViewById(com.google.android.youtube.R.id.tabrow);
        this.d = (Workspace) this.a.findViewById(com.google.android.youtube.R.id.workspace);
        this.e = interfaceC0005ae.L();
        this.f = interfaceC0005ae.J();
        this.q = watchActivity.getString(com.google.android.youtube.R.string.loading);
        this.r = watchActivity.getString(com.google.android.youtube.R.string.no_videos_found);
        this.s = watchActivity.getString(com.google.android.youtube.R.string.no_related_artists);
    }

    public final void b() {
        this.o = null;
        this.p = false;
        d();
    }

    public final void a(String str) {
        this.o = null;
        this.p = true;
        c();
        this.e.a(str, new defpackage.E(this.a, new T(this)));
    }

    public final void a(fM fMVar) {
        gq.a(fMVar);
        this.o = null;
        if (this.p || fMVar.a()) {
            this.f.a(fMVar.a, new defpackage.E(this.a, new U(this)));
        } else {
            d();
        }
        this.p = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.m == null) {
            this.m = this.a.getLayoutInflater().inflate(com.google.android.youtube.R.layout.artist_bio, (ViewGroup) null);
            this.n = AbstractViewOnClickListenerC0103p.a(this.a, this.m.findViewById(com.google.android.youtube.R.id.status), this);
            this.n.a();
            Drawable drawable = this.a.getResources().getDrawable(android.R.drawable.divider_horizontal_dark);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.a);
            this.j = new ListView(this.a);
            this.j.setDivider(drawable);
            this.j.setTag(this.a.getString(com.google.android.youtube.R.string.related_artists));
            this.j.setLayoutParams(layoutParams);
            View viewInflate = layoutInflaterFrom.inflate(com.google.android.youtube.R.layout.status, (ViewGroup) this.j, false);
            this.k = new C0234z(this.a);
            C0096i c0096i = new C0096i(this.k, viewInflate);
            this.l = new ViewOnClickListenerC0088a(viewInflate, c0096i, this);
            this.j.setAdapter((ListAdapter) c0096i);
            this.j.setOnItemClickListener(new X(this));
            this.g = new ListView(this.a);
            this.g.setDivider(drawable);
            this.g.setTag(this.a.getString(com.google.android.youtube.R.string.artist_tracks));
            this.g.setLayoutParams(layoutParams);
            View viewInflate2 = layoutInflaterFrom.inflate(com.google.android.youtube.R.layout.status, (ViewGroup) this.j, false);
            this.h = new C0230v(this.a, true);
            C0096i c0096i2 = new C0096i(this.h, viewInflate);
            this.i = new ViewOnClickListenerC0088a(viewInflate2, c0096i2, this);
            this.g.setAdapter((ListAdapter) c0096i2);
            this.g.setOnItemClickListener(new W(this));
        }
        if (this.m.getParent() == null) {
            this.d.addView(this.m, 0);
            this.d.addView(this.j, 1);
            this.d.addView(this.g, 2);
            a(3);
        }
    }

    private void d() {
        if (this.m != null && this.m.getParent() == this.d) {
            this.d.removeView(this.g);
            this.d.removeView(this.j);
            this.d.removeView(this.m);
            a(-3);
        }
    }

    private void a(int i) {
        this.d.updateTabRow();
        int iMax = Math.max(0, this.d.getCurrentScreen() + i);
        this.c.focusTab(iMax, false);
        this.d.setCurrentScreen(iMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.i.a(this.q, true);
        this.l.a(this.q, true);
        this.n.a(com.google.android.youtube.R.string.loading, true);
        this.e.a(str, new defpackage.E(this.a, new V(this)));
    }

    @Override // com.google.android.youtube.ui.InterfaceC0104q
    public final void a_() {
        b(this.o.b);
    }
}
