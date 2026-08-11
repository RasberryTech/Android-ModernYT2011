package defpackage;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class cE implements aN {
    @Override // defpackage.aN
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((eP) obj);
    }

    private static List a(eP ePVar) throws aK {
        try {
            return cC.a(C0206ga.a(ePVar.b()).b());
        } catch (IOException e) {
            throw new aK("IO error converting music video data response", e);
        }
    }
}
