package defpackage;

import java.util.Date;

/* JADX INFO: renamed from: fs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0197fs {
    private String a;
    private EnumC0196fr b;
    private String c;
    private Date d;

    public final C0197fs a(String str) {
        this.a = str;
        return this;
    }

    public final C0197fs a(EnumC0196fr enumC0196fr) {
        this.b = enumC0196fr;
        return this;
    }

    public final C0197fs b(String str) {
        this.c = str;
        return this;
    }

    public final C0197fs a(Date date) {
        this.d = date;
        return this;
    }

    public final C0195fq a() {
        return new C0195fq(this.a, this.b, this.c, this.d);
    }
}
