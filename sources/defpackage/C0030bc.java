package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: renamed from: bc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0030bc implements aN {
    @Override // defpackage.aN
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((HttpResponse) obj);
    }

    private static Bitmap a(HttpResponse httpResponse) throws aK {
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpResponse.getEntity().getContent());
            if (bitmapDecodeStream == null) {
                throw new aK("Error in stream, can't create bitmap");
            }
            return bitmapDecodeStream;
        } catch (IOException e) {
            throw new aK("IO error converting bitmap", e);
        }
    }
}
