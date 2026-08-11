package defpackage;

/* JADX INFO: renamed from: eg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0158eg extends AbstractC0159eh {
    private Long[] a;
    private Integer[] b;

    /* synthetic */ C0158eg() {
        this((byte) 0);
    }

    private C0158eg(byte b) {
        this.a = new Long[]{new Long(0L), new Long(1L), new Long(2L), new Long(3L), new Long(4L), new Long(5L), new Long(6L), new Long(7L), new Long(8L), new Long(9L), new Long(10L), new Long(11L), new Long(12L), new Long(13L), new Long(14L), new Long(15L)};
        this.b = new Integer[]{new Integer(0), new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5), new Integer(6), new Integer(7), new Integer(8), new Integer(9), new Integer(10), new Integer(11), new Integer(12), new Integer(13), new Integer(14), new Integer(15)};
    }

    @Override // defpackage.AbstractC0159eh
    public final Integer a(int i) {
        return (i < 0 || i >= this.b.length) ? new Integer(i) : this.b[i];
    }

    @Override // defpackage.AbstractC0159eh
    public final Long a(long j) {
        return (j < 0 || j >= ((long) this.a.length)) ? new Long(j) : this.a[(int) j];
    }
}
