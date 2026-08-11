package com.google.android.youtube;

import android.content.Context;
import com.google.android.youtube.ui.AbstractC0092e;
import defpackage.V;
import defpackage.fH;

/* JADX INFO: renamed from: com.google.android.youtube.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0073d extends AbstractC0092e {
    private /* synthetic */ defpackage.E a;
    private /* synthetic */ ChannelActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0073d(ChannelActivity channelActivity, Context context, defpackage.E e) {
        super(context);
        this.b = channelActivity;
        this.a = e;
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.b.s = fHVar;
        if (this.b.u != null) {
            this.b.j.a(V.c(this.b.u, fHVar), this.a);
        } else {
            this.b.showDialog(11);
        }
    }
}
