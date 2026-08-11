package com.google.android.youtube;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.ui.C0090c;
import com.google.android.youtube.ui.C0093f;
import com.google.android.youtube.ui.C0100m;
import com.google.android.youtube.ui.ViewOnClickListenerC0098k;
import com.google.android.youtube.ui.Workspace;
import defpackage.C0013am;
import defpackage.C0210ge;
import defpackage.C0233y;
import defpackage.EnumC0215gj;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.InterfaceC0021au;
import defpackage.V;
import defpackage.fH;
import defpackage.fM;
import defpackage.gp;

/* JADX INFO: loaded from: classes.dex */
public class MyChannelActivity extends YouTubeActivity implements InterfaceC0021au, com.google.android.youtube.ui.E {
    private InterfaceC0004ad a;
    private InterfaceC0004ad b;
    private InterfaceC0004ad c;
    private InterfaceC0004ad d;
    private InterfaceC0004ad e;
    private InterfaceC0004ad f;
    private InterfaceC0004ad g;
    private InterfaceC0004ad h;
    private com.google.android.youtube.ui.G i;
    private com.google.android.youtube.ui.G j;
    private C0100m k;
    private C0100m l;
    private C0090c m;
    private C0013am n;
    private C0210ge o;
    private com.google.android.youtube.ui.A p;
    private View q;
    private fM r;

    @Override // com.google.android.youtube.ui.E
    public final /* bridge */ /* synthetic */ boolean a(View view, Object obj) {
        this.r = (fM) obj;
        if (view != this.q) {
            return false;
        }
        showDialog(11);
        return true;
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final void a(YouTubeApplication youTubeApplication) {
        super.a(youTubeApplication);
        this.n = youTubeApplication.k();
        InterfaceC0005ae interfaceC0005aeJ = youTubeApplication.j();
        this.a = interfaceC0005aeJ.g();
        this.b = interfaceC0005aeJ.i();
        this.c = interfaceC0005aeJ.l();
        this.d = interfaceC0005aeJ.n();
        this.e = interfaceC0005aeJ.o();
        this.f = interfaceC0005aeJ.e();
        this.g = interfaceC0005aeJ.K();
        this.h = interfaceC0005aeJ.j();
        this.o = youTubeApplication.f();
    }

    @Override // com.google.android.youtube.YouTubeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.my_channel_activity);
        Workspace.setTabRowToWorkspace(this, R.id.tabrow, R.id.workspace);
        ViewOnClickListenerC0098k viewOnClickListenerC0098kC = c();
        if (gp.a((Context) this)) {
            viewOnClickListenerC0098kC.b(R.string.upload).setOnClickListener(new ViewOnClickListenerC0084o(this));
        }
        viewOnClickListenerC0098kC.b(R.string.logout).setOnClickListener(new ViewOnClickListenerC0085p(this));
        this.m = new C0090c(this, this.a, this.f);
        this.p = new com.google.android.youtube.ui.A(this, 12, com.google.android.youtube.ui.F.ON_TOP);
        this.p.a(this);
        this.q = this.p.a(R.string.delete_upload_title, R.drawable.delete_drawable);
        this.j = new com.google.android.youtube.ui.G(this, (ListView) findViewById(R.id.uploads), new defpackage.C(this, this.p), this.b, this.g, this.f, true);
        this.j.a(this.o, EnumC0215gj.MY_VIDEOS);
        this.i = new C0086q(this, this, (ListView) findViewById(R.id.favorites), this.c, this.g, this.f, true);
        this.i.a(this.o, EnumC0215gj.FAVORITES);
        C0233y c0233y = new C0233y(this);
        ListView listView = (ListView) findViewById(R.id.playlists);
        this.k = new C0100m(this, listView, c0233y, this.d, getString(R.string.no_playlists_found));
        listView.setOnItemClickListener(new s(this, c0233y));
        defpackage.A a = new defpackage.A(this);
        ListView listView2 = (ListView) findViewById(R.id.subscriptions);
        this.l = new C0100m(this, listView2, a, this.e, getString(R.string.no_subscriptions_found));
        listView2.setOnItemClickListener(new t(this, a));
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.j.b();
        this.i.b();
        this.k.b();
        this.l.b();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.n.a(this, this);
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.m.a(fHVar);
        this.j.a(V.c(fHVar));
        this.i.a(V.d(fHVar));
        this.k.a(V.e(fHVar));
        this.l.a(V.f(fHVar));
    }

    @Override // defpackage.InterfaceC0021au
    public final void a() {
        finish();
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(Exception exc) {
        C0093f.b(this, exc);
        finish();
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final Dialog a(int i) {
        switch (i) {
            case YouTubePlayer.ENDED /* 6 */:
                return this.n.a((Activity) this);
            case 11:
                DialogInterfaceOnClickListenerC0087r dialogInterfaceOnClickListenerC0087r = new DialogInterfaceOnClickListenerC0087r(this);
                return new AlertDialog.Builder(this).setTitle(R.string.delete_upload_title).setMessage(R.string.delete_upload_confirmation).setPositiveButton(android.R.string.yes, dialogInterfaceOnClickListenerC0087r).setNegativeButton(android.R.string.no, dialogInterfaceOnClickListenerC0087r).create();
            case 12:
                return this.p.b();
            default:
                return null;
        }
    }
}
