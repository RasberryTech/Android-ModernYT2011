package com.google.android.youtube;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.youtube.ui.C0093f;
import defpackage.C0013am;
import defpackage.C0210ge;
import defpackage.EnumC0215gj;
import defpackage.InterfaceC0004ad;
import defpackage.InterfaceC0005ae;
import defpackage.InterfaceC0021au;
import defpackage.U;
import defpackage.fH;

/* JADX INFO: loaded from: classes.dex */
public class PlaylistActivity extends YouTubeActivity implements InterfaceC0021au {
    private InterfaceC0004ad a;
    private InterfaceC0004ad b;
    private InterfaceC0004ad c;
    private InterfaceC0004ad d;
    private C0013am e;
    private com.google.android.youtube.ui.G f;
    private TextView g;
    private TextView h;
    private TextView i;
    private C0210ge j;
    private boolean k;
    private Uri l;
    private Button m;

    public static Intent a(Context context, Uri uri, String str, String str2, String str3, int i, boolean z) {
        return new Intent(context, (Class<?>) PlaylistActivity.class).setData(uri).putExtra("playlist_title", str).putExtra("playlist_description", str2).putExtra("playlist_author", str3).putExtra("playlist_size", i).putExtra("authenticate", z);
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final void a(YouTubeApplication youTubeApplication) {
        super.a(youTubeApplication);
        InterfaceC0005ae interfaceC0005aeJ = youTubeApplication.j();
        this.b = interfaceC0005aeJ.A();
        this.c = interfaceC0005aeJ.B();
        this.a = interfaceC0005aeJ.e();
        this.d = interfaceC0005aeJ.K();
        this.e = youTubeApplication.k();
        this.j = youTubeApplication.f();
    }

    @Override // com.google.android.youtube.YouTubeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.playlist_activity);
        Intent intent = getIntent();
        this.l = intent.getData();
        this.k = intent.getBooleanExtra("authenticate", false);
        this.g = (TextView) findViewById(R.id.header_title);
        this.g.setText(intent.getStringExtra("playlist_title"));
        this.g.setVisibility(0);
        this.h = (TextView) findViewById(R.id.playlist_summary);
        String stringExtra = intent.getStringExtra("playlist_description");
        this.h.setText(stringExtra);
        this.h.setVisibility(TextUtils.isEmpty(stringExtra) ? 8 : 0);
        this.i = (TextView) findViewById(R.id.playlist_details);
        String stringExtra2 = intent.getStringExtra("playlist_author");
        int intExtra = intent.getIntExtra("playlist_size", 0);
        if (stringExtra2 != null) {
            if (intExtra == 0) {
                this.i.setText(getString(R.string.playlist_details_without_videos, new Object[]{stringExtra2}));
            } else if (intExtra == 1) {
                this.i.setText(getString(R.string.playlist_details_with_one_video, new Object[]{stringExtra2}));
            } else {
                this.i.setText(getString(R.string.playlist_details_with_several_videos, new Object[]{stringExtra2, Integer.valueOf(intExtra)}));
            }
        }
        this.i.setVisibility(stringExtra2 != null ? 0 : 8);
        this.f = new com.google.android.youtube.ui.G(this, (ListView) findViewById(R.id.playlist), this.k ? this.c : this.b, this.d, this.a, true);
        this.f.a(this.j, EnumC0215gj.PLAYLIST);
        this.m = c().b(R.string.playlist_play_all);
        this.m.setVisibility(intExtra > 0 ? 0 : 8);
        this.m.setOnClickListener(new x(this));
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f.b();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.k) {
            this.e.a(this, this);
        } else {
            this.f.a(U.a(this.l));
        }
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.f.a(U.a(this.l, fHVar.b));
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(Exception exc) {
        C0093f.b(this, exc);
        finish();
    }

    @Override // defpackage.InterfaceC0021au
    public final void a() {
        finish();
    }
}
