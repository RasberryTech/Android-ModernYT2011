package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: classes.dex */
public final class aW {
    private static final Attributes a = new aY();
    private static final Map c;
    private final SAXParserFactory b;

    static {
        HashMap map = new HashMap();
        map.put("http://xml.org/sax/features/namespaces", false);
        map.put("http://xml.org/sax/features/namespace-prefixes", true);
        c = Collections.unmodifiableMap(map);
    }

    public static aW a() {
        return new aW(c);
    }

    private aW(Map map) {
        gq.a(map, "features can't be null");
        try {
            this.b = SAXParserFactory.newInstance();
            for (Map.Entry entry : map.entrySet()) {
                this.b.setFeature((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX initilization error", e);
        } catch (SAXNotRecognizedException e2) {
            throw new RuntimeException("SAX initilization error", e2);
        } catch (SAXNotSupportedException e3) {
            throw new RuntimeException("SAX initilization error", e3);
        }
    }

    public final Object a(InputStream inputStream, aO aOVar) throws aL {
        XMLReader xMLReader;
        gq.a(inputStream, "input can't be null");
        gq.a(aOVar, "rules can't be null");
        try {
            synchronized (this.b) {
                xMLReader = this.b.newSAXParser().getXMLReader();
            }
            aZ aZVar = new aZ(aOVar);
            xMLReader.setContentHandler(aZVar);
            xMLReader.parse(new InputSource(inputStream));
            if (aZVar.a == null) {
                throw new aL("XML is well-formed but invalid");
            }
            return aZVar.a;
        } catch (IOException e) {
            throw new aL(e);
        } catch (ParserConfigurationException e2) {
            throw new aL(e2);
        } catch (SAXException e3) {
            throw new aL(e3);
        }
    }
}
