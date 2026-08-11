package com.google.android.youtube.ui;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class C implements View.OnClickListener {
    private /* synthetic */ A a;

    C(A a) {
        this.a = a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.k != null && this.a.k.a(view, this.a.j)) {
            this.a.a();
        }
    }
}
