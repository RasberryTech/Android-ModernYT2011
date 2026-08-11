package defpackage;

import com.google.android.youtube.R;

/* JADX INFO: renamed from: fr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0196fr {
    VIDEO_RATED(R.string.event_video_rated, true),
    VIDEO_SHARED(R.string.event_video_shared, true),
    VIDEO_FAVORITED(R.string.event_video_favorited, true),
    VIDEO_COMMENTED(R.string.event_video_commented, true),
    VIDEO_UPLOADED(R.string.event_video_uploaded, true),
    FRIEND_ADDED(R.string.event_friend_added, false),
    USER_SUBSCRIPTION_ADDED(R.string.event_user_subscription_added, false);

    public final int h;
    public final boolean i;

    EnumC0196fr(int i, boolean z) {
        this.h = i;
        this.i = z;
    }
}
