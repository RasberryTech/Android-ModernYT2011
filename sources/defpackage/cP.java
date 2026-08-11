package defpackage;

import com.google.android.youtube.C0081l;
import java.net.MalformedURLException;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public class cP extends cU {
    private final cQ a;
    private final cR b;
    private C0198ft c;
    private boolean d;

    public cP(cQ cQVar, cR cRVar) {
        super(cQVar);
        this.a = cQVar;
        this.b = cRVar;
    }

    @Override // defpackage.cU
    protected final void b() {
        this.b.b();
        this.c = new C0198ft();
        this.d = false;
    }

    @Override // defpackage.cU
    protected final void a(String str, Attributes attributes) {
        if (str.equals("entry")) {
            this.d = true;
        }
        if (this.d) {
            this.b.a(str, attributes);
            return;
        }
        if (str.equals("link")) {
            try {
                String value = attributes.getValue("rel");
                String value2 = attributes.getValue("href");
                if ("self".equals(value)) {
                    this.c.a(new cJ(value2));
                } else if ("next".equals(value)) {
                    this.c.c(new cJ(value2));
                } else if ("previous".equals(value)) {
                    this.c.b(new cJ(value2));
                }
            } catch (MalformedURLException e) {
                C0081l.b("Problem parsing page url", e);
            }
        }
    }

    @Override // defpackage.cU
    protected final void a(String str, String str2) {
        if (this.d) {
            this.b.a(str, str2);
            return;
        }
        if (str.equals("openSearch:totalResults")) {
            this.c.a(b(str2));
        } else if (str.equals("openSearch:startIndex")) {
            this.c.c(b(str2));
        } else if (str.equals("openSearch:itemsPerPage")) {
            this.c.b(b(str2));
        }
    }

    @Override // defpackage.cU
    protected final void a(String str) {
        if (this.d) {
            this.b.a(str);
        }
        if (str.equals("entry")) {
            this.d = false;
            this.c.a(this.b.c());
            this.b.b();
        }
    }

    @Override // defpackage.cU
    protected final void a() {
        this.a.a(this.c);
        this.c = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GDataEntryPageParser[");
        sb.append("entryPage=" + this.c + " ");
        sb.append("]");
        return sb.toString();
    }
}
