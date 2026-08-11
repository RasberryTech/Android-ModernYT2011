package com.google.android.youtube;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.ui.InterfaceC0113z;
import com.google.android.youtube.ui.ViewOnClickListenerC0098k;
import com.google.android.youtube.ui.ViewOnClickListenerC0111x;
import com.google.android.youtube.ui.Workspace;
import defpackage.C0210ge;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.V;
import defpackage.W;
import defpackage.X;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BrowseActivity extends YouTubeActivity implements InterfaceC0113z {
    private InterfaceC0004ad a;
    private InterfaceC0004ad b;
    private InterfaceC0004ad c;
    private ViewOnClickListenerC0111x d;
    private String e;
    private String f;
    private EnumMap g;
    private EnumMap h;
    private C0210ge i;

    @Override // com.google.android.youtube.YouTubeActivity
    protected final void a(YouTubeApplication youTubeApplication) {
        super.a(youTubeApplication);
        InterfaceC0005ae interfaceC0005aeJ = youTubeApplication.j();
        this.a = interfaceC0005aeJ.s();
        this.b = interfaceC0005aeJ.e();
        this.c = interfaceC0005aeJ.K();
        this.i = youTubeApplication.f();
    }

    @Override // com.google.android.youtube.YouTubeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.browse_activity);
        Workspace.setTabRowToWorkspace(this, R.id.tabrow, R.id.workspace);
        this.e = Locale.getDefault().getCountry();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("category_label");
        this.f = intent.getStringExtra("category_term");
        this.g = new EnumMap(W.class);
        this.g.put(W.TOP_RATED, (ListView) findViewById(R.id.top_rated));
        this.g.put(W.TOP_FAVORITES, (ListView) findViewById(R.id.top_favorited));
        this.g.put(W.MOST_VIEWED, (ListView) findViewById(R.id.most_viewed));
        this.g.put(W.MOST_DISCUSSED, (ListView) findViewById(R.id.most_discussed));
        ViewOnClickListenerC0098k viewOnClickListenerC0098kC = c();
        viewOnClickListenerC0098kC.a(stringExtra);
        this.d = new ViewOnClickListenerC0111x(this, this, X.THIS_WEEK);
        this.d.a(viewOnClickListenerC0098kC.b(R.string.time_filter_this_week));
        this.h = new EnumMap(W.class);
        for (Map.Entry entry : this.g.entrySet()) {
            com.google.android.youtube.ui.G g = new com.google.android.youtube.ui.G(this, (ListView) entry.getValue(), this.a, this.c, this.b);
            g.a(this.i, ((W) entry.getKey()).g);
            this.h.put((Enum) entry.getKey(), g);
        }
        b(this.d.b());
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final Dialog a(int i) {
        switch (i) {
            case YouTubePlayer.PLAYING /* 2 */:
                return this.d.a();
            default:
                return null;
        }
    }

    private void b(X x) {
        for (W w : this.g.keySet()) {
            ((com.google.android.youtube.ui.G) this.h.get(w)).a(V.a(w, this.f, this.e, x));
        }
    }

    @Override // com.google.android.youtube.ui.InterfaceC0113z
    public final void a(X x) {
        b(x);
    }
}
