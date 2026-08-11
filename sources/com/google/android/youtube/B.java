package com.google.android.youtube;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: classes.dex */
final class B extends OrientationEventListener {
    private int a;
    private int b;
    private /* synthetic */ WatchActivity c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    B(WatchActivity watchActivity, Context context, int i) {
        super(context, 0);
        this.c = watchActivity;
    }

    @Override // android.view.OrientationEventListener
    public final void enable() {
        this.a = -1;
        this.b = -1;
        super.enable();
    }

    private static boolean a(int i, int i2) {
        int iAbs = Math.abs(i - i2);
        return iAbs > 60 && iAbs < 300;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        if (this.a == -1) {
            this.a = i;
            return;
        }
        if (this.b == -1) {
            if (a(i, this.a)) {
                this.b = i;
            }
        } else if (a(i, this.b)) {
            this.c.setRequestedOrientation(4);
            disable();
        }
    }
}
