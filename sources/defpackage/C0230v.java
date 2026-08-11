package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.google.android.youtube.R;

/* JADX INFO: renamed from: v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0230v extends ArrayAdapter {
    private final LayoutInflater a;
    private final boolean b;
    private String c;

    public C0230v(Context context, boolean z) {
        super(context, R.layout.music_video_item);
        this.a = LayoutInflater.from(context);
        this.b = true;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0231w c0231w;
        View view2;
        if (view == null) {
            View viewInflate = this.a.inflate(R.layout.music_video_item, viewGroup, false);
            c0231w = new C0231w(viewInflate);
            viewInflate.setTag(c0231w);
            view2 = viewInflate;
        } else {
            c0231w = (C0231w) view.getTag();
            view2 = view;
        }
        C0199fu c0199fu = (C0199fu) getItem(i);
        c0231w.a.setText(this.b ? c0199fu.e : c0199fu.c + " - " + c0199fu.e);
        c0231w.b.setText(gv.a(c0199fu.f));
        c0231w.c.setVisibility(c0199fu.d.equals(this.c) ? 0 : 8);
        return view2;
    }

    public final void a(C0199fu c0199fu) {
        this.c = c0199fu.d;
        notifyDataSetChanged();
    }
}
