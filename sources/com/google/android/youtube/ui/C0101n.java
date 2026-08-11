package com.google.android.youtube.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* JADX INFO: renamed from: com.google.android.youtube.ui.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0101n {
    private final Context a;
    private final SharedPreferences b;
    private final int c;

    public C0101n(Context context) {
        this.a = context;
        this.b = context.getSharedPreferences("youtube", 0);
        this.c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public final void a() {
        a("promo_tabs", com.google.android.youtube.R.string.promo_tabs, com.google.android.youtube.R.drawable.promo_flick, EnumC0102o.BOTTOM);
    }

    public final void b() {
        a("promo_fullscreen", com.google.android.youtube.R.string.promo_fullscreen, com.google.android.youtube.R.drawable.promo_rotate, EnumC0102o.TOP);
    }

    public final void c() {
        a("promo_playlist", com.google.android.youtube.R.string.promo_playlist, com.google.android.youtube.R.drawable.promo_flick, EnumC0102o.TOP);
    }

    public final void d() {
        a("promo_music", com.google.android.youtube.R.string.promo_music, com.google.android.youtube.R.drawable.ic_music, EnumC0102o.CENTER);
    }

    private void a(String str, int i, int i2, EnumC0102o enumC0102o) {
        if (!this.b.getBoolean(str, false)) {
            Toast toast = new Toast(this.a);
            View viewInflate = LayoutInflater.from(this.a).inflate(com.google.android.youtube.R.layout.promo, (ViewGroup) null);
            ((ImageView) viewInflate.findViewById(com.google.android.youtube.R.id.icon)).setImageResource(i2);
            ((TextView) viewInflate.findViewById(com.google.android.youtube.R.id.message)).setText(i);
            toast.setView(viewInflate);
            toast.setDuration(1);
            toast.setGravity(48, 0, (enumC0102o.d * this.c) / 100);
            toast.show();
            this.b.edit().putBoolean(str, true).commit();
        }
    }
}
