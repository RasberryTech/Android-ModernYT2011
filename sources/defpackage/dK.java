package defpackage;

import android.util.Log;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
final class dK implements HttpRequestInterceptor {
    private /* synthetic */ dH a;

    /* synthetic */ dK(dH dHVar) {
        this(dHVar, (byte) 0);
    }

    private dK(dH dHVar, byte b) {
        this.a = dHVar;
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        dL dLVarA = dH.a(this.a);
        if (dLVarA != null && Log.isLoggable(dLVarA.a, dLVarA.b) && (httpRequest instanceof HttpUriRequest)) {
            Log.println(dLVarA.b, dLVarA.a, dH.a((HttpUriRequest) httpRequest));
        }
    }
}
