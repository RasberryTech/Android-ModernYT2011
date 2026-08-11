package defpackage;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: ec, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0154ec {
    private int a = 0;
    private int b = Integer.MIN_VALUE;
    private Enumeration c = null;
    private /* synthetic */ C0153eb d;

    public C0154ec(C0153eb c0153eb) {
        this.d = c0153eb;
    }

    public final boolean a() {
        if (this.b != Integer.MIN_VALUE) {
            return true;
        }
        if (this.a <= this.d.c) {
            while (this.a <= this.d.c) {
                if (this.d.a[this.a] != null) {
                    int i = this.a;
                    this.a = i + 1;
                    this.b = i;
                    return true;
                }
                this.a++;
            }
        }
        if (this.d.b != null) {
            if (this.c == null) {
                this.c = this.d.b.keys();
            }
            if (this.c.hasMoreElements()) {
                this.b = ((Integer) this.c.nextElement()).intValue();
                return true;
            }
        }
        return false;
    }

    public final int b() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = Integer.MIN_VALUE;
        return i;
    }
}
