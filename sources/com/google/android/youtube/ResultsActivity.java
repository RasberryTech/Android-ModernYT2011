package com.google.android.youtube;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.modern.ModernYouTubeClient;
import com.google.android.youtube.modern.ModernYouTubeConfig;
import com.google.android.youtube.modern.ModernYouTubeVideo;
import com.google.android.youtube.modern.ModernVideoAdapter;
import com.google.android.youtube.ui.InterfaceC0113z;
import com.google.android.youtube.ui.ViewOnClickListenerC0098k;
import com.google.android.youtube.ui.ViewOnClickListenerC0111x;
import defpackage.C0210ge;
import defpackage.C0223o;
import defpackage.EnumC0215gj;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.V;
import defpackage.X;

/* JADX INFO: loaded from: classes.dex */
public class ResultsActivity extends YouTubeActivity implements InterfaceC0113z {
    private InterfaceC0004ad a;
    private InterfaceC0004ad b;
    private ViewOnClickListenerC0111x c;
    private String d;
    private ListView e;
    private com.google.android.youtube.ui.G f;
    private C0210ge g;
    private SearchRecentSuggestions h;
    private InterfaceC0004ad i;
    private ModernVideoAdapter modernAdapter;
    private boolean modernMode;

    @Override // com.google.android.youtube.YouTubeActivity
    protected final void a(YouTubeApplication youTubeApplication) {
        super.a(youTubeApplication);
        InterfaceC0005ae interfaceC0005aeJ = youTubeApplication.j();
        this.a = interfaceC0005aeJ.b();
        this.i = interfaceC0005aeJ.K();
        this.b = interfaceC0005aeJ.e();
        this.g = youTubeApplication.f();
        this.h = youTubeApplication.e();
    }

    @Override // com.google.android.youtube.YouTubeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.results_activity);
        this.d = getIntent().getStringExtra("query").trim();
        this.e = (ListView) findViewById(R.id.videos);
        this.modernMode = ModernYouTubeConfig.isConfigured(this);
        if (this.modernMode) {
            this.modernAdapter = new ModernVideoAdapter(this, new ModernVideoAdapter.Listener() {
                public void onVideoClick(ModernYouTubeVideo video) {
                    startActivity(WatchActivity.a(ResultsActivity.this, video.id));
                }
            });
            this.e.setAdapter(this.modernAdapter);
            new ModernYouTubeClient(this).search(this.d, null, new ModernYouTubeClient.Callback() {
                public void onSuccess(java.util.List<ModernYouTubeVideo> videos, String nextPageToken) {
                    modernAdapter.setVideos(videos);
                }
                public void onError(Exception error) {
                    Toast.makeText(ResultsActivity.this, "Modern YouTube search failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } else {
            this.f = new com.google.android.youtube.ui.G(this, this.e, this.a, this.i, this.b);
            this.f.a(this.g, EnumC0215gj.SEARCH_RESULTS);
            b(X.ALL_TIME);
        }
        ViewOnClickListenerC0098k viewOnClickListenerC0098kC = c();
        viewOnClickListenerC0098kC.a(String.format(getString(R.string.videos_matching), this.d));
        Button buttonB = viewOnClickListenerC0098kC.b(R.string.time_filter_all_time);
        this.c = new ViewOnClickListenerC0111x(this, this);
        this.c.a(buttonB);
        viewOnClickListenerC0098kC.a(R.drawable.search_drawable).setOnClickListener(new y(this));
        this.h.saveRecentQuery(this.d, null);
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final Dialog a(int i) {
        switch (i) {
            case YouTubePlayer.PLAYING /* 2 */:
                return this.c.a();
            default:
                return null;
        }
    }

    @Override // com.google.android.youtube.ui.InterfaceC0113z
    public final void a(X x) {
        b(x);
    }

    private void b(X x) {
        if (this.modernMode) {
            new ModernYouTubeClient(this).search(this.d, null, new ModernYouTubeClient.Callback() {
                public void onSuccess(java.util.List<ModernYouTubeVideo> videos, String nextPageToken) { modernAdapter.setVideos(videos); }
                public void onError(Exception error) { Toast.makeText(ResultsActivity.this, "Modern YouTube search failed: " + error.getMessage(), Toast.LENGTH_LONG).show(); }
            });
        } else {
            this.f.a(V.a(this.d, x));
        }
    }

    public class ShellActivity extends Activity {
        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            startActivityForResult(getIntent().setClassName(getPackageName(), ResultsActivity.class.getName()), 42);
        }

        @Override // android.app.Activity
        protected void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i == 42) {
                finish();
            }
        }
    }

    public class GservicesBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean zA = C0223o.a(context.getContentResolver(), "youtube:enable_media_play_from_search", false);
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), ShellActivity.class.getName()), zA ? 1 : 2, 0);
        }
    }
}
