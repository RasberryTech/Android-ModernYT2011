package com.google.android.youtube.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.WatchActivity;
import defpackage.C0210ge;
import defpackage.EnumC0215gj;
import defpackage.InterfaceC0004ad;
import defpackage.fM;
import defpackage.fO;
import defpackage.gq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class G extends C0100m implements AdapterView.OnItemClickListener {
    private final defpackage.C c;
    private final boolean d;
    private final InterfaceC0004ad e;
    private InterfaceC0004ad f;
    private final defpackage.E g;
    private final defpackage.E h;
    private C0210ge i;
    private EnumC0215gj j;

    @Override // com.google.android.youtube.ui.C0100m, defpackage.gr
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return this.d || ((fM) obj).s == fO.PLAYABLE;
    }

    public G(Activity activity, ListView listView, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2, InterfaceC0004ad interfaceC0004ad3) {
        this(activity, listView, new defpackage.C(activity), interfaceC0004ad, interfaceC0004ad2, interfaceC0004ad3, false);
    }

    public G(Activity activity, ListView listView, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2, InterfaceC0004ad interfaceC0004ad3, boolean z) {
        this(activity, listView, new defpackage.C(activity), interfaceC0004ad, interfaceC0004ad2, interfaceC0004ad3, z);
    }

    public G(Activity activity, ListView listView, defpackage.C c, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2, InterfaceC0004ad interfaceC0004ad3, boolean z) {
        super(activity, listView, c, interfaceC0004ad, activity.getString(com.google.android.youtube.R.string.no_videos_found));
        this.c = c;
        this.d = z;
        this.e = (InterfaceC0004ad) gq.a(interfaceC0004ad3);
        this.f = (InterfaceC0004ad) gq.a(interfaceC0004ad2);
        this.g = new defpackage.E(activity, new I(this));
        this.h = new defpackage.E(activity, new H(this));
        listView.setOnItemClickListener(this);
    }

    public final void a(C0210ge c0210ge, EnumC0215gj enumC0215gj) {
        this.i = (C0210ge) gq.a(c0210ge, "masfLog may not be null");
        this.j = (EnumC0215gj) gq.a(enumC0215gj, "logCategory may not be null");
    }

    @Override // com.google.android.youtube.ui.C0100m
    protected void a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            fM fMVar = (fM) it.next();
            if (fMVar.d != null) {
                this.e.a(fMVar.d, this.g);
                if (fMVar.a()) {
                    arrayList.add(fMVar.a);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f.a(arrayList, this.h);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i < this.c.getCount()) {
            fM fMVar = (fM) this.c.getItem(i);
            if (this.i != null) {
                this.i.a(this.j, i);
            } else {
                C0081l.b("missing log category");
            }
            this.a.startActivity(a(fMVar));
        }
    }

    protected Intent a(fM fMVar) {
        return WatchActivity.a(this.a, fMVar.a);
    }
}
