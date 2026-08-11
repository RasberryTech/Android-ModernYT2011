package com.google.android.youtube;

import android.util.Log;
import com.google.android.youtube.player.YouTubePlayer;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.google.android.youtube.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0081l {
    private static final String a;
    private static /* synthetic */ boolean b;

    static {
        b = !C0081l.class.desiredAssertionStatus();
        String str = C0081l.class.getPackage().getName() + ".";
        a = str;
        str.length();
        C0081l.class.getName();
        Pattern.compile("");
    }

    private C0081l() {
    }

    public static void a(String str) {
        a(EnumC0083n.ERROR, str, null);
    }

    public static void a(String str, Throwable th) {
        a(EnumC0083n.ERROR, str, th);
    }

    public static void b(String str) {
        a(EnumC0083n.WARNING, str, null);
    }

    public static void b(String str, Throwable th) {
        a(EnumC0083n.WARNING, str, th);
    }

    private static void a(EnumC0083n enumC0083n, String str, Throwable th) {
        switch (C0082m.a[enumC0083n.ordinal()]) {
            case YouTubePlayer.PREPARED /* 1 */:
                Log.e("YouTube", str, th);
                return;
            case YouTubePlayer.PLAYING /* 2 */:
                Log.w("YouTube", str, th);
                return;
            case YouTubePlayer.PAUSED /* 3 */:
                Log.i("YouTube", str, th);
                return;
            case YouTubePlayer.STOPPED /* 4 */:
                Log.d("YouTube", str, th);
                return;
            case YouTubePlayer.PROGRESS /* 5 */:
                return;
            default:
                if (!b) {
                    throw new AssertionError("Unknown type.");
                }
                return;
        }
    }
}
