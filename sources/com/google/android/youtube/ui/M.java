package com.google.android.youtube.ui;

import android.content.DialogInterface;
import com.google.android.youtube.C0081l;
import defpackage.C0200fv;
import defpackage.C0202fx;
import defpackage.fH;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class M extends AbstractC0092e implements defpackage.I, DialogInterface.OnClickListener {
    public String[] a;
    private List b;
    private /* synthetic */ J c;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Error retrieving user's playlists", exc);
        C0093f.b(this.c.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        C0200fv c0200fv = (C0200fv) obj2;
        if (c0200fv.a == 0) {
            this.c.b(com.google.android.youtube.R.string.no_playlists_found);
            return;
        }
        this.b = c0200fv.d;
        this.a = new String[c0200fv.d.size()];
        Iterator it = c0200fv.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.a[i] = ((C0202fx) it.next()).a;
            i++;
        }
        this.c.a.showDialog(10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(J j) {
        super(j.a);
        this.c = j;
    }

    @Override // defpackage.InterfaceC0021au
    public final void a(fH fHVar) {
        this.c.e.a(defpackage.V.e(fHVar), new defpackage.E(this.c.a, this));
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.c.g.a(this.c.a, new L(this.c, (C0202fx) this.b.get(i)));
    }
}
