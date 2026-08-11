package defpackage;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import java.io.IOException;

/* JADX INFO: renamed from: ar, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0018ar implements AccountManagerCallback {
    private /* synthetic */ C0013am a;

    C0018ar(C0013am c0013am) {
        this.a = c0013am;
    }

    @Override // android.accounts.AccountManagerCallback
    public final void run(AccountManagerFuture accountManagerFuture) {
        try {
            Account accountB = this.a.b(((Bundle) accountManagerFuture.getResult()).getString("authAccount"));
            String str = "added account " + accountB.name;
            this.a.c("added account");
            this.a.a(accountB);
        } catch (AuthenticatorException e) {
            this.a.c("added account AuthenticatorException");
            this.a.a(e);
        } catch (OperationCanceledException e2) {
            this.a.c("added account canceled");
            this.a.d();
        } catch (IOException e3) {
            this.a.c("added account IOException");
            this.a.a(e3);
        }
    }
}
