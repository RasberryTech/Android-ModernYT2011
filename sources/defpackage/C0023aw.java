package defpackage;

import org.apache.http.client.HttpResponseException;

/* JADX INFO: renamed from: aw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0023aw implements InterfaceC0004ad {
    final /* synthetic */ C0013am a;
    private final InterfaceC0004ad b;

    static /* synthetic */ boolean a(C0023aw c0023aw, HttpResponseException httpResponseException) {
        if (httpResponseException.getStatusCode() != 401) {
            return false;
        }
        String message = httpResponseException.getMessage();
        return message != null && message.toLowerCase().contains("token");
    }

    @Override // defpackage.InterfaceC0004ad
    public final /* bridge */ /* synthetic */ void a(Object obj, I i) {
        U u = (U) obj;
        gq.a(u.b, (Object) "attempted a retrying request with an empty authToken");
        this.b.a(u, new C0024ax(this, i, u));
    }

    public C0023aw(C0013am c0013am, InterfaceC0004ad interfaceC0004ad) {
        this.a = c0013am;
        this.b = interfaceC0004ad;
    }
}
