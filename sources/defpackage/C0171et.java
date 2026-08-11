package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: renamed from: et, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0171et extends AbstractC0143ds {
    private static int f = 20000;
    private static C0171et g;
    long c;
    long d;
    C0152ea e;
    private dZ h;
    private RunnableC0134di i;
    private InterfaceC0149dy j;
    private eE k;
    private String l;
    private eA q;
    private Vector m = new Vector();
    private Vector n = new Vector();
    Object a = new Object();
    private int o = 0;
    int b = 0;
    private int p = 0;

    private C0171et(String str, String str2, String str3, String str4, String str5) {
        this.k = new eE(str2, str3, str4, str5, "g");
        dU dUVar = new dU();
        this.h = new dZ(dUVar, "MobileServiceMux TaskRunner", 1);
        this.h.b();
        this.j = cX.a().f();
        this.l = str;
        this.i = new RunnableC0134di(this.h, dUVar, this.j, "MobileServiceMux AsyncHttpRequestFactory", 3);
        this.i.a();
        new C0180fb(this, this.h, this.k);
        this.q = new eA(8);
        this.e = new C0152ea(this.h, new RunnableC0172eu(this));
    }

    private eP a(eQ eQVar, eI eIVar) {
        String strJ = eQVar.j();
        eJ eJVar = new eJ(eIVar.c(), eIVar.g(), eIVar.d());
        Hashtable hashtable = new Hashtable();
        eC[] eCVarArrE = eIVar.e();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= eCVarArrE.length) {
                break;
            }
            eC eCVar = eCVarArrE[i2];
            String str = (String) eCVar.d().get("Content-Location");
            if (str == null || str.equals(strJ)) {
                eJVar.a(eCVar);
            } else {
                eJ eJVar2 = (eJ) hashtable.get(str);
                if (eJVar2 == null) {
                    hashtable.put(str, new eJ(eIVar.c(), Integer.parseInt((String) eCVar.d().get("X-Masf-Response-Code")), eCVar));
                } else {
                    eJVar2.a(eCVar);
                }
            }
            i = i2 + 1;
        }
        Enumeration enumerationKeys = hashtable.keys();
        synchronized (this.a) {
            while (enumerationKeys.hasMoreElements()) {
                Object objNextElement = enumerationKeys.nextElement();
                this.q.a(objNextElement, ((eJ) hashtable.get(objNextElement)).a());
            }
        }
        return eJVar.a();
    }

    public static void a() {
        if (g != null) {
            if (g.i != null) {
                g.i.b();
            }
            if (g.h != null) {
                g.h.c();
            }
            g = null;
        }
    }

    private void a(eN eNVar, eP ePVar) {
        try {
            eO eOVarI = eNVar.i();
            if (eOVarI != null) {
                eOVarI.a(eNVar, ePVar);
            }
            e();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            ePVar.h();
        }
    }

    private void a(eN eNVar, Exception exc) {
        if (!eNVar.e()) {
            eO eOVarI = eNVar.i();
            if (eOVarI != null) {
                eOVarI.a(eNVar, exc);
                return;
            }
            return;
        }
        long jD = eNVar.d();
        C0152ea c0152ea = new C0152ea(this.h, new RunnableC0173ev(this, eNVar, true));
        c0152ea.a(jD);
        c0152ea.e();
    }

    static /* synthetic */ void a(C0171et c0171et, InterfaceC0133dh interfaceC0133dh, Object[] objArr) {
        eP ePVarB;
        eN eNVar;
        int iB_ = interfaceC0133dh.b_();
        String strF = interfaceC0133dh.f();
        if (interfaceC0133dh.d()) {
            Exception excC = interfaceC0133dh.c();
            if (!(excC instanceof IOException)) {
                if (excC instanceof SecurityException) {
                    c0171et.a(objArr);
                    return;
                } else {
                    c0171et.b(objArr, excC);
                    return;
                }
            }
            if (excC.getMessage() == null || !excC.getMessage().endsWith("-3")) {
                c0171et.b(objArr, excC);
                return;
            } else {
                c0171et.a(objArr);
                return;
            }
        }
        if (iB_ == 502) {
            c0171et.b(objArr, new C0168eq(iB_));
            return;
        }
        if (iB_ != 200) {
            a(objArr, new C0168eq(iB_));
            c0171et.e();
            return;
        }
        if (strF != null) {
            try {
                if (strF.equals("application/binary")) {
                    c0171et.p = (int) (((long) c0171et.p) + interfaceC0133dh.e());
                    eM eMVar = new eM(interfaceC0133dh.g());
                    for (int i = 0; i < objArr.length && (ePVarB = eMVar.b()) != null; i++) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= objArr.length) {
                                eNVar = null;
                                break;
                            }
                            eN eNVar2 = (eN) objArr[i2];
                            if (eNVar2 != null && eNVar2.c() == ePVarB.c()) {
                                objArr[i2] = null;
                                eNVar = eNVar2;
                                break;
                            }
                            i2++;
                        }
                        if (eNVar != null) {
                            eP ePVarA = ((ePVarB instanceof eI) && (eNVar instanceof eQ)) ? c0171et.a((eQ) eNVar, (eI) ePVarB) : ePVarB;
                            int iG = ePVarA.g();
                            if (iG == 550) {
                                ePVarA.h();
                                c0171et.a(eNVar, new C0168eq(iG));
                            } else {
                                c0171et.a(eNVar, ePVarA);
                            }
                        } else {
                            try {
                                ePVarB.b().read(new byte[ePVarB.a()]);
                            } catch (IOException e) {
                            }
                            ePVarB.h();
                        }
                    }
                    eMVar.a();
                    return;
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                return;
            } catch (IOException e3) {
                e3.printStackTrace();
                return;
            } finally {
                c0171et.b(objArr, new IOException("Request didn't complete"));
            }
        }
        c0171et.b(objArr, new IOException("Bad content-type"));
    }

    static /* synthetic */ void a(C0171et c0171et, Object[] objArr) {
        for (Object obj : objArr) {
            eN eNVar = (eN) obj;
            if (eNVar != null) {
                eNVar.f();
            }
        }
    }

    public static synchronized void a(String str, String str2, String str3, String str4, String str5) {
        if (g == null) {
            g = new C0171et(str, str2, str3, str4, str5);
        }
    }

    private void a(Vector vector) throws IOException {
        InputStream[] inputStreamArr = new InputStream[vector.size()];
        eN[] eNVarArr = new eN[vector.size()];
        vector.copyInto(eNVarArr);
        for (int i = 0; i < eNVarArr.length; i++) {
            inputStreamArr[i] = eNVarArr[i].b();
        }
        InterfaceC0133dh interfaceC0133dhA = this.i.a(this.l);
        interfaceC0133dhA.a("POST");
        dF dFVar = new dF(this.k.b(), new dF(inputStreamArr));
        int iAvailable = dFVar.available();
        interfaceC0133dhA.a(dFVar);
        interfaceC0133dhA.a(f);
        interfaceC0133dhA.b("application/binary");
        interfaceC0133dhA.b(new dY(this.h, new RunnableC0174ew(this, interfaceC0133dhA, eNVarArr, iAvailable)));
    }

    private void a(Object[] objArr) {
        a(objArr, new SecurityException("Connection disallowed"));
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Object[] objArr, Exception exc) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return;
            }
            eN eNVar = (eN) objArr[i2];
            eO eOVarI = eNVar.i();
            if (eOVarI != null) {
                eOVarI.a(eNVar, exc);
            }
            i = i2 + 1;
        }
    }

    public static C0171et b() {
        return g;
    }

    private void b(Object[] objArr, Exception exc) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return;
            }
            eN eNVar = (eN) objArr[i2];
            if (eNVar != null) {
                a(eNVar, exc);
            }
            objArr[i2] = null;
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x005c A[Catch: IOException -> 0x0057, TRY_ENTER, TryCatch #1 {IOException -> 0x0057, blocks: (B:6:0x0016, B:7:0x0024, B:9:0x0027, B:11:0x002d, B:13:0x0037, B:14:0x0039, B:19:0x0044, B:26:0x0055, B:27:0x0056, B:31:0x005c, B:33:0x006d, B:34:0x0079, B:35:0x0085, B:37:0x008b, B:15:0x003a, B:16:0x0040), top: B:42:0x0016, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x006d A[Catch: IOException -> 0x0057, TryCatch #1 {IOException -> 0x0057, blocks: (B:6:0x0016, B:7:0x0024, B:9:0x0027, B:11:0x002d, B:13:0x0037, B:14:0x0039, B:19:0x0044, B:26:0x0055, B:27:0x0056, B:31:0x005c, B:33:0x006d, B:34:0x0079, B:35:0x0085, B:37:0x008b, B:15:0x003a, B:16:0x0040), top: B:42:0x0016, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x008f  */
    public void d() {
        eN[] eNVarArr;
        int iA;
        String strJ;
        Object objA;
        synchronized (this.a) {
            eNVarArr = new eN[this.n.size()];
            this.n.copyInto(eNVarArr);
            this.n.removeAllElements();
        }
        try {
            Vector vector = new Vector();
            int iA2 = this.k.a();
            int i = 0;
            while (true) {
                int i2 = i;
                int i3 = iA2;
                if (i2 >= eNVarArr.length) {
                    break;
                }
                eN eNVar = eNVarArr[i2];
                if (!(eNVar instanceof eQ) || (strJ = ((eQ) eNVar).j()) == null) {
                    eNVar.a(f());
                    if (eNVar.a() + i3 > 32768) {
                        a(vector);
                        iA = this.k.a();
                        vector.removeAllElements();
                    } else {
                        iA = i3;
                    }
                    eNVarArr[i2] = null;
                    vector.addElement(eNVar);
                    iA2 = iA + eNVar.a();
                } else {
                    synchronized (this.a) {
                        objA = this.q.a(strJ);
                    }
                    if (objA != null) {
                        eNVarArr[i2] = null;
                        a(eNVar, (eP) objA);
                        iA2 = i3;
                    } else {
                        eNVar.a(f());
                        if (eNVar.a() + i3 > 32768) {
                            a(vector);
                            iA = this.k.a();
                            vector.removeAllElements();
                        } else {
                            iA = i3;
                        }
                        eNVarArr[i2] = null;
                        vector.addElement(eNVar);
                        iA2 = iA + eNVar.a();
                    }
                }
                i = i2 + 1;
            }
            if (vector.size() > 0) {
                a(vector);
            }
        } catch (IOException e) {
            b(eNVarArr, e);
        }
    }

    private InterfaceC0175ex[] e() {
        InterfaceC0175ex[] interfaceC0175exArr;
        synchronized (this.m) {
            interfaceC0175exArr = new InterfaceC0175ex[this.m.size()];
            this.m.copyInto(interfaceC0175exArr);
        }
        return interfaceC0175exArr;
    }

    private synchronized int f() {
        int i;
        i = this.o;
        this.o = i + 1;
        return i;
    }

    @Override // defpackage.InterfaceC0149dy
    public final InterfaceC0146dv a(String str, boolean z) {
        return new C0176ey(str, z);
    }

    public final void a(eN eNVar) {
        a(eNVar, true);
    }

    public final void a(eN eNVar, boolean z) {
        synchronized (this.a) {
            this.n.addElement(eNVar);
            if (z) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = 10 + jCurrentTimeMillis;
                if (this.d == 0) {
                    this.c = jCurrentTimeMillis + 100;
                    this.d = j;
                    this.e.b(this.d);
                    this.e.e();
                } else if (j < this.c) {
                    this.d = j;
                } else if (this.d < this.c) {
                    this.d = this.c;
                }
            }
        }
    }

    public final void c() {
        d();
    }
}
