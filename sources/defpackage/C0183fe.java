package defpackage;

import com.google.android.youtube.player.YouTubePlayer;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;

/* JADX INFO: renamed from: fe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0183fe {
    private DataInputStream a;
    private eW b;
    private eP c;
    private Exception d;
    private boolean e;
    private String f;
    private Vector g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;
    private long m;
    private int n;
    private int o;
    private /* synthetic */ C0180fb p;

    private boolean a(C0179fa c0179fa) {
        String str = "WindowResumeService.Control.processResponse(" + c0179fa + ")";
        C0126da.a();
        if (c0179fa.b()) {
            C0126da.a();
            return false;
        }
        int iD = c0179fa.d();
        String str2 = "WindowResumeService.Control.processResponse(): statusCode == " + iD;
        C0126da.a();
        switch (iD) {
            case -5:
                C0126da.a();
                return false;
            case -4:
                C0126da.a();
                this.p.a((String) null);
                this.f = null;
                this.g = null;
                return true;
            case -3:
            case -2:
            case -1:
            case YouTubePlayer.PREPARED /* 1 */:
            default:
                C0126da.a();
                return false;
            case 0:
            case YouTubePlayer.PAUSED /* 3 */:
                String str3 = "WindowResumeService.Control.processResponse(): statusCode == OK (" + iD + ")";
                C0126da.a();
                if (this.f == null) {
                    C0126da.a();
                    this.f = c0179fa.e();
                    this.p.a(null, this.f);
                }
                int iF = c0179fa.f();
                if (iF == 0 && iD == 0) {
                    C0126da.a();
                    try {
                        this.c = new eM(c0179fa.i()).b();
                        this.e = true;
                    } catch (IOException e) {
                        this.d = e;
                    }
                    break;
                } else {
                    C0126da.a();
                    if (this.g == null) {
                        this.g = new Vector();
                        int[] iArrG = c0179fa.g();
                        int[] iArrH = c0179fa.h();
                        for (int i = 0; i < iF; i++) {
                            this.g.addElement(new C0182fd(this.p, iArrG[i], iArrH[i]));
                        }
                    }
                }
                return true;
            case YouTubePlayer.PLAYING /* 2 */:
                C0126da.a();
                this.e = true;
                return true;
        }
    }

    private byte[] a(int i, int i2) throws IOException {
        String str = "WindowResumeService.Control.getRequestPayload(" + i + ", " + i2 + ")";
        C0126da.a();
        if (i < this.i) {
            this.a.close();
            this.a = null;
        }
        if (this.a == null) {
            this.i = 0;
            if (this.b.d() == 0 || this.b.d() == 3) {
                this.a = new DataInputStream(new dF(this.p.d.b(), this.b.b()));
            } else {
                this.a = new DataInputStream(this.b.b());
            }
        }
        while (i > this.i) {
            this.i += this.a.skipBytes(i - this.i);
        }
        byte[] bArr = new byte[i2];
        this.a.readFully(bArr);
        this.i += i2;
        return bArr;
    }

    private eZ[] a(int i) {
        Vector vector = null;
        String str = "WindowResumeService.Control.createRequest(" + i + ")";
        C0126da.a();
        if (this.f == null) {
            C0126da.a();
            if (vector.size() == 0) {
                int iMin = Math.min(0, this.p.g);
                eZ eZVarB = b();
                eZVarB.a("Length", Integer.toString(0));
                eZVarB.a(0, a(0, iMin));
                eZVarB.d(this.b.d());
                return new eZ[]{eZVarB};
            }
        } else {
            if (this.g != null) {
                C0126da.a();
                eZ[] eZVarArr = new eZ[i];
                for (int i2 = 0; i2 < i && this.g.size() > 0; i2++) {
                    C0182fd c0182fd = (C0182fd) this.g.firstElement();
                    int i3 = c0182fd.a;
                    int iMin2 = Math.min(c0182fd.b, this.p.g);
                    if (c0182fd.b > iMin2) {
                        c0182fd.a += iMin2;
                        c0182fd.b -= iMin2;
                    } else {
                        this.g.removeElementAt(0);
                    }
                    eZ eZVarB2 = b();
                    eZVarB2.a(this.f);
                    eZVarB2.a(i3, a(i3, iMin2));
                    eZVarArr[i2] = eZVarB2;
                }
                return eZVarArr;
            }
            C0126da.a();
            if (vector.size() == 0) {
                eZ eZVarB3 = b();
                eZVarB3.a(this.f);
                eZVarB3.a("Length", Integer.toString(0));
                eZVarB3.a(0, (byte[]) null);
                eZVarB3.d(this.b.d());
                return new eZ[]{eZVarB3};
            }
        }
        return null;
    }

    private eZ b() {
        eZ eZVar = new eZ();
        eZVar.a(new C0184ff(this.p));
        eZVar.b(0);
        return eZVar;
    }

    public final synchronized void a() {
        C0126da.a();
        Vector vector = null;
        String str = "WindowResumeService.Control.run(): requestVector.size() == " + vector.size();
        C0126da.a();
        Vector vector2 = null;
        int size = vector2.size();
        while (size > 0) {
            int i = size - 1;
            String str2 = "WindowResumeService.Control.run(): i == " + i;
            C0126da.a();
            Vector vector3 = null;
            eZ eZVar = (eZ) vector3.elementAt(i);
            C0179fa c0179faL = eZVar.l();
            if (c0179faL != null) {
                this.k++;
                if (a(c0179faL)) {
                    if (this.h < 0) {
                        this.h++;
                        this.j = 0;
                    }
                    Vector vector4 = null;
                    vector4.removeElementAt(i);
                } else {
                    this.j++;
                    if (this.j < 0) {
                        eZVar.a((C0179fa) null);
                        this.p.c.a(eZVar);
                    } else {
                        if (c0179faL.b()) {
                            this.d = c0179faL.c();
                        } else {
                            this.d = new C0168eq(c0179faL.d());
                        }
                        Vector vector5 = null;
                        vector5.removeElementAt(i);
                    }
                }
                c0179faL.a();
            }
            size = i;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0126da.a();
        int i2 = (int) (jCurrentTimeMillis - this.l);
        if (this.l == 0) {
            this.l = jCurrentTimeMillis;
            i2 = 0;
        }
        if (i2 >= 100 && this.k > 2) {
            if (this.i > this.n) {
                int i3 = this.i - this.n;
                if (i2 == 0) {
                    i2 = 1;
                }
                int i4 = ((((i3 * 1000) / i2) - this.o) >> 2) + this.o;
                String str3 = "WindowResumeService.Control.run(): bandwidthEstimate = " + i4;
                C0126da.a();
                this.o = i4;
                long j = this.o;
                this.m = j == 0 ? -1L : ((long) (0 - this.i)) / j;
            }
            this.n = this.i;
            this.l = jCurrentTimeMillis;
        }
        if (this.k > 4) {
            new dY(this.p.e, new RunnableC0181fc(this.b, this.i, this.m)).e();
        }
        if (this.d != null) {
            C0126da.a();
            synchronized (this.p.b) {
                this.p.a.removeElement(this);
            }
            new dY(this.p.e, new RunnableC0181fc(this.b, this.d)).e();
        } else if (this.e) {
            C0126da.a();
            synchronized (this.p.b) {
                this.p.a.removeElement(this);
            }
            new dY(this.p.e, new RunnableC0181fc(this.b, this.c)).e();
        } else {
            C0126da.a();
            if (this.g != null && this.g.size() == 0) {
                Vector vector6 = null;
                if (vector6.size() == 0) {
                    C0126da.a();
                    this.g = null;
                }
            }
            try {
                Vector vector7 = null;
                eZ[] eZVarArrA = a(this.h - vector7.size());
                if (eZVarArrA != null) {
                    for (eZ eZVar2 : eZVarArrA) {
                        if (eZVar2 != null) {
                            String str4 = "WindowResumeService.Control.run(): request = " + eZVar2;
                            C0126da.a();
                            Vector vector8 = null;
                            vector8.addElement(eZVar2);
                            this.p.c.a(eZVar2);
                        }
                    }
                }
            } catch (IOException e) {
                this.d = e;
                this.p.f.e();
            }
        }
    }
}
