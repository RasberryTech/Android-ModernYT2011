package defpackage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: renamed from: am, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0013am {
    private static final int a = C0210ge.a("UserAuthorizer");
    private static final String[] b = {"service_youtube"};
    private final AccountManager c;
    private final SharedPreferences d;
    private fH e;
    private ArrayList f;
    private Activity g;
    private final LinkedList h = new LinkedList();
    private final C0210ge i;
    private InterfaceC0022av j;

    static /* synthetic */ void c(C0013am c0013am) {
        c0013am.c("adding account");
        c0013am.c.addAccount("com.google", "youtube", b, null, c0013am.g, new C0018ar(c0013am), null);
    }

    public C0013am(AccountManager accountManager, SharedPreferences sharedPreferences, C0210ge c0210ge) {
        this.c = (AccountManager) gq.a(accountManager);
        this.i = (C0210ge) gq.a(c0210ge);
        this.d = (SharedPreferences) gq.a(sharedPreferences);
    }

    public final synchronized void a(Activity activity, InterfaceC0021au interfaceC0021au) {
        if (this.e != null) {
            interfaceC0021au.a(this.e);
        } else {
            if (this.g != null && activity != this.g) {
                C0081l.b("new activity attempting the sign in flow");
                d();
            }
            this.g = activity;
            this.h.add(interfaceC0021au);
            if (this.h.size() == 1) {
                Account accountB = b(this.d.getString("user_account", null));
                if (accountB != null) {
                    a(accountB);
                } else {
                    this.c.getAccountsByTypeAndFeatures("com.google", b, new C0015ao(this), null);
                }
            }
        }
    }

    public final synchronized void a(InterfaceC0021au interfaceC0021au) {
        if (this.e != null) {
            interfaceC0021au.a(this.e);
        } else {
            Account accountB = b(this.d.getString("user_account", null));
            if (accountB != null) {
                this.c.getAuthToken(accountB, "youtube", false, new C0014an(this, interfaceC0021au), null);
            } else {
                interfaceC0021au.a();
            }
        }
    }

    public final synchronized void a() {
        if (this.j != null) {
            this.j.I();
        }
        this.e = null;
        this.d.edit().remove("user_account").remove("username").commit();
    }

    public final synchronized void a(InterfaceC0022av interfaceC0022av) {
        this.j = interfaceC0022av;
    }

    public final synchronized boolean b() {
        return this.e != null || this.d.contains("user_account");
    }

    public final synchronized String c() {
        return this.e != null ? this.e.c : this.d.getString("username", null);
    }

    final synchronized void a(fH fHVar) {
        this.e = fHVar;
        this.d.edit().putString("user_account", this.e.a).putString("username", this.e.c).commit();
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((InterfaceC0021au) it.next()).a(this.e);
        }
        this.h.clear();
        this.g = null;
    }

    final synchronized void a(Exception exc) {
        C0081l.b("authentication error", exc);
        this.e = null;
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((InterfaceC0021au) it.next()).a(exc);
        }
        this.h.clear();
        this.g = null;
    }

    final synchronized void d() {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((InterfaceC0021au) it.next()).a();
        }
        this.h.clear();
        this.g = null;
    }

    public final Dialog a(Activity activity) {
        if (activity != this.g) {
            C0081l.b("sign in activity is different from dialog activity, assuming a restore and canceling");
            d();
            return null;
        }
        gq.a(this.f, "youtubeAccounts not initialized");
        String[] strArr = new String[this.f.size() + 1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f.size()) {
                strArr[i2] = ((Account) this.f.get(i2)).name;
                i = i2 + 1;
            } else {
                strArr[this.f.size()] = this.g.getString(R.string.other_account);
                return new AlertDialog.Builder(this.g).setTitle(R.string.accounts_title).setItems(strArr, new DialogInterfaceOnClickListenerC0017aq(this)).setOnCancelListener(new DialogInterfaceOnCancelListenerC0016ap(this)).create();
            }
        }
    }

    final void a(Account account) {
        String str = "fetching authToken for " + account.name;
        this.c.getAuthToken(account, "youtube", (Bundle) null, this.g, new C0019as(this), (Handler) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Account b(String str) {
        if (str != null) {
            for (Account account : this.c.getAccountsByType("com.google")) {
                if (str.equals(account.name)) {
                    return account;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0046  */
    final synchronized String a(String str) {
        String strBlockingGetAuthToken;
        this.c.invalidateAuthToken("com.google", str);
        Account accountB = b(this.e != null ? this.e.a : this.d.getString("user_account", null));
        if (accountB != null) {
            try {
                strBlockingGetAuthToken = this.c.blockingGetAuthToken(accountB, "youtube", false);
                if (strBlockingGetAuthToken == null) {
                    strBlockingGetAuthToken = str;
                } else if (this.e != null) {
                    this.e = new fH(this.e.a, strBlockingGetAuthToken, this.e.c);
                }
            } catch (AuthenticatorException e) {
                c("authToken refresh AuthenticatorException");
            } catch (OperationCanceledException e2) {
                c("authToken refresh canceled");
            } catch (IOException e3) {
                c("authToken refresh IOException");
            }
        } else {
            strBlockingGetAuthToken = str;
        }
        return strBlockingGetAuthToken;
    }

    public final InterfaceC0004ad a(InterfaceC0004ad interfaceC0004ad) {
        return new C0023aw(this, interfaceC0004ad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.i != null) {
            this.i.a(a, C0210ge.a(str));
        }
    }
}
