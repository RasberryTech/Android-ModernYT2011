package com.google.android.youtube;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.View;
import defpackage.EnumC0215gj;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
final class x implements View.OnClickListener {
    private /* synthetic */ PlaylistActivity a;

    x(PlaylistActivity playlistActivity) {
        this.a = playlistActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.j.a(EnumC0215gj.PLAYLIST_PLAY_ALL, 0);
        Uri data = this.a.getIntent().getData();
        PlaylistActivity playlistActivity = this.a;
        PlaylistActivity playlistActivity2 = this.a;
        playlistActivity.startActivity(new Intent(playlistActivity2, (Class<?>) WatchActivity.class).putExtra("playlist_uri", (Parcelable) gq.a(data)).putExtra("authenticate", this.a.k));
    }
}
