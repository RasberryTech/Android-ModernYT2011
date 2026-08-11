package defpackage;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class fA {
    static final /* synthetic */ int[] a = new int[fC.values().length];

    static {
        try {
            a[fC.USER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[fC.FAVORITES.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[fC.CHANNEL.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[fC.PLAYLIST.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[fC.QUERY.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
