package defpackage;

import com.google.android.youtube.R;

/* JADX INFO: loaded from: classes.dex */
public enum X {
    TODAY(R.string.time_filter_today),
    THIS_WEEK(R.string.time_filter_this_week),
    THIS_MONTH(R.string.time_filter_this_month),
    ALL_TIME(R.string.time_filter_all_time);

    public final int c;

    X(int i) {
        this.c = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return super.toString().toLowerCase();
    }
}
