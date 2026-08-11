package com.google.android.youtube;

import android.net.Uri;
import android.widget.Toast;
import com.google.android.youtube.ui.C0093f;

/* JADX INFO: renamed from: com.google.android.youtube.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0077h implements defpackage.I {
    private /* synthetic */ ChannelActivity a;

    /* synthetic */ C0077h(ChannelActivity channelActivity) {
        this(channelActivity, (byte) 0);
    }

    private C0077h(ChannelActivity channelActivity, byte b) {
        this.a = channelActivity;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0093f.b(this.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        Toast.makeText(this.a, R.string.unsubscribed, 1).show();
        ChannelActivity.a(this.a, (Uri) null);
        this.a.a();
    }
}
