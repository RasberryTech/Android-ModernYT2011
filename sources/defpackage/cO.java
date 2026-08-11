package defpackage;

import java.util.Date;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public final class cO extends cR {
    private boolean a;
    private String b;
    private String c;
    private String d;
    private Date e;

    protected cO(cG cGVar) {
        super(cGVar);
    }

    @Override // defpackage.cR, defpackage.cU
    protected final void b() {
        super.b();
        this.a = false;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    @Override // defpackage.cU
    protected final void a(String str, Attributes attributes) {
        if ("author".equals(str)) {
            this.a = true;
        }
    }

    @Override // defpackage.cU
    protected final void a(String str, String str2) {
        if ("title".equals(str)) {
            this.b = str2;
            return;
        }
        if ("content".equals(str)) {
            this.c = str2;
            return;
        }
        if (this.a && "name".equals(str)) {
            this.d = str2;
        } else if ("published".equals(str)) {
            this.e = c(str2);
        }
    }

    @Override // defpackage.cU
    protected final void a(String str) {
        if ("entry".equals(str)) {
            a(new C0193fo(this.b, this.c, this.d, this.e));
        } else if ("author".equals(str)) {
            this.a = false;
        }
    }

    @Override // defpackage.cU
    protected final void a() {
    }
}
