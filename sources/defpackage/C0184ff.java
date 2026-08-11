package defpackage;

import java.io.IOException;

/* JADX INFO: renamed from: ff, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0184ff implements eO {
    private /* synthetic */ C0180fb a;

    /* synthetic */ C0184ff(C0180fb c0180fb) {
        this(c0180fb, (byte) 0);
    }

    private C0184ff(C0180fb c0180fb, byte b) {
        this.a = c0180fb;
    }

    @Override // defpackage.eO
    public final void a(eN eNVar, eP ePVar) {
        String str = "WindowResumeService.Listener.requestCompleted(" + eNVar + ", " + ePVar + ")";
        C0126da.a();
        eZ eZVar = (eZ) eNVar;
        try {
            C0126da.a();
            eZVar.a(new C0179fa(ePVar));
        } catch (IOException e) {
            C0126da.a();
            eZVar.a(new C0179fa(e));
        } finally {
            C0126da.a();
            this.a.f.e();
        }
    }

    @Override // defpackage.eO
    public final void a(eN eNVar, Exception exc) {
        String str = "WindowResumeService.Listener.requestFailed(" + eNVar + ", " + exc + ")";
        C0126da.a();
        try {
            C0126da.a();
            ((eZ) eNVar).a(new C0179fa(exc));
        } finally {
            C0126da.a();
            this.a.f.e();
        }
    }
}
