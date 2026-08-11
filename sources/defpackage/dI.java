package defpackage;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
final class dI implements HttpRequestInterceptor {
    dI() {
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (dH.a.get() != null && ((Boolean) dH.a.get()).booleanValue()) {
            throw new RuntimeException("This thread forbids HTTP requests");
        }
    }
}
