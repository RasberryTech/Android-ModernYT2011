package defpackage;

import android.os.ConditionVariable;
import com.google.android.youtube.C0081l;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class aF extends AbstractC0025ay {
    private final String a;
    private final String b;
    private final ConcurrentHashMap c;
    private final FilenameFilter d;
    private final ConditionVariable e;
    private volatile boolean f;

    static /* synthetic */ void a(aF aFVar) {
        File[] fileArrListFiles = new File(aFVar.a).listFiles(aFVar.d);
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                aFVar.c.put(file.getName(), "");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // defpackage.aB
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws Throwable {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        BufferedOutputStream bufferedOutputStream;
        ObjectOutputStream objectOutputStream2;
        BufferedOutputStream bufferedOutputStream2;
        Serializable serializable = (Serializable) obj2;
        f();
        String strC = c(obj);
        ?? r2 = this.a;
        ?? file = new File((String) r2, strC);
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream((File) file);
                try {
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream2);
                    try {
                        ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(bufferedOutputStream3);
                        try {
                            objectOutputStream3.writeObject(serializable);
                            objectOutputStream3.flush();
                            this.c.put(strC, "");
                            a((OutputStream) fileOutputStream2);
                            a((OutputStream) bufferedOutputStream3);
                            a((OutputStream) objectOutputStream3);
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            bufferedOutputStream2 = bufferedOutputStream3;
                            objectOutputStream2 = objectOutputStream3;
                            C0081l.b("Error creating cache file.", e);
                            a((OutputStream) fileOutputStream);
                            a((OutputStream) bufferedOutputStream2);
                            a((OutputStream) objectOutputStream2);
                            file = objectOutputStream2;
                            r2 = bufferedOutputStream2;
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            bufferedOutputStream = bufferedOutputStream3;
                            objectOutputStream = objectOutputStream3;
                            C0081l.b("Error creating cache file.", e);
                            a((OutputStream) fileOutputStream);
                            a((OutputStream) bufferedOutputStream);
                            a((OutputStream) objectOutputStream);
                            file = objectOutputStream;
                            r2 = bufferedOutputStream;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            r2 = bufferedOutputStream3;
                            file = objectOutputStream3;
                            a((OutputStream) fileOutputStream);
                            a((OutputStream) r2);
                            a((OutputStream) file);
                            throw th;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        objectOutputStream2 = null;
                    } catch (IOException e4) {
                        e = e4;
                        fileOutputStream = fileOutputStream2;
                        bufferedOutputStream = bufferedOutputStream3;
                        objectOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        r2 = bufferedOutputStream3;
                        file = 0;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    objectOutputStream2 = null;
                    fileOutputStream = fileOutputStream2;
                    bufferedOutputStream2 = null;
                } catch (IOException e6) {
                    e = e6;
                    objectOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    file = 0;
                    fileOutputStream = fileOutputStream2;
                    r2 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            objectOutputStream2 = null;
            bufferedOutputStream2 = null;
            fileOutputStream = null;
        } catch (IOException e8) {
            e = e8;
            objectOutputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            file = 0;
            r2 = 0;
            fileOutputStream = null;
        }
    }

    public aF(String str, String str2) {
        gq.a(new File(str).isDirectory());
        this.a = str;
        this.e = new ConditionVariable(false);
        this.c = new ConcurrentHashMap();
        this.b = (String) gq.a((Object) str2);
        this.d = new aG(this, str2);
    }

    public final aF a(Executor executor) {
        gq.a(executor, "executor may not be null");
        this.f = true;
        executor.execute(new aH(this));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // defpackage.aB
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Serializable a(Object obj) throws Throwable {
        ObjectInputStream objectInputStream;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream2;
        Serializable serializable;
        f();
        String strC = c(obj);
        if (!this.c.containsKey(strC)) {
            b();
            return null;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(this.a, strC));
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream2);
                try {
                    ObjectInputStream objectInputStream3 = new ObjectInputStream(bufferedInputStream2);
                    try {
                        serializable = (Serializable) objectInputStream3.readObject();
                        a((InputStream) fileInputStream2);
                        a((InputStream) bufferedInputStream2);
                        a((InputStream) objectInputStream3);
                    } catch (Exception e) {
                        objectInputStream2 = objectInputStream3;
                        fileInputStream = fileInputStream2;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            this.c.remove(strC);
                            C0081l.b("Error opening cache file (maybe removed). [filename=" + strC + "]");
                            a((InputStream) fileInputStream);
                            a((InputStream) bufferedInputStream);
                            a((InputStream) objectInputStream2);
                            serializable = null;
                        } catch (Throwable th) {
                            objectInputStream = objectInputStream2;
                            th = th;
                            a((InputStream) fileInputStream);
                            a((InputStream) bufferedInputStream);
                            a((InputStream) objectInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = objectInputStream3;
                        fileInputStream = fileInputStream2;
                        bufferedInputStream = bufferedInputStream2;
                        a((InputStream) fileInputStream);
                        a((InputStream) bufferedInputStream);
                        a((InputStream) objectInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    objectInputStream2 = null;
                    fileInputStream = fileInputStream2;
                    bufferedInputStream = bufferedInputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    objectInputStream = null;
                    fileInputStream = fileInputStream2;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Exception e3) {
                objectInputStream2 = null;
                fileInputStream = fileInputStream2;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                objectInputStream = null;
                fileInputStream = fileInputStream2;
                bufferedInputStream = null;
            }
        } catch (Exception e4) {
            objectInputStream2 = null;
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            objectInputStream = null;
            bufferedInputStream = null;
            fileInputStream = null;
        }
        if (serializable != null) {
            a();
            return serializable;
        }
        b();
        return serializable;
    }

    @Override // defpackage.aB
    public final void a(gr grVar) {
        e();
    }

    @Override // defpackage.aB
    public final void e() {
        f();
        this.c.clear();
        File[] fileArrListFiles = new File(this.a).listFiles(this.d);
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
    }

    private String c(Object obj) {
        return String.valueOf(obj.hashCode()) + this.b;
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }

    private static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    private void f() {
        if (!this.f) {
            throw new IllegalStateException(String.valueOf("init() must be called before calling to this method"));
        }
        this.e.block();
    }
}
