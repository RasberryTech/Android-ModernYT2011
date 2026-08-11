package com.google.android.youtube.modern;

/** Small immutable model used by the legacy 2011 list UI. */
public final class ModernYouTubeVideo {
    public final String id;
    public final String title;
    public final String channelTitle;
    public final String thumbnailUrl;
    public final String publishedAt;

    public ModernYouTubeVideo(String id, String title, String channelTitle,
            String thumbnailUrl, String publishedAt) {
        this.id = id;
        this.title = title;
        this.channelTitle = channelTitle;
        this.thumbnailUrl = thumbnailUrl;
        this.publishedAt = publishedAt;
    }
}
