package com.google.android.youtube.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;
import com.google.android.youtube.C0081l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class YouTubePlayer extends RelativeLayout {
    public static final float ASPECT_RATIO = 1.777f;
    public static final int ENDED = 6;
    public static final int ERROR = 7;
    public static final int PAUSED = 3;
    public static final int PLAYING = 2;
    public static final int PREPARED = 1;
    public static final int PROGRESS = 5;
    public static final int STOPPED = 4;
    private f a;
    private SurfaceHolder b;
    private MediaPlayer c;
    private g d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private Uri i;
    private int j;
    private boolean k;
    /** True when a portrait/Short-style video should fill the legacy player viewport. */
    private boolean lFillViewport;
    private e l;
    private ArrayList m;
    private h n;

    static /* synthetic */ void a(YouTubePlayer youTubePlayer, int i, int i2) {
        for (Handler handler : youTubePlayer.m) {
            handler.sendMessage(Message.obtain(handler, 7, i, i2));
        }
    }

    static /* synthetic */ void a(YouTubePlayer youTubePlayer, int i, int i2, int i3) {
        for (Handler handler : youTubePlayer.m) {
            handler.sendMessage(Message.obtain(handler, 5, i, i2, Integer.valueOf(i3)));
        }
    }

    static /* synthetic */ void a(YouTubePlayer youTubePlayer, Uri uri) {
        if (youTubePlayer.c == null || uri == null) {
            C0081l.b("Media Player null pointer preparing video " + youTubePlayer.c + " " + uri);
            youTubePlayer.a(new NullPointerException());
            return;
        }
        try {
            youTubePlayer.c.setDataSource(youTubePlayer.getContext(), uri);
            youTubePlayer.c.prepareAsync();
        } catch (IOException e) {
            C0081l.b("Media Player error preparing video", e);
            youTubePlayer.a(e);
        }
    }

    static /* synthetic */ boolean b(YouTubePlayer youTubePlayer, boolean z) {
        youTubePlayer.h = true;
        return true;
    }

    static /* synthetic */ Uri c(YouTubePlayer youTubePlayer, Uri uri) {
        youTubePlayer.i = null;
        return null;
    }

    static /* synthetic */ boolean c(YouTubePlayer youTubePlayer, boolean z) {
        youTubePlayer.g = true;
        return true;
    }

    public YouTubePlayer(Context context) {
        super(context);
        a(context);
    }

    public YouTubePlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        setKeepScreenOn(true);
        this.l = new e(this);
        this.m = new ArrayList(8);
        this.lFillViewport = false;
        this.n = new h(this);
        this.a = new f(this, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.a, layoutParams);
        this.b = this.a.getHolder();
        this.b.addCallback(this.l);
        this.b.setType(3);
        this.d = new g(this);
        this.d.start();
    }

    public void loadVideo(Uri uri, int i) {
        this.j = i;
        a(uri);
    }

    public void loadVideo(Uri uri) {
        loadVideo(uri, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri) {
        blockingStopVideo();
        if (!this.k) {
            this.i = uri;
            return;
        }
        this.c = new MediaPlayer();
        this.c.setDisplay(this.b);
        this.c.setAudioStreamType(3);
        this.c.setOnPreparedListener(this.l);
        this.c.setOnVideoSizeChangedListener(this.l);
        this.c.setOnBufferingUpdateListener(this.l);
        this.c.setOnCompletionListener(this.l);
        this.c.setOnErrorListener(this.l);
        this.d.a(uri);
    }

    public boolean isPlaying() {
        return this.c != null && this.c.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.c != null) {
            return this.c.getCurrentPosition();
        }
        return 0;
    }

    public void playVideo() {
        this.d.a();
    }

    public void blockingPlayVideo() {
        if (this.c != null && a()) {
            if (this.j != 0) {
                this.c.seekTo(this.j);
                this.j = 0;
            }
            this.c.start();
            a(2);
            this.n.sendEmptyMessage(5);
        }
    }

    public void pauseVideo() {
        this.d.b();
    }

    public void blockingPauseVideo() {
        if (this.c != null && a()) {
            this.c.pause();
            a(3);
        }
    }

    public void seekTo(int i) {
        this.d.a(i);
    }

    public void blockingSeekTo(int i) {
        if (this.c != null && a()) {
            this.c.seekTo(i);
        }
    }

    public void stopVideo() {
        this.d.c();
    }

    public void blockingStopVideo() {
        if (this.c != null) {
            this.n.removeMessages(5);
            a(4);
            this.c.release();
            this.c = null;
        }
        this.e = 0;
        this.f = 0;
        this.lFillViewport = false;
        this.g = false;
        this.h = false;
    }

    private boolean a() {
        return this.h && this.g;
    }

    /**
     * Enables the legacy full-viewport presentation used for portrait/Short-style videos.
     * The 2011 player chrome remains unchanged; only the video surface measurement changes.
     */
    void setFillViewport(boolean fill) {
        if (this.lFillViewport != fill) {
            this.lFillViewport = fill;
            this.a.requestLayout();
            requestLayout();
            invalidate();
        }
    }

    boolean fillsViewport() {
        return this.lFillViewport;
    }

    public void release() {
        this.d.d();
    }

    public void addListener(Handler handler) {
        this.m.add(handler);
    }

    public boolean removeListener(Handler handler) {
        return this.m.remove(handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((Handler) it.next()).sendEmptyMessage(i);
        }
    }

    private void a(Exception exc) {
        for (Handler handler : this.m) {
            handler.sendMessage(Message.obtain(handler, 7, exc));
        }
    }
}
