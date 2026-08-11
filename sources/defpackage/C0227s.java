package defpackage;

import android.view.View;
import android.widget.TextView;
import com.google.android.youtube.R;

/* JADX INFO: renamed from: s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0227s {
    public final TextView a;
    public final TextView b;
    public final TextView c;

    public C0227s(View view) {
        this.a = (TextView) view.findViewById(R.id.author);
        this.b = (TextView) view.findViewById(R.id.time);
        this.c = (TextView) view.findViewById(R.id.comment);
    }
}
