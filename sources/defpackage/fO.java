package defpackage;

import com.google.android.youtube.R;

/* JADX INFO: loaded from: classes.dex */
public enum fO {
    PLAYABLE(-1),
    PROCESSING(R.string.processing_video),
    DELETED(R.string.video_was_deleted),
    COUNTRY_RESTRICTED(R.string.video_not_available_in_your_country),
    NOT_AVAILABLE_ON_MOBILE(R.string.video_not_available_on_mobile),
    PRIVATE(R.string.video_is_private),
    COPYRIGHT(R.string.video_infringes_copyright),
    INAPPROPRIATE(R.string.video_was_judged_inappropriate),
    DUPLICATE(R.string.duplicate_upload),
    TERMS_OF_USE(R.string.video_violated_terms_of_use),
    ACCOUNT_SUSPENDED(R.string.uploader_account_suspended),
    VIDEO_TOO_LONG(R.string.video_too_long),
    BLOCKED_BY_OWNER(R.string.blocked_by_content_owner),
    CANT_PROCESS(R.string.video_couldnt_be_processed),
    INVALID_FORMAT(R.string.video_is_in_an_invalid_format),
    UNSUPPORTED_CODEC(R.string.video_uses_an_unsupported_codec),
    EMPTY(R.string.video_is_empty),
    TOO_SMALL(R.string.video_is_too_small);

    public final int s;

    fO(int i) {
        this.s = i;
    }
}
