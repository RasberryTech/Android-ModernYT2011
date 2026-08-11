package com.google.android.youtube.player;

import android.content.Context;
import android.view.SurfaceView;

/* JADX INFO: loaded from: classes.dex */
final class f extends SurfaceView {
    private /* synthetic */ YouTubePlayer a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(YouTubePlayer youTubePlayer, Context context) {
        super(context);
        this.a = youTubePlayer;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x006b  */
    @Override // android.view.SurfaceView, android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(this.a.e, widthMeasureSpec);
        int height = getDefaultSize(this.a.f, heightMeasureSpec);

        // The original 2011 player letterboxed portrait video by measuring the
        // SurfaceView at the video's native aspect ratio. Modern Shorts are
        // portrait videos, so that behavior produces the unwanted
        // "phone-in-a-box" presentation. In fill mode the surface occupies
        // the entire player viewport. The parent remains responsible for
        // clipping, so the old player chrome/layout is untouched.
        if (this.a.fillsViewport()) {
            if (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED) {
                width = MeasureSpec.getSize(widthMeasureSpec);
            }
            if (MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.UNSPECIFIED) {
                height = MeasureSpec.getSize(heightMeasureSpec);
            }
            setMeasuredDimension(width, height);
            return;
        }

        if (this.a.e > 0 && this.a.f > 0) {
            if (this.a.e * height > this.a.f * width) {
                height = (this.a.f * width) / this.a.e;
            } else if (this.a.e * height < this.a.f * width) {
                width = (this.a.e * height) / this.a.f;
            }
        }
        setMeasuredDimension(width, height);
    }
}
