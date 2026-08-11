package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class cX {
    public static boolean b;
    public static boolean c;
    private static cX d;
    private static boolean p;
    private static String q;
    private static String r;
    private static String s;
    private cZ t;
    private final cW u = new cY();
    public static int a = -9999;
    private static int e = -9999;
    private static int f = -9999;
    private static int g = -9999;
    private static int h = -9999;
    private static int i = -9999;
    private static int j = -9999;
    private static int k = -9999;
    private static int l = -9999;
    private static int m = -9999;
    private static int n = -9999;
    private static int o = -9999;

    public static cX a() {
        return d;
    }

    public static void a(cX cXVar) {
        d = cXVar;
    }

    private static int[] a(int i2, String str) {
        int i3 = 0;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            int[] iArr = new int[i2];
            int i4 = 0;
            while (true) {
                int iIndexOf = str.indexOf(",", i4);
                if (iIndexOf == -1) {
                    break;
                }
                iArr[i3] = Integer.parseInt(str.substring(i4, iIndexOf));
                i4 = iIndexOf + 1;
                i3++;
            }
            int i5 = i3 + 1;
            iArr[i3] = Integer.parseInt(str.substring(i4));
            if (i5 != i2) {
                return null;
            }
            return iArr;
        } catch (ArrayIndexOutOfBoundsException e2) {
            C0126da.a("CONFIG", e2);
            return null;
        } catch (NumberFormatException e3) {
            C0126da.a("CONFIG", e3);
            return null;
        }
    }

    protected final void b() {
        this.t = cZ.a(null);
        String property = System.getProperty("microedition.platform");
        String lowerCase = property == null ? "" : property.toLowerCase();
        String strD = d();
        q = strD;
        if (strD == null) {
            q = "unknown";
        }
        r = null;
        if (0 == 0) {
            r = "unknown";
        }
        s = null;
        if (0 == 0) {
            s = "unknown";
        }
        a = a;
        e = e;
        f = f;
        g = g;
        p = lowerCase.startsWith("nokia");
        m = m;
        n = n;
        o = o;
        if (p) {
            int i2 = e;
            e = g;
            g = i2;
        }
        h = h;
        i = i;
        j = j;
        k = k;
        l = l;
        b = (lowerCase.startsWith("nokia") || lowerCase.startsWith("sony")) ? false : true;
        c = false;
        a(12, null);
        a(4, null);
        if (c && !b) {
            b = true;
        }
        c();
    }

    protected abstract void c();

    protected String d() {
        return null;
    }

    protected final cZ e() {
        return this.t;
    }

    public abstract InterfaceC0149dy f();

    public abstract dC g();

    public cW h() {
        return this.u;
    }
}
