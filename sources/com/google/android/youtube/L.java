package com.google.android.youtube;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
final class L implements DialogInterface.OnClickListener {
    private /* synthetic */ YouTubeActivity a;

    L(YouTubeActivity youTubeActivity) {
        this.a = youTubeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.finish();
    }
}
