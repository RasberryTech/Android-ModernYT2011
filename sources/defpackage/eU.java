package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public final class eU {
    private dC c;
    private String[] b = new String[64];
    private Hashtable a = new Hashtable();

    public eU(dC dCVar) {
        this.c = dCVar;
        a();
    }

    private void a() {
        byte[] bArrA = this.c.a("MasfResumableIds");
        if (bArrA == null) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrA);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            int i = dataInputStream.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                String utf = dataInputStream.readUTF();
                String utf2 = dataInputStream.readUTF();
                long j = dataInputStream.readLong();
                if (691200000 + j < jCurrentTimeMillis) {
                    break;
                }
                this.a.put(utf, new eV(utf2, j));
                this.b[i2] = utf;
            }
        } catch (IOException e) {
            this.a.clear();
            this.b = new String[64];
        } finally {
            dA.a(dataInputStream);
            dA.a(byteArrayInputStream);
        }
    }

    private String b(String str) {
        if (this.a.containsKey(str)) {
            return ((eV) this.a.get(str)).b();
        }
        return null;
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int size = this.a.size() - 1; size >= 0 && c(this.b[size]) + 691200000 < jCurrentTimeMillis; size--) {
            this.a.remove(this.b[size]);
            this.b[size] = null;
        }
    }

    private long c(String str) {
        if (this.a.containsKey(str)) {
            return ((eV) this.a.get(str)).a();
        }
        return -1L;
    }

    private void c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            b();
            dataOutputStream.writeInt(this.a.size());
            for (int i = 0; i < this.a.size(); i++) {
                dataOutputStream.writeUTF(this.b[i]);
                dataOutputStream.writeUTF(b(this.b[i]));
                dataOutputStream.writeLong(c(this.b[i]));
            }
            this.c.a("MasfResumableIds", byteArrayOutputStream.toByteArray());
            this.c.a();
        } catch (IOException e) {
        } finally {
            dA.a(dataOutputStream);
            dA.a(byteArrayOutputStream);
        }
    }

    private void d(String str) {
        for (int i = 0; i < this.a.size(); i++) {
            if (this.b[i].equals(str)) {
                System.arraycopy(this.b, i + 1, this.b, i, (this.a.size() - i) - 1);
                this.a.remove(str);
                return;
            }
        }
    }

    public final void a(String str) {
        d(str);
        c();
    }

    public final void a(String str, String str2) {
        if (this.a.contains(str)) {
            d(str);
        } else if (this.a.size() == 64) {
            this.a.remove(this.b[63]);
            this.b[63] = null;
        }
        System.arraycopy(this.b, 0, this.b, 1, this.a.size());
        this.b[0] = str;
        this.a.put(str, new eV(str2, System.currentTimeMillis()));
        c();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RequestIdStore[");
        String[] strArr = new String[this.a.size()];
        System.arraycopy(this.b, 0, strArr, 0, strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            stringBuffer.append("<'" + strArr[i]);
            stringBuffer.append("', '" + b(strArr[i]));
            stringBuffer.append("', " + c(strArr[i]) + ">");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
