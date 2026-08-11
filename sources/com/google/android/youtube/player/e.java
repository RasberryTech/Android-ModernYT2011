package com.google.android.youtube.player;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import com.google.android.youtube.C0081l;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
final class e implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback {
    private /* synthetic */ YouTubePlayer a;

    /* synthetic */ e(YouTubePlayer youTubePlayer) {
        this(youTubePlayer, (byte) 0);
    }

    private e(YouTubePlayer youTubePlayer, byte b) {
        this.a = youTubePlayer;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.a.k = true;
        if (this.a.i != null) {
            this.a.a(this.a.i);
            YouTubePlayer.c(this.a, (Uri) null);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.a.k = false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        YouTubePlayer.b(this.a, true);
        this.a.a(1);
        this.a.playVideo();
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        gq.a(i > 0, "video width must be positive " + i);
        gq.a(i2 > 0, "video height must be positive " + i2);
        this.a.e = i;
        this.a.f = i2;
        // Shorts/portrait videos get the full legacy player viewport instead
        // of being rendered as a narrow phone-shaped surface with side bars.
        // A portrait source is a Short-style presentation.  Keep the
        // original 2011 chrome, but let the SurfaceView occupy the entire
        // player viewport instead of rendering a narrow "phone" surface.
        boolean portrait = i2 > i && ((float) i2 / (float) i) >= 1.20f;
        this.a.setFillViewport(portrait);
        YouTubePlayer.c(this.a, true);
        if (portrait) {
            // The SurfaceView is measured to the available player bounds.
            // Do not lock it to the portrait source dimensions; doing so is
            // what creates the old boxed/side-bar presentation.
            this.a.b.setFixedSize(this.a.getWidth() > 0 ? this.a.getWidth() : i,
                    this.a.getHeight() > 0 ? this.a.getHeight() : i2);
        } else {
            this.a.b.setFixedSize(i, i2);
        }
        this.a.playVideo();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        int i2 = this.a.n.a;
        this.a.n.a = (i <= 90 || !(i2 == i || i2 == 100)) ? i : 100;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.a.n.removeMessages(5);
        int duration = mediaPlayer.getDuration();
        YouTubePlayer.a(this.a, duration, 100, duration);
        this.a.a(6);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        C0081l.a("media player error " + i + " " + i2);
        this.a.n.removeMessages(5);
        YouTubePlayer.a(this.a, i, i2);
        return true;
    }
}
