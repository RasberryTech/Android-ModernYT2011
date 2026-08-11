package defpackage;

import android.content.SharedPreferences;
import android.text.format.Time;
import java.util.TreeSet;

/* JADX INFO: renamed from: a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0000a {
    private final SharedPreferences a;

    public C0000a(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public final long a(C0027b c0027b) {
        if (this.a.getBoolean("OperationScheduler_enabledState", true) && !this.a.getBoolean("OperationScheduler_permanentError", false)) {
            int i = this.a.getInt("OperationScheduler_errorCount", 0);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jA = a("OperationScheduler_lastSuccessTimeMillis", jCurrentTimeMillis);
            long jA2 = a("OperationScheduler_lastErrorTimeMillis", jCurrentTimeMillis);
            long jMin = this.a.getLong("OperationScheduler_triggerTimeMillis", Long.MAX_VALUE);
            long jA3 = a("OperationScheduler_moratoriumTimeMillis", a("OperationScheduler_moratoriumSetTimeMillis", jCurrentTimeMillis) + c0027b.c);
            if (c0027b.e > 0) {
                jMin = Math.min(jMin, c0027b.e + jA);
            }
            long jMax = Math.max(Math.max(jMin, jA3), jA);
            return i > 0 ? Math.max(jMax, (c0027b.b * ((long) i)) + jA2) : jMax;
        }
        return Long.MAX_VALUE;
    }

    public final long a() {
        return this.a.getLong("OperationScheduler_lastSuccessTimeMillis", 0L);
    }

    private long a(String str, long j) {
        long j2 = this.a.getLong(str, 0L);
        if (j2 <= j) {
            return j2;
        }
        this.a.edit().putLong(str, j).commit();
        return j;
    }

    public final void a(long j) {
        this.a.edit().putLong("OperationScheduler_triggerTimeMillis", 0L).commit();
    }

    public final void b() {
        this.a.edit().remove("OperationScheduler_errorCount").commit();
        this.a.edit().remove("OperationScheduler_permanentError").commit();
        this.a.edit().remove("OperationScheduler_errorCount").remove("OperationScheduler_lastErrorTimeMillis").remove("OperationScheduler_permanentError").remove("OperationScheduler_triggerTimeMillis").putLong("OperationScheduler_lastSuccessTimeMillis", System.currentTimeMillis()).commit();
    }

    public final void c() {
        this.a.edit().putLong("OperationScheduler_lastErrorTimeMillis", System.currentTimeMillis()).commit();
        this.a.edit().putInt("OperationScheduler_errorCount", this.a.getInt("OperationScheduler_errorCount", 0) + 1).commit();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[OperationScheduler:");
        for (String str : new TreeSet(this.a.getAll().keySet())) {
            if (str.startsWith("OperationScheduler_")) {
                if (str.endsWith("TimeMillis")) {
                    Time time = new Time();
                    time.set(this.a.getLong(str, 0L));
                    sb.append(" ").append(str.substring("OperationScheduler_".length(), str.length() - 10));
                    sb.append("=").append(time.format("%Y-%m-%d/%H:%M:%S"));
                } else {
                    sb.append(" ").append(str.substring("OperationScheduler_".length()));
                    sb.append("=").append(this.a.getAll().get(str).toString());
                }
            }
        }
        return sb.append("]").toString();
    }
}
