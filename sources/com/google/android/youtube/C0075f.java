package com.google.android.youtube;

import android.view.View;
import android.widget.AdapterView;
import defpackage.C0202fx;
import defpackage.C0233y;

/* JADX INFO: renamed from: com.google.android.youtube.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0075f implements AdapterView.OnItemClickListener {
    private /* synthetic */ C0233y a;
    private /* synthetic */ ChannelActivity b;

    C0075f(ChannelActivity channelActivity, C0233y c0233y) {
        this.b = channelActivity;
        this.a = c0233y;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0202fx c0202fx = (C0202fx) this.a.getItem(i);
        this.b.startActivity(PlaylistActivity.a(this.b, c0202fx.d, c0202fx.a, c0202fx.b, c0202fx.c, c0202fx.e, false));
    }
}
