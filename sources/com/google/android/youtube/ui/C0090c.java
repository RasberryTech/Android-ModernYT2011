package com.google.android.youtube.ui;

import android.app.Activity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.youtube.C0081l;
import defpackage.InterfaceC0004ad;
import defpackage.fH;
import defpackage.fJ;
import defpackage.gq;
import org.apache.http.client.HttpResponseException;

/* JADX INFO: renamed from: com.google.android.youtube.ui.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0090c implements defpackage.I {
    private final Activity a;
    private final InterfaceC0004ad b;
    private final InterfaceC0004ad c;
    private final C0091d d = new C0091d(this);
    private final ImageView e;
    private final TextView f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final TextView j;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error retrieving user profile", exc);
        if (!(exc instanceof HttpResponseException) || ((HttpResponseException) exc).getStatusCode() != 403) {
            C0093f.b(this.a, exc);
        } else {
            Activity activity = this.a;
            Toast.makeText(activity, activity.getString(com.google.android.youtube.R.string.channel_not_public), 1).show();
        }
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        fJ fJVar = (fJ) obj2;
        this.f.setText(fJVar.a);
        this.g.setText(Html.fromHtml(this.a.getString(com.google.android.youtube.R.string.channel_stats_views, new Object[]{Integer.valueOf(fJVar.e)})));
        this.h.setText(Html.fromHtml(this.a.getString(com.google.android.youtube.R.string.channel_stats_uploaded, new Object[]{Integer.valueOf(fJVar.d)})));
        if (this.i != null) {
            this.i.setText(Html.fromHtml(this.a.getString(com.google.android.youtube.R.string.channel_stats_subscribers, new Object[]{Integer.valueOf(fJVar.g)})));
        }
        if (this.j != null) {
            this.j.setText(Html.fromHtml(this.a.getString(com.google.android.youtube.R.string.channel_stats_subscriptions, new Object[]{Integer.valueOf(fJVar.f)})));
        }
        this.c.a(fJVar.c, new defpackage.E(this.a, this.d));
    }

    public C0090c(Activity activity, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2) {
        this.a = (Activity) gq.a(activity);
        this.c = (InterfaceC0004ad) gq.a(interfaceC0004ad2);
        this.b = (InterfaceC0004ad) gq.a(interfaceC0004ad);
        this.e = (ImageView) activity.findViewById(com.google.android.youtube.R.id.channel_avatar);
        this.f = (TextView) activity.findViewById(com.google.android.youtube.R.id.channel_title);
        this.g = (TextView) activity.findViewById(com.google.android.youtube.R.id.channel_views);
        this.h = (TextView) activity.findViewById(com.google.android.youtube.R.id.channel_uploaded);
        this.i = (TextView) activity.findViewById(com.google.android.youtube.R.id.channel_subscribers);
        this.j = (TextView) activity.findViewById(com.google.android.youtube.R.id.channel_subscriptions);
    }

    public final void a(String str) {
        gq.a(str);
        this.f.setText(str);
        this.b.a(defpackage.V.c(str), new defpackage.E(this.a, this));
    }

    public final void a(fH fHVar) {
        gq.a(fHVar);
        this.f.setText(fHVar.c);
        this.b.a(defpackage.V.b(fHVar), new defpackage.E(this.a, this));
    }
}
