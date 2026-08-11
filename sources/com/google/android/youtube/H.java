package com.google.android.youtube;

import android.os.Handler;
import android.os.Message;
import com.google.android.youtube.player.YouTubePlayer;

/* JADX INFO: loaded from: classes.dex */
final class H extends Handler {
    private boolean a;
    private /* synthetic */ D b;

    H(D d) {
        this.b = d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (!this.a) {
            switch (message.what) {
                case YouTubePlayer.PREPARED /* 1 */:
                case YouTubePlayer.PLAYING /* 2 */:
                    this.a = true;
                    break;
                default:
            }
        } else {
            switch (message.what) {
                case YouTubePlayer.STOPPED /* 4 */:
                case YouTubePlayer.ENDED /* 6 */:
                case YouTubePlayer.ERROR /* 7 */:
                    this.a = false;
                    break;
            }
        }
        if (this.b.e) {
            switch (message.what) {
                case YouTubePlayer.STOPPED /* 4 */:
                case YouTubePlayer.ENDED /* 6 */:
                case YouTubePlayer.ERROR /* 7 */:
                    D.a(this.b, message.what == 4);
                    break;
            }
        } else {
            switch (message.what) {
                case YouTubePlayer.ENDED /* 6 */:
                    D.b(this.b);
                    break;
            }
        }
    }
}
