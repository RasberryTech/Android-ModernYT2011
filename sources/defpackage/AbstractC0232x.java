package defpackage;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0232x extends BaseAdapter {
    public final int a;
    private ArrayList b;

    private AbstractC0232x(int i) {
        gq.a(true, (Object) "maxItems can't be negative or 0");
        this.b = new ArrayList(100);
        this.a = 100;
    }

    public AbstractC0232x() {
        this(100);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public final void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        notifyDataSetChanged();
    }

    public void a() {
        this.b.clear();
        notifyDataSetChanged();
    }

    protected void a(Object obj) {
        if (this.b.size() < this.a) {
            this.b.add(obj);
        }
    }
}
