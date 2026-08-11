package defpackage;

import java.util.ArrayList;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public final class cL extends cU {
    private final cM a;
    private ArrayList b;
    private boolean c;
    private String d;
    private String e;
    private String f;
    private boolean g;

    public cL(cM cMVar) {
        super(cMVar);
        this.a = cMVar;
        this.b = new ArrayList();
    }

    @Override // defpackage.cU
    protected final void a(String str, Attributes attributes) {
        if (str.equals("atom:category")) {
            this.c = true;
            this.d = attributes.getValue("term");
            this.e = attributes.getValue("label");
        } else if (this.c) {
            if (str.equals("yt:browsable")) {
                String value = attributes.getValue("regions");
                if (value != null) {
                    this.f = value;
                    return;
                }
                return;
            }
            if (str.equals("yt:deprecated")) {
                this.g = true;
            }
        }
    }

    @Override // defpackage.cU
    protected final void a(String str, String str2) {
    }

    @Override // defpackage.cU
    protected final void a(String str) {
        if (str.equals("atom:category")) {
            this.b.add(new C0192fn(this.d, this.e, this.f, this.g));
            this.c = false;
            this.f = null;
            this.e = null;
            this.d = null;
            this.g = false;
        }
    }

    @Override // defpackage.cU
    protected final void a() {
        this.a.a(this.b);
        this.b = null;
    }
}
