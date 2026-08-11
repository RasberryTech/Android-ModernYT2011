package defpackage;

import com.google.android.youtube.C0081l;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: classes.dex */
public abstract class cU {
    private static final SimpleDateFormat a;
    private static final SimpleDateFormat b;
    private static /* synthetic */ boolean d;
    private final cG c;

    protected abstract void a();

    protected abstract void a(String str);

    protected abstract void a(String str, String str2);

    protected abstract void a(String str, Attributes attributes);

    static {
        d = !cU.class.desiredAssertionStatus();
        a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
    }

    public cU(cG cGVar) {
        if (!d && cGVar == null) {
            throw new AssertionError("GDataErrorListener cannot be null.");
        }
        this.c = cGVar;
    }

    protected void b() {
    }

    public static int b(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String str2 = "Invalid int: " + str;
            return (int) d(str);
        }
    }

    private static float d(String str) {
        if (str == null) {
            return -1.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            String str2 = "Invalid float: " + str;
            return -1.0f;
        }
    }

    public static Date c(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        try {
            return a.parse(str);
        } catch (ParseException e) {
            try {
                int length = str.length() - 3;
                str2 = (length < 0 || str.charAt(length) != ':') ? str : str.substring(0, length) + str.substring(length + 1);
                try {
                    return b.parse(str2);
                } catch (ParseException e2) {
                    String str3 = "Invalid RFC3339 date: " + str2;
                    return null;
                }
            } catch (ParseException e3) {
                str2 = str;
            }
        }
    }

    public final void a(InputStream inputStream) {
        try {
            b();
            cV cVVar = new cV(this);
            try {
                try {
                    XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                    xMLReader.setContentHandler(cVVar);
                    xMLReader.setFeature("http://xml.org/sax/features/namespaces", false);
                    xMLReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
                    xMLReader.parse(new InputSource(inputStream));
                } catch (SAXException e) {
                    C0081l.b("Error parsing XML", e);
                    cVVar.a.c.a(new cH(e, cI.RESPONSE_ERROR));
                }
            } catch (IOException e2) {
                C0081l.b("Error parsing XML", e2);
                cVVar.a.c.a(new cH(e2, cI.RESPONSE_ERROR));
            } catch (ParserConfigurationException e3) {
                C0081l.b("Error parsing XML", e3);
                cVVar.a.c.a(new cH(e3, cI.RESPONSE_ERROR));
            }
        } catch (Exception e4) {
            C0081l.b("Error parsing XML", e4);
            this.c.a(new cH(e4, cI.RESPONSE_ERROR));
        }
    }
}
