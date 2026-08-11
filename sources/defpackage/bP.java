package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes.dex */
public final class bP implements aM, aN {
    @Override // defpackage.aN
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((HttpResponse) obj);
    }

    @Override // defpackage.aM
    public final /* bridge */ /* synthetic */ Object b(Object obj) {
        String str = (String) obj;
        gq.a(str);
        return new HttpGet("http://video.google.com/timedtext?hl=en&v=" + str + "&type=list");
    }

    private static List a(HttpResponse httpResponse) throws aK {
        ArrayList arrayList = new ArrayList();
        try {
            if (httpResponse.getEntity().getContentLength() != 0) {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(httpResponse.getEntity().getContent()).getElementsByTagName("track");
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    NamedNodeMap attributes = elementsByTagName.item(i).getAttributes();
                    arrayList.add(new fG(attributes.getNamedItem("lang_code").getNodeValue(), attributes.getNamedItem("lang_original").getNodeValue(), attributes.getNamedItem("name").getNodeValue()));
                }
            }
            return arrayList;
        } catch (IOException e) {
            throw new aK(e);
        } catch (ParserConfigurationException e2) {
            throw new aK(e2);
        } catch (SAXException e3) {
            throw new aK(e3);
        }
    }
}
