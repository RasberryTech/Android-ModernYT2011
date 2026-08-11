package defpackage;

import android.content.Context;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;

/* JADX INFO: loaded from: classes.dex */
public final class dM extends AbstractC0143ds {
    private static int d;
    private static final Object e = new Object();
    private String a;
    private final Context b;
    private dP c;

    public dM(Context context) {
        this.b = context;
    }

    static /* synthetic */ int b() {
        int i = d;
        d = i + 1;
        return i;
    }

    static /* synthetic */ int c() {
        int i = d;
        d = i - 1;
        return i;
    }

    @Override // defpackage.InterfaceC0149dy
    public final InterfaceC0146dv a(String str, boolean z) {
        if (this.c == null) {
            this.c = new dP(this.b.getContentResolver(), this.a, true);
            ConnManagerParams.setMaxConnectionsPerRoute(this.c.getParams(), new ConnPerRouteBean(4));
        }
        return new dN(this, str, z);
    }

    public final void a(String str) {
        this.a = str;
    }
}
