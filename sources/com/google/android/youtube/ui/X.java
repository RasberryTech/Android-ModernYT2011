package com.google.android.youtube.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.google.android.youtube.WatchActivity;
import defpackage.C0189fk;
import defpackage.EnumC0215gj;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
final class X implements AdapterView.OnItemClickListener {
    private /* synthetic */ S a;

    /* synthetic */ X(S s) {
        this(s, (byte) 0);
    }

    private X(S s, byte b) {
        this.a = s;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0189fk c0189fk = (C0189fk) adapterView.getAdapter().getItem(i);
        this.a.b.a(EnumC0215gj.MUSIC_ARTIST, i);
        this.a.a.startActivity(new Intent(this.a.a, (Class<?>) WatchActivity.class).putExtra("artist_id", (String) gq.a((Object) c0189fk.a)));
    }
}
