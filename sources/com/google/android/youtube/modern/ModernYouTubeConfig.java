package com.google.android.youtube.modern;

import android.content.Context;
import android.text.TextUtils;

/** Configuration for the modern YouTube bridge. API 8 compatible. */
public final class ModernYouTubeConfig {
    private ModernYouTubeConfig() {}

    public static String getApiKey(Context context) {
        String key = context.getSharedPreferences("youtube", 0).getString("modern_youtube_api_key", null);
        if (!TextUtils.isEmpty(key)) return key;
        int id = context.getResources().getIdentifier("modern_youtube_api_key", "string", context.getPackageName());
        return id == 0 ? null : context.getString(id);
    }

    public static boolean isConfigured(Context context) {
        String key = getApiKey(context);
        return !TextUtils.isEmpty(key) && !"PUT_YOUR_YOUTUBE_DATA_API_KEY_HERE".equals(key);
    }
}
