package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.common.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class gs implements Runnable {
    private final Context a;
    private final SharedPreferences b;
    private AtomicBoolean d = new AtomicBoolean(true);
    private AtomicReference c = new AtomicReference(gt.STRICT);

    public gs(Context context, SharedPreferences sharedPreferences) {
        this.a = context;
        this.b = sharedPreferences;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.set(a.a(this.a, "youtube"));
        String str = "parental control is " + this.d.get();
        if (!this.d.get()) {
            a(gt.values()[this.b.getInt("safe_search", gt.MODERATE.ordinal())]);
        }
    }

    public final synchronized void a(gt gtVar) {
        if (this.c.get() != gtVar) {
            this.b.edit().putInt("safe_search", gtVar.ordinal()).commit();
        }
        this.c.set(gtVar);
    }

    public final gt a() {
        return (gt) this.c.get();
    }

    public final boolean b() {
        return this.d.get();
    }
}
