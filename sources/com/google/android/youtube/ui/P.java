package com.google.android.youtube.ui;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.ChannelActivity;
import com.google.android.youtube.YouTubeActivity;
import com.google.android.youtube.YouTubeApplication;
import com.google.android.youtube.player.BrandingOverlay;
import defpackage.C0190fl;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.fM;
import defpackage.gq;
import defpackage.gv;

/* JADX INFO: loaded from: classes.dex */
public final class P implements defpackage.I, View.OnClickListener {
    private final YouTubeActivity a;
    private final BrandingOverlay b;
    private final InterfaceC0004ad c;
    private final InterfaceC0004ad d;
    private final View e;
    private final AbstractViewOnClickListenerC0103p f;
    private final ImageView g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final TextView n;
    private final TextView o;
    private fM p;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Couldn't retrieve branding info from [uri=" + ((defpackage.U) obj).a + "]", exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        C0190fl c0190fl = (C0190fl) obj2;
        if (c0190fl.a != null) {
            if (gv.d(this.p.n)) {
                this.b.show();
            }
            this.d.a(c0190fl.a, new defpackage.E(this.a, new Q(this, c0190fl)));
        }
    }

    public P(YouTubeActivity youTubeActivity, BrandingOverlay brandingOverlay, InterfaceC0005ae interfaceC0005ae, InterfaceC0104q interfaceC0104q) {
        this.a = youTubeActivity;
        this.b = brandingOverlay;
        this.c = interfaceC0005ae.H();
        this.d = interfaceC0005ae.e();
        this.f = AbstractViewOnClickListenerC0103p.a(this.a, this.a.findViewById(com.google.android.youtube.R.id.info_status), interfaceC0104q);
        this.f.a();
        this.e = youTubeActivity.findViewById(com.google.android.youtube.R.id.info_layout);
        this.g = (ImageView) this.e.findViewById(com.google.android.youtube.R.id.branding);
        this.h = a(com.google.android.youtube.R.id.title);
        this.l = a(com.google.android.youtube.R.id.channel);
        this.l.setOnClickListener(this);
        this.m = a(com.google.android.youtube.R.id.description);
        this.i = a(com.google.android.youtube.R.id.date_added);
        this.j = a(com.google.android.youtube.R.id.view_count);
        this.n = a(com.google.android.youtube.R.id.category);
        this.o = a(com.google.android.youtube.R.id.tags);
        this.k = a(com.google.android.youtube.R.id.likes_dislikes);
    }

    public final void a() {
        this.e.setVisibility(8);
        this.f.a(com.google.android.youtube.R.string.loading, true);
        this.b.hide();
    }

    public final void a(String str) {
        this.e.setVisibility(8);
        this.f.a(str, true);
        this.b.hide();
    }

    public final void a(fM fMVar) {
        this.p = (fM) gq.a(fMVar);
        this.g.setVisibility(8);
        this.h.setText(fMVar.i);
        if (fMVar.o != null) {
            this.i.setText(this.a.getString(com.google.android.youtube.R.string.published_date, new Object[]{DateFormat.getLongDateFormat(this.a).format(fMVar.o)}));
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.j.setText(this.a.getString(com.google.android.youtube.R.string.views, new Object[]{Integer.valueOf(fMVar.k)}));
        this.k.setText(this.a.getString(com.google.android.youtube.R.string.num_likes_and_dislikes, new Object[]{Integer.valueOf(fMVar.l), Integer.valueOf(fMVar.m)}));
        this.l.setText(this.a.getString(com.google.android.youtube.R.string.by, new Object[]{fMVar.n}));
        this.m.setText(fMVar.r);
        this.n.setText(fMVar.p);
        this.o.setText(fMVar.q);
        this.e.setVisibility(0);
        this.f.b();
        this.b.hide();
        if (!YouTubeApplication.a && fMVar.v) {
            this.c.a(defpackage.V.h(fMVar.n), this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.l) {
            this.a.b("channel button");
            this.a.startActivity(ChannelActivity.a(this.a, this.p.n));
        }
    }

    public final void a(boolean z) {
        TextView textView = this.k;
        YouTubeActivity youTubeActivity = this.a;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.p.l + (z ? 1 : 0));
        objArr[1] = Integer.valueOf(this.p.m + (z ? 0 : 1));
        textView.setText(youTubeActivity.getString(com.google.android.youtube.R.string.num_likes_and_dislikes, objArr));
    }

    public final boolean b() {
        return this.g.getVisibility() == 0;
    }

    private TextView a(int i) {
        return (TextView) this.e.findViewById(i);
    }
}
