package com.google.android.youtube.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

/* JADX INFO: renamed from: com.google.android.youtube.ui.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0096i extends BaseAdapter implements WrapperListAdapter {
    private final BaseAdapter a;
    private final View b;

    public C0096i(BaseAdapter baseAdapter, View view) {
        this.a = baseAdapter;
        this.b = view;
        this.b.setClickable(false);
        baseAdapter.registerDataSetObserver(new C0097j(this));
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.getCount() + (this.b.getVisibility() == 0 ? 1 : 0);
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (i == this.a.getCount()) {
            return null;
        }
        return this.a.getItem(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (i == this.a.getCount()) {
            return -1L;
        }
        return this.a.getItemId(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (i == this.a.getCount()) {
            return this.b;
        }
        return this.a.getView(i, view == this.b ? null : view, viewGroup);
    }

    @Override // android.widget.WrapperListAdapter
    public final ListAdapter getWrappedAdapter() {
        return this.a;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        return this.a.areAllItemsEnabled() && this.b.getVisibility() != 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        if (i < this.a.getCount()) {
            return this.a.isEnabled(i);
        }
        return false;
    }
}
