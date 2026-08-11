package com.google.android.youtube.player;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.youtube.R;
import defpackage.fK;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
public final class AdOverlay extends LinearLayout implements View.OnClickListener {
    private final YouTubePlayer a;
    private final TextView b;
    private final TextView c;
    private final a d;

    public AdOverlay(Context context, YouTubePlayer youTubePlayer, a aVar) {
        super(context);
        this.a = (YouTubePlayer) gq.a(youTubePlayer, "player cannot be null");
        this.d = aVar;
        this.b = new TextView(context);
        this.b.setTextColor(-3355444);
        this.b.setIncludeFontPadding(false);
        this.b.setGravity(3);
        this.b.setText(context.getString(R.string.advertisement));
        addView(this.b, new LinearLayout.LayoutParams(-2, -2));
        this.c = new TextView(context);
        this.c.setTextColor(-3355444);
        this.c.setIncludeFontPadding(false);
        this.c.setGravity(5);
        addView(this.c, new LinearLayout.LayoutParams(-1, -2));
        setBackgroundColor(-2013265920);
        setPadding(4, 4, 4, 4);
        setVisibility(8);
        setOnClickListener(this);
    }

    public final void install() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.a.addView(this, layoutParams);
    }

    public final void setAd(fK fKVar) {
        gq.a(fKVar);
        this.c.setText(fKVar.h != null ? fKVar.h.getAuthority() : null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.d != null) {
            this.d.h();
        }
    }
}
