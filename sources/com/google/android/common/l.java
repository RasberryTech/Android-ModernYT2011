package com.google.android.common;

import android.content.Intent;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class l implements h {
    private View a;
    private Intent b;
    private ArrayList c;
    private ArrayList d;

    public l(View view, ArrayList arrayList, ArrayList arrayList2) {
        this.a = view;
        this.c = arrayList;
        this.d = arrayList2;
    }

    @Override // com.google.android.common.h
    public final View b() {
        return this.a;
    }

    @Override // com.google.android.common.h
    public final void a() {
        if (this.d != null) {
            this.d.remove(this);
        }
        if (this.c != null) {
            this.c.add(this);
        }
    }

    @Override // com.google.android.common.h
    public final Intent c() {
        return this.b;
    }
}
