package com.google.android.youtube.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import defpackage.gq;
import java.util.EnumMap;

/* JADX INFO: renamed from: com.google.android.youtube.ui.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0111x implements View.OnClickListener {
    private final Activity a;
    private final InterfaceC0113z b;
    private final EnumMap c;
    private final Dialog d;
    private Button e;
    private defpackage.X f;

    public ViewOnClickListenerC0111x(Activity activity, InterfaceC0113z interfaceC0113z, defpackage.X x) {
        this.a = activity;
        this.b = (InterfaceC0113z) gq.a(interfaceC0113z);
        this.f = (defpackage.X) gq.a(x);
        this.c = new EnumMap(defpackage.X.class);
        defpackage.X[] xArrValues = defpackage.X.values();
        String[] strArr = new String[xArrValues.length];
        for (int i = 0; i < xArrValues.length; i++) {
            strArr[i] = activity.getString(xArrValues[i].c);
            this.c.put(xArrValues[i], strArr[i]);
        }
        this.d = new AlertDialog.Builder(activity).setTitle(activity.getString(com.google.android.youtube.R.string.time_filter_dialog_title)).setSingleChoiceItems(strArr, this.f.ordinal(), new DialogInterfaceOnClickListenerC0112y(this)).create();
    }

    public ViewOnClickListenerC0111x(Activity activity, InterfaceC0113z interfaceC0113z) {
        this(activity, interfaceC0113z, defpackage.X.ALL_TIME);
    }

    final void a(defpackage.X x) {
        if (x != this.f) {
            this.f = x;
            if (this.e != null) {
                this.e.setText((CharSequence) this.c.get(this.f));
            }
            this.b.a(x);
        }
    }

    public final void a(Button button) {
        gq.a(button);
        this.e = button;
        this.e.setText((CharSequence) this.c.get(this.f));
        this.e.setOnClickListener(this);
    }

    public final Dialog a() {
        return this.d;
    }

    public final defpackage.X b() {
        return this.f;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.showDialog(2);
    }
}
