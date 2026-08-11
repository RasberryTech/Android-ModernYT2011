package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class gI extends RuntimeException {
    public gI() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final gF a() {
        return new gF(getMessage());
    }
}
