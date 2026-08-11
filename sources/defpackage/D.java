package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.youtube.R;

/* JADX INFO: loaded from: classes.dex */
final class D {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;
    public final TextView f;
    public final ImageView g;

    public D(View view) {
        this.a = (TextView) view.findViewById(R.id.title);
        this.b = (TextView) view.findViewById(R.id.author);
        this.c = (TextView) view.findViewById(R.id.recent);
        this.d = (TextView) view.findViewById(R.id.detail);
        this.e = (ImageView) view.findViewById(R.id.thumbnail);
        this.f = (TextView) view.findViewById(R.id.duration);
        this.g = (ImageView) view.findViewById(R.id.more);
    }
}
