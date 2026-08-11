package com.google.android.youtube.ui;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.google.android.youtube.C0081l;
import defpackage.AbstractC0232x;
import defpackage.C0200fv;
import defpackage.InterfaceC0004ad;
import defpackage.gq;
import defpackage.gr;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpResponseException;

/* JADX INFO: renamed from: com.google.android.youtube.ui.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0100m implements defpackage.I, AbsListView.OnScrollListener, InterfaceC0104q, gr {
    protected final Activity a;
    protected final AbstractC0232x b;
    private C0096i c;
    private final InterfaceC0004ad d;
    private final defpackage.E e;
    private ViewOnClickListenerC0088a f;
    private String g;
    private String h;
    private defpackage.U i;
    private Uri j;
    private int k;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.b("Error for request " + ((defpackage.U) obj) + " : " + exc);
        if ((exc instanceof HttpResponseException) && ((HttpResponseException) exc).getStatusCode() == 403) {
            this.f.a(this.a.getString(com.google.android.youtube.R.string.error_forbidden_list_access), false);
        } else {
            this.f.b(C0093f.a(this.a, exc), true);
        }
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        C0200fv c0200fv = (C0200fv) obj2;
        if (((defpackage.U) obj) == this.i) {
            List list = c0200fv.d;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int iMax = Math.max(0, (this.k - c0200fv.b) + 1); iMax < size; iMax++) {
                Object obj3 = list.get(iMax);
                if (a(obj3)) {
                    arrayList.add(obj3);
                }
            }
            this.k = Math.max(this.k, (list.size() + c0200fv.b) - 1);
            if (arrayList.isEmpty()) {
                this.j = null;
            } else {
                this.b.a((List) arrayList);
                this.j = c0200fv.c;
                a((List) arrayList);
            }
            if (this.b.getCount() == 0) {
                this.f.a(this.h, false);
            } else {
                this.f.a();
            }
        }
    }

    public C0100m(Activity activity, AbsListView absListView, AbstractC0232x abstractC0232x, InterfaceC0004ad interfaceC0004ad, String str) {
        this.a = (Activity) gq.a(activity);
        this.b = (AbstractC0232x) gq.a(abstractC0232x);
        this.d = (InterfaceC0004ad) gq.a(interfaceC0004ad);
        this.e = new defpackage.E(activity, this);
        View viewInflate = LayoutInflater.from(activity).inflate(com.google.android.youtube.R.layout.status, (ViewGroup) absListView, false);
        this.c = new C0096i(abstractC0232x, viewInflate);
        this.f = new ViewOnClickListenerC0088a(viewInflate, this.c, this);
        this.h = gq.a(str);
        this.g = activity.getString(com.google.android.youtube.R.string.loading);
        absListView.setOnScrollListener(this);
        absListView.setAdapter(this.c);
    }

    public final void a(defpackage.U u) {
        gq.a(u);
        c();
        b(u);
    }

    public final void b() {
        c();
        this.f.a(this.h, false);
    }

    public final void a(String str) {
        c();
        this.f.a(str, false);
    }

    private void c() {
        this.j = null;
        this.i = null;
        this.k = 0;
        this.b.a();
    }

    public boolean a(Object obj) {
        return true;
    }

    protected void a(List list) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = i + i2;
        if (this.j != null && this.i.a != this.j && i4 == i3 && this.b.getCount() < this.b.a) {
            defpackage.U uA = defpackage.U.a(this.j, this.i);
            this.j = null;
            b(uA);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    private final void b(defpackage.U u) {
        this.i = u;
        this.f.a(this.g, true);
        this.d.a(u, this.e);
    }

    @Override // com.google.android.youtube.ui.InterfaceC0104q
    public final void a_() {
        if (this.i != null) {
            b(this.i);
        }
    }
}
