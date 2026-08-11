package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes.dex */
final class aG implements FilenameFilter {
    private /* synthetic */ String a;

    aG(aF aFVar, String str) {
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.endsWith(this.a);
    }
}
