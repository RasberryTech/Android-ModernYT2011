package defpackage;

import android.accounts.Account;
import android.content.DialogInterface;

/* JADX INFO: renamed from: aq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0017aq implements DialogInterface.OnClickListener {
    private /* synthetic */ C0013am a;

    DialogInterfaceOnClickListenerC0017aq(C0013am c0013am) {
        this.a = c0013am;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.g.removeDialog(6);
        if (i < this.a.f.size()) {
            this.a.a((Account) this.a.f.get(i));
        } else {
            C0013am.c(this.a);
        }
        this.a.c("logging in");
    }
}
