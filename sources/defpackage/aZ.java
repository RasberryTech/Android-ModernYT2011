package defpackage;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes.dex */
final class aZ extends DefaultHandler {
    public Object a;
    private final aO b;
    private final gu c;
    private final gu d = new gu();
    private final gu e;
    private final gu f;

    public aZ(aO aOVar) {
        this.b = aOVar;
        this.d.offer("");
        this.e = new gu();
        this.f = new gu();
        this.c = new gu();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        String str4 = ((String) this.d.peek()) + "/" + str3;
        this.d.offer(str4);
        InterfaceC0028ba interfaceC0028baA = this.b.a(str4);
        if (interfaceC0028baA != null) {
            this.e.offer(attributes != null ? new AttributesImpl(attributes) : aW.a);
            this.f.offer(new StringBuilder());
            interfaceC0028baA.a(this.c, attributes);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        InterfaceC0028ba interfaceC0028baA = this.b.a((String) this.d.poll());
        if (interfaceC0028baA != null) {
            Attributes attributes = (Attributes) this.e.poll();
            String string = ((StringBuilder) this.f.poll()).toString();
            Object objPeek = this.c.peek();
            if (objPeek == null) {
                objPeek = this.a;
            }
            this.a = objPeek;
            interfaceC0028baA.a(this.c, attributes, string);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i, int i2) {
        if (this.b.a((String) this.d.peek()) != null) {
            ((StringBuilder) this.f.peek()).append(cArr, i, i2);
        }
    }
}
