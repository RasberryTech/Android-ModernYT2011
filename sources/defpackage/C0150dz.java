package defpackage;

import java.util.Hashtable;

/* JADX INFO: renamed from: dz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0150dz implements dC {
    private final Hashtable a = new Hashtable();
    private Hashtable b = new Hashtable();

    @Override // defpackage.dC
    public final synchronized int a(byte[] bArr, String str) {
        byte[] bArr2;
        bArr2 = bArr == null ? new byte[0] : bArr;
        this.b.put(str, bArr2);
        return bArr2.length;
    }

    @Override // defpackage.dC
    public final void a() {
    }

    @Override // defpackage.dC
    public final boolean a(String str, byte[] bArr) {
        if (bArr == null) {
            this.a.remove(str);
            return true;
        }
        this.a.put(str, bArr);
        return true;
    }

    @Override // defpackage.dC
    public final byte[] a(String str) {
        return (byte[]) this.a.get(str);
    }

    @Override // defpackage.dC
    public final byte[] b(String str) {
        return (byte[]) this.b.get(str);
    }
}
