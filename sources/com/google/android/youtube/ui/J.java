package com.google.android.youtube.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.YouTubeActivity;
import defpackage.C0013am;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.fM;
import defpackage.fO;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
public final class J implements View.OnClickListener, E {
    private final YouTubeActivity a;
    private final InterfaceC0004ad b;
    private final InterfaceC0004ad c;
    private final InterfaceC0004ad d;
    private final InterfaceC0004ad e;
    private final InterfaceC0004ad f;
    private final C0013am g;
    private final A h;
    private final ImageButton i;
    private final ImageButton j;
    private final Button k;
    private final View l;
    private final View m;
    private final View n;
    private final View o;
    private final View p;
    private final M q = new M(this);
    private final P r;
    private fM s;
    private Uri t;

    static /* synthetic */ void a(J j, View view, boolean z) {
        view.setSelected(z);
        view.setClickable(!z);
    }

    @Override // com.google.android.youtube.ui.E
    public final /* bridge */ /* synthetic */ boolean a(View view, Object obj) {
        if (view == this.o) {
            this.a.b("toolbar: share video");
            YouTubeActivity youTubeActivity = this.a;
            fM fMVar = this.s;
            if (fMVar == null || fMVar.c == null) {
                C0081l.b("Share video error: null watch uri");
            } else {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", youTubeActivity.getString(com.google.android.youtube.R.string.share_subject, fMVar.i));
                intent.putExtra("android.intent.extra.TEXT", fMVar.c.toString());
                intent.setFlags(524288);
                youTubeActivity.startActivity(Intent.createChooser(intent, youTubeActivity.getText(com.google.android.youtube.R.string.send_video)));
            }
        } else if (view == this.p) {
            this.a.b("toolbar: copy video url");
            ((ClipboardManager) this.a.getSystemService("clipboard")).setText(this.s.c.toString());
            b(com.google.android.youtube.R.string.url_copied);
        } else if (view == this.n) {
            if (this.t == null) {
                this.a.b("toolbar: add favorite");
                this.g.a(this.a, new K(this));
            } else {
                this.a.b("toolbar: remove favorite");
                this.g.a(this.a, new O(this));
            }
        } else if (view == this.l) {
            this.a.b("toolbar: flag video");
            YouTubeActivity youTubeActivity2 = this.a;
            fM fMVar2 = this.s;
            if (fMVar2 == null || fMVar2.a == null) {
                C0081l.b("Flag video error: null id uri");
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(String.format("http://m.youtube.com/flag?v=%s", fMVar2.a)));
                youTubeActivity2.startActivity(intent2);
            }
        } else if (view == this.m) {
            this.a.b("toolbar: save to playlist");
            this.g.a(this.a, this.q);
        }
        return true;
    }

    public J(YouTubeActivity youTubeActivity, ViewOnClickListenerC0098k viewOnClickListenerC0098k, P p, InterfaceC0005ae interfaceC0005ae, C0013am c0013am) {
        this.a = (YouTubeActivity) gq.a(youTubeActivity);
        this.g = (C0013am) gq.a(c0013am);
        this.r = (P) gq.a(p);
        this.b = interfaceC0005ae.u();
        this.c = interfaceC0005ae.v();
        this.d = interfaceC0005ae.w();
        this.e = interfaceC0005ae.n();
        this.f = interfaceC0005ae.z();
        this.h = new A(youTubeActivity, 12, F.BELOW);
        this.i = viewOnClickListenerC0098k.a(com.google.android.youtube.R.drawable.like_drawable);
        this.i.setOnClickListener(this);
        this.j = viewOnClickListenerC0098k.a(com.google.android.youtube.R.drawable.dislike_drawable);
        this.j.setOnClickListener(this);
        this.k = viewOnClickListenerC0098k.a(com.google.android.youtube.R.drawable.more_drawable, com.google.android.youtube.R.string.header_more);
        this.h.a(this.k, (Object) null);
        this.l = this.h.a(com.google.android.youtube.R.string.flag, com.google.android.youtube.R.drawable.flag_drawable);
        this.m = this.h.a(com.google.android.youtube.R.string.save_to_playlist, com.google.android.youtube.R.drawable.save_drawable);
        this.n = this.h.a((String) null, (Drawable) null);
        a(this.t);
        this.o = this.h.a(com.google.android.youtube.R.string.share, com.google.android.youtube.R.drawable.share_drawable);
        this.p = this.h.a(com.google.android.youtube.R.string.copy_url_button_text, com.google.android.youtube.R.drawable.copy_url_drawable);
        this.h.a(this);
        a(false);
    }

    public final void a(fM fMVar, Uri uri) {
        this.s = fMVar;
        a(uri);
        a(fMVar != null && fMVar.s == fO.PLAYABLE);
    }

    private void a(boolean z) {
        this.i.setEnabled(z);
        this.j.setEnabled(z);
        this.k.setEnabled(z);
    }

    public final void a() {
        this.h.a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.i) {
            this.a.b("header: like button");
            this.g.a(this.a, new N(this, true));
        } else if (view == this.j) {
            this.a.b("header: dislike button");
            this.g.a(this.a, new N(this, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri) {
        this.t = uri;
        this.h.a(this.n, uri == null ? com.google.android.youtube.R.string.add_favorite : com.google.android.youtube.R.string.remove_favorite);
        this.h.b(this.n, uri == null ? com.google.android.youtube.R.drawable.favorite_drawable : com.google.android.youtube.R.drawable.unfavorite_drawable);
    }

    public final Dialog a(int i) {
        switch (i) {
            case 10:
                return new AlertDialog.Builder(this.a).setTitle(com.google.android.youtube.R.string.save_to_playlist).setItems(this.q.a, this.q).create();
            case 11:
            default:
                return null;
            case 12:
                return this.h.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Toast.makeText(this.a, i, 1).show();
    }
}
