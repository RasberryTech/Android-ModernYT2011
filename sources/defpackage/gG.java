package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class gG {
    public abstract void a(gA gAVar);

    public abstract int j();

    public byte[] w() {
        try {
            byte[] bArr = new byte[j()];
            gA gAVarA = gA.a(bArr);
            a(gAVarA);
            gAVarA.a();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }
}
