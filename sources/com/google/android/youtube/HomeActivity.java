package com.google.android.youtube;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.google.android.youtube.ui.ViewOnClickListenerC0098k;
import android.widget.Toast;
import com.google.android.youtube.modern.ModernYouTubeClient;
import com.google.android.youtube.modern.ModernYouTubeConfig;
import com.google.android.youtube.modern.ModernYouTubeVideo;
import com.google.android.youtube.modern.ModernVideoAdapter;
import defpackage.C0008ah;
import defpackage.C0013am;
import defpackage.C0210ge;
import defpackage.EnumC0215gj;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.InterfaceC0021au;
import defpackage.V;
import defpackage.fH;
import defpackage.gp;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class HomeActivity extends YouTubeActivity implements InterfaceC0021au {
    private C0013am a;
    private C0008ah b;
    private InterfaceC0004ad c;
    private InterfaceC0004ad d;
    private com.google.android.youtube.ui.G e;
    private C0210ge f;
    private boolean g;
    private ModernVideoAdapter modernAdapter;

    public static Intent a(Context context) {
        return new Intent(context, (Class<?>) HomeActivity.class).setFlags(67108864);
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final void a(YouTubeApplication youTubeApplication) {
        super.a(youTubeApplication);
        this.a = youTubeApplication.k();
        InterfaceC0005ae interfaceC0005aeJ = youTubeApplication.j();
        this.b = new C0008ah(interfaceC0005aeJ, Locale.getDefault().getCountry());
        this.c = interfaceC0005aeJ.e();
        this.d = interfaceC0005aeJ.K();
        this.f = youTubeApplication.f();
        this.g = youTubeApplication.a();
    }

    @Override // com.google.android.youtube.YouTubeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_activity);
        ViewOnClickListenerC0098k viewOnClickListenerC0098kC = c();
        if (gp.a((Context) this)) {
            viewOnClickListenerC0098kC.a(R.drawable.capture_drawable).setOnClickListener(new ViewOnClickListenerC0078i(this));
        }
        viewOnClickListenerC0098kC.a(R.drawable.search_drawable).setOnClickListener(new ViewOnClickListenerC0079j(this));
        if (ModernYouTubeConfig.isConfigured(this)) {
            modernAdapter = new ModernVideoAdapter(this, new ModernVideoAdapter.Listener() {
                public void onVideoClick(ModernYouTubeVideo video) { startActivity(WatchActivity.a(HomeActivity.this, video.id)); }
            });
            ((ListView) findViewById(R.id.videos)).setAdapter(modernAdapter);
            new ModernYouTubeClient(this).mostPopular(Locale.getDefault().getCountry(), new ModernYouTubeClient.Callback() {
                public void onSuccess(java.util.List<ModernYouTubeVideo> videos, String nextPageToken) { modernAdapter.setVideos(videos); }
                public void onError(Exception error) { Toast.makeText(HomeActivity.this, "Modern YouTube feed failed: " + error.getMessage(), Toast.LENGTH_LONG).show(); }
            });
        } else {
            this.e = new C0080k(this, this, (ListView) findViewById(R.id.videos), new defpackage.C(this, this.b.a()), this.b, this.d, this.c, false);
            this.e.a(this.f, EnumC0215gj.THE_FEED);
        }
        Intent intent = getIntent();
        if (intent != null && "com.google.android.youtube.action.search".equals(intent.getAction()) && this.g) {
            onSearchRequested();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.a.a((InterfaceC0021au) this);
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        if (this.modernAdapter == null) this.e.a(V.a(fHVar));
    }

    @Override // defpackage.InterfaceC0021au
    public final void a() {
        b();
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(Exception exc) {
        b();
    }

    private void b() {
        if (this.modernAdapter == null) this.e.a(V.a());
    }
}
