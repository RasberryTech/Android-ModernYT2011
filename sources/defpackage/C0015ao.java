package defpackage;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: renamed from: ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0015ao implements AccountManagerCallback {
    private /* synthetic */ C0013am a;

    C0015ao(C0013am c0013am) {
        this.a = c0013am;
    }

    @Override // android.accounts.AccountManagerCallback
    public final void run(AccountManagerFuture accountManagerFuture) {
        try {
            Account[] accountArr = (Account[]) accountManagerFuture.getResult();
            this.a.f = new ArrayList();
            Collections.addAll(this.a.f, accountArr);
            String str = "got " + this.a.f.size() + " accounts";
            this.a.g.showDialog(6);
        } catch (AuthenticatorException e) {
            this.a.c("fetching accounts AuthenticatorException");
            this.a.a(e);
        } catch (OperationCanceledException e2) {
            this.a.c("fetching accounts canceled");
            this.a.d();
        } catch (IOException e3) {
            this.a.c("fetching accounts IOException");
            this.a.a(e3);
        }
    }
}
