package com.google.android.youtube.ui;

import android.accounts.AuthenticatorException;
import android.content.Context;
import android.widget.Toast;
import defpackage.aK;
import java.io.IOException;
import java.net.SocketException;
import org.apache.http.client.HttpResponseException;

/* JADX INFO: renamed from: com.google.android.youtube.ui.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0093f {
    private C0093f() {
    }

    public static String a(Context context, Throwable th) {
        boolean z;
        Throwable th2 = th;
        while (true) {
            Throwable cause = th2;
            while (true) {
                if (cause == null) {
                    z = false;
                    break;
                }
                if (defpackage.R.class.isAssignableFrom(cause.getClass())) {
                    z = true;
                    break;
                }
                cause = cause.getCause();
            }
            if (z) {
                return context.getString(com.google.android.youtube.R.string.error_dev_reg);
            }
            if (th2 instanceof AuthenticatorException) {
                return context.getString(com.google.android.youtube.R.string.error_authenticating);
            }
            if (th2 instanceof SocketException) {
                return context.getString(com.google.android.youtube.R.string.error_connection);
            }
            if (th2 instanceof HttpResponseException) {
                HttpResponseException httpResponseException = (HttpResponseException) th2;
                if (httpResponseException.getStatusCode() == 403) {
                    return context.getString(com.google.android.youtube.R.string.error_forbidden_action);
                }
                return context.getString(com.google.android.youtube.R.string.error_http, Integer.valueOf(httpResponseException.getStatusCode()));
            }
            if (th2 instanceof aK) {
                return context.getString(com.google.android.youtube.R.string.error_response);
            }
            if (th2 instanceof IOException) {
                return context.getString(com.google.android.youtube.R.string.error_network);
            }
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                return context.getString(com.google.android.youtube.R.string.error_generic);
            }
            th2 = cause2;
        }
    }

    public static void b(Context context, Throwable th) {
        Toast.makeText(context, a(context, th), 1).show();
    }
}
