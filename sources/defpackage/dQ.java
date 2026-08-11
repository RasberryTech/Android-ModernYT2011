package defpackage;

import com.google.android.youtube.player.YouTubePlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class dQ {
    private static Boolean a = new Boolean(false);
    private static Boolean b = new Boolean(true);
    private dS c;
    private final C0153eb d;
    private final C0153eb e;

    static {
        new dR();
    }

    public dQ(dS dSVar) {
        this.c = dSVar;
        if (dSVar != null) {
            this.d = dSVar.a();
            this.e = dSVar.a();
        } else {
            this.d = new C0153eb();
            this.e = new C0153eb();
        }
    }

    private int a(int i) {
        return a(this.d.a(i));
    }

    private static int a(long j) {
        if (j < 0) {
            return 10;
        }
        int i = 1;
        for (long j2 = j; j2 >= 128; j2 >>= 7) {
            i++;
        }
        return i;
    }

    private int a(dB dBVar) throws IOException {
        int i;
        boolean z;
        C0154ec c0154ec = new C0154ec(this.d);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!c0154ec.a()) {
                return i3;
            }
            int iB = c0154ec.b();
            int iA = a(iB);
            int iB2 = b(iB);
            switch (iB2) {
                case 0:
                case YouTubePlayer.PREPARED /* 1 */:
                case YouTubePlayer.PLAYING /* 2 */:
                case YouTubePlayer.PAUSED /* 3 */:
                case YouTubePlayer.PROGRESS /* 5 */:
                case 16:
                    i = iB2;
                    break;
                case YouTubePlayer.STOPPED /* 4 */:
                case YouTubePlayer.ENDED /* 6 */:
                case YouTubePlayer.ERROR /* 7 */:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                default:
                    throw new RuntimeException("Unsupp.Type:" + this.c + '/' + iB + '/' + iB2);
                case 17:
                case 22:
                case 32:
                    i = 1;
                    break;
                case 18:
                case 23:
                case 31:
                    i = 5;
                    break;
                case 19:
                case 20:
                case 21:
                case 24:
                case 29:
                case 30:
                case 33:
                case 34:
                    i = 0;
                    break;
                case 25:
                case 27:
                case 28:
                case 35:
                case 36:
                    i = 2;
                    break;
                case 26:
                    i = 3;
                    break;
            }
            int i4 = (iB << 3) | i;
            int iB3 = 0;
            for (int i5 = 0; i5 < iA; i5++) {
                int iA2 = a(dBVar, i4) + iB3;
                int iB4 = dBVar.b();
                switch (i) {
                    case 0:
                        long jLongValue = ((Long) a(iB, i5, 19)).longValue();
                        if (c(iB)) {
                            jLongValue = (-(jLongValue >>> 63)) ^ (jLongValue << 1);
                        }
                        a(dBVar, jLongValue);
                        z = false;
                        break;
                    case YouTubePlayer.PREPARED /* 1 */:
                    case YouTubePlayer.PROGRESS /* 5 */:
                        long jLongValue2 = ((Long) a(iB, i5, 19)).longValue();
                        int i6 = i == 5 ? 4 : 8;
                        for (int i7 = 0; i7 < i6; i7++) {
                            dBVar.write((int) (255 & jLongValue2));
                            jLongValue2 >>= 8;
                        }
                        z = false;
                        break;
                    case YouTubePlayer.PLAYING /* 2 */:
                        Object objA = a(iB, i5, b(iB) == 27 ? 16 : 25);
                        if (objA instanceof byte[]) {
                            byte[] bArr = (byte[]) objA;
                            a(dBVar, bArr.length);
                            dBVar.write(bArr);
                            z = false;
                        } else {
                            dBVar.b(dBVar.b());
                            int iA3 = dBVar.a();
                            dBVar.b(-1);
                            int iA4 = ((dQ) objA).a(dBVar);
                            dBVar.a(iA3, iA4);
                            iA2 = iA4 + a(iA4) + iA2;
                            z = true;
                        }
                        break;
                    case YouTubePlayer.PAUSED /* 3 */:
                        iA2 = ((dQ) a(iB, i5, 26)).a(dBVar) + iA2 + a(dBVar, (iB << 3) | 4);
                        z = true;
                        break;
                    case YouTubePlayer.STOPPED /* 4 */:
                    default:
                        throw new IllegalArgumentException();
                }
                iB3 = !z ? (dBVar.b() - iB4) + iA2 : iA2;
            }
            i2 = iB3 + i3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0187  */
    /* JADX WARN: Code duplicated, block: B:57:0x018d A[RETURN] */
    private int a(InputStream inputStream, int i, boolean z, dR dRVar) throws IOException {
        Object obj;
        if (z) {
            this.d.b();
            this.e.b();
        }
        int iA = i;
        while (iA > 0) {
            long jA = a(inputStream, true, dRVar);
            if (jA != -1) {
                iA -= dRVar.a;
                int i2 = ((int) jA) & 7;
                if (i2 != 4) {
                    int i3 = (int) (jA >>> 3);
                    this.e.a(i3, C0157ef.a(i2));
                    switch (i2) {
                        case 0:
                            long jA2 = a(inputStream, false, dRVar);
                            int i4 = iA - dRVar.a;
                            if (c(i3)) {
                                jA2 = (-(jA2 & 1)) ^ (jA2 >>> 1);
                            }
                            Object objA = C0157ef.a(jA2);
                            iA = i4;
                            obj = objA;
                            break;
                        case YouTubePlayer.PREPARED /* 1 */:
                        case YouTubePlayer.PROGRESS /* 5 */:
                            int i5 = i2 == 5 ? 4 : 8;
                            int i6 = iA - i5;
                            int i7 = 0;
                            int i8 = i5;
                            long j = 0;
                            while (true) {
                                int i9 = i8 - 1;
                                if (i8 <= 0) {
                                    Object objA2 = C0157ef.a(j);
                                    iA = i6;
                                    obj = objA2;
                                } else {
                                    j |= ((long) inputStream.read()) << i7;
                                    i7 += 8;
                                    i8 = i9;
                                }
                                break;
                            }
                            break;
                        case YouTubePlayer.PLAYING /* 2 */:
                            int iA2 = (int) a(inputStream, false, dRVar);
                            int i10 = (iA - dRVar.a) - iA2;
                            if (b(i3) != 27) {
                                byte[] bArr = new byte[iA2];
                                int i11 = 0;
                                while (i11 < iA2) {
                                    int i12 = inputStream.read(bArr, i11, iA2 - i11);
                                    if (i12 <= 0) {
                                        throw new IOException("Unexp.EOF");
                                    }
                                    i11 += i12;
                                }
                                iA = i10;
                                obj = bArr;
                            } else {
                                dQ dQVar = new dQ((dS) this.c.b(i3));
                                dQVar.a(inputStream, iA2, false, dRVar);
                                iA = i10;
                                obj = dQVar;
                            }
                            break;
                        case YouTubePlayer.PAUSED /* 3 */:
                            dQ dQVar2 = new dQ(this.c == null ? null : (dS) this.c.b(i3));
                            iA = dQVar2.a(inputStream, iA, false, dRVar);
                            obj = dQVar2;
                            break;
                        case YouTubePlayer.STOPPED /* 4 */:
                        default:
                            throw new IOException("Unknown wire type " + i2 + ", reading garbage data?");
                    }
                    Object objA3 = this.d.a(i3);
                    Vector vector = objA3 instanceof Vector ? (Vector) objA3 : null;
                    if (objA3 == null || (vector != null && vector.size() == 0)) {
                        a(i3, obj);
                    } else {
                        if (vector == null) {
                            vector = new Vector();
                            vector.addElement(objA3);
                            this.d.a(i3, vector);
                        }
                        vector.addElement(obj);
                    }
                }
            }
            if (iA < 0) {
                throw new IOException();
            }
            return iA;
        }
        if (iA < 0) {
            throw new IOException();
        }
        return iA;
    }

    private static int a(OutputStream outputStream, long j) throws IOException {
        int i = 0;
        long j2 = j;
        while (i < 10) {
            int i2 = (int) (127 & j2);
            j2 >>>= 7;
            if (j2 == 0) {
                outputStream.write(i2);
                return i + 1;
            }
            outputStream.write(i2 | 128);
            i++;
        }
        return i;
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Vector) {
            return ((Vector) obj).size();
        }
        return 1;
    }

    private static long a(InputStream inputStream, boolean z, dR dRVar) throws IOException {
        dRVar.a = 0;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (i < 10) {
            int i3 = inputStream.read();
            if (i3 != -1) {
                j |= ((long) (i3 & 127)) << i2;
                if ((i3 & 128) == 0) {
                    break;
                }
                i2 += 7;
                i++;
            } else {
                if (i == 0 && z) {
                    return -1L;
                }
                throw new IOException("EOF");
            }
        }
        long j2 = j;
        dRVar.a = i + 1;
        return j2;
    }

    private Object a(int i, int i2, int i3) {
        Object objElementAt;
        Vector vector;
        Object objA = this.d.a(i);
        if (i2 >= a(objA)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (objA instanceof Vector) {
            vector = (Vector) objA;
            objElementAt = vector.elementAt(i2);
        } else {
            objElementAt = objA;
            vector = null;
        }
        Object objA2 = a(objElementAt, i3);
        if (objA2 != objElementAt && objElementAt != null) {
            if (vector == null) {
                a(i, objA2);
            } else {
                vector.setElementAt(objA2, i2);
            }
        }
        return objA2;
    }

    private static Object a(Object obj, int i) {
        switch (i) {
            case 16:
                return obj;
            case 17:
            case 18:
            case 20:
            case 29:
            case 30:
            default:
                throw new RuntimeException("Unsupp.Type");
            case 19:
            case 21:
            case 22:
            case 23:
            case 31:
            case 32:
            case 33:
            case 34:
                if (obj instanceof Boolean) {
                    return C0157ef.a(((Boolean) obj).booleanValue() ? 1L : 0L);
                }
                return obj;
            case 24:
                if (obj instanceof Boolean) {
                    return obj;
                }
                switch ((int) ((Long) obj).longValue()) {
                    case 0:
                        return a;
                    case YouTubePlayer.PREPARED /* 1 */:
                        return b;
                    default:
                        throw new IllegalArgumentException("Type mismatch");
                }
            case 25:
            case 35:
                if (obj instanceof String) {
                    return dA.a((String) obj);
                }
                if (!(obj instanceof dQ)) {
                    return obj;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ((dQ) obj).a((OutputStream) byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e) {
                    throw new RuntimeException(e.toString());
                }
            case 26:
            case 27:
                if (!(obj instanceof byte[])) {
                    return obj;
                }
                try {
                    dQ dQVar = new dQ(null);
                    byte[] bArr = (byte[]) obj;
                    dQVar.a(new ByteArrayInputStream(bArr), bArr.length, true, new dR());
                    return dQVar;
                } catch (IOException e2) {
                    throw new RuntimeException(e2.toString());
                }
            case 28:
            case 36:
                if (!(obj instanceof byte[])) {
                    return obj;
                }
                byte[] bArr2 = (byte[]) obj;
                return dA.a(bArr2, 0, bArr2.length, true);
        }
    }

    private void a(int i, Object obj) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.d.a(i, obj);
    }

    private int b(int i) {
        Integer num;
        int iA = this.c != null ? this.c.a(i) : 16;
        int iIntValue = (iA != 16 || (num = (Integer) this.e.a(i)) == null) ? iA : num.intValue();
        if (iIntValue != 16 || a(i) <= 0) {
            return iIntValue;
        }
        Object objA = a(i, 0, 16);
        return ((objA instanceof Long) || (objA instanceof Boolean)) ? 0 : 2;
    }

    private boolean c(int i) {
        int iB = b(i);
        return iB == 33 || iB == 34;
    }

    public final void a(int i, int i2) {
        a(i, i2);
    }

    public final void a(int i, long j) {
        a(i, C0157ef.a(j));
    }

    public final void a(int i, dQ dQVar) {
        a(13, (Object) dQVar);
    }

    public final void a(OutputStream outputStream) {
        int i = 0;
        dB dBVar = new dB();
        a(dBVar);
        int iA = dBVar.a();
        int i2 = 0;
        while (i < iA) {
            int iA2 = dBVar.a(i);
            dBVar.a(outputStream, i2, iA2 - i2);
            a(outputStream, dBVar.a(i + 1));
            i += 2;
            i2 = iA2;
        }
        if (i2 < dBVar.b()) {
            dBVar.a(outputStream, i2, dBVar.b() - i2);
        }
    }
}
