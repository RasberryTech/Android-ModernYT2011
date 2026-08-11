package defpackage;

import com.google.android.youtube.player.YouTubePlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

/* JADX INFO: renamed from: dc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0128dc {
    private static byte[] a;

    static {
        new Vector();
        if (a != null) {
            System.gc();
            try {
                a = new byte[4096];
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private C0128dc() {
    }

    private static Object a(String str, int i) {
        byte[] bArrA = cX.a().g().a(str);
        DataInputStream dataInputStream = bArrA == null ? null : new DataInputStream(new ByteArrayInputStream(bArrA));
        if (dataInputStream == null) {
            return null;
        }
        try {
            switch (i) {
                case 0:
                    return new Boolean(dataInputStream.readBoolean());
                case YouTubePlayer.PREPARED /* 1 */:
                    return new Integer(dataInputStream.readInt());
                case YouTubePlayer.PLAYING /* 2 */:
                    return new Long(dataInputStream.readLong());
                case YouTubePlayer.PAUSED /* 3 */:
                    return dataInputStream.readUTF();
                default:
                    throw new RuntimeException("Bad class: " + i + " for " + str);
            }
        } catch (IOException e) {
            return null;
        }
    }

    public static void a(String str, long j) {
        a(str, new Long(j));
    }

    private static void a(String str, Object obj) {
        dC dCVarG = cX.a().g();
        if (obj == null) {
            dCVarG.a(str, (byte[]) null);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            if (obj instanceof Boolean) {
                dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                dataOutputStream.writeUTF((String) obj);
            } else if (obj instanceof Integer) {
                dataOutputStream.writeInt(((Integer) obj).intValue());
            } else {
                if (!(obj instanceof Long)) {
                    throw new IllegalArgumentException("Bad type: " + obj.getClass() + " for " + str);
                }
                dataOutputStream.writeLong(((Long) obj).longValue());
            }
            dCVarG.a(str, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            C0126da.b("Writing: " + str, e);
        }
    }

    public static void a(String str, boolean z) {
        a(str, new Boolean(z));
    }

    public static long b(String str, long j) {
        Object objA = a(str, 2);
        if (objA != null) {
            return ((Long) objA).longValue();
        }
        return 0L;
    }

    public static boolean b(String str, boolean z) {
        Object objA = a(str, 0);
        if (objA != null) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }
}
