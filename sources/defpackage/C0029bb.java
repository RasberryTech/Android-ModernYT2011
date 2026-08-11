package defpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/* JADX INFO: renamed from: bb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0029bb implements aM, aN {
    private final C0013am a;
    private final String b;

    @Override // defpackage.aN
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((HttpResponse) obj);
    }

    @Override // defpackage.aM
    public final /* bridge */ /* synthetic */ Object b(Object obj) {
        String str = (String) obj;
        gq.a(str);
        String strC = this.a.c();
        return new HttpGet("http://www.youtube.com/get_ad_tags?action_pre=1&v=" + str + "&ps=android&clientid=" + this.b + (strC != null ? "&username=" + strC : ""));
    }

    public C0029bb(C0013am c0013am, String str) {
        this.a = (C0013am) gq.a(c0013am);
        this.b = str;
    }

    private static C0186fh a(HttpResponse httpResponse) throws aK {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            int i = Integer.parseInt(bufferedReader.readLine());
            String line = bufferedReader.readLine();
            bufferedReader.close();
            if (line != null) {
                return new C0186fh(i, gv.c(line));
            }
            return null;
        } catch (NumberFormatException e) {
            throw new aK("error converting ad tag response, invalid delay", e);
        } catch (Exception e2) {
            throw new aK("error converting ad tag response", e2);
        }
    }
}
