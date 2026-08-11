package defpackage;

import com.google.android.youtube.C0081l;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements InterfaceC0004ad {
    private final HttpClient a;
    private final aM b;
    private final aN c;

    public Y(HttpClient httpClient, aM aMVar, aN aNVar) {
        this.a = (HttpClient) gq.a(httpClient, "httpClient may not be null");
        this.b = (aM) gq.a(aMVar, "request converter may not be null");
        this.c = (aN) gq.a(aNVar, "response converter may not be null");
    }

    public Y(HttpClient httpClient, aM aMVar) {
        this.a = (HttpClient) gq.a(httpClient, "httpClient may not be null");
        this.b = (aM) gq.a(aMVar, "request converter may not be null");
        this.c = null;
    }

    @Override // defpackage.InterfaceC0004ad
    public final void a(Object obj, I i) {
        HttpUriRequest httpUriRequest;
        HttpResponse httpResponseExecute;
        gq.a(obj, "request can't be null");
        try {
            try {
                HttpUriRequest httpUriRequest2 = (HttpUriRequest) this.b.b(obj);
                try {
                    httpResponseExecute = this.a.execute(httpUriRequest2);
                    try {
                        int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                        String reasonPhrase = httpResponseExecute.getStatusLine().getReasonPhrase();
                        if (!(statusCode >= 200 && statusCode < 300)) {
                            C0081l.a("Http error: request=[" + obj + "] status=[" + statusCode + "] msg=[" + reasonPhrase + "]");
                            a(httpResponseExecute);
                            i.a(obj, (Exception) new HttpResponseException(statusCode, reasonPhrase));
                        } else {
                            Object objA = this.c != null ? this.c.a(httpResponseExecute) : null;
                            a(httpResponseExecute);
                            i.a(obj, objA);
                        }
                    } catch (Exception e) {
                        e = e;
                        if (httpResponseExecute != null) {
                            try {
                                a(httpResponseExecute);
                            } catch (IOException e2) {
                            }
                        }
                        i.a(obj, e);
                    }
                } catch (RuntimeException e3) {
                    httpUriRequest = httpUriRequest2;
                    e = e3;
                    if (httpUriRequest != null) {
                        httpUriRequest.abort();
                        throw e;
                    }
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                httpResponseExecute = null;
            }
        } catch (RuntimeException e5) {
            e = e5;
            httpUriRequest = null;
        }
    }

    private static void a(HttpResponse httpResponse) throws IOException {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            entity.consumeContent();
        }
    }
}
