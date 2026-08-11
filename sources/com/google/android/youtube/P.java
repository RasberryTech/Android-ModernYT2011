package com.google.android.youtube;

import defpackage.fM;
import defpackage.fO;

/* JADX INFO: loaded from: classes.dex */
final class P implements defpackage.I {
    private /* synthetic */ YouTubeApplication a;

    P(YouTubeApplication youTubeApplication) {
        this.a = youTubeApplication;
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        if (((fM) obj2).s == fO.PLAYABLE) {
            YouTubeApplication.a = false;
            this.a.l.edit().putBoolean("andicapped", false).commit();
        }
    }
}
