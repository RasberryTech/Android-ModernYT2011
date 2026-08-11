package com.google.android.youtube;

import android.content.Context;
import android.view.View;

/* JADX INFO: renamed from: com.google.android.youtube.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC0085p implements View.OnClickListener {
    private /* synthetic */ MyChannelActivity a;

    ViewOnClickListenerC0085p(MyChannelActivity myChannelActivity) {
        this.a = myChannelActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b("header: logout");
        this.a.n.a();
        this.a.startActivity(HomeActivity.a((Context) this.a));
    }
}
