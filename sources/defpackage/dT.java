package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class dT {
    private int a;
    private Object b;

    dT(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof dT)) {
            return false;
        }
        dT dTVar = (dT) obj;
        return this.a == dTVar.a && (this.b == dTVar.b || (this.b != null && this.b.equals(dTVar.b)));
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "TypeInfo{type=" + this.a + ", data=" + this.b + "}";
    }
}
