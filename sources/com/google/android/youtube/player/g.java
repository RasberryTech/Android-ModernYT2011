package com.google.android.youtube.player;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class g extends Thread implements Handler.Callback {
    private Handler a;
    private /* synthetic */ YouTubePlayer b;

    /* synthetic */ g(YouTubePlayer youTubePlayer) {
        this(youTubePlayer, (byte) 0);
    }

    private g(YouTubePlayer youTubePlayer, byte b) {
        this.b = youTubePlayer;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Looper.prepare();
        this.a = new Handler(this);
        Looper.loop();
    }

    public final void a(Uri uri) {
        this.a.sendMessage(Message.obtain(this.a, 1, uri));
    }

    public final void a() {
        this.a.sendEmptyMessage(2);
    }

    public final void b() {
        this.a.sendEmptyMessage(3);
    }

    public final void a(int i) {
        this.a.sendMessage(Message.obtain(this.a, 4, i, 0));
    }

    public final void c() {
        this.a.sendEmptyMessage(5);
    }

    public final void d() {
        this.a.sendEmptyMessage(6);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case YouTubePlayer.PREPARED /* 1 */:
                YouTubePlayer.a(this.b, (Uri) message.obj);
                return true;
            case YouTubePlayer.PLAYING /* 2 */:
                this.b.blockingPlayVideo();
                return true;
            case YouTubePlayer.PAUSED /* 3 */:
                this.b.blockingPauseVideo();
                return true;
            case YouTubePlayer.STOPPED /* 4 */:
                this.b.blockingSeekTo(message.arg1);
                return true;
            case YouTubePlayer.PROGRESS /* 5 */:
                this.b.blockingStopVideo();
                return true;
            case YouTubePlayer.ENDED /* 6 */:
                this.b.blockingStopVideo();
                Looper.myLooper().quit();
                this.a.removeCallbacksAndMessages(null);
                return true;
            default:
                return false;
        }
    }
}
