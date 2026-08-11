package com.google.android.youtube.suggest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private SQLiteOpenHelper a;
    private String[] b = {"0 AS suggest_format", "display1 AS suggest_text_1", "display2 AS suggest_text_2", "query AS suggest_intent_query", "_id"};

    public a(Context context) {
        this.a = new b(context);
    }

    public final void a(ContentValues contentValues) {
        String str = "History insert " + contentValues;
        this.a.getWritableDatabase().insert("suggestions", "query", contentValues);
    }

    public final Cursor a() {
        Cursor cursorQuery = this.a.getReadableDatabase().query("suggestions", this.b, null, null, null, null, "date DESC", null);
        String str = "History query returning " + cursorQuery.getCount() + " rows";
        return cursorQuery;
    }

    public final void b() {
        String str = "Cleared search history " + this.a.getWritableDatabase().delete("suggestions", "1", null) + " rows";
    }
}
