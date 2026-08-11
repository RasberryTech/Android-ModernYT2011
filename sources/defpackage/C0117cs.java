package defpackage;

import android.net.Uri;
import com.google.android.youtube.player.YouTubePlayer;
import org.xml.sax.Attributes;

/* JADX INFO: renamed from: cs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0117cs extends aX {
    C0117cs() {
    }

    @Override // defpackage.aX, defpackage.InterfaceC0028ba
    public final void a(gu guVar, Attributes attributes) {
        fN fNVar = (fN) guVar.a(fN.class);
        switch (gv.a(attributes.getValue("yt:format"), -1)) {
            case YouTubePlayer.PLAYING /* 2 */:
                if (fNVar.b() == null) {
                    fNVar.a(Uri.parse(attributes.getValue("url")));
                }
                break;
            case YouTubePlayer.PAUSED /* 3 */:
                fNVar.b(Uri.parse(attributes.getValue("url")));
                break;
            case 9:
                fNVar.a(Uri.parse(attributes.getValue("url")));
                break;
        }
    }
}
