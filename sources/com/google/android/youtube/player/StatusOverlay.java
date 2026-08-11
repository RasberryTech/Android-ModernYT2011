package com.google.android.youtube.player;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.youtube.R;
import defpackage.gq;
import defpackage.gv;

/* JADX INFO: loaded from: classes.dex */
public class StatusOverlay extends FrameLayout implements Handler.Callback {
    private final YouTubePlayer a;
    private final ProgressBar b;
    private final TextView c;
    private final ImageView d;
    private final ImageView e;
    private final View.OnClickListener f;
    private View g;

    public StatusOverlay(Context context, YouTubePlayer youTubePlayer, View.OnClickListener onClickListener) {
        super(context);
        this.a = (YouTubePlayer) gq.a(youTubePlayer, "player cannot be null");
        this.f = onClickListener;
        setPadding(4, 4, 4, 4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.b = new ProgressBar(context);
        this.b.setIndeterminate(true);
        addView(this.b, layoutParams);
        this.c = new TextView(context);
        this.c.setGravity(17);
        addView(this.c, layoutParams);
        this.d = new ImageView(context);
        this.d.setImageResource(R.drawable.player_replay);
        this.d.setFocusable(true);
        this.d.setClickable(true);
        this.d.setOnClickListener((View.OnClickListener) gq.a(onClickListener, "replayListener cannot be null"));
        addView(this.d, layoutParams);
        this.e = new ImageView(context);
        this.e.setImageResource(R.drawable.player_osd_paused);
        addView(this.e, layoutParams);
        a(this.b);
    }

    public void install() {
        this.a.addView(this, new RelativeLayout.LayoutParams(-1, -1));
        this.a.addListener(new Handler(this));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case YouTubePlayer.PLAYING /* 2 */:
                a(null);
                return true;
            case YouTubePlayer.PAUSED /* 3 */:
                a(this.e);
                return true;
            case YouTubePlayer.STOPPED /* 4 */:
            case YouTubePlayer.PROGRESS /* 5 */:
            case YouTubePlayer.ENDED /* 6 */:
            default:
                return false;
            case YouTubePlayer.ERROR /* 7 */:
                if (!gv.a(getContext())) {
                    showErrorMessage(R.string.no_network, true);
                } else {
                    showErrorMessage(R.string.problem_while_playing, true);
                }
                return true;
        }
    }

    private void a(View view) {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.g = view;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (this.g != null) {
            int measuredWidth = this.g.getMeasuredWidth();
            int measuredHeight = this.g.getMeasuredHeight();
            if (this.g == this.e) {
                i6 = i2;
                i5 = i;
            } else {
                i5 = ((i3 - i) - measuredWidth) / 2;
                i6 = ((i4 - i2) - measuredHeight) / 2;
            }
            this.g.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    public void showLoading() {
        a(this.b);
    }

    public void showReplay() {
        a(this.d);
    }

    public void showErrorMessage(int i, boolean z) {
        this.c.setText(getContext().getString(i));
        this.c.setOnClickListener(z ? this.f : null);
        a(this.c);
    }

    public void showErrorMessage(int i) {
        showErrorMessage(i, false);
    }

    public void hide() {
        a(null);
    }
}
