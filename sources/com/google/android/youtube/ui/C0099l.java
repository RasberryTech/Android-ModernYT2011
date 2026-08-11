package com.google.android.youtube.ui;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.Button;

/* JADX INFO: renamed from: com.google.android.youtube.ui.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0099l extends Button {
    private static final BlurMaskFilter[] c = new BlurMaskFilter[5];
    private final Paint a;
    private final Rect b;

    static {
        for (int i = 0; i < c.length; i++) {
            c[i] = new BlurMaskFilter((i << 1) + 1, BlurMaskFilter.Blur.SOLID);
        }
    }

    public C0099l(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new Rect();
        setTextColor(context.getResources().getColorStateList(com.google.android.youtube.R.color.header_text));
        this.a.setAntiAlias(true);
        this.a.setTextAlign(Paint.Align.LEFT);
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isFocused() || isSelected() || isPressed()) {
            String string = getText().toString();
            canvas.getClipBounds(this.b);
            this.a.setTextSize(getTextSize());
            this.a.setColor(-4111806);
            int totalPaddingLeft = this.b.left + getTotalPaddingLeft();
            int baseline = getBaseline();
            for (BlurMaskFilter blurMaskFilter : c) {
                this.a.setMaskFilter(blurMaskFilter);
                canvas.drawText(string, totalPaddingLeft, baseline, this.a);
            }
            this.a.setColor(-1);
            canvas.drawText(string, totalPaddingLeft, baseline, this.a);
        }
    }
}
