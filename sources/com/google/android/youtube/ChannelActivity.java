package com.google.android.youtube;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ListView;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.ui.C0090c;
import com.google.android.youtube.ui.C0094g;
import com.google.android.youtube.ui.C0100m;
import com.google.android.youtube.ui.Workspace;
import defpackage.C0013am;
import defpackage.C0210ge;
import defpackage.C0233y;
import defpackage.EnumC0215gj;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.U;
import defpackage.V;
import defpackage.fH;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
public class ChannelActivity extends YouTubeActivity implements DialogInterface.OnClickListener {
    private InterfaceC0004ad a;
    private InterfaceC0004ad b;
    private InterfaceC0004ad c;
    private InterfaceC0004ad d;
    private InterfaceC0004ad e;
    private InterfaceC0004ad f;
    private InterfaceC0004ad g;
    private InterfaceC0004ad h;
    private InterfaceC0004ad i;
    private InterfaceC0004ad j;
    private C0210ge k;
    private com.google.android.youtube.ui.G l;
    private com.google.android.youtube.ui.G m;
    private C0094g n;
    private C0100m o;
    private C0090c p;
    private Button q;
    private C0013am r;
    private fH s;
    private String t;
    private Uri u;
    private String[] v;

    static /* synthetic */ Uri a(ChannelActivity channelActivity, Uri uri) {
        channelActivity.u = null;
        return null;
    }

    public static Intent a(Context context, String str, int i, Uri uri) {
        return new Intent(context, (Class<?>) ChannelActivity.class).putExtra("username", gq.a(str)).putExtra("selected_tab_id", i).putExtra("unsubscribe_uri", (Parcelable) gq.a(uri));
    }

    public static Intent a(Context context, String str) {
        return new Intent(context, (Class<?>) ChannelActivity.class).putExtra("username", gq.a(str));
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final void a(YouTubeApplication youTubeApplication) {
        super.a(youTubeApplication);
        InterfaceC0005ae interfaceC0005aeJ = youTubeApplication.j();
        this.a = interfaceC0005aeJ.a();
        this.b = interfaceC0005aeJ.f();
        this.c = interfaceC0005aeJ.h();
        this.e = interfaceC0005aeJ.k();
        this.d = interfaceC0005aeJ.e();
        this.f = interfaceC0005aeJ.t();
        this.g = interfaceC0005aeJ.m();
        this.h = interfaceC0005aeJ.K();
        this.i = interfaceC0005aeJ.x();
        this.j = interfaceC0005aeJ.y();
        this.k = youTubeApplication.f();
        this.r = youTubeApplication.k();
    }

    @Override // com.google.android.youtube.YouTubeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.channel_activity);
        Intent intent = getIntent();
        this.t = intent.getStringExtra("username");
        this.u = (Uri) intent.getParcelableExtra("unsubscribe_uri");
        Workspace.setTabRowToWorkspace(this, R.id.tabrow, R.id.workspace, getIntent().getIntExtra("selected_tab_id", 0));
        this.v = new String[2];
        this.v[0] = getString(R.string.subscribe_to_user_activity, new Object[]{this.t});
        this.v[1] = getString(R.string.subscribe_to_channel, new Object[]{this.t});
        this.q = c().b((String) null);
        this.q.setOnClickListener(new ViewOnClickListenerC0074e(this, new C0073d(this, this, new defpackage.E(this, new C0077h(this)))));
        a();
        this.p = new C0090c(this, this.b, this.d);
        this.p.a(this.t);
        this.m = new com.google.android.youtube.ui.G(this, (ListView) findViewById(R.id.uploads), this.c, this.h, this.d, true);
        this.m.a(this.k, EnumC0215gj.OTHER_USER_UPLOADS);
        this.m.a(V.d(this.t));
        this.l = new com.google.android.youtube.ui.G(this, (ListView) findViewById(R.id.favorites), this.e, this.h, this.d, true);
        this.l.a(this.k, EnumC0215gj.OTHER_USER_FAVORITES);
        this.l.a(V.e(this.t));
        this.n = new C0094g(this, (ListView) findViewById(R.id.activity), this.f, this.a);
        this.n.a(this.k, EnumC0215gj.OTHER_USER_ACTIVITY);
        this.n.a(V.f(this.t));
        C0233y c0233y = new C0233y(this);
        ListView listView = (ListView) findViewById(R.id.playlists);
        this.o = new C0100m(this, listView, c0233y, this.g, getString(R.string.no_playlists_found));
        listView.setOnItemClickListener(new C0075f(this, c0233y));
        this.o.a(V.g(this.t));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.q.setText(this.u != null ? R.string.unsubscribe : R.string.subscribe);
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final Dialog a(int i) {
        switch (i) {
            case YouTubePlayer.ENDED /* 6 */:
                return this.r.a(this);
            case 11:
                return new AlertDialog.Builder(this).setTitle(getString(R.string.subscribe_dialog_title)).setSingleChoiceItems(this.v, -1, this).create();
            default:
                return null;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                U uB = V.b(this.t, this.s);
                String string = getString(R.string.subscribed_to_activity, new Object[]{this.t});
                b("header: subscribe to activity");
                this.i.a(uB, new defpackage.E(this, new C0076g(this, string)));
                dialogInterface.cancel();
                break;
            case YouTubePlayer.PREPARED /* 1 */:
                U uC = V.c(this.t, this.s);
                String string2 = getString(R.string.subscribed_to_uploads, new Object[]{this.t});
                b("subscribe to uploads");
                this.i.a(uC, new defpackage.E(this, new C0076g(this, string2)));
                dialogInterface.cancel();
                break;
        }
    }
}
