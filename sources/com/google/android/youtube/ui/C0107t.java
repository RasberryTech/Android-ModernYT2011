package com.google.android.youtube.ui;

import com.google.android.youtube.C0081l;
import defpackage.fG;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.youtube.ui.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0107t implements defpackage.I {
    private /* synthetic */ C0106s a;

    C0107t(C0106s c0106s) {
        this.a = c0106s;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("error retrieving subtitle tracks", exc);
        this.a.b();
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        fG fGVar;
        fG fGVar2;
        String str = (String) obj;
        Iterator it = ((List) obj2).iterator();
        fG fGVar3 = null;
        while (true) {
            if (!it.hasNext()) {
                fGVar = null;
                break;
            }
            fGVar = (fG) it.next();
            if (fGVar.a.equals(this.a.i)) {
                String str2 = this.a.i + " is available";
                break;
            }
            if (fGVar3 != null || !"en".equals(fGVar.a)) {
                fGVar = fGVar3;
            }
            fGVar3 = fGVar;
        }
        if (fGVar != null) {
            fGVar2 = new fG(fGVar, str);
        } else if (fGVar3 != null) {
            String str3 = this.a.i + " not available, requesting translation";
            fGVar2 = new fG(this.a.i, fGVar3.a, fGVar3.c, str);
        } else {
            String str4 = this.a.i + " or en not available";
            return;
        }
        this.a.f.a(fGVar2, this.a.g);
    }
}
