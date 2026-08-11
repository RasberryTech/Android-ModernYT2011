package com.google.android.youtube.ui;

import android.content.Context;
import android.view.View;

/* JADX INFO: renamed from: com.google.android.youtube.ui.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0105r extends AbstractViewOnClickListenerC0103p {
    /* synthetic */ C0105r(Context context, View view, InterfaceC0104q interfaceC0104q) {
        this(context, view, interfaceC0104q, (byte) 0);
    }

    private C0105r(Context context, View view, InterfaceC0104q interfaceC0104q, byte b) {
        super(context, interfaceC0104q);
        this.a = view;
    }

    @Override // com.google.android.youtube.ui.AbstractViewOnClickListenerC0103p
    protected final void c() {
        this.a.setVisibility(0);
    }

    @Override // com.google.android.youtube.ui.AbstractViewOnClickListenerC0103p
    protected final void d() {
        this.a.setVisibility(8);
    }

    @Override // com.google.android.youtube.ui.AbstractViewOnClickListenerC0103p
    public final void a() {
        super.a();
        d();
    }
}
