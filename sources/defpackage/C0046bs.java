package defpackage;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

/* JADX INFO: renamed from: bs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0046bs implements aM {
    private EnumC0047bt a;
    private String b;
    private Q c;

    public C0046bs(EnumC0047bt enumC0047bt, Q q) {
        this.a = (EnumC0047bt) gq.a(enumC0047bt, "method can't be null");
        this.b = null;
        this.c = (Q) gq.a(q, "deviceAuthorizer can't be null");
    }

    public C0046bs(EnumC0047bt enumC0047bt, String str, Q q) {
        this.a = (EnumC0047bt) gq.a(enumC0047bt, "method can't be null");
        this.b = (String) gq.a((Object) str, (Object) "contentType can't be null");
        this.c = (Q) gq.a(q, "deviceAuthProvider can't be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.aM
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public HttpUriRequest b(U u) throws aK {
        if (u.c != null && !this.a.a()) {
            throw new IllegalArgumentException("Content not allowed [method=" + this.a + "]");
        }
        HttpUriRequest httpUriRequestA = this.a.a(u.a);
        httpUriRequestA.setHeader("GData-Version", "2");
        if (this.c != null) {
            try {
                httpUriRequestA.setHeader("X-GData-Device", this.c.a(u.a));
            } catch (R e) {
                throw new aK(e);
            }
        } else {
            httpUriRequestA.setHeader("X-GData-Key", "key=" + new String(Q.a));
        }
        if (u.b != null) {
            httpUriRequestA.setHeader("Authorization", "GoogleLogin auth=\"" + u.b + "\"");
        }
        if (u.c != null) {
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(u.c);
            byteArrayEntity.setContentType(this.b);
            ((HttpEntityEnclosingRequestBase) httpUriRequestA).setEntity(byteArrayEntity);
        }
        return httpUriRequestA;
    }
}
