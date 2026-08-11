package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class gF extends IOException {
    public gF(String str) {
        super(str);
    }

    static gF a() {
        return new gF("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static gF b() {
        return new gF("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
