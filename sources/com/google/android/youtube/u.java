package com.google.android.youtube;

import android.widget.Toast;
import com.google.android.youtube.ui.C0093f;

/* JADX INFO: loaded from: classes.dex */
final class u implements defpackage.I {
    private /* synthetic */ MyChannelActivity a;

    u(MyChannelActivity myChannelActivity) {
        this.a = myChannelActivity;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0093f.b(this.a, exc);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.a.b();
        Toast.makeText(this.a, R.string.deleted_from_uploads, 1).show();
    }
}
