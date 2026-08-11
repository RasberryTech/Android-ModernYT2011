package defpackage;

import android.app.Activity;
import com.google.android.youtube.C0081l;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class E implements I {
    private static final LinkedBlockingQueue a = new LinkedBlockingQueue();
    private final Activity b;
    private final I c;

    static /* synthetic */ void a(F f) {
        try {
            a.put(f);
        } catch (InterruptedException e) {
            C0081l.b("Interrupted when releasing runnable to the queue", e);
        }
    }

    public E(Activity activity, I i) {
        this.b = (Activity) gq.a(activity);
        this.c = (I) gq.a(i);
    }

    @Override // defpackage.I
    public final void a(Object obj, Object obj2) {
        F fA = a();
        fA.a(this.c, obj, obj2);
        this.b.runOnUiThread(fA);
    }

    @Override // defpackage.I
    public final void a(Object obj, Exception exc) {
        F fA = a();
        fA.a(this.c, obj, exc);
        this.b.runOnUiThread(fA);
    }

    private static F a() {
        F f = (F) a.poll();
        return f != null ? f : new F();
    }
}
