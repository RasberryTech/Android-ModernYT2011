package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.youtube.R;

/* JADX INFO: loaded from: classes.dex */
public final class gp {
    public static boolean a(Context context) {
        return context.getPackageManager().resolveActivity(a((Uri) null, (String) null), 0) != null;
    }

    public static void a(Activity activity) {
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setType("video/*");
        activity.startActivityForResult(Intent.createChooser(intent, activity.getText(R.string.pick_video_to_upload)), 901);
    }

    public static void b(Activity activity) {
        Intent intentPutExtra = new Intent().setClassName("com.google.android.camera", "com.android.camera.VideoCamera").setAction("android.media.action.VIDEO_CAPTURE").putExtra("android.intent.extra.durationLimit", 600).putExtra("android.intent.extra.quickCapture", true);
        if (activity.getPackageManager().resolveActivity(intentPutExtra, 0) == null) {
            intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("android.intent.extra.quickCapture", true);
        }
        activity.startActivityForResult(intentPutExtra, 900);
    }

    public static boolean a(Activity activity, int i, int i2, Intent intent, String str) {
        switch (i) {
            case 900:
            case 901:
                if (i2 != -1) {
                    return false;
                }
                activity.startActivityForResult(a(intent.getData(), str), 902);
                return true;
            case 902:
                return false;
            default:
                return false;
        }
    }

    private static Intent a(Uri uri, String str) {
        Intent intentPutExtra = new Intent().setClassName("com.google.android.apps.uploader", "com.google.android.apps.uploader.clients.youtube.YouTubeSettingsActivity").setAction("android.intent.action.SEND").setDataAndType(uri, "video/*").putExtra("android.intent.extra.STREAM", uri);
        if (str != null) {
            intentPutExtra.putExtra("com.google.android.apps.uploader.extra.preferredAccount", str);
        }
        return intentPutExtra;
    }

    public static void a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        context.startActivity(intent);
    }

    public static String[] a(Uri uri) {
        String str;
        if ("vnd.youtube".equals(uri.getScheme())) {
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            if (schemeSpecificPart.startsWith("//")) {
                schemeSpecificPart = schemeSpecificPart.substring(2);
            }
            String query = uri.getQuery();
            if (query != null) {
                schemeSpecificPart = schemeSpecificPart.substring(0, schemeSpecificPart.indexOf(query) - 1);
            }
            return new String[]{schemeSpecificPart, query};
        }
        String path = uri.getPath();
        if (path.startsWith("/watch")) {
            String queryParameter = uri.getQueryParameter("v");
            String query2 = uri.getQuery();
            String str2 = "v=" + queryParameter;
            if (query2.length() == str2.length()) {
                str = null;
            } else {
                int iIndexOf = query2.indexOf(str2);
                int length = str2.length() + iIndexOf;
                String str3 = iIndexOf > 0 ? "" + query2.substring(0, iIndexOf) : "";
                str = length + 1 < query2.length() ? str3 + query2.substring(length + 1) : str3;
            }
            return new String[]{queryParameter, str};
        }
        if (path.startsWith("/v/")) {
            String lastPathSegment = uri.getLastPathSegment();
            int iIndexOf2 = lastPathSegment.indexOf("&");
            return iIndexOf2 >= 0 ? new String[]{lastPathSegment.substring(0, iIndexOf2), lastPathSegment.substring(iIndexOf2 + 1, lastPathSegment.length())} : new String[]{lastPathSegment, null};
        }
        return new String[]{null, null};
    }
}
