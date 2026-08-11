package com.google.android.youtube.suggest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.youtube.C0081l;
import com.google.android.youtube.YouTubeApplication;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class SuggestionProvider extends ContentProvider {
    private HttpClient a;
    private String b;
    private ArrayList c = new ArrayList(10);
    private HttpGet d;
    private String e;
    private a f;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.a = new DefaultHttpClient();
        this.f = new a(getContext());
        YouTubeApplication.d().a(this.f);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.b = null;
        if (uri.getPathSegments().size() > 1) {
            this.b = uri.getLastPathSegment().toLowerCase();
        }
        c cVar = new c();
        if (!TextUtils.isEmpty(this.b)) {
            try {
                String strEncode = URLEncoder.encode(this.b, "UTF-8");
                String str3 = "en";
                String language = Locale.getDefault().getLanguage();
                if (language != null && language.length() == 2) {
                    str3 = language;
                }
                this.d = new HttpGet(String.format("http://suggestqueries.google.com/complete/search?hl=%s&ds=yt&client=androidyt&hjson=t&q=%s", str3, strEncode));
                HttpResponse httpResponseExecute = this.a.execute(this.d);
                int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    this.e = EntityUtils.toString(httpResponseExecute.getEntity());
                    JSONArray jSONArray = new JSONArray(this.e).getJSONArray(1);
                    synchronized (this.c) {
                        this.c.clear();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                            this.c.add(new d(jSONArray2.getString(0), jSONArray2.getString(1), jSONArray2.getString(2)));
                        }
                    }
                } else {
                    String str4 = "unexpected suggest response " + statusCode;
                }
            } catch (IOException e) {
                C0081l.b("error fetching suggestions", e);
            } catch (JSONException e2) {
                C0081l.b("error fetching suggestions, response was " + this.e, e2);
            }
            synchronized (this.c) {
                cVar.a(this.c);
            }
            return cVar;
        }
        return this.f.a();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd.android.search.suggest";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        this.f.a(contentValues);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }
}
