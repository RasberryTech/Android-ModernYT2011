package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class cB implements aN {
    @Override // defpackage.aN
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((eP) obj);
    }

    private static C0188fj a(eP ePVar) throws aK {
        try {
            fQ fQVarA = fQ.a(ePVar.b());
            fR fRVarC = fQVarA.c();
            C0187fi c0187fi = new C0187fi(fRVarC.c(), fRVarC.e(), fRVarC.g());
            List listA = cC.a(fQVarA.g());
            List listA2 = cC.a(fQVarA.h());
            List<fU> listF = fQVarA.f();
            ArrayList arrayList = new ArrayList(listF.size());
            for (fU fUVar : listF) {
                arrayList.add(new C0189fk(fUVar.c(), fUVar.e()));
            }
            return new C0188fj(c0187fi, listA2, listA, arrayList);
        } catch (IOException e) {
            throw new aK("IO error converting artist one call response", e);
        }
    }
}
