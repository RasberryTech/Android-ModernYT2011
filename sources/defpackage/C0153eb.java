package defpackage;

import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: renamed from: eb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0153eb {
    private Object[] a;
    private Hashtable b;
    private int c;
    private int d;
    private int e;

    public C0153eb() {
        this(16);
    }

    private C0153eb(int i) {
        this.a = new Object[i > 0 ? Math.min(i, 128) : 16];
        this.e = 0;
        this.d = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
    }

    private int c() {
        return this.b == null ? this.e : this.e + this.b.size();
    }

    public final C0153eb a() {
        return new C0153eb(this.c);
    }

    public final Object a(int i) {
        if (i <= this.c && i >= 0) {
            return this.a[i];
        }
        if (i <= this.d && this.b != null) {
            return this.b.get(C0157ef.a(i));
        }
        return null;
    }

    public final void a(int i, Object obj) {
        boolean z;
        if (obj == null) {
            if (i < 0 || i >= this.a.length) {
                if (this.b != null) {
                    this.b.remove(C0157ef.a(i));
                    return;
                }
                return;
            } else {
                if (this.a[i] != null) {
                    this.e--;
                }
                this.a[i] = null;
                return;
            }
        }
        if (i > this.d) {
            this.d = i;
        }
        if (i < 0 || i >= this.a.length) {
            if (i >= 128 || i < this.a.length || i <= 0) {
                z = false;
            } else {
                int length = this.a.length;
                do {
                    length <<= 1;
                } while (length <= i);
                Object[] objArr = new Object[Math.min(length, 128)];
                System.arraycopy(this.a, 0, objArr, 0, this.a.length);
                this.a = objArr;
                z = true;
            }
            if (!z) {
                if (this.b == null) {
                    this.b = new Hashtable();
                }
                this.b.put(C0157ef.a(i), obj);
                return;
            }
        }
        if (i > this.c) {
            this.c = i;
            this.e++;
        } else if (this.a[i] == null) {
            this.e++;
        }
        this.a[i] = obj;
    }

    public final void b() {
        for (int i = 0; i < this.a.length; i++) {
            this.a[i] = null;
        }
        if (this.b != null) {
            this.b.clear();
        }
        this.d = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.e = 0;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0153eb)) {
            return false;
        }
        C0153eb c0153eb = (C0153eb) obj;
        if (c() != c0153eb.c()) {
            return false;
        }
        Object[] objArr = this.a;
        Object[] objArr2 = c0153eb.a;
        int iMin = Math.min(objArr.length, objArr2.length);
        int i = 0;
        while (true) {
            if (i >= iMin) {
                if (objArr.length <= objArr2.length) {
                    if (objArr.length >= objArr2.length) {
                        z = true;
                        break;
                    }
                    int i2 = iMin;
                    while (true) {
                        if (i2 >= objArr2.length) {
                            z = true;
                            break;
                        }
                        if (objArr2[i2] != null) {
                            z = false;
                            break;
                        }
                        i2++;
                    }
                } else {
                    int i3 = iMin;
                    while (true) {
                        if (i3 >= objArr.length) {
                            z = true;
                            break;
                        }
                        if (objArr[i3] != null) {
                            z = false;
                            break;
                        }
                        i3++;
                    }
                }
            } else {
                if ((objArr[i] == null && objArr2[i] != null) || (objArr[i] != null && !objArr[i].equals(objArr2[i]))) {
                    z = false;
                    break;
                }
                i++;
            }
        }
        if (z) {
            Hashtable hashtable = this.b;
            Hashtable hashtable2 = c0153eb.b;
            if (hashtable != hashtable2) {
                if (hashtable != null && hashtable2 != null && hashtable.size() == hashtable2.size()) {
                    Enumeration enumerationKeys = hashtable.keys();
                    while (true) {
                        if (!enumerationKeys.hasMoreElements()) {
                            z2 = true;
                            break;
                        }
                        Object objNextElement = enumerationKeys.nextElement();
                        if (!hashtable.get(objNextElement).equals(hashtable2.get(objNextElement))) {
                            z2 = false;
                            break;
                        }
                    }
                } else {
                    z2 = false;
                }
            } else {
                z2 = true;
                break;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 1;
        for (int i = 0; i < this.a.length; i++) {
            Object obj = this.a[i];
            if (obj != null) {
                iHashCode = (iHashCode * 31) + obj.hashCode() + i;
            }
        }
        return this.b == null ? iHashCode : this.b.size() + iHashCode;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("IntMap{lower:");
        for (int i = 0; i < this.a.length; i++) {
            if (this.a[i] != null) {
                stringBuffer.append(i);
                stringBuffer.append("=>");
                stringBuffer.append(this.a[i]);
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(", higher:" + this.b + "}");
        return stringBuffer.toString();
    }
}
