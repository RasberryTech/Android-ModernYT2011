package defpackage;

import android.view.View;
import android.widget.TextView;
import com.google.android.youtube.R;

/* JADX INFO: renamed from: w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0231w {
    public final TextView a;
    public final TextView b;
    public final View c;

    public C0231w(View view) {
        this.a = (TextView) view.findViewById(R.id.information);
        this.b = (TextView) view.findViewById(R.id.length);
        this.c = view.findViewById(R.id.now_playing);
    }
}
