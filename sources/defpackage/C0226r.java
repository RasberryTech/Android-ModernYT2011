package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.R;

/* JADX INFO: renamed from: r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0226r extends AbstractC0232x {
    private final LayoutInflater b;
    private final Resources c;

    public C0226r(Context context) {
        this.c = context.getResources();
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0227s c0227s;
        View view2;
        if (view == null) {
            View viewInflate = this.b.inflate(R.layout.comment_item, viewGroup, false);
            c0227s = new C0227s(viewInflate);
            viewInflate.setTag(c0227s);
            view2 = viewInflate;
        } else {
            c0227s = (C0227s) view.getTag();
            view2 = view;
        }
        C0193fo c0193fo = (C0193fo) getItem(i);
        c0227s.a.setText(c0193fo.b);
        c0227s.b.setText(gv.a(c0193fo.c, this.c));
        c0227s.c.setText(c0193fo.a);
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        return false;
    }
}
