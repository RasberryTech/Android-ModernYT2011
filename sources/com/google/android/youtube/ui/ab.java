package com.google.android.youtube.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class ab extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = new ac();
    int a;

    /* synthetic */ ab(Parcel parcel) {
        this(parcel, (byte) 0);
    }

    ab(Parcelable parcelable) {
        super(parcelable);
        this.a = -1;
    }

    private ab(Parcel parcel, byte b) {
        super(parcel);
        this.a = -1;
        this.a = parcel.readInt();
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a);
    }
}
