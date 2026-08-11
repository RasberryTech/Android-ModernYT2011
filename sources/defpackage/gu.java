package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class gu implements Queue {
    private final LinkedList a = new LinkedList();

    @Override // java.util.Queue
    public final Object element() {
        if (this.a.size() > 0) {
            return this.a.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        this.a.add(0, obj);
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (this.a.size() > 0) {
            return this.a.get(0);
        }
        return null;
    }

    public final Object a(Class cls) {
        return cls.cast(peek());
    }

    @Override // java.util.Queue
    public final Object poll() {
        if (this.a.size() > 0) {
            return this.a.remove(0);
        }
        return null;
    }

    public final Object b(Class cls) {
        return cls.cast(poll());
    }

    @Override // java.util.Queue
    public final Object remove() {
        if (this.a.size() > 0) {
            return this.a.remove(0);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Queue, java.util.Collection
    public final boolean add(Object obj) {
        this.a.add(0, obj);
        return true;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.a.add(0, it.next());
        }
        return true;
    }

    @Override // java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.a.iterator();
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        throw new UnsupportedOperationException();
    }
}
