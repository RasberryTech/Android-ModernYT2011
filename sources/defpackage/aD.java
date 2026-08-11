package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class aD extends LinkedHashMap {
    private /* synthetic */ aC a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aD(aC aCVar, int i, float f, boolean z) {
        super(i, 0.75f, true);
        this.a = aCVar;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.a.a;
    }
}
