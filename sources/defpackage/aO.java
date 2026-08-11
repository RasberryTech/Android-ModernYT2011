package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class aO {
    private Map a;

    /* synthetic */ aO(Map map) {
        this(map, (byte) 0);
    }

    private aO(Map map, byte b) {
        this.a = Collections.unmodifiableMap(map);
    }

    public final InterfaceC0028ba a(String str) {
        return (InterfaceC0028ba) this.a.get(str);
    }
}
