package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class eR {
    private static eR d;
    private boolean a = false;
    private long b = 0;
    private boolean c = C0128dc.b("RequestNewInstallId", false);

    private eR() {
        if (this.c) {
            c();
        }
    }

    public static synchronized eR a() {
        if (d == null) {
            d = new eR();
        }
        return d;
    }

    static /* synthetic */ boolean a(eR eRVar, boolean z) {
        eRVar.c = false;
        return false;
    }

    static /* synthetic */ boolean b(eR eRVar, boolean z) {
        eRVar.a = false;
        return false;
    }

    private synchronized void c() {
        C0171et c0171etB;
        if (!this.a && (c0171etB = C0171et.b()) != null) {
            this.a = true;
            this.c = true;
            this.b = 0L;
            e();
            eK eKVar = new eK("g:c", 0);
            eKVar.a(new eS(this));
            c0171etB.a((eN) eKVar, false);
        }
    }

    private synchronized void d() {
        this.b = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        C0128dc.a("InstallId", this.b);
        C0128dc.a("RequestNewInstallId", this.c);
        cX.a().g().a();
    }

    public final synchronized long b() {
        long j;
        if (this.c) {
            c();
            j = this.b;
        } else {
            if (this.b == 0) {
                this.b = C0128dc.b("InstallId", 0L);
            }
            if (this.b == 0) {
                d();
            }
            if (this.b == 0) {
                c();
            }
            j = this.b;
        }
        return j;
    }
}
