package defpackage;

import android.net.Uri;
import com.google.android.youtube.player.YouTubePlayer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class fB implements Serializable {
    private fC a;
    private Uri b;
    private Uri c;
    private String d;
    private String e;
    private String f;
    private String g;

    public final fB a(fC fCVar) {
        this.a = fCVar;
        return this;
    }

    public final fB a(Uri uri) {
        this.b = uri;
        return this;
    }

    public final fB a(String str) {
        this.d = str;
        return this;
    }

    public final fB b(String str) {
        this.e = str;
        return this;
    }

    public final fB c(String str) {
        this.f = str;
        return this;
    }

    public final fB d(String str) {
        this.g = str;
        return this;
    }

    public final fB b(Uri uri) {
        this.c = uri;
        return this;
    }

    public final C0204fz a() {
        if (this.d == null) {
            switch (fA.a[this.a.ordinal()]) {
                case YouTubePlayer.PREPARED /* 1 */:
                    this.d = this.e;
                    break;
                case YouTubePlayer.PLAYING /* 2 */:
                    this.d = this.e;
                    break;
                case YouTubePlayer.PAUSED /* 3 */:
                    this.d = this.e;
                    break;
                case YouTubePlayer.STOPPED /* 4 */:
                    this.d = this.f;
                    break;
                case YouTubePlayer.PROGRESS /* 5 */:
                    this.d = this.g;
                    break;
            }
        }
        return new C0204fz(this.d, this.a, this.b, this.c);
    }

    private Object readResolve() {
        return a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.d);
        objectOutputStream.writeObject(this.a);
        objectOutputStream.writeObject(gv.a(this.b));
        objectOutputStream.writeObject(gv.a(this.c));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.d = (String) objectInputStream.readObject();
        this.a = (fC) objectInputStream.readObject();
        this.b = gv.a((String) objectInputStream.readObject());
        this.c = gv.a((String) objectInputStream.readObject());
    }
}
