package defpackage;

import java.util.Vector;

/* JADX INFO: renamed from: di, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0134di implements Runnable {
    private dZ c;
    private dW d;
    private InterfaceC0149dy e;
    private String f;
    private boolean h;
    private Vector a = new Vector();
    private Object b = new Object();
    private Thread[] g = new Thread[3];

    public RunnableC0134di(dZ dZVar, dW dWVar, InterfaceC0149dy interfaceC0149dy, String str, int i) {
        this.c = dZVar;
        this.d = dWVar;
        this.e = interfaceC0149dy;
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RunnableC0135dj runnableC0135dj) {
        synchronized (this.b) {
            if (this.a.contains(runnableC0135dj)) {
                return false;
            }
            this.a.addElement(runnableC0135dj);
            this.b.notifyAll();
            return true;
        }
    }

    public final InterfaceC0133dh a(String str) {
        return new RunnableC0135dj(this, str);
    }

    public final void a() {
        synchronized (this.b) {
            if (!this.h) {
                this.h = true;
                for (int i = 0; i < this.g.length; i++) {
                    this.g[i] = this.d.a(this.f + "-" + i, this);
                    this.g[i].start();
                }
            }
        }
    }

    public final void b() {
        synchronized (this.b) {
            if (this.h) {
                this.h = false;
                for (int i = 0; i < this.g.length; i++) {
                    this.g[i] = null;
                }
                this.b.notifyAll();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        RunnableC0135dj runnableC0135dj;
        while (true) {
            synchronized (this.b) {
                while (this.a.size() == 0) {
                    try {
                        this.b.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                if (!this.h) {
                    return;
                }
                runnableC0135dj = (RunnableC0135dj) this.a.elementAt(0);
                this.a.removeElementAt(0);
            }
            runnableC0135dj.run();
        }
    }
}
