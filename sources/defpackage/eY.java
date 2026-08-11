package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class eY {
    private eU a = new eU(cX.a().g());

    protected final synchronized void a(String str) {
        String str2 = "ResumeService.removeClientTicketMap(" + str + ")";
        if (str != null) {
            this.a.a(str);
        }
    }

    protected final synchronized void a(String str, String str2) {
        String str3 = "ResumeService.addClientTicketMap(" + str + ")";
        if (str != null) {
            this.a.a(str, str2);
        }
    }
}
