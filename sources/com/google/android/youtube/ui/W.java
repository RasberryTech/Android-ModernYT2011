package com.google.android.youtube.ui;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.youtube.WatchActivity;
import defpackage.C0199fu;
import defpackage.EnumC0215gj;

/* JADX INFO: loaded from: classes.dex */
final class W implements AdapterView.OnItemClickListener {
    private /* synthetic */ S a;

    /* synthetic */ W(S s) {
        this(s, (byte) 0);
    }

    private W(S s, byte b) {
        this.a = s;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0199fu c0199fu = (C0199fu) adapterView.getAdapter().getItem(i);
        this.a.b.a(EnumC0215gj.MUSIC_ARTIST_TRACKS, i);
        this.a.a.startActivity(WatchActivity.a(this.a.a, c0199fu.a));
    }
}
