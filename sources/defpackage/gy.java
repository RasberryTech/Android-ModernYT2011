package defpackage;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class gy implements gH {
    @Override // defpackage.gH
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract gy b(gz gzVar, gC gCVar);

    @Override // 
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public abstract gy clone();

    public final gy a(InputStream inputStream) throws gF {
        gz gzVarA = gz.a(inputStream);
        b(gzVarA, gC.a());
        gzVarA.a(0);
        return this;
    }

    protected static void a(Iterable iterable, Collection collection) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException();
            }
        }
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            collection.add(it2.next());
        }
    }
}
