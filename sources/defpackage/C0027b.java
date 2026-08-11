package defpackage;

/* JADX INFO: renamed from: b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0027b {
    public long a = 0;
    public long b = 5000;
    public long c = 86400000;
    public long d = 0;
    public long e = 0;

    public final String toString() {
        return String.format("OperationScheduler.Options[backoff=%.1f+%.1f max=%.1f min=%.1f period=%.1f]", Double.valueOf(0.0d), Double.valueOf(this.b / 1000.0d), Double.valueOf(this.c / 1000.0d), Double.valueOf(0.0d), Double.valueOf(this.e / 1000.0d));
    }
}
