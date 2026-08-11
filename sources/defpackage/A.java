package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.youtube.R;
import com.google.android.youtube.player.YouTubePlayer;

/* JADX INFO: loaded from: classes.dex */
public final class A extends AbstractC0232x {
    private final Context b;
    private final LayoutInflater c;

    public A(Context context) {
        this.b = context;
        this.c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        String string;
        C0204fz c0204fz = (C0204fz) getItem(i);
        TextView textView = (TextView) (view == null ? this.c.inflate(R.layout.text_item, viewGroup, false) : view);
        textView.setEnabled(true);
        switch (B.a[c0204fz.b.ordinal()]) {
            case YouTubePlayer.PREPARED /* 1 */:
                string = this.b.getString(R.string.subscription_user, c0204fz.a);
                break;
            case YouTubePlayer.PLAYING /* 2 */:
                string = this.b.getString(R.string.subscription_favorites, c0204fz.a);
                break;
            case YouTubePlayer.PAUSED /* 3 */:
                if (c0204fz.a.startsWith("[4]")) {
                    string = c0204fz.a.substring(3);
                    textView.setEnabled(false);
                } else {
                    string = this.b.getString(R.string.subscription_playlist, c0204fz.a);
                }
                break;
            case YouTubePlayer.STOPPED /* 4 */:
                string = this.b.getString(R.string.subscription_query, c0204fz.a);
                break;
            case YouTubePlayer.PROGRESS /* 5 */:
                string = c0204fz.a;
                break;
            default:
                string = c0204fz.a;
                break;
        }
        textView.setText(string);
        return textView;
    }
}
