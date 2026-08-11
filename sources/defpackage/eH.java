package defpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public final class eH {
    private static String[] a = {"application/atom+xml", "application/binary", "image/jpg", "image/png", "multipart/alternative", "multipart/mixed", "multipart/related", "text/plain", "text/xml"};
    private static int[] b = {24929, 24930, 26986, 26992, 28001, 28013, 28018, 29808, 29816};

    public static String a(int i) {
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] == i) {
                return a[i2];
            }
        }
        return null;
    }

    public static Hashtable a(DataInputStream dataInputStream) {
        Hashtable hashtable = new Hashtable();
        int i = dataInputStream.readByte() & 255;
        for (int i2 = 0; i2 < i; i2++) {
            hashtable.put(dataInputStream.readUTF(), dataInputStream.readUTF());
        }
        return hashtable;
    }

    public static void a(DataOutputStream dataOutputStream, String str) throws IOException {
        String strSubstring;
        String str2;
        int i;
        int iIndexOf = str.indexOf(59);
        if (iIndexOf >= 0) {
            String strSubstring2 = str.substring(0, iIndexOf);
            strSubstring = str.substring(iIndexOf + 1);
            str2 = strSubstring2;
        } else {
            strSubstring = "";
            str2 = str;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= a.length) {
                i = 0;
                break;
            } else {
                if (str2.equals(a[i2])) {
                    i = b[i2];
                    break;
                }
                i2++;
            }
        }
        if (i > 0) {
            dataOutputStream.writeShort(i);
            dataOutputStream.writeUTF(strSubstring);
        } else {
            dataOutputStream.writeShort(0);
            dataOutputStream.writeUTF(str);
        }
    }

    public static void a(DataOutputStream dataOutputStream, Hashtable hashtable, String str) throws IOException {
        dataOutputStream.writeByte((hashtable != null ? hashtable.size() : 0) + (str != null ? 1 : 0));
        if (str != null) {
            dataOutputStream.writeUTF("Content-Type");
            dataOutputStream.writeUTF(str);
        }
        if (hashtable != null) {
            Enumeration enumerationKeys = hashtable.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str2 = (String) enumerationKeys.nextElement();
                String str3 = (String) hashtable.get(str2);
                dataOutputStream.writeUTF(str2);
                dataOutputStream.writeUTF(str3);
            }
        }
    }
}
