package com.google.android.youtube;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class y implements View.OnClickListener {
    private /* synthetic */ ResultsActivity a;

    y(ResultsActivity resultsActivity) {
        this.a = resultsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b("header: search");
        this.a.onSearchRequested();
    }
}
