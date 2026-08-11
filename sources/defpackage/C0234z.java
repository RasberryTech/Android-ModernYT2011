package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.youtube.R;

/* JADX INFO: renamed from: z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0234z extends ArrayAdapter {
    private final LayoutInflater a;

    public C0234z(Context context) {
        super(context, R.layout.related_artist_item);
        this.a = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) (view == null ? this.a.inflate(R.layout.related_artist_item, viewGroup, false) : view);
        textView.setText(((C0189fk) getItem(i)).b);
        return textView;
    }
}
