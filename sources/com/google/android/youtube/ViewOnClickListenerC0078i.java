package com.google.android.youtube;

import android.view.View;
import defpackage.gp;

/* JADX INFO: renamed from: com.google.android.youtube.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC0078i implements View.OnClickListener {
    private /* synthetic */ HomeActivity a;

    ViewOnClickListenerC0078i(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b("header: quick record");
        gp.b(this.a);
    }
}
