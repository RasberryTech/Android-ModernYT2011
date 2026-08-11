package com.google.android.youtube;

import android.app.Activity;
import android.widget.ListView;
import com.google.android.youtube.widget.WidgetProvider;
import defpackage.InterfaceC0004ad;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.youtube.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0080k extends com.google.android.youtube.ui.G {
    private /* synthetic */ HomeActivity c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0080k(HomeActivity homeActivity, Activity activity, ListView listView, defpackage.C c, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2, InterfaceC0004ad interfaceC0004ad3, boolean z) {
        super(activity, listView, c, interfaceC0004ad, interfaceC0004ad2, interfaceC0004ad3, false);
        this.c = homeActivity;
    }

    @Override // com.google.android.youtube.ui.G, com.google.android.youtube.ui.C0100m
    protected final void a(List list) {
        super.a(list);
        WidgetProvider.a(this.c);
    }
}
