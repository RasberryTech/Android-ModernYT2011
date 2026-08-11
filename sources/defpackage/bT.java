package defpackage;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public final class bT implements aN {
    private final aW a;
    private final aO b = new aP().a("/VAST", new bZ(this)).a("/VAST/Ad/InLine/Impression", new bY(this)).a("/VAST/Ad/InLine/Creatives/Creative/Linear/MediaFiles/MediaFile", new bX(this)).a("/VAST/Ad/InLine/Creatives/Creative/Linear/TrackingEvents/Tracking", new bW(this)).a("/VAST/Ad/InLine/Creatives/Creative/Linear/VideoClicks/ClickThrough", new bV(this)).a("/VAST/Ad/InLine/Creatives/Creative/Linear/VideoClicks/ClickTracking", new bU(this)).a();

    public bT(aW aWVar) {
        this.a = (aW) gq.a(aWVar, "the parser can't be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.aN
    public fK a(HttpResponse httpResponse) throws aK {
        try {
            fL fLVar = (fL) this.a.a(httpResponse.getEntity().getContent(), this.b);
            if (fLVar != null) {
                return fLVar.a();
            }
            return null;
        } catch (IOException e) {
            throw new aK("Error converting VAST response", e);
        }
    }
}
