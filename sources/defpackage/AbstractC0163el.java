package defpackage;

/* JADX INFO: renamed from: el, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0163el {
    private StringBuffer b = new StringBuffer(256);
    private int a = C0162ek.a(5);

    public AbstractC0163el() {
        C0162ek.a();
        C0162ek.b();
        System.currentTimeMillis();
    }

    public void a(Object obj, Throwable th, int i, String str, String str2, int i2) {
        String string;
        if (this.a <= i) {
            synchronized (this.b) {
                try {
                    this.b.append('[').append(C0162ek.b(i));
                    this.b.append(":EXCEPTION]");
                    if (str != null) {
                        this.b.append(' ').append(str).append('#').append(str2);
                        this.b.append('@').append(i2);
                    }
                    this.b.append(": ").append(obj);
                    this.b.append(": ").append(th);
                    string = this.b.toString();
                    this.b.setLength(0);
                } catch (Throwable th2) {
                    this.b.setLength(0);
                    throw th2;
                }
            }
            a(string);
        }
    }

    public abstract void a(String str);
}
