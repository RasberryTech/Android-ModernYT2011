package com.google.android.youtube.player;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.youtube.R;
import defpackage.gp;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
public class BrandingOverlay extends ImageView implements View.OnClickListener {
    private final YouTubePlayer a;

    public BrandingOverlay(Context context, YouTubePlayer youTubePlayer) {
        super(context);
        this.a = (YouTubePlayer) gq.a(youTubePlayer, "player cannot be null");
        setImageResource(R.drawable.vevo_overlay);
        setOnClickListener(this);
        hide();
    }

    public void install() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        this.a.addView(this, layoutParams);
    }

    public void hide() {
        setVisibility(8);
    }

    public void show() {
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        gp.a(getContext(), Uri.parse("http://www.vevo.com"));
    }
}
