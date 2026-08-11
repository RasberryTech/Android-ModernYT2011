package com.google.android.youtube.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.Html;
import android.widget.RemoteViews;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.R;
import com.google.android.youtube.YouTubeApplication;
import defpackage.C0008ah;
import defpackage.C0013am;
import defpackage.I;
import defpackage.InterfaceC0005ae;
import defpackage.InterfaceC0021au;
import defpackage.V;
import defpackage.fH;
import defpackage.gp;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class WidgetProvider extends AppWidgetProvider {
    private static int a = 15;

    static /* synthetic */ RemoteViews a(Context context, List list) {
        RemoteViews remoteViewsE = e(context);
        remoteViewsE.removeAllViews(R.id.video_flipper);
        remoteViewsE.setViewVisibility(R.id.video_flipper, 0);
        remoteViewsE.setViewVisibility(R.id.video_flipper_alt, 8);
        int iMin = Math.min(list.size(), a);
        for (int i = 0; i < iMin; i++) {
            a aVar = (a) list.get(i);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_teaser);
            remoteViews.setTextViewText(R.id.title, aVar.a.i);
            remoteViews.setImageViewBitmap(R.id.thumbnail, aVar.b);
            remoteViews.setOnClickPendingIntent(R.id.teaser_video, WidgetActivity.a(context, aVar.a.a));
            remoteViews.setTextViewText(R.id.by, Html.fromHtml(context.getString(R.string.widget_from_user, aVar.a.n)));
            remoteViews.setTextViewText(R.id.source, context.getString(aVar.c));
            remoteViewsE.addView(R.id.video_flipper, remoteViews);
        }
        return remoteViewsE;
    }

    static /* synthetic */ RemoteViews b(Context context) {
        RemoteViews remoteViewsE = e(context);
        remoteViewsE.setViewVisibility(R.id.widget_progress, 0);
        remoteViewsE.setViewVisibility(R.id.widget_messages, 8);
        remoteViewsE.setViewVisibility(R.id.widget_error, 8);
        remoteViewsE.setViewVisibility(R.id.video_flipper, 8);
        remoteViewsE.setViewVisibility(R.id.video_flipper_alt, 0);
        return remoteViewsE;
    }

    static /* synthetic */ RemoteViews c(Context context) {
        RemoteViews remoteViewsE = e(context);
        Resources resources = context.getResources();
        remoteViewsE.setTextViewText(R.id.widget_message, resources.getString(R.string.error_network));
        remoteViewsE.setTextViewText(R.id.widget_submessage, resources.getString(R.string.tap_to_retry));
        remoteViewsE.setViewVisibility(R.id.widget_progress, 8);
        remoteViewsE.setViewVisibility(R.id.widget_messages, 0);
        remoteViewsE.setViewVisibility(R.id.widget_error, 0);
        remoteViewsE.setOnClickPendingIntent(R.id.video_flipper_alt, f(context));
        remoteViewsE.setViewVisibility(R.id.video_flipper, 8);
        remoteViewsE.setViewVisibility(R.id.video_flipper_alt, 0);
        return remoteViewsE;
    }

    static /* synthetic */ void d(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + 3600000, f(context));
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        a(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str = "onReceive " + intent.getAction();
        if ("com.google.android.youtube.action.widget_update".equals(intent.getAction())) {
            a(context);
        } else {
            super.onReceive(context, intent);
        }
    }

    public static void a(Context context) {
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) WidgetProvider.class));
        if (appWidgetIds != null && appWidgetIds.length != 0) {
            ((AlarmManager) context.getSystemService("alarm")).cancel(f(context));
            context.startService(new Intent(context, (Class<?>) UpdateService.class));
        }
    }

    public class UpdateService extends Service implements I, InterfaceC0021au {
        private AppWidgetManager a;
        private b b;
        private ComponentName c;
        private C0013am d;

        @Override // defpackage.I
        public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
            this.a.updateAppWidget(this.c, WidgetProvider.c(this));
            WidgetProvider.d(this);
            stopSelf();
        }

        @Override // defpackage.I
        public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            List list = (List) obj2;
            if (list.size() == 0) {
                this.a.updateAppWidget(this.c, WidgetProvider.c(this));
                WidgetProvider.d(this);
            } else {
                this.a.updateAppWidget(this.c, WidgetProvider.a(this, list));
            }
            stopSelf();
        }

        @Override // android.app.Service
        public void onCreate() {
            YouTubeApplication youTubeApplication = (YouTubeApplication) getApplication();
            this.d = youTubeApplication.k();
            InterfaceC0005ae interfaceC0005aeJ = youTubeApplication.j();
            C0008ah c0008ah = new C0008ah(interfaceC0005aeJ, Locale.getDefault().getCountry());
            this.b = new b(c0008ah, c0008ah.a(), interfaceC0005aeJ.e());
            this.a = AppWidgetManager.getInstance(this);
            this.c = new ComponentName(this, (Class<?>) WidgetProvider.class);
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            this.a.updateAppWidget(this.c, WidgetProvider.b(this));
            this.d.a(this);
            return 1;
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // defpackage.InterfaceC0021au
        public final void a(fH fHVar) {
            this.b.a(V.a(fHVar), (I) this);
        }

        @Override // defpackage.InterfaceC0021au
        public final void a() {
            b();
        }

        @Override // defpackage.InterfaceC0021au
        public final void a(Exception exc) {
            b();
        }

        private void b() {
            this.b.a(V.a(), (I) this);
        }
    }

    private static RemoteViews e(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        remoteViews.setOnClickPendingIntent(R.id.widget_logo, WidgetActivity.c(context));
        remoteViews.setOnClickPendingIntent(R.id.search_icon, WidgetActivity.b(context));
        remoteViews.setViewVisibility(R.id.buttons, 0);
        if (gp.a(context)) {
            remoteViews.setViewVisibility(R.id.camera_icon, 0);
            remoteViews.setViewVisibility(R.id.camera_divider, 0);
            remoteViews.setOnClickPendingIntent(R.id.camera_icon, WidgetActivity.a(context));
        } else {
            C0081l.b("Uploader not found: Turning off widget camera button.");
            remoteViews.setViewVisibility(R.id.camera_icon, 8);
            remoteViews.setViewVisibility(R.id.camera_divider, 8);
        }
        return remoteViews;
    }

    private static PendingIntent f(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent("com.google.android.youtube.action.widget_update"), 0);
    }
}
