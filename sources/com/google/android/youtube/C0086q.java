package com.google.android.youtube;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.ListView;
import defpackage.InterfaceC0004ad;
import defpackage.fM;
import defpackage.gq;

/* JADX INFO: renamed from: com.google.android.youtube.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0086q extends com.google.android.youtube.ui.G {
    private /* synthetic */ MyChannelActivity c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0086q(MyChannelActivity myChannelActivity, Activity activity, ListView listView, InterfaceC0004ad interfaceC0004ad, InterfaceC0004ad interfaceC0004ad2, InterfaceC0004ad interfaceC0004ad3, boolean z) {
        super(activity, listView, interfaceC0004ad, interfaceC0004ad2, interfaceC0004ad3, true);
        this.c = myChannelActivity;
    }

    @Override // com.google.android.youtube.ui.G
    protected final Intent a(fM fMVar) {
        return new Intent(this.c, (Class<?>) WatchActivity.class).putExtra("video_id", (String) gq.a((Object) fMVar.a)).putExtra("unfavorite_uri", (Parcelable) gq.a(fMVar.e));
    }
}
