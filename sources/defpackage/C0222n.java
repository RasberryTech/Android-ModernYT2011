package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: renamed from: n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0222n extends C0221m {
    private static Uri a = Uri.parse("content://com.google.settings/partner");

    /* JADX WARN: Code duplicated, block: B:19:0x005e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072  */
    private static String a(ContentResolver contentResolver, String str) throws Throwable {
        Cursor cursor;
        String string;
        try {
            Cursor cursorQuery = contentResolver.query(a, new String[]{"value"}, "name=?", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        string = cursorQuery.getString(0);
                    } else {
                        string = null;
                    }
                } catch (SQLException e) {
                    cursor = cursorQuery;
                    e = e;
                    try {
                        Log.e("GoogleSettings", "Can't get key " + str + " from " + a, e);
                        if (cursor == null) {
                            return null;
                        }
                        cursor.close();
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    cursor = cursorQuery;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                string = null;
            }
            if (cursorQuery == null) {
                return string;
            }
            cursorQuery.close();
            return string;
        } catch (SQLException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public static String a(ContentResolver contentResolver, String str, String str2) throws Throwable {
        String strA = a(contentResolver, str);
        return strA == null ? str2 : strA;
    }
}
