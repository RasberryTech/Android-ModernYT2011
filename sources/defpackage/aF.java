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

public final class aF extends AbstractC0025ay {
    private final String a;
    private final String b;
    private final ConcurrentHashMap c;
    private final FilenameFilter d;
    private final ConditionVariable e;
    private volatile boolean f;

    static /* synthetic */ void a(aF aFVar) {
        File[] files = new File(aFVar.a).listFiles(aFVar.d);
        if (files != null) {
            for (File file : files) {
                aFVar.c.put(file.getName(), "");
            }
        }
    }

    @Override
    public final void a(Object obj, Object obj2) throws Throwable {
        Serializable serializable = (Serializable) obj2;
        f();
        String strC = c(obj);
        File file = new File(this.a, strC);
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            this.c.put(strC, "");
        } catch (FileNotFoundException e) {
            C0081l.b("Error creating cache file.", e);
        } catch (IOException e) {
            C0081l.b("Error creating cache file.", e);
        } finally {
            a((OutputStream) objectOutputStream);
            a((OutputStream) bufferedOutputStream);
            a((OutputStream) fileOutputStream);
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

    @Override
    public final Serializable a(Object obj) throws Throwable {
        f();
        String strC = c(obj);
        if (!this.c.containsKey(strC)) {
            b();
            return null;
        }
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        ObjectInputStream objectInputStream = null;
        Serializable serializable = null;
        try {
            fileInputStream = new FileInputStream(new File(this.a, strC));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            objectInputStream = new ObjectInputStream(bufferedInputStream);
            serializable = (Serializable) objectInputStream.readObject();
        } catch (Exception e) {
            this.c.remove(strC);
            C0081l.b("Error opening cache file (maybe removed). [filename=" + strC + "]");
        } finally {
            a((InputStream) objectInputStream);
            a((InputStream) bufferedInputStream);
            a((InputStream) fileInputStream);
        }
        if (serializable != null) {
            a();
            return serializable;
        }
        b();
        return null;
    }

    @Override
    public final void a(gr grVar) {
        e();
    }

    @Override
    public final void e() {
        f();
        this.c.clear();
        File[] files = new File(this.a).listFiles(this.d);
        if (files != null) {
            for (File file : files) {
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
