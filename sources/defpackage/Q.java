package defpackage;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.ConditionVariable;
import android.util.Base64;
import com.google.android.youtube.C0081l;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class Q implements I, aN {
    public static final byte[] a = {65, 73, 51, 57, 115, 105, 55, 50, 79, 53, 84, 113, 113, 51, 107, 78, 110, 45, 48, 69, 88, 50, 87, 72, 117, 78, 55, 100, 98, 88, 77, 119, 121, 69, 111, 114, 52, 119, 100, 83, 75, 54, 95, 71, 88, 87, 122, 109, 102, 66, 103, 50, 95, 68, 57, 83, 67, 118, 84, 76, 119, 70, 98, 71, 50, 107, 86, 70, 74, 104, 73, 81, 53, 83, 105, 78, 121, 72, 69, 102, 84, 55, 54, 88, 85, 70, 85, 99, 56, 52, 115, 76, 102, 95, 76, 103, 48, 81};
    private static byte[] b = {85, 66, 118, 121, 103, 82, 56, 51, 67, 57, 98, 77, 90, 113, 103, 85, 121, 88, 122, 108, 80, 65, 61, 61};
    private final HttpClient c;
    private final String d;
    private final SharedPreferences e;
    private volatile boolean f;
    private final ConditionVariable g;
    private volatile C0194fp h;
    private volatile R i;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        this.h = null;
        this.i = new R(exc);
        this.g.open();
        this.f = false;
        C0081l.a("device registration failed");
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        this.h = (C0194fp) obj2;
        this.i = null;
        C0194fp.a(this.h, this.e);
        this.g.open();
        this.f = false;
    }

    public Q(HttpClient httpClient, String str, SharedPreferences sharedPreferences) {
        this.e = sharedPreferences;
        this.c = httpClient;
        this.d = str;
        String string = sharedPreferences.getString("device_id", null);
        String string2 = sharedPreferences.getString("device_key", null);
        this.h = (string == null || string2 == null) ? null : new C0194fp(string, Base64.decode(string2, 0));
        this.g = this.h == null ? new ConditionVariable(false) : null;
    }

    public final String a(Uri uri) throws R {
        boolean z;
        if (this.h != null) {
            return this.h.a(uri);
        }
        synchronized (this) {
            if (this.f) {
                z = false;
            } else {
                this.f = true;
                this.g.close();
                z = true;
            }
        }
        if (z) {
            new Y(this.c, new bQ(EnumC0047bt.b), this).a(Uri.parse(String.format("https://www.google.com/youtube/accounts/registerDevice?developer=%s&serialNumber=%s", new String(a), this.d)), this);
        } else {
            this.g.block();
        }
        if (this.i != null) {
            throw this.i;
        }
        return this.h.a(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.aN
    public C0194fp a(HttpResponse httpResponse) throws aK {
        try {
            Properties properties = new Properties();
            properties.load(httpResponse.getEntity().getContent());
            String property = properties.getProperty("DeviceId");
            String property2 = properties.getProperty("DeviceKey");
            if (property != null && property2 != null) {
                return new C0194fp(property, a(property2));
            }
            throw new aK("invalid device registration response");
        } catch (IOException e) {
            throw new aK(e);
        }
    }

    private static byte[] a(String str) throws aK {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] bArrDecode = Base64.decode(b, 0);
            byte[] bArrDecode2 = Base64.decode(str, 0);
            try {
                cipher.init(2, new SecretKeySpec(bArrDecode, "AES"));
                byte[] bArrDoFinal = cipher.doFinal(bArrDecode2);
                if (bArrDoFinal.length > 20) {
                    byte[] bArr = new byte[20];
                    System.arraycopy(bArrDoFinal, 0, bArr, 0, 20);
                    return bArr;
                }
                return bArrDoFinal;
            } catch (InvalidKeyException e) {
                throw new aK(e);
            } catch (BadPaddingException e2) {
                throw new aK(e2);
            } catch (IllegalBlockSizeException e3) {
                throw new aK(e3);
            }
        } catch (NoSuchAlgorithmException e4) {
            throw new aK(e4);
        } catch (NoSuchPaddingException e5) {
            throw new aK(e5);
        }
    }
}
