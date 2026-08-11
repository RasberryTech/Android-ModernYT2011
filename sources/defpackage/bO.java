package defpackage;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URLEncoder;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/* JADX INFO: loaded from: classes.dex */
public final class bO implements aM, aN {
    private static final Pattern a = Pattern.compile("[:.]");

    @Override // defpackage.aN
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((HttpResponse) obj);
    }

    @Override // defpackage.aM
    public final /* bridge */ /* synthetic */ Object b(Object obj) {
        StringBuilder sbA;
        fG fGVar = (fG) obj;
        String strA = gq.a(fGVar.d);
        if (fGVar.a()) {
            sbA = a(strA, fGVar.b, fGVar.c);
            sbA.append("&tlang=").append(fGVar.a);
        } else {
            sbA = a(strA, fGVar.a, fGVar.c);
        }
        return new HttpGet(sbA.toString());
    }

    private static StringBuilder a(String str, String str2, String str3) {
        return new StringBuilder("http://video.google.com/timedtext?").append("hl=").append(str2).append("&v=").append(str).append("&type=track").append("&lang=").append(str2).append("&name=").append(URLEncoder.encode(str3)).append("&format=sbv");
    }

    private static fD a(HttpResponse httpResponse) throws aK {
        fE fEVar = new fE();
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            for (String line = lineNumberReader.readLine(); line != null; line = lineNumberReader.readLine()) {
                int iIndexOf = line.indexOf(",");
                if (iIndexOf < 0) {
                    throw new aK("invalid format in line, [startTime,endTime] expected");
                }
                int iA = a(line.substring(0, iIndexOf));
                int iA2 = a(line.substring(iIndexOf + 1));
                StringBuilder sb = new StringBuilder();
                for (String line2 = lineNumberReader.readLine(); !TextUtils.isEmpty(line2); line2 = lineNumberReader.readLine()) {
                    sb.append(line2).append("\n");
                }
                fEVar.a(sb.toString().trim(), iA, iA2);
            }
            return fEVar.a();
        } catch (IOException e) {
            throw new aK(e);
        }
    }

    private static int a(String str) {
        String[] strArrSplit = TextUtils.split(str, a);
        int i = Integer.parseInt(strArrSplit[0]);
        int i2 = Integer.parseInt(strArrSplit[1]);
        return Integer.parseInt(strArrSplit[3]) + (((((i * 60) + i2) * 60) + Integer.parseInt(strArrSplit[2])) * 1000);
    }
}
