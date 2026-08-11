package com.google.android.youtube;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
final class K implements DialogInterface.OnCancelListener {
    private /* synthetic */ YouTubeActivity a;

    K(YouTubeActivity youTubeActivity) {
        this.a = youTubeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
