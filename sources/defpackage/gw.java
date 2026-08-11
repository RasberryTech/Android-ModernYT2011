package defpackage;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes.dex */
final class gw implements FileFilter {
    private /* synthetic */ String a;

    gw(String str) {
        this.a = str;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return !file.isDirectory() && file.getName().endsWith(this.a);
    }
}
