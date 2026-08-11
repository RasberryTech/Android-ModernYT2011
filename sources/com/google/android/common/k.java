package com.google.android.common;

import android.content.Intent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class k {
    private ArrayList a = new ArrayList();
    private ArrayList b = new ArrayList();
    private g c;

    k(SwipeySwitcher swipeySwitcher, g gVar) {
        this.c = gVar;
    }

    final h a(Intent intent) {
        if (this.a.size() == 0) {
            this.a.add(new l(this.c.a(), this.a, this.b));
        }
        h hVar = (h) this.a.remove(this.a.size() - 1);
        this.b.add(hVar);
        ((l) hVar).b = intent;
        return hVar;
    }

    final boolean a(h hVar) {
        return this.b.contains(hVar) || this.a.contains(hVar);
    }
}
