package defpackage;

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* JADX INFO: renamed from: g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0205g extends HttpEntityWrapper {
    private final String a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public C0205g(HttpEntity httpEntity, String str, int i, long j, long j2, long j3, long j4) {
        super(httpEntity);
        this.a = str;
        this.b = i;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public final InputStream getContent() {
        return new C0216h(this, super.getContent());
    }
}
