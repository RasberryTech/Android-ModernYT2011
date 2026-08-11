package com.google.android.youtube.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class TabRow extends HorizontalScrollView implements View.OnClickListener {
    private final LinearLayout a;
    private InterfaceC0110w b;
    private int c;
    private boolean d;

    public TabRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = true;
        this.a = new LinearLayout(context);
        addView(this.a, new LinearLayout.LayoutParams(-2, -2));
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
    }

    public void addTab(int i) {
        addTab(getContext().getString(i));
    }

    public void addTab(String str) {
        LayoutInflater.from(getContext()).inflate(com.google.android.youtube.R.layout.tab, (ViewGroup) this.a, true);
        TextView textView = (TextView) this.a.getChildAt(this.a.getChildCount() - 1);
        textView.setText(str);
        textView.setOnClickListener(this);
        this.d = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIndexOfChild;
        if (this.b != null && (iIndexOfChild = this.a.indexOfChild(view)) >= 0) {
            this.b.b(iIndexOfChild);
        }
    }

    public View getTabAt(int i) {
        return ((LinearLayout) getChildAt(0)).getChildAt(i);
    }

    public int getTabCount() {
        return ((LinearLayout) getChildAt(0)).getChildCount();
    }

    public void removeAllTabs() {
        ((LinearLayout) getChildAt(0)).removeAllViews();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.d = false;
        int i5 = this.c;
        if (i5 >= 0) {
            this.c = -1;
            focusTab(i5, true);
        }
    }

    public void focusTab(int i, boolean z) {
        if (this.d) {
            this.c = i;
            return;
        }
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        int childCount = linearLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            linearLayout.getChildAt(i2).setSelected(i2 == i);
            i2++;
        }
        View childAt = linearLayout.getChildAt(i);
        if (childAt != null) {
            int left = ((childAt.getLeft() + childAt.getRight()) - getWidth()) / 2;
            if (z) {
                smoothScrollTo(left, 0);
            } else {
                scrollTo(left, 0);
            }
        }
    }

    public void setOnTabClickListener(InterfaceC0110w interfaceC0110w) {
        this.b = interfaceC0110w;
    }
}
