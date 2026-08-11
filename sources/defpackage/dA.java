package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class dA {
    static {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private dA() {
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00bd  */
    private static int a(String str, byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        int length = str.length();
        int i5 = i;
        for (int i6 = 0; i6 < length; i6 = i2 + 1) {
            char cCharAt = str.charAt(i6);
            if (cCharAt < 55296 || cCharAt > 57343 || i6 + 1 >= length) {
                i2 = i6;
                i3 = cCharAt;
            } else {
                char cCharAt2 = str.charAt(i6 + 1);
                if (((cCharAt2 & 64512) ^ (cCharAt & 64512)) == 1024) {
                    int i7 = i6 + 1;
                    if ((cCharAt2 & 64512) == 55296) {
                        cCharAt2 = cCharAt;
                        cCharAt = cCharAt2;
                    }
                    int i8 = (((cCharAt & 1023) << 10) | (cCharAt2 & 1023)) + 65536;
                    i2 = i7;
                    i3 = i8;
                } else {
                    i2 = i6;
                    i3 = cCharAt;
                }
            }
            if (i3 <= 127) {
                if (bArr != null) {
                    bArr[i5] = (byte) i3;
                }
                i4 = i5 + 1;
            } else if (i3 <= 2047) {
                if (bArr != null) {
                    bArr[i5] = (byte) ((i3 >> 6) | 192);
                    bArr[i5 + 1] = (byte) ((i3 & 63) | 128);
                }
                i4 = i5 + 2;
            } else if (i3 <= 65535) {
                if (bArr != null) {
                    bArr[i5] = (byte) ((i3 >> 12) | 224);
                    bArr[i5 + 1] = (byte) (((i3 >> 6) & 63) | 128);
                    bArr[i5 + 2] = (byte) ((i3 & 63) | 128);
                }
                i4 = i5 + 3;
            } else {
                if (bArr != null) {
                    bArr[i5] = (byte) ((i3 >> 18) | 240);
                    bArr[i5 + 1] = (byte) (((i3 >> 12) & 63) | 128);
                    bArr[i5 + 2] = (byte) (((i3 >> 6) & 63) | 128);
                    bArr[i5 + 3] = (byte) ((i3 & 63) | 128);
                }
                i4 = i5 + 4;
            }
            i5 = i4;
        }
        return i5;
    }

    public static String a(byte[] bArr, int i, int i2, boolean z) {
        StringBuffer stringBuffer = new StringBuffer(i2);
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            int i5 = bArr[i3] & 255;
            if (i5 <= 127) {
                stringBuffer.append((char) i5);
                i3 = i4;
            } else if (i5 >= 245) {
                stringBuffer.append((char) i5);
                i3 = i4;
            } else {
                int i6 = 1;
                int i7 = 224;
                int i8 = 31;
                while (i5 >= i7) {
                    i7 = (i7 >> 1) | 128;
                    i6++;
                    i8 >>= 1;
                }
                int i9 = i5 & i8;
                int i10 = i4;
                int i11 = i9;
                for (int i12 = 0; i12 < i6; i12++) {
                    i11 <<= 6;
                    if (i10 < i2) {
                        i11 |= bArr[i10] & 63;
                        i10++;
                    }
                }
                if (i11 >= 55296 && i11 <= 57343) {
                    throw new IllegalArgumentException("Invalid UTF8");
                }
                if (i11 <= 65535) {
                    stringBuffer.append((char) i11);
                    i3 = i10;
                } else {
                    int i13 = i11 - 65536;
                    stringBuffer.append((char) ((i13 >> 10) | 55296));
                    stringBuffer.append((char) ((i13 & 1023) | 56320));
                    i3 = i10;
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void a(InterfaceC0146dv interfaceC0146dv) {
        if (interfaceC0146dv != null) {
            try {
                interfaceC0146dv.f();
            } catch (IOException e) {
            }
        }
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[a(str, null, 0)];
        a(str, bArr, 0);
        return bArr;
    }
}
