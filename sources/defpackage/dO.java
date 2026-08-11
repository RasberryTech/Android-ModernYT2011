package defpackage;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class dO extends AbstractC0144dt implements dC {
    private Context a;

    public dO(Context context) {
        this.a = context;
    }

    private int b(byte[] bArr, String str) throws dD {
        byte[] bArr2;
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } catch (FileNotFoundException e) {
                throw new dD(e.getMessage(), -1);
            } catch (IOException e2) {
                throw new dD(e2.getMessage(), -1);
            }
        } else {
            bArr2 = bArr;
        }
        FileOutputStream fileOutputStreamOpenFileOutput = this.a.openFileOutput(c(str), 0);
        fileOutputStreamOpenFileOutput.write(bArr2);
        fileOutputStreamOpenFileOutput.close();
        return (((bArr2.length - 1) / 4096) + 1) * 4096;
    }

    private static String c(String str) {
        return "DATA_" + str;
    }

    @Override // defpackage.dC
    public final int a(byte[] bArr, String str) {
        try {
            return b(bArr, str);
        } catch (dD e) {
            return e.a();
        }
    }

    @Override // defpackage.dC
    public final byte[] b(String str) {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.a.openFileInput(c(str));
            int iAvailable = fileInputStreamOpenFileInput.available();
            byte[] bArr = new byte[iAvailable];
            fileInputStreamOpenFileInput.read(bArr, 0, iAvailable);
            fileInputStreamOpenFileInput.close();
            return bArr;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e2) {
            return null;
        }
    }
}
