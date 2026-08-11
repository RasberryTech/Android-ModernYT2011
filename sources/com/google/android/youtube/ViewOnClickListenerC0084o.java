package com.google.android.youtube;

import android.app.Activity;
import android.view.View;
import defpackage.gp;

/* JADX INFO: renamed from: com.google.android.youtube.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC0084o implements View.OnClickListener {
    private /* synthetic */ MyChannelActivity a;

    ViewOnClickListenerC0084o(MyChannelActivity myChannelActivity) {
        this.a = myChannelActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b("header: upload");
        gp.a((Activity) this.a);
    }
}
