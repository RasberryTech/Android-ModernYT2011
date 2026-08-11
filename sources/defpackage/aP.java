package defpackage;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class aP {
    private final HashMap a = new HashMap();

    public final aP a(String str, InterfaceC0028ba interfaceC0028ba) {
        this.a.put(str, interfaceC0028ba);
        return this;
    }

    public final aO a() {
        return new aO(this.a);
    }
}
