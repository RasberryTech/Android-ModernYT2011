package com.google.android.common;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class b implements g {
    private /* synthetic */ SwipeySwitcher a;

    b(SwipeySwitcher swipeySwitcher) {
        this.a = swipeySwitcher;
    }

    @Override // com.google.android.common.g
    public final View a() {
        return new View(this.a.d);
    }
}
