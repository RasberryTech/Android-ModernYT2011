package com.google.android.common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import defpackage.C0000a;
import defpackage.C0027b;
import defpackage.C0054c;
import defpackage.C0223o;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a(Context context, String str) {
        String strA;
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            Log.wtf("ParentalControl", "Network request on main thread");
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (!C0223o.a(contentResolver, "parental_control_check_enabled", false)) {
            return false;
        }
        if (str != null && (strA = C0223o.a(contentResolver, "parental_control_apps_list")) != null && !strA.contains(str)) {
            return false;
        }
        ContentResolver contentResolver2 = context.getContentResolver();
        SharedPreferences sharedPreferences = context.getSharedPreferences("ParentalControl", 0);
        C0000a c0000a = new C0000a(sharedPreferences);
        C0027b c0027b = new C0027b();
        c0027b.e = C0223o.a(contentResolver2, "parental_control_timeout_in_ms", 43200000L);
        if (new File("/proc/1").lastModified() > c0000a.a()) {
            c0000a.a(0L);
        }
        if (c0000a.a(c0027b) <= System.currentTimeMillis()) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                Log.e("ParentalControl", "Parental control unchanged: No ConnectivityManager");
            } else {
                C0054c c0054c = new C0054c(context, "Android-PC", false);
                try {
                    if (b(connectivityManager)) {
                        Uri uri = Uri.parse("http://android.clients.google.com/content/default");
                        InetAddress byName = InetAddress.getByName(uri.getHost());
                        byte[] address = byName.getAddress();
                        if (connectivityManager.requestRouteToHost(5, (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8))) {
                            Uri uriBuild = uri.buildUpon().authority(uri.getHost() + (uri.getPort() > 0 ? ":" + uri.getPort() : "")).build();
                            Log.i("ParentalControl", "Attempting litmus URL fetch: " + uriBuild);
                            HttpGet httpGet = new HttpGet(uriBuild.toString());
                            httpGet.setHeader("Connection", "close");
                            HttpResponse httpResponseExecute = c0054c.execute(httpGet);
                            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                            if (statusCode == 200) {
                                String strA2 = C0223o.a(contentResolver2, "parental_control_expected_response");
                                if (strA2 == null || strA2.equals(EntityUtils.toString(httpResponseExecute.getEntity()).trim())) {
                                    Log.i("ParentalControl", "Parental control is OFF: Litmus fetch succeeded");
                                    c0000a.b();
                                    sharedPreferences.edit().putBoolean("enabled", false);
                                } else {
                                    Log.i("ParentalControl", "Parental control is ON: Litmus content was modified");
                                    c0000a.b();
                                    sharedPreferences.edit().putBoolean("enabled", true).putString("landingUrl", "").commit();
                                }
                            } else if (statusCode == 302) {
                                String strA3 = C0223o.a(contentResolver2, "parental_control_redirect_regex");
                                Header firstHeader = httpResponseExecute.getFirstHeader("location");
                                String value = firstHeader == null ? null : firstHeader.getValue();
                                if (strA3 == null || value == null || !Pattern.matches(strA3, value)) {
                                    c0000a.c();
                                    StringBuilder sbAppend = new StringBuilder().append("Parental control unchanged: Unknown litmus redirect ");
                                    if (value == null) {
                                        value = "(none)";
                                    }
                                    Log.i("ParentalControl", sbAppend.append(value).toString());
                                } else {
                                    Log.i("ParentalControl", "Parental control is ON: Litmus redirects to " + value);
                                    c0000a.b();
                                    sharedPreferences.edit().putBoolean("enabled", true).putString("landingUrl", value).commit();
                                }
                            }
                        } else {
                            Log.e("ParentalControl", "Parental control unchanged: Error rerouting " + byName);
                            c0000a.c();
                        }
                    } else {
                        c0000a.c();
                    }
                } catch (IOException e) {
                    Log.e("ParentalControl", "Parental control unchanged: Litmus fetch failed", e);
                    c0000a.c();
                } finally {
                    c0054c.a();
                    connectivityManager.stopUsingNetworkFeature(0, "enableHIPRI");
                }
            }
        }
        return context.getSharedPreferences("ParentalControl", 0).getBoolean("enabled", false);
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        return connectivityManager.getNetworkInfo(5).isConnected();
    }

    private static boolean b(ConnectivityManager connectivityManager) {
        boolean zA = a(connectivityManager);
        int iStartUsingNetworkFeature = connectivityManager.startUsingNetworkFeature(0, "enableHIPRI");
        if (zA) {
            return true;
        }
        if (iStartUsingNetworkFeature != 0 && iStartUsingNetworkFeature != 1) {
            Log.e("ParentalControl", "Parental control unchanged: Mobile network error, code " + iStartUsingNetworkFeature);
            return false;
        }
        for (int i = 0; i < 20; i++) {
            Log.i("ParentalControl", "Waiting 1000ms for mobile network");
            SystemClock.sleep(1000L);
            if (a(connectivityManager)) {
                return true;
            }
        }
        Log.e("ParentalControl", "Parental control unchanged: Timed out waiting for mobile network");
        return false;
    }

    private a() {
    }
}
