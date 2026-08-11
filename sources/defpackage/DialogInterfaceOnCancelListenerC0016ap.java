package defpackage;

import android.content.DialogInterface;

/* JADX INFO: renamed from: ap, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnCancelListenerC0016ap implements DialogInterface.OnCancelListener {
    private /* synthetic */ C0013am a;

    DialogInterfaceOnCancelListenerC0016ap(C0013am c0013am) {
        this.a = c0013am;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.g.removeDialog(6);
        this.a.d();
    }
}
