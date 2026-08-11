package com.google.android.youtube.ui;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.ChannelActivity;
import com.google.android.youtube.WatchActivity;
import defpackage.C0195fq;
import defpackage.C0210ge;
import defpackage.C0228t;
import defpackage.EnumC0215gj;
import defpackage.InterfaceC0004ad;
import defpackage.gq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.youtube.ui.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0094g extends C0100m implements AdapterView.OnItemClickListener {
    private final C0228t c;
    private final InterfaceC0004ad d;
    private final defpackage.E e;
    private C0210ge f;
    private EnumC0215gj g;
    private final HashMap h;

    public C0094g(Activity activity, ListView listView, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2) {
        super(activity, listView, new C0228t(activity), interfaceC0004ad, activity.getString(com.google.android.youtube.R.string.no_events_found));
        this.c = (C0228t) this.b;
        this.d = (InterfaceC0004ad) gq.a(interfaceC0004ad2);
        this.e = new defpackage.E(activity, new C0095h(this));
        listView.setOnItemClickListener(this);
        this.h = new HashMap();
    }

    public final void a(C0210ge c0210ge, EnumC0215gj enumC0215gj) {
        this.f = (C0210ge) gq.a(c0210ge, "masfLog may not be null");
        this.g = (EnumC0215gj) gq.a(enumC0215gj, "logCategory may not be null");
    }

    @Override // com.google.android.youtube.ui.C0100m
    protected final void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0195fq c0195fq = (C0195fq) it.next();
            if (c0195fq.b.i) {
                defpackage.U uB = defpackage.V.b(c0195fq.c);
                this.h.put(uB, c0195fq.c);
                this.d.a(uB, this.e);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0195fq c0195fq = (C0195fq) this.c.getItem(i);
        if (c0195fq.b.i) {
            if (this.c.b(c0195fq.c) != null) {
                if (this.f != null) {
                    this.f.a(this.g, i);
                } else {
                    C0081l.b("missing log category");
                }
                this.a.startActivity(WatchActivity.a(this.a, c0195fq.c));
                return;
            }
            return;
        }
        this.a.startActivity(ChannelActivity.a(this.a, c0195fq.c));
    }
}
