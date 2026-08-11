package defpackage;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class dG extends AbstractC0144dt implements dC {
    private File a;

    public dG(String str) {
        this.a = new File(str);
        if (!this.a.isDirectory()) {
            throw new IllegalStateException("Directory " + str + " must already exist");
        }
        if (!this.a.canWrite()) {
            throw new IllegalStateException("Directory " + str + " must be writeable");
        }
        if (!this.a.canRead()) {
            throw new IllegalStateException("Directory " + str + " must be readable");
        }
    }

    private File c(String str) {
        return new File(new File(this.a, "FIXED_DATA_").getAbsolutePath() + str);
    }

    @Override // defpackage.dC
    public final int a(byte[] bArr, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(c(str));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return (((bArr.length - 1) / 4096) + 1) * 4096;
        } catch (FileNotFoundException e) {
            Log.w("Fixed_Persistence_Store", "Couldn't write block:  " + e.getMessage());
            return -1;
        } catch (IOException e2) {
            Log.w("Fixed_Persistence_Store", "Couldn't write block:  " + e2.getMessage());
            return -1;
        }
    }

    @Override // defpackage.dC
    public final byte[] b(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(c(str));
            int iAvailable = fileInputStream.available();
            byte[] bArr = new byte[iAvailable];
            if (fileInputStream.read(bArr, 0, iAvailable) < iAvailable) {
                Log.w("Fixed_Persistence_Store", "Didn't read full file:  " + str);
            }
            fileInputStream.close();
            return bArr;
        } catch (FileNotFoundException e) {
            Log.w("Fixed_Persistence_Store", "Couldn't find file:  " + e.getMessage());
            return null;
        } catch (IOException e2) {
            Log.w("Fixed_Persistence_Store", "Couldn't read file:  " + e2.getMessage());
            return null;
        }
    }
}
