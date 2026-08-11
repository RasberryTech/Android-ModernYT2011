package com.google.android.youtube;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
final class M implements DialogInterface.OnClickListener {
    private /* synthetic */ YouTubeActivity a;

    M(YouTubeActivity youTubeActivity) {
        this.a = youTubeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.b();
    }
}
