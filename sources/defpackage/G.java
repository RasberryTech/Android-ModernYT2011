package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class G implements InterfaceC0004ad {
    private final Executor a;
    private final InterfaceC0004ad b;

    public static G a(Executor executor, InterfaceC0004ad interfaceC0004ad) {
        gq.a(executor, "executor may not be null");
        gq.a(interfaceC0004ad, "target may not be null");
        return new G(executor, interfaceC0004ad);
    }

    private G(Executor executor, InterfaceC0004ad interfaceC0004ad) {
        this.a = executor;
        this.b = interfaceC0004ad;
    }

    @Override // defpackage.InterfaceC0004ad
    public final void a(Object obj, I i) {
        this.a.execute(new H(this, obj, i));
    }
}
