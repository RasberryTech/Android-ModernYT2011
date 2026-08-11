package com.google.android.youtube.ui;

import android.app.Activity;
import android.widget.ListView;
import defpackage.C0013am;
import defpackage.C0210ge;
import defpackage.EnumC0215gj;
import defpackage.InterfaceC0005ae;
import defpackage.InterfaceC0021au;
import defpackage.fH;
import defpackage.fM;
import defpackage.gq;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements InterfaceC0021au {
    private final G a;
    private final C0013am b;
    private fM c;

    public Y(Activity activity, InterfaceC0005ae interfaceC0005ae, C0013am c0013am, C0210ge c0210ge) {
        this.b = (C0013am) gq.a(c0013am);
        this.a = new G(activity, (ListView) activity.findViewById(com.google.android.youtube.R.id.related_list), interfaceC0005ae.c(), interfaceC0005ae.K(), interfaceC0005ae.e());
        this.a.a(c0210ge, EnumC0215gj.RELATED_RESULTS);
    }

    public final void a(fM fMVar) {
        if (fMVar != null && fMVar.g != null) {
            this.c = fMVar;
            this.b.a(this);
        } else {
            this.c = null;
            this.a.b();
        }
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.a.a(defpackage.V.a(this.c.g, fHVar.b));
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(Exception exc) {
        this.a.a(defpackage.V.a(this.c.g));
    }

    @Override // defpackage.InterfaceC0021au
    public final void a() {
        this.a.a(defpackage.V.a(this.c.g));
    }
}
