package defpackage;

import android.net.TrafficStats;
import android.os.SystemClock;
import android.util.EventLog;
import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: renamed from: h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0216h extends FilterInputStream {
    private /* synthetic */ C0205g a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0216h(C0205g c0205g, InputStream inputStream) {
        super(inputStream);
        this.a = c0205g;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            super.close();
            EventLog.writeEvent(52001, this.a.a, Long.valueOf(this.a.e), Long.valueOf(SystemClock.elapsedRealtime() - this.a.f), Long.valueOf(TrafficStats.getUidTxBytes(this.a.b) - this.a.c), Long.valueOf(TrafficStats.getUidRxBytes(this.a.b) - this.a.d));
        } catch (Throwable th) {
            EventLog.writeEvent(52001, this.a.a, Long.valueOf(this.a.e), Long.valueOf(SystemClock.elapsedRealtime() - this.a.f), Long.valueOf(TrafficStats.getUidTxBytes(this.a.b) - this.a.c), Long.valueOf(TrafficStats.getUidRxBytes(this.a.b) - this.a.d));
            throw th;
        }
    }
}
