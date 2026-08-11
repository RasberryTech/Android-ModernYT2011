package defpackage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: renamed from: ep, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0167ep implements InterfaceC0170es {
    private byte[] a;

    public C0167ep(byte[] bArr) {
        this.a = bArr;
    }

    @Override // defpackage.InterfaceC0170es
    public final int a() {
        return this.a.length;
    }

    @Override // defpackage.InterfaceC0170es
    public final InputStream b() {
        return new ByteArrayInputStream(this.a);
    }
}
