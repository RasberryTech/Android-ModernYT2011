package com.google.android.youtube.ui;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import defpackage.gq;

/* JADX INFO: renamed from: com.google.android.youtube.ui.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnClickListenerC0103p implements View.OnClickListener {
    protected View a;
    private final Context b;
    private final InterfaceC0104q c;
    private TextView d;
    private ProgressBar e;
    private Button f;
    private View g;

    protected abstract void c();

    protected abstract void d();

    /* synthetic */ AbstractViewOnClickListenerC0103p(Context context, InterfaceC0104q interfaceC0104q) {
        this(context, interfaceC0104q, (byte) 0);
    }

    public static AbstractViewOnClickListenerC0103p a(Context context, View view, InterfaceC0104q interfaceC0104q) {
        return new C0105r(context, view, interfaceC0104q);
    }

    public void a() {
        this.d = (TextView) this.a.findViewById(com.google.android.youtube.R.id.message);
        this.e = (ProgressBar) this.a.findViewById(com.google.android.youtube.R.id.progressbar);
        this.f = (Button) this.a.findViewById(com.google.android.youtube.R.id.retry);
        this.g = this.a.findViewById(com.google.android.youtube.R.id.error);
        this.f.setOnClickListener(this);
        d();
    }

    public final void b() {
        d();
    }

    public final void a(int i, boolean z) {
        String string = this.b.getString(com.google.android.youtube.R.string.loading);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        this.e.setVisibility(1 != 0 ? 0 : 8);
        this.d.setText(string);
        c();
    }

    public final void a(String str, boolean z) {
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.d.setText(str);
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.c.a_();
    }

    private AbstractViewOnClickListenerC0103p(Context context, InterfaceC0104q interfaceC0104q, byte b) {
        this.c = (InterfaceC0104q) gq.a(interfaceC0104q);
        this.b = (Context) gq.a(context);
    }
}
