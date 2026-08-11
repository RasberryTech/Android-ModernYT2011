package defpackage;

import com.google.android.youtube.C0081l;
import java.net.MalformedURLException;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public final class cS extends cU {
    private final cT a;
    private fI b;

    public cS(cT cTVar) {
        super(cTVar);
        this.a = cTVar;
        this.b = null;
    }

    @Override // defpackage.cU
    public final void b() {
        this.b = null;
    }

    @Override // defpackage.cU
    protected final void a(String str, Attributes attributes) {
        try {
            if (str.equals("entry")) {
                this.b = new fI();
            }
            if (this.b != null) {
                if (str.equals("media:thumbnail")) {
                    this.b.a(new cJ(attributes.getValue("url")));
                    return;
                }
                if (str.equals("gd:feedLink")) {
                    String value = attributes.getValue("rel");
                    int iB = b(attributes.getValue("countHint"));
                    if (value.equals("http://gdata.youtube.com/schemas/2007#user.favorites")) {
                        this.b.d(iB);
                        return;
                    } else if (value.equals("http://gdata.youtube.com/schemas/2007#user.subscriptions")) {
                        this.b.e(iB);
                        return;
                    } else {
                        if (value.equals("http://gdata.youtube.com/schemas/2007#user.uploads")) {
                            this.b.b(iB);
                            return;
                        }
                        return;
                    }
                }
                if (str.equals("yt:statistics")) {
                    this.b.f(b(attributes.getValue("subscriberCount")));
                    this.b.c(b(attributes.getValue("viewCount")));
                }
            }
        } catch (MalformedURLException e) {
            C0081l.b("Problem parsing user profile thumbnail url", e);
        }
    }

    @Override // defpackage.cU
    protected final void a(String str, String str2) {
        if (this.b != null) {
            if (str.equals("yt:username")) {
                this.b.a(str2);
            } else if (str.equals("yt:age")) {
                this.b.a(Integer.parseInt(str2));
            }
        }
    }

    @Override // defpackage.cU
    protected final void a(String str) {
    }

    @Override // defpackage.cU
    protected final void a() {
        this.a.a(this.b);
        this.b = null;
    }
}
