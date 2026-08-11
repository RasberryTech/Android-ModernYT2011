package com.google.android.youtube;

import defpackage.InterfaceC0213gh;

/* JADX INFO: loaded from: classes.dex */
final class Q implements InterfaceC0213gh {
    final /* synthetic */ YouTubeApplication a;

    /* synthetic */ Q(YouTubeApplication youTubeApplication) {
        this(youTubeApplication, (byte) 0);
    }

    private Q(YouTubeApplication youTubeApplication, byte b) {
        this.a = youTubeApplication;
    }

    @Override // defpackage.InterfaceC0213gh
    public final void a(byte[] bArr) {
        this.a.j.execute(new R(this, bArr));
    }
}
