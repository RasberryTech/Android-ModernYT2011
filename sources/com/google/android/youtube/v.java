package com.google.android.youtube;

import android.content.Context;
import com.google.android.youtube.ui.AbstractC0092e;
import defpackage.V;
import defpackage.fH;

/* JADX INFO: loaded from: classes.dex */
final class v extends AbstractC0092e {
    private /* synthetic */ defpackage.I a;
    private /* synthetic */ MyChannelActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v(MyChannelActivity myChannelActivity, Context context, defpackage.I i) {
        super(context);
        this.b = myChannelActivity;
        this.a = i;
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.b.h.a(V.b(this.b.r.e, fHVar), this.a);
    }
}
