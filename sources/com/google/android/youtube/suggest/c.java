package com.google.android.youtube.suggest;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AbstractCursor {
    private static String[] b = {"_id", "suggest_text_1", "suggest_text_2", "suggest_intent_query"};
    private ArrayList a = new ArrayList(10);

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final String[] getColumnNames() {
        return b;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final String getString(int i) {
        if (this.mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        if (this.mPos >= this.a.size()) {
            throw new CursorIndexOutOfBoundsException("After last row.");
        }
        if (i == 3 || i == 1) {
            return ((d) this.a.get(this.mPos)).a;
        }
        return null;
    }

    public final void a(ArrayList arrayList) {
        this.a.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.a.add((d) it.next());
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final int getCount() {
        return this.a.size();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final double getDouble(int i) {
        return Double.valueOf(getString(i)).doubleValue();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final float getFloat(int i) {
        return Float.valueOf(getString(i)).floatValue();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final int getInt(int i) {
        return Integer.valueOf(getString(i)).intValue();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final long getLong(int i) {
        return i == 0 ? this.mPos : Long.valueOf(getString(i)).longValue();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final short getShort(int i) {
        return Short.valueOf(getString(i)).shortValue();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final boolean isNull(int i) {
        return getString(i) == null;
    }
}
