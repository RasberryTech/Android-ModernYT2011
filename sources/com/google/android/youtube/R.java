package com.google.android.youtube;

import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class R implements Runnable {
    private /* synthetic */ byte[] a;
    private /* synthetic */ Q b;

    /* JADX INFO: Added by JADX */
    public static final class anim {

        /* JADX INFO: Added by JADX */
        public static final int player_out = 0x7f040000;

        /* JADX INFO: Added by JADX */
        public static final int video_teaser_in = 0x7f040001;

        /* JADX INFO: Added by JADX */
        public static final int video_teaser_out = 0x7f040002;
    }

    /* JADX INFO: Added by JADX */
    public static final class array {

        /* JADX INFO: Added by JADX */
        public static final int safe_search_levels = 0x7f090000;

        /* JADX INFO: Added by JADX */
        public static final int subtitles_size_entries = 0x7f090001;

        /* JADX INFO: Added by JADX */
        public static final int subtitles_size_values = 0x7f090002;
    }

    /* JADX INFO: Added by JADX */
    public static final class color {

        /* JADX INFO: Added by JADX */
        public static final int white = 0x7f070000;

        /* JADX INFO: Added by JADX */
        public static final int grey = 0x7f070001;

        /* JADX INFO: Added by JADX */
        public static final int light_grey = 0x7f070002;

        /* JADX INFO: Added by JADX */
        public static final int dark_grey = 0x7f070003;

        /* JADX INFO: Added by JADX */
        public static final int dark_transparent = 0x7f070004;

        /* JADX INFO: Added by JADX */
        public static final int light_transparent = 0x7f070005;

        /* JADX INFO: Added by JADX */
        public static final int black = 0x7f070006;

        /* JADX INFO: Added by JADX */
        public static final int red = 0x7f070007;

        /* JADX INFO: Added by JADX */
        public static final int grey_text = 0x7f070008;

        /* JADX INFO: Added by JADX */
        public static final int header_text = 0x7f070009;

        /* JADX INFO: Added by JADX */
        public static final int link_text = 0x7f07000a;

        /* JADX INFO: Added by JADX */
        public static final int tab_indicator_text = 0x7f07000b;

        /* JADX INFO: Added by JADX */
        public static final int tab_text = 0x7f07000c;

        /* JADX INFO: Added by JADX */
        public static final int white_text = 0x7f07000d;
    }

    /* JADX INFO: Added by JADX */
    public static final class dimen {

        /* JADX INFO: Added by JADX */
        public static final int extra_small_font_size = 0x7f060000;

        /* JADX INFO: Added by JADX */
        public static final int small_font_size = 0x7f060001;

        /* JADX INFO: Added by JADX */
        public static final int medium_font_size = 0x7f060002;

        /* JADX INFO: Added by JADX */
        public static final int large_font_size = 0x7f060003;

        /* JADX INFO: Added by JADX */
        public static final int thumbnail_width = 0x7f060004;

        /* JADX INFO: Added by JADX */
        public static final int thumbnail_height = 0x7f060005;

        /* JADX INFO: Added by JADX */
        public static final int avatar_width = 0x7f060006;

        /* JADX INFO: Added by JADX */
        public static final int avatar_height = 0x7f060007;

        /* JADX INFO: Added by JADX */
        public static final int small_thumbnail_width = 0x7f060008;

        /* JADX INFO: Added by JADX */
        public static final int small_thumbnail_height = 0x7f060009;

        /* JADX INFO: Added by JADX */
        public static final int list_item_padding = 0x7f06000a;

        /* JADX INFO: Added by JADX */
        public static final int header_height = 0x7f06000b;

        /* JADX INFO: Added by JADX */
        public static final int header_text_horizontal_padding = 0x7f06000c;
    }

    /* JADX INFO: Added by JADX */
    public static final class drawable {

        /* JADX INFO: Added by JADX */
        public static final int alert_error = 0x7f020000;

        /* JADX INFO: Added by JADX */
        public static final int appwidget_inner_focus_l = 0x7f020001;

        /* JADX INFO: Added by JADX */
        public static final int appwidget_inner_press_l = 0x7f020002;

        /* JADX INFO: Added by JADX */
        public static final int avatar_border = 0x7f020003;

        /* JADX INFO: Added by JADX */
        public static final int btn_default_normal = 0x7f020004;

        /* JADX INFO: Added by JADX */
        public static final int btn_default_selected = 0x7f020005;

        /* JADX INFO: Added by JADX */
        public static final int btn_logo_normal = 0x7f020006;

        /* JADX INFO: Added by JADX */
        public static final int btn_logo_selected = 0x7f020007;

        /* JADX INFO: Added by JADX */
        public static final int btn_tab_default = 0x7f020008;

        /* JADX INFO: Added by JADX */
        public static final int btn_tab_selected = 0x7f020009;

        /* JADX INFO: Added by JADX */
        public static final int btn_widget_logo = 0x7f02000a;

        /* JADX INFO: Added by JADX */
        public static final int button_background = 0x7f02000b;

        /* JADX INFO: Added by JADX */
        public static final int capture_drawable = 0x7f02000c;

        /* JADX INFO: Added by JADX */
        public static final int copy_url_drawable = 0x7f02000d;

        /* JADX INFO: Added by JADX */
        public static final int delete_drawable = 0x7f02000e;

        /* JADX INFO: Added by JADX */
        public static final int dislike_drawable = 0x7f02000f;

        /* JADX INFO: Added by JADX */
        public static final int favorite_drawable = 0x7f020010;

        /* JADX INFO: Added by JADX */
        public static final int flag_drawable = 0x7f020011;

        /* JADX INFO: Added by JADX */
        public static final int header = 0x7f020012;

        /* JADX INFO: Added by JADX */
        public static final int header_divider = 0x7f020013;

        /* JADX INFO: Added by JADX */
        public static final int ic_activity_comment = 0x7f020014;

        /* JADX INFO: Added by JADX */
        public static final int ic_activity_favorite = 0x7f020015;

        /* JADX INFO: Added by JADX */
        public static final int ic_activity_friend = 0x7f020016;

        /* JADX INFO: Added by JADX */
        public static final int ic_activity_like = 0x7f020017;

        /* JADX INFO: Added by JADX */
        public static final int ic_activity_shared = 0x7f020018;

        /* JADX INFO: Added by JADX */
        public static final int ic_activity_subscribe = 0x7f020019;

        /* JADX INFO: Added by JADX */
        public static final int ic_activity_upload = 0x7f02001a;

        /* JADX INFO: Added by JADX */
        public static final int ic_add_playlist = 0x7f02001b;

        /* JADX INFO: Added by JADX */
        public static final int ic_add_playlist_focus = 0x7f02001c;

        /* JADX INFO: Added by JADX */
        public static final int ic_copy_link = 0x7f02001d;

        /* JADX INFO: Added by JADX */
        public static final int ic_copy_link_focus = 0x7f02001e;

        /* JADX INFO: Added by JADX */
        public static final int ic_delete = 0x7f02001f;

        /* JADX INFO: Added by JADX */
        public static final int ic_delete_focus = 0x7f020020;

        /* JADX INFO: Added by JADX */
        public static final int ic_dislike = 0x7f020021;

        /* JADX INFO: Added by JADX */
        public static final int ic_dislike_disabled = 0x7f020022;

        /* JADX INFO: Added by JADX */
        public static final int ic_dislike_focus = 0x7f020023;

        /* JADX INFO: Added by JADX */
        public static final int ic_favorite = 0x7f020024;

        /* JADX INFO: Added by JADX */
        public static final int ic_favorite_focus = 0x7f020025;

        /* JADX INFO: Added by JADX */
        public static final int ic_flag = 0x7f020026;

        /* JADX INFO: Added by JADX */
        public static final int ic_flag_focus = 0x7f020027;

        /* JADX INFO: Added by JADX */
        public static final int ic_launcher_youtube = 0x7f020028;

        /* JADX INFO: Added by JADX */
        public static final int ic_like = 0x7f020029;

        /* JADX INFO: Added by JADX */
        public static final int ic_like_disabled = 0x7f02002a;

        /* JADX INFO: Added by JADX */
        public static final int ic_like_focus = 0x7f02002b;

        /* JADX INFO: Added by JADX */
        public static final int ic_menu_browse = 0x7f02002c;

        /* JADX INFO: Added by JADX */
        public static final int ic_menu_capture_focus = 0x7f02002d;

        /* JADX INFO: Added by JADX */
        public static final int ic_menu_capture_normal = 0x7f02002e;

        /* JADX INFO: Added by JADX */
        public static final int ic_menu_home = 0x7f02002f;

        /* JADX INFO: Added by JADX */
        public static final int ic_menu_my_channel = 0x7f020030;

        /* JADX INFO: Added by JADX */
        public static final int ic_menu_search_focus = 0x7f020031;

        /* JADX INFO: Added by JADX */
        public static final int ic_menu_search_normal = 0x7f020032;

        /* JADX INFO: Added by JADX */
        public static final int ic_more = 0x7f020033;

        /* JADX INFO: Added by JADX */
        public static final int ic_more_disabled = 0x7f020034;

        /* JADX INFO: Added by JADX */
        public static final int ic_more_focus = 0x7f020035;

        /* JADX INFO: Added by JADX */
        public static final int ic_music = 0x7f020036;

        /* JADX INFO: Added by JADX */
        public static final int ic_now_playing = 0x7f020037;

        /* JADX INFO: Added by JADX */
        public static final int ic_searchable = 0x7f020038;

        /* JADX INFO: Added by JADX */
        public static final int ic_share = 0x7f020039;

        /* JADX INFO: Added by JADX */
        public static final int ic_share_focus = 0x7f02003a;

        /* JADX INFO: Added by JADX */
        public static final int ic_unfavorite = 0x7f02003b;

        /* JADX INFO: Added by JADX */
        public static final int ic_unfavorite_focus = 0x7f02003c;

        /* JADX INFO: Added by JADX */
        public static final int ic_youtube_thumbnail_small = 0x7f02003d;

        /* JADX INFO: Added by JADX */
        public static final int ic_youtube_thumbnail_unavailable = 0x7f02003e;

        /* JADX INFO: Added by JADX */
        public static final int like_drawable = 0x7f02003f;

        /* JADX INFO: Added by JADX */
        public static final int logo = 0x7f020040;

        /* JADX INFO: Added by JADX */
        public static final int more_drawable = 0x7f020041;

        /* JADX INFO: Added by JADX */
        public static final int player_cc = 0x7f020042;

        /* JADX INFO: Added by JADX */
        public static final int player_cc_focus = 0x7f020043;

        /* JADX INFO: Added by JADX */
        public static final int player_cc_off = 0x7f020044;

        /* JADX INFO: Added by JADX */
        public static final int player_cc_on = 0x7f020045;

        /* JADX INFO: Added by JADX */
        public static final int player_hq = 0x7f020046;

        /* JADX INFO: Added by JADX */
        public static final int player_hq_focus = 0x7f020047;

        /* JADX INFO: Added by JADX */
        public static final int player_hq_off = 0x7f020048;

        /* JADX INFO: Added by JADX */
        public static final int player_hq_on = 0x7f020049;

        /* JADX INFO: Added by JADX */
        public static final int player_osd_paused = 0x7f02004a;

        /* JADX INFO: Added by JADX */
        public static final int player_replay = 0x7f02004b;

        /* JADX INFO: Added by JADX */
        public static final int player_replay_focus = 0x7f02004c;

        /* JADX INFO: Added by JADX */
        public static final int player_replay_off = 0x7f02004d;

        /* JADX INFO: Added by JADX */
        public static final int player_scrubber = 0x7f02004e;

        /* JADX INFO: Added by JADX */
        public static final int promo_bubble = 0x7f02004f;

        /* JADX INFO: Added by JADX */
        public static final int promo_flick = 0x7f020050;

        /* JADX INFO: Added by JADX */
        public static final int promo_rotate = 0x7f020051;

        /* JADX INFO: Added by JADX */
        public static final int save_drawable = 0x7f020052;

        /* JADX INFO: Added by JADX */
        public static final int search_drawable = 0x7f020053;

        /* JADX INFO: Added by JADX */
        public static final int share_drawable = 0x7f020054;

        /* JADX INFO: Added by JADX */
        public static final int tab_drawable = 0x7f020055;

        /* JADX INFO: Added by JADX */
        public static final int unfavorite_drawable = 0x7f020056;

        /* JADX INFO: Added by JADX */
        public static final int vevo_overlay = 0x7f020057;

        /* JADX INFO: Added by JADX */
        public static final int video_frame = 0x7f020058;

        /* JADX INFO: Added by JADX */
        public static final int widget_divider = 0x7f020059;

        /* JADX INFO: Added by JADX */
        public static final int widget_left_highlight = 0x7f02005a;

        /* JADX INFO: Added by JADX */
        public static final int yt_widget_background = 0x7f02005b;
    }

    /* JADX INFO: Added by JADX */
    public static final class id {

        /* JADX INFO: Added by JADX */
        public static final int edit = 0x7f0b0000;

        /* JADX INFO: Added by JADX */
        public static final int submit = 0x7f0b0001;

        /* JADX INFO: Added by JADX */
        public static final int status = 0x7f0b0002;

        /* JADX INFO: Added by JADX */
        public static final int name = 0x7f0b0003;

        /* JADX INFO: Added by JADX */
        public static final int bio = 0x7f0b0004;

        /* JADX INFO: Added by JADX */
        public static final int tabrow = 0x7f0b0005;

        /* JADX INFO: Added by JADX */
        public static final int workspace = 0x7f0b0006;

        /* JADX INFO: Added by JADX */
        public static final int most_viewed = 0x7f0b0007;

        /* JADX INFO: Added by JADX */
        public static final int top_rated = 0x7f0b0008;

        /* JADX INFO: Added by JADX */
        public static final int most_discussed = 0x7f0b0009;

        /* JADX INFO: Added by JADX */
        public static final int top_favorited = 0x7f0b000a;

        /* JADX INFO: Added by JADX */
        public static final int feed_info_list_screen = 0x7f0b000b;

        /* JADX INFO: Added by JADX */
        public static final int categories = 0x7f0b000c;

        /* JADX INFO: Added by JADX */
        public static final int category = 0x7f0b000d;

        /* JADX INFO: Added by JADX */
        public static final int uploads = 0x7f0b000e;

        /* JADX INFO: Added by JADX */
        public static final int favorites = 0x7f0b000f;

        /* JADX INFO: Added by JADX */
        public static final int activity = 0x7f0b0010;

        /* JADX INFO: Added by JADX */
        public static final int playlists = 0x7f0b0011;

        /* JADX INFO: Added by JADX */
        public static final int channel_avatar = 0x7f0b0012;

        /* JADX INFO: Added by JADX */
        public static final int channel_title = 0x7f0b0013;

        /* JADX INFO: Added by JADX */
        public static final int channel_views = 0x7f0b0014;

        /* JADX INFO: Added by JADX */
        public static final int channel_uploaded = 0x7f0b0015;

        /* JADX INFO: Added by JADX */
        public static final int channel_subscribers = 0x7f0b0016;

        /* JADX INFO: Added by JADX */
        public static final int author = 0x7f0b0017;

        /* JADX INFO: Added by JADX */
        public static final int comment = 0x7f0b0018;

        /* JADX INFO: Added by JADX */
        public static final int time = 0x7f0b0019;

        /* JADX INFO: Added by JADX */
        public static final int icon = 0x7f0b001a;

        /* JADX INFO: Added by JADX */
        public static final int title = 0x7f0b001b;

        /* JADX INFO: Added by JADX */
        public static final int target_not_found = 0x7f0b001c;

        /* JADX INFO: Added by JADX */
        public static final int target = 0x7f0b001d;

        /* JADX INFO: Added by JADX */
        public static final int timeAgo = 0x7f0b001e;

        /* JADX INFO: Added by JADX */
        public static final int header_logo = 0x7f0b001f;

        /* JADX INFO: Added by JADX */
        public static final int header_buttons = 0x7f0b0020;

        /* JADX INFO: Added by JADX */
        public static final int header_title = 0x7f0b0021;

        /* JADX INFO: Added by JADX */
        public static final int videos = 0x7f0b0022;

        /* JADX INFO: Added by JADX */
        public static final int now_playing = 0x7f0b0023;

        /* JADX INFO: Added by JADX */
        public static final int information = 0x7f0b0024;

        /* JADX INFO: Added by JADX */
        public static final int length = 0x7f0b0025;

        /* JADX INFO: Added by JADX */
        public static final int subscriptions = 0x7f0b0026;

        /* JADX INFO: Added by JADX */
        public static final int channel_subscriptions = 0x7f0b0027;

        /* JADX INFO: Added by JADX */
        public static final int playlist_summary = 0x7f0b0028;

        /* JADX INFO: Added by JADX */
        public static final int playlist_details = 0x7f0b0029;

        /* JADX INFO: Added by JADX */
        public static final int playlist = 0x7f0b002a;

        /* JADX INFO: Added by JADX */
        public static final int message = 0x7f0b002b;

        /* JADX INFO: Added by JADX */
        public static final int error = 0x7f0b002c;

        /* JADX INFO: Added by JADX */
        public static final int progressbar = 0x7f0b002d;

        /* JADX INFO: Added by JADX */
        public static final int retry = 0x7f0b002e;

        /* JADX INFO: Added by JADX */
        public static final int text = 0x7f0b002f;

        /* JADX INFO: Added by JADX */
        public static final int toolbar_layout = 0x7f0b0030;

        /* JADX INFO: Added by JADX */
        public static final int video_frame = 0x7f0b0031;

        /* JADX INFO: Added by JADX */
        public static final int thumbnail = 0x7f0b0032;

        /* JADX INFO: Added by JADX */
        public static final int duration = 0x7f0b0033;

        /* JADX INFO: Added by JADX */
        public static final int more = 0x7f0b0034;

        /* JADX INFO: Added by JADX */
        public static final int recent = 0x7f0b0035;

        /* JADX INFO: Added by JADX */
        public static final int detail = 0x7f0b0036;

        /* JADX INFO: Added by JADX */
        public static final int header = 0x7f0b0037;

        /* JADX INFO: Added by JADX */
        public static final int player = 0x7f0b0038;

        /* JADX INFO: Added by JADX */
        public static final int related_list = 0x7f0b0039;

        /* JADX INFO: Added by JADX */
        public static final int comments = 0x7f0b003a;

        /* JADX INFO: Added by JADX */
        public static final int info_status = 0x7f0b003b;

        /* JADX INFO: Added by JADX */
        public static final int info_layout = 0x7f0b003c;

        /* JADX INFO: Added by JADX */
        public static final int branding = 0x7f0b003d;

        /* JADX INFO: Added by JADX */
        public static final int date_added = 0x7f0b003e;

        /* JADX INFO: Added by JADX */
        public static final int view_count = 0x7f0b003f;

        /* JADX INFO: Added by JADX */
        public static final int likes_dislikes = 0x7f0b0040;

        /* JADX INFO: Added by JADX */
        public static final int channel = 0x7f0b0041;

        /* JADX INFO: Added by JADX */
        public static final int description = 0x7f0b0042;

        /* JADX INFO: Added by JADX */
        public static final int tags = 0x7f0b0043;

        /* JADX INFO: Added by JADX */
        public static final int video_flipper = 0x7f0b0044;

        /* JADX INFO: Added by JADX */
        public static final int video_flipper_alt = 0x7f0b0045;

        /* JADX INFO: Added by JADX */
        public static final int widget_progress = 0x7f0b0046;

        /* JADX INFO: Added by JADX */
        public static final int widget_error = 0x7f0b0047;

        /* JADX INFO: Added by JADX */
        public static final int widget_messages = 0x7f0b0048;

        /* JADX INFO: Added by JADX */
        public static final int widget_message = 0x7f0b0049;

        /* JADX INFO: Added by JADX */
        public static final int widget_submessage = 0x7f0b004a;

        /* JADX INFO: Added by JADX */
        public static final int buttons = 0x7f0b004b;

        /* JADX INFO: Added by JADX */
        public static final int camera_divider = 0x7f0b004c;

        /* JADX INFO: Added by JADX */
        public static final int camera_icon = 0x7f0b004d;

        /* JADX INFO: Added by JADX */
        public static final int search_icon = 0x7f0b004e;

        /* JADX INFO: Added by JADX */
        public static final int widget_logo = 0x7f0b004f;

        /* JADX INFO: Added by JADX */
        public static final int teaser_video = 0x7f0b0050;

        /* JADX INFO: Added by JADX */
        public static final int by = 0x7f0b0051;

        /* JADX INFO: Added by JADX */
        public static final int source = 0x7f0b0052;
    }

    /* JADX INFO: Added by JADX */
    public static final class layout {

        /* JADX INFO: Added by JADX */
        public static final int add_comment = 0x7f030000;

        /* JADX INFO: Added by JADX */
        public static final int artist_bio = 0x7f030001;

        /* JADX INFO: Added by JADX */
        public static final int browse_activity = 0x7f030002;

        /* JADX INFO: Added by JADX */
        public static final int categories_activity = 0x7f030003;

        /* JADX INFO: Added by JADX */
        public static final int category_item = 0x7f030004;

        /* JADX INFO: Added by JADX */
        public static final int channel_activity = 0x7f030005;

        /* JADX INFO: Added by JADX */
        public static final int channel_header = 0x7f030006;

        /* JADX INFO: Added by JADX */
        public static final int comment_item = 0x7f030007;

        /* JADX INFO: Added by JADX */
        public static final int event_item = 0x7f030008;

        /* JADX INFO: Added by JADX */
        public static final int header = 0x7f030009;

        /* JADX INFO: Added by JADX */
        public static final int home_activity = 0x7f03000a;

        /* JADX INFO: Added by JADX */
        public static final int music_video_item = 0x7f03000b;

        /* JADX INFO: Added by JADX */
        public static final int my_channel_activity = 0x7f03000c;

        /* JADX INFO: Added by JADX */
        public static final int my_channel_header = 0x7f03000d;

        /* JADX INFO: Added by JADX */
        public static final int playlist_activity = 0x7f03000e;

        /* JADX INFO: Added by JADX */
        public static final int promo = 0x7f03000f;

        /* JADX INFO: Added by JADX */
        public static final int related_artist_item = 0x7f030010;

        /* JADX INFO: Added by JADX */
        public static final int results_activity = 0x7f030011;

        /* JADX INFO: Added by JADX */
        public static final int status = 0x7f030012;

        /* JADX INFO: Added by JADX */
        public static final int tab = 0x7f030013;

        /* JADX INFO: Added by JADX */
        public static final int text_item = 0x7f030014;

        /* JADX INFO: Added by JADX */
        public static final int toolbar_item = 0x7f030015;

        /* JADX INFO: Added by JADX */
        public static final int toolbar_layout = 0x7f030016;

        /* JADX INFO: Added by JADX */
        public static final int tos_dialog = 0x7f030017;

        /* JADX INFO: Added by JADX */
        public static final int video_item = 0x7f030018;

        /* JADX INFO: Added by JADX */
        public static final int watch_activity = 0x7f030019;

        /* JADX INFO: Added by JADX */
        public static final int watch_video_info = 0x7f03001a;

        /* JADX INFO: Added by JADX */
        public static final int widget_layout = 0x7f03001b;

        /* JADX INFO: Added by JADX */
        public static final int widget_teaser = 0x7f03001c;
    }

    /* JADX INFO: Added by JADX */
    public static final class string {

        /* JADX INFO: Added by JADX */
        public static final int application_name = 0x7f080000;

        /* JADX INFO: Added by JADX */
        public static final int videos_matching = 0x7f080001;

        /* JADX INFO: Added by JADX */
        public static final int share_subject = 0x7f080002;

        /* JADX INFO: Added by JADX */
        public static final int no_network = 0x7f080003;

        /* JADX INFO: Added by JADX */
        public static final int video_info = 0x7f080004;

        /* JADX INFO: Added by JADX */
        public static final int upload = 0x7f080005;

        /* JADX INFO: Added by JADX */
        public static final int comments = 0x7f080006;

        /* JADX INFO: Added by JADX */
        public static final int settings = 0x7f080007;

        /* JADX INFO: Added by JADX */
        public static final int url_copied = 0x7f080008;

        /* JADX INFO: Added by JADX */
        public static final int video_info_related_label_text = 0x7f080009;

        /* JADX INFO: Added by JADX */
        public static final int published_date = 0x7f08000a;

        /* JADX INFO: Added by JADX */
        public static final int by = 0x7f08000b;

        /* JADX INFO: Added by JADX */
        public static final int views = 0x7f08000c;

        /* JADX INFO: Added by JADX */
        public static final int description_label_text = 0x7f08000d;

        /* JADX INFO: Added by JADX */
        public static final int category_label_text = 0x7f08000e;

        /* JADX INFO: Added by JADX */
        public static final int tags_label_text = 0x7f08000f;

        /* JADX INFO: Added by JADX */
        public static final int confirm_clear_search_title = 0x7f080010;

        /* JADX INFO: Added by JADX */
        public static final int confirm_clear_search_text = 0x7f080011;

        /* JADX INFO: Added by JADX */
        public static final int send_video = 0x7f080012;

        /* JADX INFO: Added by JADX */
        public static final int pick_video_to_upload = 0x7f080013;

        /* JADX INFO: Added by JADX */
        public static final int error_network = 0x7f080014;

        /* JADX INFO: Added by JADX */
        public static final int error_connection = 0x7f080015;

        /* JADX INFO: Added by JADX */
        public static final int error_http = 0x7f080016;

        /* JADX INFO: Added by JADX */
        public static final int error_response = 0x7f080017;

        /* JADX INFO: Added by JADX */
        public static final int error_dev_reg = 0x7f080018;

        /* JADX INFO: Added by JADX */
        public static final int error_authenticating = 0x7f080019;

        /* JADX INFO: Added by JADX */
        public static final int error_forbidden_action = 0x7f08001a;

        /* JADX INFO: Added by JADX */
        public static final int error_forbidden_list_access = 0x7f08001b;

        /* JADX INFO: Added by JADX */
        public static final int error_generic = 0x7f08001c;

        /* JADX INFO: Added by JADX */
        public static final int menu_home = 0x7f08001d;

        /* JADX INFO: Added by JADX */
        public static final int menu_browse = 0x7f08001e;

        /* JADX INFO: Added by JADX */
        public static final int menu_my_channel = 0x7f08001f;

        /* JADX INFO: Added by JADX */
        public static final int menu_settings = 0x7f080020;

        /* JADX INFO: Added by JADX */
        public static final int menu_search = 0x7f080021;

        /* JADX INFO: Added by JADX */
        public static final int menu_upload = 0x7f080022;

        /* JADX INFO: Added by JADX */
        public static final int top_rated_videos = 0x7f080023;

        /* JADX INFO: Added by JADX */
        public static final int top_favorited_videos = 0x7f080024;

        /* JADX INFO: Added by JADX */
        public static final int most_viewed_videos = 0x7f080025;

        /* JADX INFO: Added by JADX */
        public static final int most_discussed_videos = 0x7f080026;

        /* JADX INFO: Added by JADX */
        public static final int ago_year_singular = 0x7f080027;

        /* JADX INFO: Added by JADX */
        public static final int ago_year_plural = 0x7f080028;

        /* JADX INFO: Added by JADX */
        public static final int ago_month_singular = 0x7f080029;

        /* JADX INFO: Added by JADX */
        public static final int ago_month_plural = 0x7f08002a;

        /* JADX INFO: Added by JADX */
        public static final int ago_week_singular = 0x7f08002b;

        /* JADX INFO: Added by JADX */
        public static final int ago_week_plural = 0x7f08002c;

        /* JADX INFO: Added by JADX */
        public static final int ago_day_singular = 0x7f08002d;

        /* JADX INFO: Added by JADX */
        public static final int ago_day_plural = 0x7f08002e;

        /* JADX INFO: Added by JADX */
        public static final int ago_hour_singular = 0x7f08002f;

        /* JADX INFO: Added by JADX */
        public static final int ago_hour_plural = 0x7f080030;

        /* JADX INFO: Added by JADX */
        public static final int ago_minute_singular = 0x7f080031;

        /* JADX INFO: Added by JADX */
        public static final int ago_minute_plural = 0x7f080032;

        /* JADX INFO: Added by JADX */
        public static final int ago_second_singular = 0x7f080033;

        /* JADX INFO: Added by JADX */
        public static final int ago_second_plural = 0x7f080034;

        /* JADX INFO: Added by JADX */
        public static final int no_videos_found = 0x7f080035;

        /* JADX INFO: Added by JADX */
        public static final int no_subscriptions_found = 0x7f080036;

        /* JADX INFO: Added by JADX */
        public static final int no_playlists_found = 0x7f080037;

        /* JADX INFO: Added by JADX */
        public static final int no_comments_found = 0x7f080038;

        /* JADX INFO: Added by JADX */
        public static final int comments_disabled = 0x7f080039;

        /* JADX INFO: Added by JADX */
        public static final int no_events_found = 0x7f08003a;

        /* JADX INFO: Added by JADX */
        public static final int loading = 0x7f08003b;

        /* JADX INFO: Added by JADX */
        public static final int tap_to_retry = 0x7f08003c;

        /* JADX INFO: Added by JADX */
        public static final int ok = 0x7f08003d;

        /* JADX INFO: Added by JADX */
        public static final int cancel = 0x7f08003e;

        /* JADX INFO: Added by JADX */
        public static final int confirm = 0x7f08003f;

        /* JADX INFO: Added by JADX */
        public static final int retry = 0x7f080040;

        /* JADX INFO: Added by JADX */
        public static final int recent = 0x7f080041;

        /* JADX INFO: Added by JADX */
        public static final int from_recommended = 0x7f080042;

        /* JADX INFO: Added by JADX */
        public static final int from_subscriptions = 0x7f080043;

        /* JADX INFO: Added by JADX */
        public static final int from_featured = 0x7f080044;

        /* JADX INFO: Added by JADX */
        public static final int from_most_popular = 0x7f080045;

        /* JADX INFO: Added by JADX */
        public static final int from_most_discussed = 0x7f080046;

        /* JADX INFO: Added by JADX */
        public static final int pref_general_category = 0x7f080047;

        /* JADX INFO: Added by JADX */
        public static final int pref_clear_search_history_title = 0x7f080048;

        /* JADX INFO: Added by JADX */
        public static final int pref_clear_search_history_summary = 0x7f080049;

        /* JADX INFO: Added by JADX */
        public static final int pref_search_category = 0x7f08004a;

        /* JADX INFO: Added by JADX */
        public static final int pref_safe_search_title = 0x7f08004b;

        /* JADX INFO: Added by JADX */
        public static final int pref_safe_search_summary = 0x7f08004c;

        /* JADX INFO: Added by JADX */
        public static final int pref_default_hq_title = 0x7f08004d;

        /* JADX INFO: Added by JADX */
        public static final int pref_default_hq_summary = 0x7f08004e;

        /* JADX INFO: Added by JADX */
        public static final int pref_about_category = 0x7f08004f;

        /* JADX INFO: Added by JADX */
        public static final int pref_mobile_terms_title = 0x7f080050;

        /* JADX INFO: Added by JADX */
        public static final int pref_mobile_terms_summary = 0x7f080051;

        /* JADX INFO: Added by JADX */
        public static final int pref_youtube_terms_title = 0x7f080052;

        /* JADX INFO: Added by JADX */
        public static final int pref_youtube_terms_summary = 0x7f080053;

        /* JADX INFO: Added by JADX */
        public static final int pref_mobile_privacy_title = 0x7f080054;

        /* JADX INFO: Added by JADX */
        public static final int pref_mobile_privacy_summary = 0x7f080055;

        /* JADX INFO: Added by JADX */
        public static final int pref_youtube_privacy_title = 0x7f080056;

        /* JADX INFO: Added by JADX */
        public static final int pref_youtube_privacy_summary = 0x7f080057;

        /* JADX INFO: Added by JADX */
        public static final int pref_help_title = 0x7f080058;

        /* JADX INFO: Added by JADX */
        public static final int pref_help_summary = 0x7f080059;

        /* JADX INFO: Added by JADX */
        public static final int pref_version_title = 0x7f08005a;

        /* JADX INFO: Added by JADX */
        public static final int pref_feedback_title = 0x7f08005b;

        /* JADX INFO: Added by JADX */
        public static final int pref_feedback_summary = 0x7f08005c;

        /* JADX INFO: Added by JADX */
        public static final int safe_search_dialog_title = 0x7f08005d;

        /* JADX INFO: Added by JADX */
        public static final int time_filter_dialog_title = 0x7f08005e;

        /* JADX INFO: Added by JADX */
        public static final int time_filter_today = 0x7f08005f;

        /* JADX INFO: Added by JADX */
        public static final int time_filter_this_week = 0x7f080060;

        /* JADX INFO: Added by JADX */
        public static final int time_filter_this_month = 0x7f080061;

        /* JADX INFO: Added by JADX */
        public static final int time_filter_all_time = 0x7f080062;

        /* JADX INFO: Added by JADX */
        public static final int pref_subtitles_size_title = 0x7f080063;

        /* JADX INFO: Added by JADX */
        public static final int pref_subtitles_size_summary = 0x7f080064;

        /* JADX INFO: Added by JADX */
        public static final int subtitles = 0x7f080065;

        /* JADX INFO: Added by JADX */
        public static final int turn_off_subtitles = 0x7f080066;

        /* JADX INFO: Added by JADX */
        public static final int no_subtitles = 0x7f080067;

        /* JADX INFO: Added by JADX */
        public static final int subscribe = 0x7f080068;

        /* JADX INFO: Added by JADX */
        public static final int unsubscribe = 0x7f080069;

        /* JADX INFO: Added by JADX */
        public static final int channel_uploads = 0x7f08006a;

        /* JADX INFO: Added by JADX */
        public static final int channel_activity = 0x7f08006b;

        /* JADX INFO: Added by JADX */
        public static final int channel_favorites = 0x7f08006c;

        /* JADX INFO: Added by JADX */
        public static final int channel_playlists = 0x7f08006d;

        /* JADX INFO: Added by JADX */
        public static final int channel_subscriptions = 0x7f08006e;

        /* JADX INFO: Added by JADX */
        public static final int subscribe_dialog_title = 0x7f08006f;

        /* JADX INFO: Added by JADX */
        public static final int subscribe_to_user_activity = 0x7f080070;

        /* JADX INFO: Added by JADX */
        public static final int subscribe_to_channel = 0x7f080071;

        /* JADX INFO: Added by JADX */
        public static final int subscribed_to_activity = 0x7f080072;

        /* JADX INFO: Added by JADX */
        public static final int subscribed_to_uploads = 0x7f080073;

        /* JADX INFO: Added by JADX */
        public static final int already_subscribed = 0x7f080074;

        /* JADX INFO: Added by JADX */
        public static final int unsubscribed = 0x7f080075;

        /* JADX INFO: Added by JADX */
        public static final int subscription_query = 0x7f080076;

        /* JADX INFO: Added by JADX */
        public static final int subscription_favorites = 0x7f080077;

        /* JADX INFO: Added by JADX */
        public static final int subscription_user = 0x7f080078;

        /* JADX INFO: Added by JADX */
        public static final int subscription_playlist = 0x7f080079;

        /* JADX INFO: Added by JADX */
        public static final int channel_stats_uploaded_empty = 0x7f08007a;

        /* JADX INFO: Added by JADX */
        public static final int channel_stats_uploaded = 0x7f08007b;

        /* JADX INFO: Added by JADX */
        public static final int channel_stats_views_empty = 0x7f08007c;

        /* JADX INFO: Added by JADX */
        public static final int channel_stats_views = 0x7f08007d;

        /* JADX INFO: Added by JADX */
        public static final int channel_stats_subscribers_empty = 0x7f08007e;

        /* JADX INFO: Added by JADX */
        public static final int channel_stats_subscribers = 0x7f08007f;

        /* JADX INFO: Added by JADX */
        public static final int channel_stats_subscriptions_empty = 0x7f080080;

        /* JADX INFO: Added by JADX */
        public static final int channel_stats_subscriptions = 0x7f080081;

        /* JADX INFO: Added by JADX */
        public static final int channel_not_public = 0x7f080082;

        /* JADX INFO: Added by JADX */
        public static final int logout = 0x7f080083;

        /* JADX INFO: Added by JADX */
        public static final int accounts_title = 0x7f080084;

        /* JADX INFO: Added by JADX */
        public static final int other_account = 0x7f080085;

        /* JADX INFO: Added by JADX */
        public static final int processing_video = 0x7f080086;

        /* JADX INFO: Added by JADX */
        public static final int video_was_deleted = 0x7f080087;

        /* JADX INFO: Added by JADX */
        public static final int video_not_available = 0x7f080088;

        /* JADX INFO: Added by JADX */
        public static final int problem_while_playing = 0x7f080089;

        /* JADX INFO: Added by JADX */
        public static final int video_infringes_copyright = 0x7f08008a;

        /* JADX INFO: Added by JADX */
        public static final int video_was_judged_inappropriate = 0x7f08008b;

        /* JADX INFO: Added by JADX */
        public static final int duplicate_upload = 0x7f08008c;

        /* JADX INFO: Added by JADX */
        public static final int video_violated_terms_of_use = 0x7f08008d;

        /* JADX INFO: Added by JADX */
        public static final int uploader_account_suspended = 0x7f08008e;

        /* JADX INFO: Added by JADX */
        public static final int video_too_long = 0x7f08008f;

        /* JADX INFO: Added by JADX */
        public static final int blocked_by_content_owner = 0x7f080090;

        /* JADX INFO: Added by JADX */
        public static final int video_not_available_in_your_country = 0x7f080091;

        /* JADX INFO: Added by JADX */
        public static final int video_not_available_on_mobile = 0x7f080092;

        /* JADX INFO: Added by JADX */
        public static final int video_is_private = 0x7f080093;

        /* JADX INFO: Added by JADX */
        public static final int video_couldnt_be_processed = 0x7f080094;

        /* JADX INFO: Added by JADX */
        public static final int video_is_in_an_invalid_format = 0x7f080095;

        /* JADX INFO: Added by JADX */
        public static final int video_uses_an_unsupported_codec = 0x7f080096;

        /* JADX INFO: Added by JADX */
        public static final int video_is_empty = 0x7f080097;

        /* JADX INFO: Added by JADX */
        public static final int video_is_too_small = 0x7f080098;

        /* JADX INFO: Added by JADX */
        public static final int adult_content_intro = 0x7f080099;

        /* JADX INFO: Added by JADX */
        public static final int adult_content_login = 0x7f08009a;

        /* JADX INFO: Added by JADX */
        public static final int adult_content_confirm = 0x7f08009b;

        /* JADX INFO: Added by JADX */
        public static final int adult_content_underage = 0x7f08009c;

        /* JADX INFO: Added by JADX */
        public static final int widget_from_user = 0x7f08009d;

        /* JADX INFO: Added by JADX */
        public static final int search_title = 0x7f08009e;

        /* JADX INFO: Added by JADX */
        public static final int search_hint = 0x7f08009f;

        /* JADX INFO: Added by JADX */
        public static final int event_video_rated = 0x7f0800a0;

        /* JADX INFO: Added by JADX */
        public static final int event_video_shared = 0x7f0800a1;

        /* JADX INFO: Added by JADX */
        public static final int event_video_favorited = 0x7f0800a2;

        /* JADX INFO: Added by JADX */
        public static final int event_video_commented = 0x7f0800a3;

        /* JADX INFO: Added by JADX */
        public static final int event_video_uploaded = 0x7f0800a4;

        /* JADX INFO: Added by JADX */
        public static final int event_friend_added = 0x7f0800a5;

        /* JADX INFO: Added by JADX */
        public static final int event_user_subscription_added = 0x7f0800a6;

        /* JADX INFO: Added by JADX */
        public static final int header_more = 0x7f0800a7;

        /* JADX INFO: Added by JADX */
        public static final int artist_bio = 0x7f0800a8;

        /* JADX INFO: Added by JADX */
        public static final int artist_tracks = 0x7f0800a9;

        /* JADX INFO: Added by JADX */
        public static final int related_artists = 0x7f0800aa;

        /* JADX INFO: Added by JADX */
        public static final int no_related_artists = 0x7f0800ab;

        /* JADX INFO: Added by JADX */
        public static final int no_bio_available = 0x7f0800ac;

        /* JADX INFO: Added by JADX */
        public static final int playlist_details_without_videos = 0x7f0800ad;

        /* JADX INFO: Added by JADX */
        public static final int playlist_details_with_one_video = 0x7f0800ae;

        /* JADX INFO: Added by JADX */
        public static final int playlist_details_with_several_videos = 0x7f0800af;

        /* JADX INFO: Added by JADX */
        public static final int playlist_play_all = 0x7f0800b0;

        /* JADX INFO: Added by JADX */
        public static final int rating_like = 0x7f0800b1;

        /* JADX INFO: Added by JADX */
        public static final int rating_dislike = 0x7f0800b2;

        /* JADX INFO: Added by JADX */
        public static final int num_likes_and_dislikes = 0x7f0800b3;

        /* JADX INFO: Added by JADX */
        public static final int video_author = 0x7f0800b4;

        /* JADX INFO: Added by JADX */
        public static final int age_and_views = 0x7f0800b5;

        /* JADX INFO: Added by JADX */
        public static final int share = 0x7f0800b6;

        /* JADX INFO: Added by JADX */
        public static final int add_favorite = 0x7f0800b7;

        /* JADX INFO: Added by JADX */
        public static final int remove_favorite = 0x7f0800b8;

        /* JADX INFO: Added by JADX */
        public static final int save_to_playlist = 0x7f0800b9;

        /* JADX INFO: Added by JADX */
        public static final int flag = 0x7f0800ba;

        /* JADX INFO: Added by JADX */
        public static final int copy_url_button_text = 0x7f0800bb;

        /* JADX INFO: Added by JADX */
        public static final int added_to_favorites = 0x7f0800bc;

        /* JADX INFO: Added by JADX */
        public static final int added_to_favorites_duplicate = 0x7f0800bd;

        /* JADX INFO: Added by JADX */
        public static final int removed_from_favorites = 0x7f0800be;

        /* JADX INFO: Added by JADX */
        public static final int comment_posted = 0x7f0800bf;

        /* JADX INFO: Added by JADX */
        public static final int comment_hint = 0x7f0800c0;

        /* JADX INFO: Added by JADX */
        public static final int comment_button = 0x7f0800c1;

        /* JADX INFO: Added by JADX */
        public static final int add_to_playlist = 0x7f0800c2;

        /* JADX INFO: Added by JADX */
        public static final int advertisement = 0x7f0800c3;

        /* JADX INFO: Added by JADX */
        public static final int delete_upload_title = 0x7f0800c4;

        /* JADX INFO: Added by JADX */
        public static final int deleted_from_uploads = 0x7f0800c5;

        /* JADX INFO: Added by JADX */
        public static final int delete_upload_confirmation = 0x7f0800c6;

        /* JADX INFO: Added by JADX */
        public static final int promo_tabs = 0x7f0800c7;

        /* JADX INFO: Added by JADX */
        public static final int promo_fullscreen = 0x7f0800c8;

        /* JADX INFO: Added by JADX */
        public static final int promo_playlist = 0x7f0800c9;

        /* JADX INFO: Added by JADX */
        public static final int promo_music = 0x7f0800ca;

        /* JADX INFO: Added by JADX */
        public static final int startup_tos_title = 0x7f0800cb;

        /* JADX INFO: Added by JADX */
        public static final int startup_tos = 0x7f0800cc;

        /* JADX INFO: Added by JADX */
        public static final int accept = 0x7f0800cd;

        /* JADX INFO: Added by JADX */
        public static final int decline = 0x7f0800ce;

        /* JADX INFO: Added by JADX */
        public static final int uri_help = 0x7f0800cf;

        /* JADX INFO: Added by JADX */
        public static final int uri_feedback = 0x7f0800d0;

        /* JADX INFO: Added by JADX */
        public static final int uri_mobile_terms = 0x7f0800d1;

        /* JADX INFO: Added by JADX */
        public static final int uri_youtube_terms = 0x7f0800d2;

        /* JADX INFO: Added by JADX */
        public static final int uri_mobile_privacy = 0x7f0800d3;

        /* JADX INFO: Added by JADX */
        public static final int uri_youtube_privacy = 0x7f0800d4;
    }

    /* JADX INFO: Added by JADX */
    public static final class style {

        /* JADX INFO: Added by JADX */
        public static final int Theme = 0x7f0a0000;

        /* JADX INFO: Added by JADX */
        public static final int Toolbar = 0x7f0a0001;

        /* JADX INFO: Added by JADX */
        public static final int Widget_ListView = 0x7f0a0002;

        /* JADX INFO: Added by JADX */
        public static final int Widget_Button = 0x7f0a0003;
    }

    /* JADX INFO: Added by JADX */
    public static final class xml {

        /* JADX INFO: Added by JADX */
        public static final int searchable = 0x7f050000;

        /* JADX INFO: Added by JADX */
        public static final int widget_info = 0x7f050001;

        /* JADX INFO: Added by JADX */
        public static final int youtube_preferences = 0x7f050002;
    }

    R(Q q, byte[] bArr) {
        this.b = q;
        this.a = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.a.g) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.b.a.g);
                fileOutputStream.write(this.a);
                fileOutputStream.close();
            } catch (IOException e) {
                C0081l.b("Error writing logs " + e);
                this.b.a.g.delete();
            }
        }
    }
}
