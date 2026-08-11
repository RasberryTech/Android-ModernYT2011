package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.google.android.youtube.R;
import com.google.android.youtube.player.YouTubePlayer;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class gv {
    private static SimpleDateFormat a;
    private static SimpleDateFormat b;
    private static final HashSet c;

    static {
        a(0);
        a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
        c = new HashSet(Arrays.asList("mariannefaithfull", "sylver", "ingrooves", "davidbisbal", "barryip", "avantgarde", "TAPBackFromTheDead", "mirandaMurphy", "scarsonbroadway", "staracademy6", "Metalblade1982", "portishead", "EdubbOnline", "fabiano", "Nordman", "UniversalTest", "taiji", "NIKP", "oranjuicejones", "universalmusicmexico", "hayleywestenra", "ryanbingham", "SylviaMcNair", "melissaetheridge", "monacibuddisti", "NolwennLeroy", "paolobrera", "TAPUNWIGGED", "TheDissociatives", "emimusic", "parlophone", "capitolmusic", "capitolrecords", "virginrecords", "mutechannel", "muteusa"));
    }

    private gv() {
    }

    public static String a(int i) {
        int i2 = i / 60;
        int i3 = i2 / 60;
        if (i3 > 0) {
            i2 %= 60;
        }
        String string = Integer.toString(i % 60);
        if (string.length() == 1) {
            string = "0" + string;
        }
        String string2 = Integer.toString(i2);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        return i3 > 0 ? i3 + ":" + string2 + ":" + string : string2 + ":" + string;
    }

    public static String a(Date date, Resources resources) {
        int i;
        int i2;
        if (date == null) {
            return null;
        }
        long time = date.getTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis <= time) {
            return null;
        }
        int i3 = (int) ((jCurrentTimeMillis - time) / 1000);
        int i4 = i3 / 60;
        int i5 = i4 / 60;
        int i6 = i5 / 24;
        int i7 = i6 / 7;
        int i8 = i6 / 30;
        int i9 = i8 / 12;
        if (i9 > 0) {
            i5 = i9;
            i = R.string.ago_year_plural;
            i2 = R.string.ago_year_singular;
        } else if (i8 > 0) {
            i5 = i8;
            i = R.string.ago_month_plural;
            i2 = R.string.ago_month_singular;
        } else if (i7 > 0) {
            i5 = i7;
            i = R.string.ago_week_plural;
            i2 = R.string.ago_week_singular;
        } else if (i6 > 0) {
            i5 = i6;
            i = R.string.ago_day_plural;
            i2 = R.string.ago_day_singular;
        } else if (i5 > 0) {
            i2 = R.string.ago_hour_singular;
            i = R.string.ago_hour_plural;
        } else if (i4 > 0) {
            i5 = i4;
            i2 = R.string.ago_minute_singular;
            i = R.string.ago_minute_plural;
        } else if (i3 > 0) {
            i2 = R.string.ago_second_singular;
            i5 = i3;
            i = R.string.ago_second_plural;
        } else {
            i = 0;
            i2 = 0;
            i5 = 0;
        }
        if (i5 > 1) {
            return String.format(resources.getString(i), Integer.toString(i5));
        }
        if (i5 == 1) {
            return String.format(resources.getString(i2), Integer.toString(i5));
        }
        return null;
    }

    private static NetworkInfo e(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean a(Context context) {
        NetworkInfo networkInfoE = e(context);
        return networkInfoE != null && networkInfoE.isConnected();
    }

    public static boolean b(Context context) {
        int type;
        NetworkInfo networkInfoE = e(context);
        return networkInfoE != null && ((type = networkInfoE.getType()) == 1 || type == 6);
    }

    public static EnumC0211gf c(Context context) {
        NetworkInfo networkInfoE = e(context);
        if (networkInfoE != null) {
            switch (networkInfoE.getType()) {
                case 0:
                case YouTubePlayer.PLAYING /* 2 */:
                case YouTubePlayer.STOPPED /* 4 */:
                case YouTubePlayer.PROGRESS /* 5 */:
                    return EnumC0211gf.MOBILE_NETWORK;
                case YouTubePlayer.PREPARED /* 1 */:
                    return EnumC0211gf.WIFI;
                case YouTubePlayer.ENDED /* 6 */:
                    return EnumC0211gf.WIMAX;
            }
        }
        return EnumC0211gf.UNKNOWN;
    }

    public static String d(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getNetworkCountryIso() : Locale.getDefault().getCountry();
    }

    public static Uri a(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    public static String a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public static C0200fv a(C0198ft c0198ft) {
        ArrayList arrayListD = c0198ft.d();
        cJ cJVarE = c0198ft.e();
        Uri uri = cJVarE != null ? Uri.parse(cJVarE.toString()) : null;
        cJ cJVarF = c0198ft.f();
        return new C0200fv(c0198ft.a(), c0198ft.b(), c0198ft.c(), uri, cJVarF != null ? Uri.parse(cJVarF.toString()) : null, arrayListD);
    }

    public static int a(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static Date b(String str) {
        String str2;
        gq.a((Object) str);
        try {
            return a.parse(str);
        } catch (ParseException e) {
            try {
                int length = str.length() - 3;
                str2 = (length < 0 || str.charAt(length) != ':') ? str : str.substring(0, length) + str.substring(length + 1);
                try {
                    return b.parse(str2);
                } catch (ParseException e2) {
                    String str3 = "Invalid RFC3339 date: " + str2;
                    return null;
                }
            } catch (ParseException e3) {
                str2 = str;
            }
        }
    }

    public static Uri c(String str) {
        return Uri.parse(Uri.encode(str, ":/?=&"));
    }

    public static boolean d(String str) {
        return str.toLowerCase().contains("vevo") || c.contains(str);
    }

    public static void a(String str, String str2, long j) {
        gq.a(j > 0, "limit may not be <= 0");
        gq.a(str, (Object) "dirPath may not be empty");
        gq.a((Object) str2, (Object) "suffix may not be null");
        File file = new File(str);
        gq.a(file.isDirectory(), str + " is not a directory");
        File[] fileArrListFiles = file.listFiles(new gw(str2));
        if (fileArrListFiles != null) {
            int length = 0;
            for (File file2 : fileArrListFiles) {
                length = (int) (file2.length() + ((long) length));
            }
            if (length < j) {
                String str3 = "Dir is below limit, no need to shrink: [size=" + length + ", limit=" + j + "]";
                return;
            }
            Arrays.sort(fileArrListFiles, new gx());
            int i = 0;
            int i2 = length;
            for (File file3 : fileArrListFiles) {
                if (i2 >= j) {
                    long length2 = file3.length();
                    if (file3.delete()) {
                        i2 = (int) (((long) i2) - length2);
                        i++;
                    }
                } else {
                    String str4 = "Dir shrunk: [deleted=" + i + ", newSize=" + i2 + ", previousSize=" + length + ", limit=" + j + "]";
                    return;
                }
            }
        }
    }
}
