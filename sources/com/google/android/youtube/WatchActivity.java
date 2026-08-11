package com.google.android.youtube;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import com.google.android.youtube.player.AdOverlay;
import com.google.android.youtube.player.BrandingOverlay;
import com.google.android.youtube.player.ControllerOverlay;
import com.google.android.youtube.player.StatusOverlay;
import com.google.android.youtube.player.SubtitleOverlay;
import com.google.android.youtube.player.YouTubePlayer;
import android.webkit.WebView;
import com.google.android.youtube.modern.ModernPlayback;
import com.google.android.youtube.modern.ModernYouTubeConfig;
import com.google.android.youtube.ui.C0100m;
import com.google.android.youtube.ui.C0101n;
import com.google.android.youtube.ui.C0106s;
import com.google.android.youtube.ui.DialogInterfaceOnClickListenerC0089b;
import com.google.android.youtube.ui.InterfaceC0110w;
import com.google.android.youtube.ui.S;
import com.google.android.youtube.ui.TabRow;
import com.google.android.youtube.ui.Workspace;
import com.google.android.youtube.ui.Y;
import defpackage.C0013am;
import defpackage.C0210ge;
import defpackage.C0226r;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.V;
import defpackage.fM;
import defpackage.gn;
import defpackage.gp;
import defpackage.gq;
import defpackage.gv;

/* JADX INFO: loaded from: classes.dex */
public class WatchActivity extends YouTubeActivity implements InterfaceC0110w {
    private C0210ge A;
    private C0013am B;
    private D C;
    private C0106s D;
    private C E;
    private I F;
    private C0101n G;
    private com.google.android.youtube.player.c H;
    private DialogInterfaceOnClickListenerC0089b I;
    private InterfaceC0004ad J;
    private C0070a K;
    private OrientationEventListener L;
    private boolean M;
    private String N;
    private String a;
    private boolean b;
    private boolean c;
    private com.google.android.youtube.ui.J d;
    private com.google.android.youtube.ui.P e;
    private Y f;
    private S g;
    private C0100m h;
    private C0226r i;
    private InterfaceC0004ad j;
    private InterfaceC0004ad k;
    private InterfaceC0004ad l;
    private InterfaceC0004ad m;
    private InterfaceC0004ad n;
    private InterfaceC0004ad o;
    private InterfaceC0004ad p;
    private InterfaceC0004ad q;
    private InterfaceC0004ad r;
    private View s;
    private TabRow t;
    private Workspace u;
    private YouTubePlayer v;
    private ControllerOverlay w;
    private AdOverlay x;
    private StatusOverlay y;
    private SharedPreferences z;
    private WebView modernWebView;

    static /* synthetic */ Uri a(WatchActivity watchActivity, fM fMVar, boolean z) {
        if (fMVar == null) {
            return null;
        }
        Uri uriA = fMVar.a(watchActivity.b);
        if (uriA == null) {
            watchActivity.c = false;
            return null;
        }
        watchActivity.c = uriA == fMVar.b;
        if (z) {
            uriA = uriA.buildUpon().appendQueryParameter("androidcid", watchActivity.N).build();
        }
        return !TextUtils.isEmpty(watchActivity.a) ? Uri.parse(uriA.toString() + "&" + watchActivity.a) : uriA;
    }

    static /* synthetic */ boolean a(WatchActivity watchActivity, boolean z) {
        watchActivity.M = false;
        return false;
    }

    public static Intent a(Context context, String str) {
        return new Intent(context, (Class<?>) WatchActivity.class).putExtra("video_id", (String) gq.a((Object) str));
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final void a(YouTubeApplication youTubeApplication) {
        super.a(youTubeApplication);
        InterfaceC0005ae interfaceC0005aeJ = youTubeApplication.j();
        this.B = youTubeApplication.k();
        this.j = interfaceC0005aeJ.a();
        this.k = interfaceC0005aeJ.A();
        this.l = interfaceC0005aeJ.B();
        this.m = interfaceC0005aeJ.d();
        this.n = interfaceC0005aeJ.C();
        this.o = interfaceC0005aeJ.D();
        this.p = interfaceC0005aeJ.f();
        this.J = interfaceC0005aeJ.E();
        this.q = interfaceC0005aeJ.F();
        this.r = interfaceC0005aeJ.G();
        this.A = youTubeApplication.f();
        this.N = youTubeApplication.g();
        if (!youTubeApplication.a()) {
            this.M = true;
        }
    }

    @Override // com.google.android.youtube.YouTubeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.watch_activity);
        this.z = getSharedPreferences("youtube", 0);
        this.b = this.z.getBoolean("default_hq", false) ? true : gv.b(this);
        this.s = findViewById(R.id.header);
        this.v = (YouTubePlayer) findViewById(R.id.player);
        this.t = (TabRow) findViewById(R.id.tabrow);
        this.u = (Workspace) findViewById(R.id.workspace);
        this.u.setTabRow(this.t);
        this.t.setOnTabClickListener(this);
        this.C = new D(this);
        this.H = com.google.android.youtube.player.c.a(this.A, this.J);
        this.v.addListener(this.H);
        SubtitleOverlay subtitleOverlay = new SubtitleOverlay(this, this.v);
        subtitleOverlay.install();
        this.w = new ControllerOverlay(this, this.v, this.C);
        this.w.install();
        this.x = new AdOverlay(this, this.v, this.C);
        this.x.install();
        BrandingOverlay brandingOverlay = new BrandingOverlay(this, this.v);
        brandingOverlay.install();
        this.y = new StatusOverlay(this, this.v, this.C);
        this.y.install();
        InterfaceC0005ae interfaceC0005aeJ = ((YouTubeApplication) getApplication()).j();
        this.e = new com.google.android.youtube.ui.P(this, brandingOverlay, interfaceC0005aeJ, this.C);
        this.d = new com.google.android.youtube.ui.J(this, c(), this.e, interfaceC0005aeJ, this.B);
        this.f = new Y(this, interfaceC0005aeJ, this.B, this.A);
        this.g = new S(this, interfaceC0005aeJ, this.A);
        this.I = new DialogInterfaceOnClickListenerC0089b(this, this.z, this.B, this.p);
        this.D = new C0106s(this, this.z, subtitleOverlay, this.w, this.n, this.o);
        this.G = new C0101n(this);
        this.E = new C(this);
        this.F = new I(this);
        ListView listView = (ListView) findViewById(R.id.comments);
        this.i = new C0226r(this);
        this.h = new C0100m(this, listView, this.i, this.m, getString(R.string.no_comments_found));
        this.K = new C0070a(new gn(), this.z, this.q, this.r, this.j);
        this.L = new B(this, this, 0);
        onConfigurationChanged(getResources().getConfiguration());
    }

