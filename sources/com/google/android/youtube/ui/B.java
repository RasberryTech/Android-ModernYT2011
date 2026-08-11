package com.google.android.youtube.ui;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class B implements View.OnClickListener {
    private /* synthetic */ A a;

    B(A a) {
        this.a = a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        A.a(this.a, view);
    }
}
