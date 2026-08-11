package com.google.android.youtube.ui;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class R implements View.OnClickListener {
    private /* synthetic */ Q a;

    R(Q q) {
        this.a = q;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b.a.startActivity(new Intent("android.intent.action.VIEW", this.a.a.b));
    }
}
