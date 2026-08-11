package defpackage;

import com.google.android.youtube.C0081l;
import org.apache.http.client.HttpResponseException;

/* JADX INFO: renamed from: aa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0001aa implements eO {
    private final I a;
    private final aN b;
    private final Object c;

    public C0001aa(Object obj, I i, aN aNVar) {
        this.c = obj;
        this.b = aNVar;
        this.a = i;
    }

    @Override // defpackage.eO
    public final void a(eN eNVar, eP ePVar) {
        if (ePVar.g() != 200) {
            this.a.a(this.c, (Exception) new HttpResponseException(ePVar.g(), "MASF error"));
            return;
        }
        try {
            this.a.a(this.c, this.b.a(ePVar));
        } catch (aK e) {
            this.a.a(this.c, (Exception) e);
        }
    }

    @Override // defpackage.eO
    public final void a(eN eNVar, Exception exc) {
        C0081l.b("MASF request failed", exc);
        this.a.a(this.c, exc);
    }
}
