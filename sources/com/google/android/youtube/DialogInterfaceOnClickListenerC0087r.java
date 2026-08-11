package com.google.android.youtube;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.google.android.youtube.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0087r implements DialogInterface.OnClickListener {
    private /* synthetic */ MyChannelActivity a;

    DialogInterfaceOnClickListenerC0087r(MyChannelActivity myChannelActivity) {
        this.a = myChannelActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            MyChannelActivity myChannelActivity = this.a;
            myChannelActivity.n.a(myChannelActivity, new v(myChannelActivity, myChannelActivity, new defpackage.E(myChannelActivity, new u(myChannelActivity))));
        }
    }
}
