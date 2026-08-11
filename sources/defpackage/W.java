package defpackage;

/* JADX INFO: loaded from: classes.dex */
public enum W {
    MOST_VIEWED(EnumC0215gj.MOST_VIEWED),
    TOP_RATED(EnumC0215gj.TOP_RATED),
    MOST_DISCUSSED(EnumC0215gj.MOST_DISCUSSED),
    TOP_FAVORITES(EnumC0215gj.TOP_FAVORITES),
    MOST_RESPONDED(EnumC0215gj.MOST_RESPONDED),
    MOST_POPULAR(EnumC0215gj.MOST_POPULAR),
    MOST_LINKED(EnumC0215gj.MOST_LINKED),
    RECENTLY_FEATURED(EnumC0215gj.RECENTLY_FEATURED),
    WATCH_ON_MOBILE(EnumC0215gj.WATCH_ON_MOBILE);

    public final EnumC0215gj g;

    W(EnumC0215gj enumC0215gj) {
        this.g = enumC0215gj;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return super.toString().toLowerCase();
    }
}
