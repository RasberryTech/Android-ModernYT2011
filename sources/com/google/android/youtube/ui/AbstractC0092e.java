package com.google.android.youtube.ui;

import android.content.Context;
import defpackage.InterfaceC0021au;
import defpackage.gq;

/* JADX INFO: renamed from: com.google.android.youtube.ui.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0092e implements InterfaceC0021au {
    private Context a;

    public AbstractC0092e(Context context) {
        this.a = (Context) gq.a(context);
    }

    @Override // defpackage.InterfaceC0021au
    public final void a() {
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(Exception exc) {
        C0093f.b(this.a, exc);
    }
}
