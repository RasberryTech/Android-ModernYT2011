package com.google.android.youtube;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
final class N implements DialogInterface.OnKeyListener {
    N(YouTubeActivity youTubeActivity) {
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 82 || i == 84;
    }
}
