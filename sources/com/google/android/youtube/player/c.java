package com.google.android.youtube.player;

import android.net.Uri;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import defpackage.C0210ge;
import defpackage.I;
import defpackage.InterfaceC0004ad;
import defpackage.fK;
import defpackage.fM;
import defpackage.gl;
import defpackage.gq;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Handler implements I {
    private static final Uri j = Uri.parse("http://s2.youtube.com/s?ns=yt");
    private static final SecureRandom k = new SecureRandom();
    private final C0210ge a;
    private final InterfaceC0004ad b;
    private fM c;
    private boolean d;
    private String e;
    private int f;
    private fK g;
    private boolean h;
    private int i;

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Exception exc) {
        String str = "Ping failed " + ((Uri) obj);
    }

    @Override // defpackage.I
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
    }

    public c(C0210ge c0210ge, InterfaceC0004ad interfaceC0004ad) {
        this.a = (C0210ge) gq.a(c0210ge);
        this.b = (InterfaceC0004ad) gq.a(interfaceC0004ad);
    }

    public final void a(fM fMVar, fK fKVar) {
        sendMessage(Message.obtain(this, 101, new Object[]{fMVar, fKVar}));
    }

    private void c() {
        byte[] bArr = new byte[12];
        k.nextBytes(bArr);
        this.e = Base64.encodeToString(bArr, 0);
        this.f = 2;
    }

    public final void a() {
        sendEmptyMessage(102);
    }

    public final void b() {
        sendEmptyMessage(103);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Uri uri;
        switch (message.what) {
            case YouTubePlayer.PREPARED /* 1 */:
                this.a.a();
                if (this.h || (this.g != null && this.g.b == null)) {
                    a(this.g.a);
                }
                break;
            case YouTubePlayer.STOPPED /* 4 */:
                if (this.h) {
                    a(this.g.g);
                }
                break;
            case YouTubePlayer.PROGRESS /* 5 */:
                int i = message.arg1;
                if (this.h) {
                    int iIntValue = ((Integer) message.obj).intValue();
                    int i2 = iIntValue > 0 ? (i * 4) / iIntValue : 0;
                    if (i2 >= this.i) {
                        for (int i3 = i2; i3 >= this.i; i3--) {
                            switch (i3) {
                                case YouTubePlayer.PREPARED /* 1 */:
                                    uri = this.g.c;
                                    break;
                                case YouTubePlayer.PLAYING /* 2 */:
                                    uri = this.g.d;
                                    break;
                                case YouTubePlayer.PAUSED /* 3 */:
                                    uri = this.g.e;
                                    break;
                                default:
                                    uri = null;
                                    break;
                            }
                            if (a(uri)) {
                                this.i = i2 + 1;
                            }
                            break;
                        }
                        this.i = i2 + 1;
                    }
                    break;
                } else if (this.d) {
                    if ((this.f == 2 && i >= 20000) || (this.f == 3 && i >= 30000)) {
                        String str = this.c.a;
                        String str2 = this.e;
                        int i4 = this.f;
                        String str3 = String.format("%.1f", Float.valueOf(i / 1000.0f));
                        a(j.buildUpon().appendQueryParameter("docid", str).appendQueryParameter("plid", str2).appendQueryParameter("ps", "android").appendQueryParameter("yttk", "1").appendQueryParameter("st", str3).appendQueryParameter("et", str3).appendQueryParameter("ctp", Integer.toString(i4)).build());
                        this.f++;
                        break;
                    }
                }
                break;
            case YouTubePlayer.ENDED /* 6 */:
                if (this.h) {
                    a(this.g.f);
                    this.h = false;
                } else if (this.d) {
                    c();
                }
                this.a.b();
                break;
            case YouTubePlayer.ERROR /* 7 */:
                if (message.obj != null) {
                    this.a.a(gl.EXCEPTION_THROWN);
                } else {
                    this.a.a(message.arg2);
                }
                if (this.h) {
                    if (this.i != 5) {
                        a(this.g.g);
                        this.i = 5;
                    }
                    this.h = false;
                }
                break;
            case 101:
                fM fMVar = (fM) ((Object[]) message.obj)[0];
                fK fKVar = (fK) ((Object[]) message.obj)[1];
                this.c = fMVar;
                this.d = fMVar.v;
                if (this.d) {
                    c();
                }
                this.g = fKVar;
                this.h = (fKVar == null || fKVar.b == null) ? false : true;
                this.i = 1;
                break;
            case 102:
                Looper.myLooper().quit();
                removeCallbacksAndMessages(null);
                break;
            case 103:
                if (this.h) {
                    a(this.g.i);
                }
                break;
        }
    }

    private boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String str = "Pinging " + uri;
        this.b.a(uri, this);
        return true;
    }

    public static c a(C0210ge c0210ge, InterfaceC0004ad interfaceC0004ad) {
        c[] cVarArr = new c[1];
        ConditionVariable conditionVariable = new ConditionVariable(false);
        new d(cVarArr, c0210ge, interfaceC0004ad, conditionVariable).start();
        conditionVariable.block();
        return cVarArr[0];
    }
}
