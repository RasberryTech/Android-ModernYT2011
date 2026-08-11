package com.google.android.youtube.ui;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import defpackage.gq;

/* JADX INFO: renamed from: com.google.android.youtube.ui.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0088a implements View.OnClickListener {
    private final InterfaceC0104q a;
    private final View b;
    private final BaseAdapter c;
    private TextView d;
    private ProgressBar e;
    private Button f;
    private View g;

    public ViewOnClickListenerC0088a(View view, BaseAdapter baseAdapter, InterfaceC0104q interfaceC0104q) {
        this.b = (View) gq.a(view, "view may not be null");
        this.c = (BaseAdapter) gq.a(baseAdapter, "adapter may not be null");
        this.a = (InterfaceC0104q) gq.a(interfaceC0104q, "retryListener may not be null");
        this.d = (TextView) gq.a((TextView) view.findViewById(com.google.android.youtube.R.id.message));
        this.e = (ProgressBar) gq.a((ProgressBar) view.findViewById(com.google.android.youtube.R.id.progressbar));
        this.f = (Button) gq.a((Button) view.findViewById(com.google.android.youtube.R.id.retry));
        this.g = (View) gq.a(view.findViewById(com.google.android.youtube.R.id.error));
        this.f.setOnClickListener(this);
        a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a_();
    }

    public final void a() {
        this.b.setVisibility(8);
        this.c.notifyDataSetChanged();
    }

    private void b() {
        this.b.setVisibility(0);
        this.c.notifyDataSetChanged();
    }

    public final void a(String str, boolean z) {
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        this.e.setVisibility(z ? 0 : 8);
        this.d.setText(str);
        b();
        this.c.notifyDataSetChanged();
    }

    public final void b(String str, boolean z) {
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.d.setText(str);
        b();
        this.c.notifyDataSetChanged();
    }
}
