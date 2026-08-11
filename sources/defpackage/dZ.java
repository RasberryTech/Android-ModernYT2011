package defpackage;

import com.google.android.youtube.player.YouTubePlayer;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class dZ implements Runnable {
    private dW e;
    private String g;
    private Vector a = new Vector();
    private Vector b = new Vector();
    private Object c = new Object();
    private int h = 127;
    private boolean i = false;
    private Thread[] f = new Thread[1];
    private cW d = cX.a().h();

    public dZ(dW dWVar, String str, int i) {
        this.e = dWVar;
        this.g = str;
    }

    private boolean d() {
        if (this.a.isEmpty()) {
            try {
                if (this.b.isEmpty()) {
                    this.c.wait();
                } else {
                    long jI = ((C0152ea) this.b.elementAt(0)).i() - this.d.a();
                    if (jI > 0) {
                        this.c.wait(jI);
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        return this.i;
    }

    private dY e() {
        while (!this.b.isEmpty()) {
            C0152ea c0152ea = (C0152ea) this.b.elementAt(0);
            if (c0152ea.i() - this.d.a() > 0) {
                break;
            }
            this.b.removeElementAt(0);
            a((dY) c0152ea);
        }
        if (this.a.isEmpty()) {
            return null;
        }
        dY dYVar = (dY) this.a.elementAt(0);
        dYVar.a(3);
        this.a.removeElementAt(0);
        return dYVar;
    }

    final int a() {
        return this.h;
    }

    final void a(dX dXVar) {
        synchronized (this.c) {
            switch (dXVar.d()) {
                case 0:
                    dXVar.f();
                    break;
                case YouTubePlayer.PAUSED /* 3 */:
                    dXVar.a(4);
                    break;
            }
        }
    }

    final void a(dY dYVar) {
        synchronized (this.c) {
            int iH = dYVar.h();
            int size = this.a.size();
            int i = 0;
            while (i < size) {
                int i2 = (i + size) / 2;
                if (iH <= ((dY) this.a.elementAt(i2)).h()) {
                    i = i2 + 1;
                } else {
                    size = i2;
                }
            }
            this.a.insertElementAt(dYVar, i);
            dYVar.a(2);
            this.c.notifyAll();
        }
    }

    final void a(C0152ea c0152ea) {
        synchronized (this.c) {
            long jI = c0152ea.i();
            int size = this.b.size();
            int i = 0;
            while (i < size) {
                int i2 = (i + size) / 2;
                if (jI >= ((C0152ea) this.b.elementAt(i2)).i()) {
                    i = i2 + 1;
                } else {
                    size = i2;
                }
            }
            this.b.insertElementAt(c0152ea, i);
            c0152ea.a(1);
            this.c.notifyAll();
        }
    }

    public final int b(dX dXVar) {
        int iC;
        synchronized (this.c) {
            iC = dXVar.c();
        }
        return iC;
    }

    public final void b() {
        synchronized (this.c) {
            if (!this.i) {
                this.i = true;
                for (int i = 0; i < this.f.length; i++) {
                    this.f[i] = this.e.a(this.g + "-" + i, this);
                    this.f[i].start();
                }
            }
        }
    }

    public final void c() {
        synchronized (this.c) {
            if (this.i) {
                this.i = false;
                for (int i = 0; i < this.f.length; i++) {
                    this.f[i] = null;
                }
                this.c.notifyAll();
            }
        }
    }

    final boolean c(dX dXVar) {
        synchronized (this.c) {
            switch (dXVar.d()) {
                case YouTubePlayer.PREPARED /* 1 */:
                    this.b.removeElement(dXVar);
                    dXVar.a(0);
                    this.c.notifyAll();
                    return true;
                case YouTubePlayer.PLAYING /* 2 */:
                    this.a.removeElement(dXVar);
                    dXVar.a(0);
                    this.c.notifyAll();
                    return true;
                case YouTubePlayer.PAUSED /* 3 */:
                case YouTubePlayer.STOPPED /* 4 */:
                    dXVar.a(0);
                    return false;
                default:
                    return false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0020 A[Catch: all -> 0x001d, TRY_ENTER, TryCatch #1 {, blocks: (B:6:0x0006, B:8:0x000d, B:13:0x0018, B:9:0x0010, B:11:0x0016, B:18:0x0020, B:19:0x0024), top: B:27:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0016 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        dY dYVarE = null;
        while (true) {
            synchronized (this.c) {
                if (dYVarE != null) {
                    if (dYVarE.d() == 4) {
                        dYVarE.f();
                    } else {
                        dYVarE.a(0);
                    }
                    if (!d()) {
                        return;
                    } else {
                        dYVarE = e();
                    }
                } else if (!d()) {
                    return;
                } else {
                    dYVarE = e();
                }
                throw th;
            }
            if (dYVarE != null) {
                try {
                    dYVarE.g();
                } catch (Throwable th) {
                    C0162ek.a("runtime exception thrown by task [" + dYVarE + "]", th);
                    th.printStackTrace();
                }
            }
        }
    }
}
