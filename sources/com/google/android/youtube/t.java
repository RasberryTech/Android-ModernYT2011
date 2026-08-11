package com.google.android.youtube;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.google.android.youtube.player.YouTubePlayer;
import defpackage.C0204fz;

/* JADX INFO: loaded from: classes.dex */
final class t implements AdapterView.OnItemClickListener {
    private /* synthetic */ defpackage.A a;
    private /* synthetic */ MyChannelActivity b;

    t(MyChannelActivity myChannelActivity, defpackage.A a) {
        this.b = myChannelActivity;
        this.a = a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intentA;
        C0204fz c0204fz = (C0204fz) this.a.getItem(i);
        switch (w.a[c0204fz.b.ordinal()]) {
            case YouTubePlayer.PREPARED /* 1 */:
                intentA = ChannelActivity.a(this.b, c0204fz.a, R.id.uploads, c0204fz.d);
                break;
            case YouTubePlayer.PLAYING /* 2 */:
                intentA = ChannelActivity.a(this.b, c0204fz.a, R.id.favorites, c0204fz.d);
                break;
            case YouTubePlayer.PAUSED /* 3 */:
                MyChannelActivity myChannelActivity = this.b;
                intentA = new Intent(myChannelActivity, (Class<?>) PlaylistActivity.class).setData(c0204fz.c).putExtra("playlist_title", c0204fz.a).putExtra("authenticate", false);
                break;
            case YouTubePlayer.STOPPED /* 4 */:
                intentA = new Intent(this.b, (Class<?>) ResultsActivity.class).putExtra("query", c0204fz.a);
                break;
            case YouTubePlayer.PROGRESS /* 5 */:
                intentA = ChannelActivity.a(this.b, c0204fz.a, R.id.activity, c0204fz.d);
                break;
            default:
                intentA = null;
                break;
        }
        if (intentA != null) {
            this.b.startActivity(intentA);
        }
    }
}
