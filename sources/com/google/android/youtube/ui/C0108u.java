package com.google.android.youtube.ui;

import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.google.android.youtube.C0081l;
import defpackage.fG;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.youtube.ui.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0108u implements defpackage.I {
    private /* synthetic */ C0106s a;

    C0108u(C0106s c0106s) {
        this.a = c0106s;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("error retrieving subtitle tracks", exc);
        this.a.b();
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        String str = (String) obj;
        List list = (List) obj2;
        if (list.size() == 0) {
            Toast.makeText(this.a.a, com.google.android.youtube.R.string.no_subtitles, 0).show();
            return;
        }
        if (this.a.h == null) {
            this.a.h = new ArrayAdapter(this.a.a, android.R.layout.select_dialog_item);
        } else {
            this.a.h.clear();
        }
        this.a.h.add(new fG("", this.a.a.getString(com.google.android.youtube.R.string.turn_off_subtitles), ""));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.a.h.add(new fG((fG) list.get(i), str));
        }
        this.a.a.showDialog(1);
    }
}
