package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.youtube.R;

/* JADX INFO: renamed from: y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0233y extends AbstractC0232x {
    private final LayoutInflater b;

    public C0233y(Context context) {
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0202fx c0202fx = (C0202fx) getItem(i);
        TextView textView = (TextView) (view == null ? this.b.inflate(R.layout.text_item, viewGroup, false) : view);
        textView.setText(c0202fx.a);
        return textView;
    }
}
