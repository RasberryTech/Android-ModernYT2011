package com.google.android.youtube;

import android.view.View;
import defpackage.InterfaceC0021au;

/* JADX INFO: renamed from: com.google.android.youtube.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC0074e implements View.OnClickListener {
    private /* synthetic */ InterfaceC0021au a;
    private /* synthetic */ ChannelActivity b;

    ViewOnClickListenerC0074e(ChannelActivity channelActivity, InterfaceC0021au interfaceC0021au) {
        this.b = channelActivity;
        this.a = interfaceC0021au;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.r.a(this.b, this.a);
    }
}
