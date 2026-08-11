package com.google.android.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.youtube.ui.C0093f;
import com.google.android.youtube.ui.C0096i;
import com.google.android.youtube.ui.InterfaceC0104q;
import com.google.android.youtube.ui.ViewOnClickListenerC0088a;
import defpackage.C0192fn;
import defpackage.InterfaceC0004ad;
import defpackage.V;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CategoriesActivity extends YouTubeActivity implements defpackage.I, AdapterView.OnItemClickListener, InterfaceC0104q {
    private ListView a;
    private ArrayAdapter b;
    private InterfaceC0004ad c;
    private String d;
    private ViewOnClickListenerC0088a e;
    private String f;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        C0081l.a("Categories request failed", exc);
        this.e.b(C0093f.a(this, exc), true);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.b.setNotifyOnChange(false);
        this.e.a();
        String str = this.d;
        ArrayAdapter arrayAdapter = this.b;
        boolean zContains = V.a.contains(str);
        for (C0192fn c0192fn : (List) obj2) {
            String str2 = c0192fn.c;
            if (!c0192fn.d && str2 != null && (!zContains || str2.contains(str))) {
                arrayAdapter.add(c0192fn);
            }
        }
        this.b.notifyDataSetChanged();
    }

    @Override // com.google.android.youtube.YouTubeActivity
    protected final void a(YouTubeApplication youTubeApplication) {
        this.c = youTubeApplication.j().r();
    }

    @Override // com.google.android.youtube.YouTubeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.categories_activity);
        this.a = (ListView) findViewById(R.id.categories);
        this.b = new ArrayAdapter(this, R.layout.category_item, R.id.category);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.status, (ViewGroup) this.a, false);
        C0096i c0096i = new C0096i(this.b, viewInflate);
        this.e = new ViewOnClickListenerC0088a(viewInflate, c0096i, this);
        this.a.setAdapter((ListAdapter) c0096i);
        this.a.setOnItemClickListener(this);
        this.f = getString(R.string.loading);
        this.d = Locale.getDefault().getCountry().toUpperCase();
        b();
    }

    private void b() {
        this.e.a(this.f, true);
        this.c.a(V.a(Locale.getDefault().getLanguage().toLowerCase(), this.d), new defpackage.E(this, this));
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0192fn c0192fn = (C0192fn) this.b.getItem(i);
        String str = c0192fn.a;
        startActivity(new Intent().setClass(this, BrowseActivity.class).putExtra("category_term", str).putExtra("category_label", c0192fn.b));
    }

    @Override // com.google.android.youtube.ui.InterfaceC0104q
    public final void a_() {
        b();
    }
}
