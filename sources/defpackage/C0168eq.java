package defpackage;

import java.io.IOException;

/* JADX INFO: renamed from: eq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0168eq extends IOException {
    public C0168eq(int i) {
        this(String.valueOf(i), i);
    }

    private C0168eq(String str, int i) {
        super(str);
    }
}
