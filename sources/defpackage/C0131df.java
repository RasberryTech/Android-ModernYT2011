package defpackage;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: renamed from: df, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0131df implements InterfaceC0148dx {
    C0131df(C0130de c0130de) {
    }

    @Override // defpackage.InterfaceC0148dx
    public final InputStream a(InputStream inputStream) {
        return new GZIPInputStream(inputStream);
    }
}
