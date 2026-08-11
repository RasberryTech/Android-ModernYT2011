package com.google.android.youtube.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.youtube.HomeActivity;

/* JADX INFO: renamed from: com.google.android.youtube.ui.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0098k implements View.OnClickListener {
    private final Activity a;
    private final Resources b;
    private final TextView c;
    private final ViewGroup d;
    private final int e;
    private final int f;

    public ViewOnClickListenerC0098k(Activity activity) {
        this.a = activity;
        this.b = activity.getResources();
        this.c = (TextView) activity.findViewById(com.google.android.youtube.R.id.header_title);
        this.d = (ViewGroup) activity.findViewById(com.google.android.youtube.R.id.header_buttons);
        this.e = this.b.getDimensionPixelSize(com.google.android.youtube.R.dimen.header_height);
        this.f = this.b.getDimensionPixelSize(com.google.android.youtube.R.dimen.header_text_horizontal_padding);
        activity.findViewById(com.google.android.youtube.R.id.header_logo).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!(this.a instanceof HomeActivity)) {
            this.a.startActivity(HomeActivity.a(this.a));
        }
    }

    public final void a(String str) {
        this.c.setText(str);
        this.c.setVisibility(0);
    }

    public final ImageButton a(int i) {
        Drawable drawable = this.b.getDrawable(i);
        ImageButton imageButton = new ImageButton(this.a);
        imageButton.setImageDrawable(drawable);
        imageButton.setScaleType(ImageView.ScaleType.CENTER);
        imageButton.setBackgroundDrawable(null);
        a(imageButton, this.e);
        return imageButton;
    }

    public final Button b(String str) {
        C0099l c0099l = new C0099l(this.a);
        c0099l.setText(str);
        c0099l.setBackgroundDrawable(null);
        c0099l.setPadding(this.f, 0, this.f, 0);
        c0099l.setEllipsize(TextUtils.TruncateAt.END);
        c0099l.setMaxLines(1);
        a(c0099l, -2);
        return c0099l;
    }

    public final Button b(int i) {
        return b(this.b.getString(i));
    }

    public final Button a(int i, int i2) {
        Drawable drawable = this.b.getDrawable(com.google.android.youtube.R.drawable.more_drawable);
        Button buttonB = b(this.b.getString(com.google.android.youtube.R.string.header_more));
        buttonB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        buttonB.setPadding(0, 0, this.f, 0);
        return buttonB;
    }

    private void a(View view, int i) {
        ImageView imageView = new ImageView(this.a);
        imageView.setImageResource(com.google.android.youtube.R.drawable.header_divider);
        imageView.setBackgroundDrawable(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.d.addView(imageView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, this.e);
        layoutParams2.gravity = 17;
        this.d.addView(view, layoutParams2);
    }
}
