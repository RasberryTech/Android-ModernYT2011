package com.google.android.youtube;

import android.accounts.AccountManager;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.SearchRecentSuggestions;
import android.provider.Settings;
import android.text.TextUtils;
import defpackage.C0013am;
import defpackage.C0130de;
import defpackage.C0171et;
import defpackage.C0210ge;
import defpackage.C0222n;
import defpackage.EnumC0214gi;
import defpackage.InterfaceC0005ae;
import defpackage.V;
import defpackage.aW;
import defpackage.cX;
import defpackage.dM;
import defpackage.gm;
import defpackage.gn;
import defpackage.gs;
import defpackage.gv;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

/* JADX INFO: loaded from: classes.dex */
public class YouTubeApplication extends Application {
    public static volatile boolean a = true;
    private static YouTubeApplication b;
    private SearchRecentSuggestions c;
    private com.google.android.youtube.suggest.a d;
    private long e = 0;
    private C0210ge f;
    private File g;
    private String h;
    private gn i;
    private Executor j;
    private HttpClient k;
    private SharedPreferences l;
    private aW m;
    private gs n;
    private defpackage.J o;
    private C0013am p;
    private boolean q;
    private boolean r;

    public YouTubeApplication() {
        b = this;
    }

    @Override // android.app.Application
    public void onCreate() {
        String str;
        EnumC0214gi enumC0214gi;
        this.e = System.currentTimeMillis();
        this.l = getSharedPreferences("youtube", 0);
        String string = this.l.getString("version", null);
        String strC = c();
        if (strC.equals(string)) {
            this.q = false;
            this.r = this.l.getBoolean("terms_accepted", false);
        } else {
            this.l.edit().putString("version", strC).remove("terms_accepted").commit();
            this.q = true;
            this.r = false;
        }
        a = this.l.getBoolean("andicapped", true);
        this.i = new gn();
        this.j = Executors.newCachedThreadPool();
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        HttpProtocolParams.setUserAgent(basicHttpParams, "Android-YouTube/2");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        this.k = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        this.m = aW.a();
        this.n = new gs(this, this.l);
        this.j.execute(this.n);
        V.a(this.n);
        V.a(gv.d(this));
        if (this.h != null) {
            str = this.h;
        } else {
            this.h = "mvapp-android-google";
            Cursor cursorQuery = getContentResolver().query(Uri.parse("content://com.google.settings/partner"), new String[]{"value"}, "name='youtube_client_id'", null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                this.h = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("value"));
                if (TextUtils.isEmpty(this.h)) {
                    this.h = "mvapp-android-google";
                }
            }
            if (!this.h.startsWith("mvapp-android-")) {
                this.h = "mvapp-android-" + this.h;
            }
            String str2 = "Distribution channel:" + this.h;
            str = this.h;
        }
        String str3 = "distributionChannel " + str;
        String strReplaceAll = String.format("[%s][%s]", Build.MODEL, Build.FINGERPRINT).replaceAll(",", "-");
        String str4 = "platformId " + strReplaceAll;
        cX.a(new C0130de(getApplicationContext()));
        ((dM) cX.a().f()).a("Android-YouTube/2");
        C0171et.a("http://www.google.com/m/appreq/mobilevideo", "youtube", c(), strReplaceAll, str);
        this.g = new File(getCacheDir(), "ps.log");
        this.f = new C0210ge(new gm(), new Q(this));
        if (this.g.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.g);
                this.f.a(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                C0081l.b("Error loading logs " + e);
            }
        }
        C0210ge c0210ge = this.f;
        String strC2 = c();
        SharedPreferences sharedPreferences = this.l;
        String string2 = sharedPreferences.getString("MasfLogYouTubeApplicationVersion", null);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("MasfLogYouTubeApplicationVersion", strC2);
        editorEdit.commit();
        if (string2 == null) {
            enumC0214gi = EnumC0214gi.FIRST_STARTUP;
        } else {
            enumC0214gi = string2.equals(strC2) ? EnumC0214gi.NORMAL_STARTUP : EnumC0214gi.UPGRADE_STARTUP;
        }
        System.currentTimeMillis();
        c0210ge.a(enumC0214gi);
        this.f.d();
        defpackage.Q q = new defpackage.Q(this.k, Settings.Secure.getString(getContentResolver(), "android_id"), this.l);
        this.p = new C0013am(AccountManager.get(this), this.l, this.f);
        if (this.q) {
            new O(this, getCacheDir().listFiles()).start();
        }
        this.o = new defpackage.J(this.j, this.k, this.i, getCacheDir().getAbsolutePath(), this.m);
        this.o.a(q, this.p, gv.d(this), g());
        this.c = new SearchRecentSuggestions(this, "com.google.android.youtube.SuggestionProvider", 1);
        if (a) {
            this.o.a().a(V.b("sg32eS1XDi8"), new P(this));
        }
    }

    public final boolean a() {
        return this.r;
    }

    public final void b() {
        this.r = true;
        this.l.edit().putBoolean("terms_accepted", true).commit();
    }

    public final String c() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            C0081l.b("Could not retrieve app version number: " + e);
            return "";
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        C0171et.a();
        this.f.c();
        super.onTerminate();
    }

    public static YouTubeApplication d() {
        return b;
    }

    public final SearchRecentSuggestions e() {
        return this.c;
    }

    public final C0210ge f() {
        return this.f;
    }

    public final String g() {
        return C0222n.a(getContentResolver(), "youtube_client_id", "android-google");
    }

    public final void a(com.google.android.youtube.suggest.a aVar) {
        this.d = aVar;
    }

    public final void h() {
        if (this.d != null) {
            this.d.b();
        }
    }

    public final gs i() {
        return this.n;
    }

    public final InterfaceC0005ae j() {
        return this.o;
    }

    public final C0013am k() {
        return this.p;
    }
}
