package com.google.android.youtube.player;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import android.widget.TextView;
import defpackage.fD;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
public class SubtitleOverlay extends TextView implements Handler.Callback {
    private final YouTubePlayer a;
    private fD b;

    public SubtitleOverlay(Context context, YouTubePlayer youTubePlayer) {
        super(context);
        this.a = (YouTubePlayer) gq.a(youTubePlayer, "player cannot be null");
        setBackgroundColor(-2013265920);
        setTextColor(-1);
        setIncludeFontPadding(false);
        setPadding(4, 4, 4, 4);
        setGravity(1);
        setTypeface(Typeface.DEFAULT_BOLD);
        setVisibility(8);
    }

    public void install() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = 16;
        this.a.addView(this, layoutParams);
        this.a.addListener(new Handler(this));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String strA;
        switch (message.what) {
            case YouTubePlayer.STOPPED /* 4 */:
            case YouTubePlayer.ENDED /* 6 */:
            case YouTubePlayer.ERROR /* 7 */:
                setVisibility(8);
                return true;
            case YouTubePlayer.PROGRESS /* 5 */:
                if (this.b != null && (strA = this.b.a(message.arg1)) != null) {
                    setText(strA);
                    setVisibility(0);
                    return true;
                }
                setVisibility(8);
                return true;
            default:
                return false;
        }
    }

    public void setSubtitle(fD fDVar) {
        this.b = fDVar;
    }

    public fD getSubtitle() {
        return this.b;
    }
}
