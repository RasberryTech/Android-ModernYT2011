package com.google.android.youtube.modern;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Official embed bridge. It never extracts protected media URLs. The legacy
 * player remains in the layout; a WebView is placed over it for modern embeds.
 */
public final class ModernPlayback {
    private ModernPlayback() {}

    public static WebView attach(final Activity activity, final View legacyPlayer, final String videoId) {
        if (videoId == null || videoId.length() == 0 || legacyPlayer == null) return null;
        if (!(legacyPlayer.getParent() instanceof ViewGroup)) return null;
        final ViewGroup parent = (ViewGroup) legacyPlayer.getParent();
        final int index = parent.indexOfChild(legacyPlayer);
        final ViewGroup.LayoutParams lp = legacyPlayer.getLayoutParams();
        final WebView web = new WebView(activity);
        web.setBackgroundColor(0xff000000);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 8) settings.setPluginsEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient() {
            private boolean failed;
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                if (!failed) { failed = true; openExternally(activity, videoId); }
            }
        });
        parent.addView(web, index, lp);
        legacyPlayer.setVisibility(View.GONE);
        web.loadUrl("https://www.youtube.com/embed/" + Uri.encode(videoId) + "?autoplay=1&playsinline=1&rel=0");
        return web;
    }

    public static void detach(View legacyPlayer, WebView web) {
        if (web != null) {
            if (web.getParent() instanceof ViewGroup) ((ViewGroup) web.getParent()).removeView(web);
            web.stopLoading();
            web.destroy();
        }
        if (legacyPlayer != null) legacyPlayer.setVisibility(View.VISIBLE);
    }

    public static void openExternally(Activity activity, String videoId) {
        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + Uri.encode(videoId))));
    }
}