    @Override // android.app.Activity
    public void onStart() {
        Intent intent = getIntent();
        Uri data = intent.getData();
        String stringExtra = intent.getStringExtra("video_id");
        Uri uri = (Uri) intent.getParcelableExtra("playlist_uri");
        String stringExtra2 = intent.getStringExtra("artist_id");
        if (stringExtra != null) {
            if (ModernYouTubeConfig.isConfigured(this)) {
                this.modernWebView = ModernPlayback.attach(this, this.v, stringExtra);
                if (this.modernWebView != null) {
                    this.M = false;
                } else {
                    this.C.a(stringExtra);
                }
            } else {
                this.C.a(stringExtra);
            }
        } else if (uri != null) {
            this.C.a(uri, intent.getBooleanExtra("authenticate", false));
        } else if (stringExtra2 != null) {
            this.g.a(stringExtra2);
        } else if (data != null) {
            String[] strArrA = gp.a(data);
            if (!TextUtils.isEmpty(strArrA[0])) {
                this.a = strArrA[1];
                this.C.a(strArrA[0]);
            } else {
                C0081l.a("invalid intercepted URI");
                finish();
            }
        } else {
            C0081l.a("invalid intent format");
            finish();
        }
        C c = this.E;
        c.a.registerReceiver(c, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        this.F.a();
        super.onStart();
    }

    public final void a() {
        this.a = null;
        this.d.a((fM) null, (Uri) null);
        this.e.a();
        this.g.b();
        this.t.focusTab(0, false);
        this.u.setCurrentScreen(0);
    }

    public final void a(fM fMVar) {
        this.d.a(fMVar, (Uri) getIntent().getParcelableExtra("unfavorite_uri"));
        this.e.a(fMVar);
        this.g.a(fMVar);
        this.f.a(fMVar);
        if (fMVar.f == null) {
            this.h.a(getString(R.string.comments_disabled));
        } else {
            this.h.a(V.b(fMVar.f));
        }
        this.D.a(fMVar);
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.M = true;
        C c = this.E;
        c.a.unregisterReceiver(c);
        I i = this.F;
        i.a.unregisterReceiver(i);
        if (this.modernWebView != null) {
            ModernPlayback.detach(this.v, this.modernWebView);
            this.modernWebView = null;
        } else {
            this.v.stopVideo();
        }
        this.f.a((fM) null);
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("stopped", true);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.M = bundle.getBoolean("stopped");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.v.release();
        this.H.a();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Window window = getWindow();
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        if (configuration.orientation == 2) {
            window.setFlags(1024, 1024);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.w.setMinimal(false);
            this.d.a();
            ((SearchManager) getSystemService("search")).stopSearch();
        } else {
            window.setFlags(0, 1024);
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            int width = getWindowManager().getDefaultDisplay().getWidth();
            layoutParams.width = width;
            layoutParams.height = (int) (width / 1.777f);
            this.w.setMinimal(true);
        }
        closeOptionsMenu();
    }

    private boolean d() {
        return (getWindow().getAttributes().flags & 1024) != 0;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return !d() && super.onSearchRequested();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(7);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(!d());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final Dialog a(int i) {
        switch (i) {
            case YouTubePlayer.PREPARED /* 1 */:
                return this.D.a();
            case YouTubePlayer.PLAYING /* 2 */:
            case YouTubePlayer.ERROR /* 7 */:
            case 8:
            case 9:
            case 11:
            default:
                return null;
            case YouTubePlayer.PAUSED /* 3 */:
            case YouTubePlayer.STOPPED /* 4 */:
            case YouTubePlayer.PROGRESS /* 5 */:
                return this.I.a(i);
            case YouTubePlayer.ENDED /* 6 */:
                return this.B.a(this);
            case 10:
            case 12:
                return this.d.a(i);
        }
    }

    public final void b() {
        this.C.b();
    }

    public final void a(String str) {
        this.C.a(str);
    }

    @Override // com.google.android.youtube.ui.InterfaceC0110w
    public final void b(int i) {
        this.u.snapToScreen(i);
        this.G.a();
    }
}
