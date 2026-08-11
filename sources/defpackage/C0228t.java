package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.R;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0228t extends AbstractC0232x {
    private static final Map e;
    private final LayoutInflater b;
    private final Resources c;
    private final HashMap d = new HashMap();

    static {
        EnumMap enumMap = new EnumMap(EnumC0196fr.class);
        enumMap.put(EnumC0196fr.FRIEND_ADDED, Integer.valueOf(R.drawable.ic_activity_friend));
        enumMap.put(EnumC0196fr.USER_SUBSCRIPTION_ADDED, Integer.valueOf(R.drawable.ic_activity_subscribe));
        enumMap.put(EnumC0196fr.VIDEO_COMMENTED, Integer.valueOf(R.drawable.ic_activity_comment));
        enumMap.put(EnumC0196fr.VIDEO_FAVORITED, Integer.valueOf(R.drawable.ic_activity_favorite));
        enumMap.put(EnumC0196fr.VIDEO_SHARED, Integer.valueOf(R.drawable.ic_activity_shared));
        enumMap.put(EnumC0196fr.VIDEO_UPLOADED, Integer.valueOf(R.drawable.ic_activity_upload));
        enumMap.put(EnumC0196fr.VIDEO_RATED, Integer.valueOf(R.drawable.ic_activity_like));
        e = Collections.unmodifiableMap(enumMap);
    }

    public C0228t(Context context) {
        this.b = LayoutInflater.from(context);
        this.c = context.getResources();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0229u c0229u;
        View view2;
        C0195fq c0195fq = (C0195fq) getItem(i);
        if (view == null) {
            View viewInflate = this.b.inflate(R.layout.event_item, viewGroup, false);
            c0229u = new C0229u(viewInflate);
            viewInflate.setTag(c0229u);
            view2 = viewInflate;
        } else {
            c0229u = (C0229u) view.getTag();
            view2 = view;
        }
        c0229u.a.setText(this.c.getString(c0195fq.b.h, c0195fq.a));
        if (!c0195fq.b.i) {
            c0229u.c.setVisibility(0);
            c0229u.d.setVisibility(8);
            c0229u.c.setText(c0195fq.c);
        } else if (this.d.containsKey(c0195fq.c)) {
            if (((fM) this.d.get(c0195fq.c)) == null) {
                view2.setFocusable(false);
                view2.setClickable(false);
                c0229u.c.setVisibility(8);
                c0229u.d.setVisibility(0);
            } else {
                c0229u.d.setVisibility(8);
                c0229u.c.setVisibility(0);
                c0229u.c.setText(((fM) this.d.get(c0195fq.c)).i);
            }
        } else {
            c0229u.c.setText((CharSequence) null);
        }
        c0229u.b.setImageResource(((Integer) e.get(c0195fq.b)).intValue());
        c0229u.e.setText(gv.a(c0195fq.d, this.c));
        return view2;
    }

    public final void a(fM fMVar) {
        gq.a(fMVar, "video can't be null");
        this.d.put(fMVar.a, fMVar);
        notifyDataSetChanged();
    }

    public final void a(String str) {
        this.d.put(str, null);
        notifyDataSetChanged();
    }

    public final fM b(String str) {
        return (fM) this.d.get(str);
    }
}
