package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.youtube.R;

/* JADX INFO: renamed from: u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0229u {
    public final TextView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;

    public C0229u(View view) {
        this.a = (TextView) view.findViewById(R.id.title);
        this.c = (TextView) view.findViewById(R.id.target);
        this.d = (TextView) view.findViewById(R.id.target_not_found);
        this.b = (ImageView) view.findViewById(R.id.icon);
        this.e = (TextView) view.findViewById(R.id.timeAgo);
    }
}
