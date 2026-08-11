package com.google.android.youtube.modern;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Direct, key-authenticated YouTube Data API v3 client using only APIs present
 * on Android 2.2+. No current Google Android SDK is required by this class.
 */
public final class ModernYouTubeClient {
    public interface Callback {
        void onSuccess(List<ModernYouTubeVideo> videos, String nextPageToken);
        void onError(Exception error);
    }

    private final Context context;

    public ModernYouTubeClient(Context context) {
        this.context = context.getApplicationContext();
    }

    public void mostPopular(final String regionCode, final Callback callback) {
        new AsyncTask<Void, Void, Result>() {
            protected Result doInBackground(Void... ignored) {
                try {
                    String key = ModernYouTubeConfig.getApiKey(context);
                    if (TextUtils.isEmpty(key)) throw new IllegalStateException("YouTube Data API key is not configured");
                    String region = TextUtils.isEmpty(regionCode) ? "US" : regionCode;
                    String url = "https://www.googleapis.com/youtube/v3/videos?part=snippet&chart=mostPopular&maxResults=25&regionCode="
                            + URLEncoder.encode(region, "UTF-8") + "&key=" + URLEncoder.encode(key, "UTF-8");
                    return fetchVideoResult(url);
                } catch (Exception e) { return Result.failure(e); }
            }
            protected void onPostExecute(Result r) {
                if (r.error != null) callback.onError(r.error); else callback.onSuccess(r.videos, r.nextPageToken);
            }
        }.execute();
    }

    public void search(final String query, final String pageToken, final Callback callback) {
        if (TextUtils.isEmpty(query)) {
            callback.onError(new IllegalArgumentException("query cannot be empty"));
            return;
        }
        new AsyncTask<Void, Void, Result>() {
            protected Result doInBackground(Void... ignored) {
                try {
                    String key = ModernYouTubeConfig.getApiKey(context);
                    if (TextUtils.isEmpty(key)) throw new IllegalStateException("YouTube Data API key is not configured");
                    StringBuilder url = new StringBuilder("https://www.googleapis.com/youtube/v3/search");
                    url.append("?part=snippet&type=video&maxResults=25");
                    url.append("&q=").append(URLEncoder.encode(query, "UTF-8"));
                    url.append("&key=").append(URLEncoder.encode(key, "UTF-8"));
                    if (!TextUtils.isEmpty(pageToken)) url.append("&pageToken=").append(URLEncoder.encode(pageToken, "UTF-8"));
                    HttpURLConnection c = (HttpURLConnection) new URL(url.toString()).openConnection();
                    c.setConnectTimeout(15000);
                    c.setReadTimeout(20000);
                    c.setRequestMethod("GET");
                    c.setRequestProperty("Accept", "application/json");
                    int code = c.getResponseCode();
                    InputStream in = code >= 400 ? c.getErrorStream() : c.getInputStream();
                    String body = read(in);
                    c.disconnect();
                    if (code < 200 || code >= 300) throw new Exception("YouTube API HTTP " + code + ": " + body);
                    JSONObject root = new JSONObject(body);
                    JSONArray items = root.optJSONArray("items");
                    List<ModernYouTubeVideo> out = new ArrayList<ModernYouTubeVideo>();
                    if (items != null) {
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject item = items.getJSONObject(i);
                            JSONObject id = item.optJSONObject("id");
                            JSONObject s = item.optJSONObject("snippet");
                            if (id == null || s == null) continue;
                            String videoId = id.optString("videoId", null);
                            if (TextUtils.isEmpty(videoId)) continue;
                            JSONObject thumbs = s.optJSONObject("thumbnails");
                            String thumb = null;
                            if (thumbs != null) {
                                JSONObject medium = thumbs.optJSONObject("medium");
                                JSONObject high = thumbs.optJSONObject("high");
                                JSONObject def = thumbs.optJSONObject("default");
                                JSONObject t = medium != null ? medium : (high != null ? high : def);
                                if (t != null) thumb = t.optString("url", null);
                            }
                            out.add(new ModernYouTubeVideo(videoId, s.optString("title", ""),
                                    s.optString("channelTitle", ""), thumb, s.optString("publishedAt", "")));
                        }
                    }
                    return Result.success(out, root.optString("nextPageToken", null));
                } catch (Exception e) {
                    return Result.failure(e);
                }
            }
            protected void onPostExecute(Result r) {
                if (r.error != null) callback.onError(r.error);
                else callback.onSuccess(r.videos, r.nextPageToken);
            }
        }.execute();
    }

    private static String read(InputStream in) throws Exception {
        if (in == null) return "";
        BufferedReader r = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuilder b = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) b.append(line);
        r.close();
        return b.toString();
    }


    private static Result fetchVideoResult(String url) throws Exception {
        HttpURLConnection c = (HttpURLConnection) new URL(url).openConnection();
        c.setConnectTimeout(15000);
        c.setReadTimeout(20000);
        c.setRequestMethod("GET");
        c.setRequestProperty("Accept", "application/json");
        int code = c.getResponseCode();
        InputStream in = code >= 400 ? c.getErrorStream() : c.getInputStream();
        String body = read(in);
        c.disconnect();
        if (code < 200 || code >= 300) throw new Exception("YouTube API HTTP " + code + ": " + body);
        JSONObject root = new JSONObject(body);
        JSONArray items = root.optJSONArray("items");
        List<ModernYouTubeVideo> out = new ArrayList<ModernYouTubeVideo>();
        if (items != null) {
            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                JSONObject id = item.optJSONObject("id");
                JSONObject s = item.optJSONObject("snippet");
                if (id == null || s == null) continue;
                String videoId = id.optString("videoId", null);
                if (TextUtils.isEmpty(videoId)) videoId = id.optString("id", null);
                if (TextUtils.isEmpty(videoId)) continue;
                JSONObject thumbs = s.optJSONObject("thumbnails");
                String thumb = null;
                if (thumbs != null) {
                    JSONObject medium = thumbs.optJSONObject("medium");
                    JSONObject high = thumbs.optJSONObject("high");
                    JSONObject def = thumbs.optJSONObject("default");
                    JSONObject t = medium != null ? medium : (high != null ? high : def);
                    if (t != null) thumb = t.optString("url", null);
                }
                out.add(new ModernYouTubeVideo(videoId, s.optString("title", ""), s.optString("channelTitle", ""), thumb, s.optString("publishedAt", "")));
            }
        }
        return Result.success(out, root.optString("nextPageToken", null));
    }

    private static final class Result {
        final List<ModernYouTubeVideo> videos;
        final String nextPageToken;
        final Exception error;
        private Result(List<ModernYouTubeVideo> v, String p, Exception e) { videos = v; nextPageToken = p; error = e; }
        static Result success(List<ModernYouTubeVideo> v, String p) { return new Result(v, p, null); }
        static Result failure(Exception e) { return new Result(null, null, e); }
    }
}
