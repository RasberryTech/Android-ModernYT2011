package defpackage;

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.google.android.youtube.C0081l;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: fp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0194fp {
    private final String a;
    private final byte[] b;

    public C0194fp(String str, byte[] bArr) {
        gq.a(str, (Object) "deviceId cannot be empty");
        gq.a(bArr, "deviceKey cannot be null");
        gq.a(bArr.length == 20, "deviceKey must be 20 bytes");
        this.a = str;
        this.b = bArr;
    }

    public final String a(Uri uri) {
        StringBuilder sb = new StringBuilder(uri.getEncodedPath());
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery != null) {
            sb.append("?").append(encodedQuery);
        }
        return String.format("device-id=\"%s\", data=\"%s\"", this.a, a(sb.toString(), this.b));
    }

    private static String a(String str, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return new String(Base64.encode(mac.doFinal(str.getBytes()), 0)).trim();
        } catch (InvalidKeyException e) {
            C0081l.a("error signing request", e);
            return null;
        } catch (NoSuchAlgorithmException e2) {
            C0081l.a("error signing request", e2);
            return null;
        }
    }

    public static void a(C0194fp c0194fp, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString("device_id", c0194fp.a).putString("device_key", new String(Base64.encode(c0194fp.b, 0))).commit();
    }
}
