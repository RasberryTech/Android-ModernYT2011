package com.google.android.youtube.widget;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.HomeActivity;
import com.google.android.youtube.WatchActivity;
import com.google.android.youtube.YouTubeApplication;
import defpackage.C0210ge;
import defpackage.EnumC0215gj;
import defpackage.gp;

/* JADX INFO: loaded from: classes.dex */
public class WidgetActivity extends Activity {
    private static final int a = C0210ge.a("WidgetActivity");
    private C0210ge b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = ((YouTubeApplication) getApplication()).f();
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.youtube.action.widget_camera".equals(action)) {
            a("widget: camera");
            gp.b(this);
            return;
        }
        if ("com.google.android.youtube.action.widget_search".equals(action)) {
            a("widget: search");
            startActivityForResult(HomeActivity.a(this).setAction("com.google.android.youtube.action.search"), 0);
            return;
        }
        if ("com.google.android.youtube.action.widget_home".equals(action)) {
            a("widget: logo");
            startActivityForResult(HomeActivity.a(this), 0);
        } else if ("com.google.android.youtube.action.widget_play".equals(action)) {
            a("widget: video");
            this.b.a(EnumC0215gj.WIDGET, 0);
            startActivityForResult(WatchActivity.a(this, intent.getStringExtra("video_id")), 0);
        } else {
            C0081l.b("missing a widget launch action");
            finish();
        }
    }

    public static PendingIntent a(Context context) {
        return b(context, "com.google.android.youtube.action.widget_camera");
    }

    public static PendingIntent b(Context context) {
        return b(context, "com.google.android.youtube.action.widget_search");
    }

    public static PendingIntent c(Context context) {
        return b(context, "com.google.android.youtube.action.widget_home");
    }

    public static PendingIntent a(Context context, String str) {
        return PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) WidgetActivity.class).setAction("com.google.android.youtube.action.widget_play").setData(new Uri.Builder().appendPath("/" + str).build()).putExtra("video_id", str).setFlags(75497472), 0);
    }

    private static PendingIntent b(Context context, String str) {
        return PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) WidgetActivity.class).setAction(str).setData(new Uri.Builder().appendPath("/" + str).build()).setFlags(75497472), 0);
    }

    private void a(String str) {
        this.b.a(a, C0210ge.a(str));
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!gp.a(this, i, i2, intent, null)) {
            finish();
        }
    }
}
