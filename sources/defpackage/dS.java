package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class dS {
    private final C0153eb a;
    private final String b;

    public dS() {
        this.a = new C0153eb();
        this.b = null;
    }

    public dS(String str) {
        this.a = new C0153eb();
        this.b = str;
    }

    public final int a(int i) {
        dT dTVar = (dT) this.a.a(i);
        if (dTVar == null) {
            return 16;
        }
        return dTVar.a & 255;
    }

    public final dS a(int i, int i2, Object obj) {
        this.a.a(i2, new dT(i, obj));
        return this;
    }

    final C0153eb a() {
        return this.a.a();
    }

    public final Object b(int i) {
        dT dTVar = (dT) this.a.a(i);
        return dTVar == null ? dTVar : dTVar.b;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((dS) obj).a);
    }

    public final int hashCode() {
        return this.a != null ? this.a.hashCode() : super.hashCode();
    }

    public final String toString() {
        return "ProtoBufType Name: " + this.b;
    }
}
