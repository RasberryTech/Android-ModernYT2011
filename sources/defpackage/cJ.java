package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class cJ implements Parcelable {
    public static final Parcelable.Creator CREATOR = new cK();
    private String a;
    private String b;
    private TreeMap c;
    private boolean d;

    /* synthetic */ cJ(Parcel parcel) {
        this(parcel, (byte) 0);
    }

    public cJ(String str) {
        if (str.startsWith("https://")) {
            this.d = true;
        }
        a(new URL(str));
    }

    private void a(URL url) {
        this.a = url.getHost();
        this.b = url.getPath();
        this.c = new TreeMap();
        a(url.getQuery());
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    this.c.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }

    private String a() {
        Set<Map.Entry> setEntrySet = this.c.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : setEntrySet) {
            if (sb.length() == 0) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d ? "https://" : "http://");
        sb.append(this.a);
        sb.append(this.b);
        sb.append(a());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(toString());
    }

    private cJ(Parcel parcel, byte b) {
        try {
            a(new URL(parcel.readString()));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }
}
