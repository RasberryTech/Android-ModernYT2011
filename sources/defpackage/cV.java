package defpackage;

import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes.dex */
final class cV extends DefaultHandler {
    final /* synthetic */ cU a;
    private Stack b;
    private Attributes c;
    private StringBuilder d;

    /* synthetic */ cV(cU cUVar) {
        this(cUVar, (byte) 0);
    }

    private cV(cU cUVar, byte b) {
        this.a = cUVar;
        this.b = new Stack();
        this.c = new AttributesImpl();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.b.push(str3);
        this.a.a(str3, attributes == null ? this.c : attributes);
        this.d = new StringBuilder();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i, int i2) {
        this.d.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        this.a.a((String) this.b.peek(), this.d.toString());
        this.a.a((String) this.b.pop());
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endDocument() {
        this.a.a();
    }
}
