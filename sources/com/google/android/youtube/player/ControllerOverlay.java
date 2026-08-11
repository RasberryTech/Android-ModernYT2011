package com.google.android.youtube.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.youtube.R;
import defpackage.gq;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ControllerOverlay extends ViewGroup implements Handler.Callback, View.OnClickListener, Animation.AnimationListener {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private final YouTubePlayer a;
    private final b b;
    private long c;
    private long d;
    private int e;
    private final Rect f;
    private final Rect g;
    private final Rect h;
    private final Rect i;
    private final Paint j;
    private final Paint k;
    private final Paint l;
    private final Paint m;
    private final StringBuilder n;
    private final Formatter o;
    private final Rect p;
    private final Bitmap q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private ImageView v;
    private ImageView w;
    private Animation x;
    private long y;
    private int z;

    public ControllerOverlay(Context context, YouTubePlayer youTubePlayer, b bVar) {
        super(context);
        this.a = (YouTubePlayer) gq.a(youTubePlayer, "player cannot be null");
        this.b = bVar;
        this.f = new Rect();
        this.g = new Rect();
        this.h = new Rect();
        this.i = new Rect();
        this.j = new Paint();
        this.j.setColor(872415231);
        this.k = new Paint();
        this.k.setColor(1157562368);
        this.l = new Paint();
        this.l.setColor(-1997746081);
        this.m = new Paint(1);
        this.m.setColor(-1);
        this.m.setTypeface(Typeface.DEFAULT_BOLD);
        this.m.setTextSize(20.0f);
        this.m.setTextAlign(Paint.Align.CENTER);
        this.p = new Rect();
        this.n = new StringBuilder();
        this.o = new Formatter(this.n, Locale.getDefault());
        this.q = BitmapFactory.decodeResource(getResources(), R.drawable.player_scrubber);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        this.v = new ImageView(context);
        this.v.setImageResource(R.drawable.player_hq);
        this.v.setFocusable(true);
        this.v.setClickable(true);
        this.v.setOnClickListener(this);
        addView(this.v, layoutParams);
        this.w = new ImageView(context);
        this.w.setImageResource(R.drawable.player_cc);
        this.w.setFocusable(true);
        this.w.setClickable(true);
        this.w.setOnClickListener(this);
        this.w.setEnabled(false);
        addView(this.w, layoutParams);
        this.x = AnimationUtils.loadAnimation(context, R.anim.player_out);
        this.x.setAnimationListener(this);
        setWillNotDraw(false);
    }

    public void install() {
        this.a.addView(this, new RelativeLayout.LayoutParams(-1, -1));
        this.a.addListener(new Handler(this));
    }

    private void a() {
        boolean z = (this.B || this.D || this.E) ? false : true;
        this.v.setVisibility(z ? 0 : 4);
        this.w.setVisibility(z ? 0 : 4);
        setAnimation(null);
        this.C = false;
        setFocusable(false);
        invalidate();
    }

    private void b() {
        if (!this.B) {
            startAnimation(this.x);
        }
    }

    public void setMinimal(boolean z) {
        this.B = z;
        a();
        b();
    }

    public void setAd(boolean z) {
        this.E = z;
        a();
        b();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.v.setVisibility(4);
        this.w.setVisibility(4);
        this.C = true;
        setFocusable(true);
        requestFocus();
        invalidate();
    }

    public void setHQ(boolean z) {
        this.v.setSelected(z);
    }

    public void setCC(boolean z) {
        this.w.setSelected(z);
    }

    public void showCC(boolean z) {
        this.w.setEnabled(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            if (view == this.v) {
                this.b.e();
            } else if (view == this.w) {
                this.b.f();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.C) {
            a();
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                setAnimation(null);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.y < 250 && this.b != null) {
                    this.y = 0L;
                    this.b.g();
                } else {
                    this.y = jCurrentTimeMillis;
                }
                this.z = x;
                this.A = y;
                if (!this.E && !this.B) {
                    float f = x;
                    float f2 = y;
                    if (((float) this.r) < f && f < ((float) (this.r + this.q.getWidth())) && ((float) this.s) < f2 && f2 < ((float) (this.s + this.q.getHeight()))) {
                        this.u = true;
                        this.t = x - this.r;
                    }
                }
                if (!this.D) {
                    if (this.a.isPlaying()) {
                        this.a.pauseVideo();
                    } else if (!this.u) {
                        this.a.playVideo();
                    }
                }
                break;
            case YouTubePlayer.PREPARED /* 1 */:
                if (this.u) {
                    this.a.seekTo((int) c());
                    this.a.playVideo();
                    this.u = false;
                } else {
                    int i = this.z - x;
                    int i2 = this.A - y;
                    if (this.b != null && Math.abs(i) > Math.abs(i2) + 75) {
                        if (i > 0) {
                            this.b.c();
                        } else {
                            this.b.d();
                        }
                    }
                }
                b();
                break;
            case YouTubePlayer.PLAYING /* 2 */:
                if (this.u) {
                    this.r = x - this.t;
                    int width = this.q.getWidth() / 2;
                    this.r = Math.min(this.g.right - width, Math.max(this.g.left - width, this.r));
                    this.d = c();
                    invalidate();
                }
                break;
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.C) {
            a();
            b();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private long c() {
        return (((long) ((this.r + (this.q.getWidth() / 2)) - this.g.left)) * this.c) / ((long) this.g.width());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case YouTubePlayer.PLAYING /* 2 */:
                this.D = false;
                a();
                b();
                return true;
            case YouTubePlayer.PAUSED /* 3 */:
            default:
                return false;
            case YouTubePlayer.STOPPED /* 4 */:
                this.d = 0L;
                this.e = 0;
                this.c = 0L;
                d();
                break;
            case YouTubePlayer.PROGRESS /* 5 */:
                if (!this.u) {
                    this.d = message.arg1;
                    this.e = message.arg2;
                    this.c = ((Integer) message.obj).intValue();
                    d();
                    invalidate();
                }
                return true;
            case YouTubePlayer.ENDED /* 6 */:
            case YouTubePlayer.ERROR /* 7 */:
                break;
        }
        this.D = true;
        a();
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        measureChildren(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.B) {
                this.f.set(0, measuredHeight - (measuredHeight / 32), measuredWidth, measuredHeight);
                this.g.set(this.f);
            } else {
                this.m.getTextBounds("0:00:00", 0, 7, this.p);
                this.p.bottom += 4;
                this.f.set(0, measuredHeight - this.p.height(), measuredWidth, measuredHeight);
                this.g.set(this.p.right, measuredHeight - this.p.height(), measuredWidth - this.p.right, measuredHeight);
            }
            this.s = this.f.bottom - this.q.getHeight();
            d();
            int measuredWidth2 = this.v.getMeasuredWidth();
            int measuredHeight2 = this.v.getMeasuredHeight();
            int i5 = i3 - measuredWidth2;
            int i6 = i2 + measuredHeight2;
            this.v.layout(i5, i2, i3, i6);
            this.w.layout(i5, i6, i3, measuredHeight2 + i6);
        }
    }

    private void d() {
        this.h.set(this.g);
        this.i.set(this.g);
        if (this.c > 0) {
            this.h.right = this.h.left + ((this.g.width() * this.e) / 100);
            this.i.right = (int) (((long) this.i.left) + ((((long) this.g.width()) * this.d) / this.c));
        } else {
            this.h.right = this.g.left;
            this.i.right = this.g.left;
        }
        if (!this.u) {
            this.r = this.i.right - (this.q.getWidth() / 2);
        }
    }

    private String a(long j) {
        int i = ((int) j) / 1000;
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        this.n.delete(0, this.n.length());
        return i4 > 0 ? this.o.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString() : this.o.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.C) {
            super.draw(canvas);
            canvas.drawRect(this.f, this.j);
            canvas.drawRect(this.g, this.j);
            if (this.E) {
                canvas.drawRect(this.i, this.l);
            } else {
                canvas.drawRect(this.h, this.k);
                canvas.drawRect(this.i, this.k);
            }
            if (!this.B) {
                if (!this.E) {
                    canvas.drawBitmap(this.q, this.r, this.s, (Paint) null);
                }
                canvas.drawText(a(this.d), this.p.width() / 2, this.f.bottom - 2, this.m);
                canvas.drawText(a(this.c), this.f.right - (this.p.width() / 2), this.f.bottom - 2, this.m);
            }
        }
    }
}
