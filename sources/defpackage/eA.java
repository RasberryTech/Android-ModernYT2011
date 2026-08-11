package defpackage;

import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class eA {
    private final int a;
    private final Hashtable b;
    private final Vector c;

    public eA() {
        this(8);
    }

    public eA(int i) {
        this.a = 8;
        this.b = new Hashtable(8);
        this.c = new Vector(8);
    }

    public final synchronized Object a(Object obj) {
        Object objRemove;
        objRemove = this.b.remove(obj);
        if (objRemove != null) {
            this.c.removeElement(obj);
        }
        return objRemove;
    }

    public final synchronized void a(Object obj, Object obj2) {
        if (this.b.size() == this.a) {
            Object objElementAt = this.c.elementAt(0);
            this.c.removeElementAt(0);
            this.b.remove(objElementAt);
        }
        if (this.b.put(obj, obj2) != null) {
            this.c.removeElement(obj);
        }
        this.c.addElement(obj);
    }
}
