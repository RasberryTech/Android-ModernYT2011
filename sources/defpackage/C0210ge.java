package defpackage;

import com.google.android.youtube.C0081l;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

/* JADX INFO: renamed from: ge, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0210ge implements eO {
    private boolean c;
    private final gm d;
    private boolean h;
    private boolean i;
    private final InterfaceC0213gh j;
    private final Object b = new Object();
    private gk f = gk.UNKNOWN;
    private EnumC0211gf g = EnumC0211gf.UNKNOWN;
    private long e = -1;
    private LinkedList a = new LinkedList();

    public C0210ge(gm gmVar, InterfaceC0213gh interfaceC0213gh) {
        this.d = (gm) gq.a(gmVar, "masfService may not be null");
        this.j = (InterfaceC0213gh) gq.a(interfaceC0213gh, "logSaver may not be null");
    }

    public final void a(EnumC0214gi enumC0214gi) {
        dQ dQVar = new dQ(eT.b);
        dQVar.a(1, 4);
        dQVar.a(3, enumC0214gi.d);
        b(dQVar);
    }

    public final void a(EnumC0215gj enumC0215gj, int i) {
        dQ dQVar = new dQ(eT.b);
        dQVar.a(1, 1);
        dQVar.a(2, enumC0215gj.F);
        dQVar.a(3, i);
        b(dQVar);
        this.e = System.currentTimeMillis();
    }

    public final void a(gk gkVar, EnumC0211gf enumC0211gf) {
        this.h = false;
        this.i = false;
        this.f = gkVar;
        this.g = enumC0211gf;
    }

    public final void a() {
        if (this.h) {
            C0081l.b("Avoiding double logging of play start");
            return;
        }
        this.h = true;
        dQ dQVar = new dQ(eT.b);
        dQVar.a(1, 2);
        if (this.e != -1) {
            dQVar.a(4, System.currentTimeMillis() - this.e);
        }
        a(dQVar);
        b(dQVar);
        this.e = -1L;
    }

    private void b(int i, int i2) {
        if (this.i) {
            C0081l.b("Avoiding double logging of play end");
            return;
        }
        this.i = true;
        dQ dQVar = new dQ(eT.b);
        dQVar.a(1, i);
        if (i2 != -1) {
            dQVar.a(8, i2);
        }
        a(dQVar);
        b(dQVar);
        this.f = gk.UNKNOWN;
        this.g = EnumC0211gf.UNKNOWN;
        d();
    }

    private void a(dQ dQVar) {
        if (this.f != gk.UNKNOWN) {
            dQVar.a(6, this.f.g);
        }
        if (this.g != EnumC0211gf.UNKNOWN) {
            dQVar.a(7, this.g.e);
        }
    }

    public final void b() {
        b(this.h ? 3 : 10, -1);
    }

    public final void a(gl glVar) {
        a(glVar.g);
    }

    public final void a(int i) {
        b(this.h ? 13 : 11, i);
    }

    public final void a(InputStream inputStream) {
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int i = dataInputStream.readInt();
            if (i > 30) {
                C0081l.b("Too many log entries - only loading first 30 of " + i);
                i = 30;
            }
            synchronized (this.b) {
                for (int i2 = 0; i2 < i; i2++) {
                    int i3 = dataInputStream.readInt();
                    if (i3 > 256) {
                        C0081l.b("Log entry was too big - skipping loading. " + i3);
                        break;
                    }
                    byte[] bArr = new byte[i3];
                    dataInputStream.read(bArr);
                    this.a.add(bArr);
                }
            }
        } catch (IOException e) {
            C0081l.b("Caught exception during log loading: " + e);
        }
    }

    public final void c() {
        synchronized (this.b) {
            if (this.c) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeInt(this.a.size());
                    for (byte[] bArr : this.a) {
                        dataOutputStream.writeInt(bArr.length);
                        dataOutputStream.write(bArr);
                    }
                } catch (IOException e) {
                    C0081l.a("Error saving logs", e);
                }
                this.j.a(byteArrayOutputStream.toByteArray());
                this.c = false;
            }
        }
    }

    public final void d() {
        this.d.a();
    }

    private void b(dQ dQVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            dQVar.a((OutputStream) byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length > 256) {
                C0081l.b("Log entry was too big - ignoring. " + byteArray.length);
                return;
            }
            synchronized (this.b) {
                if (this.a.size() >= 30) {
                    C0081l.b("Too many unsent logs pending - ignoring log");
                } else {
                    this.a.add(byteArray);
                    this.c = true;
                    C0212gg c0212gg = new C0212gg(byteArray);
                    c0212gg.a(this);
                    this.d.a(c0212gg, false);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public static int a(String str) {
        byte[] bytes = str.getBytes();
        int i = 17;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = (i * 31) + bytes[i2];
        }
        return i;
    }

    public final void a(int i, int i2) {
        String str = i + ": " + i2;
        dQ dQVar = new dQ(eT.a);
        dQVar.a(1, i);
        dQVar.a(2, i2);
        dQ dQVar2 = new dQ(eT.b);
        dQVar2.a(1, 20);
        dQVar2.a(13, dQVar);
        b(dQVar2);
    }

    private void a(eN eNVar) {
        boolean zRemove;
        C0212gg c0212gg = (C0212gg) eNVar;
        synchronized (this.b) {
            zRemove = this.a.remove(c0212gg.a);
            this.c |= zRemove;
        }
        if (!zRemove) {
            C0081l.a("attempt to remove unknown unsent log");
        }
    }

    @Override // defpackage.eO
    public final void a(eN eNVar, eP ePVar) {
        a(eNVar);
    }

    @Override // defpackage.eO
    public final void a(eN eNVar, Exception exc) {
        C0081l.b("Failed to send log - " + exc);
        a(eNVar);
    }
}
