package com.google.android.youtube.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubePlayer;

/* JADX INFO: loaded from: classes.dex */
public final class A {
    private final Activity a;
    private final int b = 12;
    private final Dialog c;
    private final View.OnClickListener d;
    private final View.OnClickListener e;
    private final Resources f;
    private final LayoutInflater g;
    private final LinearLayout h;
    private final F i;
    private Object j;
    private E k;

    static /* synthetic */ void a(A a, View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        WindowManager.LayoutParams attributes = a.c.getWindow().getAttributes();
        switch (D.a[a.i.ordinal()]) {
            case YouTubePlayer.PREPARED /* 1 */:
                attributes.y = rect.bottom - view.getPaddingBottom();
                break;
            case YouTubePlayer.PLAYING /* 2 */:
                attributes.y = rect.top;
                break;
        }
        a.j = view.getTag();
        a.c.getWindow().setAttributes(attributes);
        a.a.showDialog(a.b);
    }

    public A(Activity activity, int i, F f) {
        this.a = activity;
        this.i = f;
        this.g = activity.getLayoutInflater();
        this.f = activity.getResources();
        this.c = new Dialog(activity, com.google.android.youtube.R.style.Toolbar);
        this.c.setCanceledOnTouchOutside(true);
        this.c.setContentView(com.google.android.youtube.R.layout.toolbar_layout);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.gravity = 51;
        attributes.width = -1;
        attributes.height = -2;
        attributes.windowAnimations = android.R.style.Animation.Dialog;
        attributes.flags = 768;
        this.c.getWindow().setAttributes(attributes);
        this.e = new B(this);
        this.d = new C(this);
        this.h = (LinearLayout) this.c.findViewById(com.google.android.youtube.R.id.toolbar_layout);
    }

    public final void a(View view, Object obj) {
        view.setOnClickListener(this.e);
        view.setTag(obj);
    }

    public final View a(String str, Drawable drawable) {
        ViewGroup viewGroup = (ViewGroup) this.g.inflate(com.google.android.youtube.R.layout.toolbar_item, (ViewGroup) this.h, false);
        this.h.addView(viewGroup);
        int childCount = this.h.getChildCount();
        if (childCount == 1) {
            this.h.setWeightSum(3.0f);
        } else if (childCount <= 3) {
            this.h.setWeightSum(childCount + 2);
        } else {
            this.h.setWeightSum(childCount);
        }
        viewGroup.setOnClickListener(this.d);
        if (drawable != null) {
            ((ImageView) viewGroup.findViewById(com.google.android.youtube.R.id.icon)).setImageDrawable(drawable);
        }
        if (str != null) {
            ((TextView) viewGroup.findViewById(com.google.android.youtube.R.id.text)).setText(str);
        }
        return viewGroup;
    }

    public final View a(int i, int i2) {
        return a(this.f.getString(i), this.f.getDrawable(i2));
    }

    public final void a(View view, int i) {
        ((TextView) ((ViewGroup) view).getChildAt(1)).setText(this.f.getString(i));
    }

    public final void b(View view, int i) {
        ((ImageView) ((ViewGroup) view).getChildAt(0)).setImageDrawable(this.f.getDrawable(i));
    }

    public final void a(E e) {
        this.k = e;
    }

    public final void a() {
        this.j = null;
        this.c.dismiss();
    }

    public final Dialog b() {
        return this.c;
    }
}
