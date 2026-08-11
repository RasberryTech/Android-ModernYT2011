package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.youtube.R;
import com.google.android.youtube.ui.A;
import com.google.android.youtube.ui.C0101n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class C extends AbstractC0232x {
    private final LayoutInflater b;
    private final Resources c;
    private final HashSet d;
    private final Bitmap e;
    private HashMap f;
    private final ConcurrentHashMap g;
    private final A h;
    private final C0101n i;
    private boolean j;

    @Override // defpackage.AbstractC0232x
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        fM fMVar = (fM) obj;
        gq.a(fMVar);
        this.f.put(fMVar.d, null);
        super.a(fMVar);
    }

    public C(Context context) {
        this(context, null, null);
    }

    public C(Context context, A a) {
        this(context, null, a);
    }

    public C(Context context, ConcurrentHashMap concurrentHashMap) {
        this(context, concurrentHashMap, null);
    }

    private C(Context context, ConcurrentHashMap concurrentHashMap, A a) {
        this.j = true;
        gq.a(context);
        this.b = LayoutInflater.from(context);
        this.c = context.getResources();
        this.i = new C0101n(context);
        this.f = new HashMap();
        this.d = new HashSet();
        this.e = BitmapFactory.decodeResource(this.c, R.drawable.ic_youtube_thumbnail_small);
        this.g = concurrentHashMap;
        this.h = a;
    }

    @Override // defpackage.AbstractC0232x
    public final void a() {
        this.f.clear();
        super.a();
    }

    public final void a(Uri uri, Bitmap bitmap) {
        if (this.f.containsKey(uri)) {
            this.f.put(uri, bitmap != null ? bitmap : this.e);
            notifyDataSetChanged();
        }
    }

    public final void a(String str) {
        if (this.d.add(str)) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        D d;
        View view2;
        fM fMVar = (fM) getItem(i);
        boolean zContains = this.d.contains(fMVar.a);
        if (view == null) {
            View viewInflate = this.b.inflate(R.layout.video_item, viewGroup, false);
            D d2 = new D(viewInflate);
            viewInflate.setTag(d2);
            view2 = viewInflate;
            d = d2;
        } else {
            d = (D) view.getTag();
            view2 = view;
        }
        d.a.setText(fMVar.i);
        d.b.setText(String.format(this.c.getString(R.string.video_author), fMVar.n));
        d.c.setVisibility(fMVar.o != null && (fMVar.o.getTime() > (System.currentTimeMillis() - 604800000) ? 1 : (fMVar.o.getTime() == (System.currentTimeMillis() - 604800000) ? 0 : -1)) > 0 ? 0 : 8);
        if (fMVar.s == fO.PLAYABLE) {
            d.d.setTypeface(Typeface.DEFAULT, 0);
            Integer num = this.g != null ? (Integer) this.g.get(fMVar.a) : null;
            if (num != null) {
                d.d.setText(this.c.getString(num.intValue()));
            } else {
                String strA = gv.a(fMVar.o, this.c);
                TextView textView = d.d;
                Resources resources = this.c;
                Object[] objArr = new Object[2];
                if (strA == null) {
                    strA = "";
                }
                objArr[0] = strA;
                objArr[1] = Integer.valueOf(fMVar.k);
                textView.setText(resources.getString(R.string.age_and_views, objArr));
            }
        } else {
            d.d.setTypeface(Typeface.DEFAULT, 2);
            d.d.setText(this.c.getString(fMVar.s.s));
        }
        Bitmap bitmap = (Bitmap) this.f.get(fMVar.d);
        d.e.setScaleType(bitmap == this.e ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_CROP);
        d.e.setImageBitmap(bitmap);
        d.f.setText(gv.a(fMVar.j));
        if (this.h != null) {
            d.g.setImageResource(R.drawable.more_drawable);
            d.g.setClickable(true);
            d.g.setVisibility(0);
            this.h.a(d.g, fMVar);
        } else if (zContains) {
            d.g.setImageResource(R.drawable.ic_music);
            d.g.setClickable(false);
            d.g.setVisibility(0);
            if (this.j) {
                this.i.d();
                this.j = false;
            }
        } else {
            d.g.setVisibility(8);
        }
        return view2;
    }
}
