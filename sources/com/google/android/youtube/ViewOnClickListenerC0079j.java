package com.google.android.youtube;

import android.view.View;

/* JADX INFO: renamed from: com.google.android.youtube.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC0079j implements View.OnClickListener {
    private /* synthetic */ HomeActivity a;

    ViewOnClickListenerC0079j(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b("header: search");
        this.a.onSearchRequested();
    }
}
