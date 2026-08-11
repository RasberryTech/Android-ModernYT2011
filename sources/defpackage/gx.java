package defpackage;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class gx implements Comparator {
    gx() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        long jLastModified = ((File) obj).lastModified();
        long jLastModified2 = ((File) obj2).lastModified();
        if (jLastModified < jLastModified2) {
            return -1;
        }
        return jLastModified > jLastModified2 ? 1 : 0;
    }
}
