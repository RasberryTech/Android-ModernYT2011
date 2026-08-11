package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Locale;

/* JADX INFO: renamed from: de, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0130de extends cX {
    private dM d;
    private dC e;
    private Context f;
    private final cW g;

    public C0130de(Context context) {
        this(context, null);
    }

    private C0130de(Context context, String str) {
        this.g = new C0129dd();
        this.f = context;
        Thread.currentThread();
        a(this);
        b();
        b = true;
        c = true;
        a = 4;
        if (context != null) {
            context.getResources().getDisplayMetrics();
        }
        if (this.f == null) {
            this.e = new C0150dz();
        } else if (0 != 0) {
            this.e = new dG(null);
        } else {
            this.e = new dO(this.f);
        }
        this.d = new dM(this.f);
        new C0140dp();
        new Cdo(this.f);
        String string = Locale.getDefault().toString();
        e().b(string);
        e().c(string);
    }

    private String a(String str) {
        try {
            Cursor cursorQuery = this.f.getContentResolver().query(Uri.parse("content://com.google.settings/partner"), new String[]{"value"}, "name='" + str + "'", null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                return null;
            }
            return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("value"));
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // defpackage.cX
    protected final void c() {
        C0147dw.a(new C0131df(this));
    }

    @Override // defpackage.cX
    protected final String d() {
        String strA = a("maps_client_id");
        if (!C0160ei.a(strA)) {
            return strA;
        }
        String strA2 = a("client_id");
        return C0160ei.a(strA2) ? "Web" : "gmm-" + strA2;
    }

    @Override // defpackage.cX
    public final /* bridge */ /* synthetic */ InterfaceC0149dy f() {
        return this.d;
    }

    @Override // defpackage.cX
    public final dC g() {
        return this.e;
    }

    @Override // defpackage.cX
    public final cW h() {
        return this.g;
    }
}
