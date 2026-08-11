package defpackage;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import android.os.Handler;
import java.io.IOException;

/* JADX INFO: renamed from: at, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0020at implements AccountManagerCallback {
    private Account a;
    private String b;
    private String c;
    private /* synthetic */ C0013am d;

    public abstract void a();

    public abstract void a(fH fHVar);

    public abstract void a(Exception exc);

    /* synthetic */ AbstractC0020at(C0013am c0013am) {
        this(c0013am, (byte) 0);
    }

    private AbstractC0020at(C0013am c0013am, byte b) {
        this.d = c0013am;
    }

    @Override // android.accounts.AccountManagerCallback
    public void run(AccountManagerFuture accountManagerFuture) {
        try {
            Bundle bundle = (Bundle) accountManagerFuture.getResult();
            if (bundle.containsKey("intent")) {
                a();
            } else if (this.a == null) {
                this.a = this.d.b(bundle.getString("authAccount"));
                this.b = bundle.getString("authtoken");
                String str = "got authToken for " + this.a.name;
                this.d.c.getAuthToken(this.a, "YouTubeUser", (Bundle) null, this.d.g, this, (Handler) null);
            } else {
                this.c = bundle.getString("authtoken");
                String str2 = "got username for " + this.a.name;
                a(new fH(this.a.name, this.b, this.c));
            }
        } catch (AuthenticatorException e) {
            this.d.c("login AuthenticatorException");
            a(e);
        } catch (OperationCanceledException e2) {
            this.d.c("login canceled");
            a();
        } catch (IOException e3) {
            this.d.c("login IOException");
            a(e3);
        }
    }
}
