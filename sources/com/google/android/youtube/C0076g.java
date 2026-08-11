package com.google.android.youtube;

import android.widget.Toast;
import com.google.android.youtube.ui.C0093f;
import org.apache.http.client.HttpResponseException;

/* JADX INFO: renamed from: com.google.android.youtube.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0076g implements defpackage.I {
    private final String a;
    private /* synthetic */ ChannelActivity b;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        if ((exc instanceof HttpResponseException) && ((HttpResponseException) exc).getStatusCode() == 400) {
            Toast.makeText(this.b, this.b.getString(R.string.already_subscribed), 1).show();
        } else {
            this.b.removeDialog(11);
            C0093f.b(this.b, exc);
        }
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        Toast.makeText(this.b, this.a, 1).show();
        this.b.a();
    }

    public C0076g(ChannelActivity channelActivity, String str) {
        this.b = channelActivity;
        this.a = str;
    }
}
