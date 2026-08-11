package com.google.android.youtube.modern;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.youtube.R;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/** Renders current API results using the original 2011 video_item layout. */
public final class ModernVideoAdapter extends BaseAdapter {
    public interface Listener { void onVideoClick(ModernYouTubeVideo video); }
    private final Context context;
    private final LayoutInflater inflater;
    private final Listener listener;
    private final List<ModernYouTubeVideo> videos = new ArrayList<ModernYouTubeVideo>();

    public ModernVideoAdapter(Context context, Listener listener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }
    public void setVideos(List<ModernYouTubeVideo> values) { videos.clear(); if (values != null) videos.addAll(values); notifyDataSetChanged(); }
    public int getCount() { return videos.size(); }
    public Object getItem(int position) { return videos.get(position); }
    public long getItemId(int position) { return position; }
    public View getView(final int position, View convert, ViewGroup parent) {
        Holder h;
        if (convert == null) { convert = inflater.inflate(R.layout.video_item, parent, false); h = new Holder(convert); convert.setTag(h); }
        else h = (Holder) convert.getTag();
        final ModernYouTubeVideo v = videos.get(position);
        h.title.setText(v.title);
        h.author.setText(v.channelTitle);
        h.detail.setText(v.publishedAt == null ? "" : v.publishedAt.length() >= 10 ? v.publishedAt.substring(0, 10) : v.publishedAt);
        h.duration.setVisibility(View.GONE);
        h.thumbnail.setImageResource(R.drawable.ic_youtube_thumbnail_unavailable);
        if (v.thumbnailUrl != null) new ThumbTask(h.thumbnail, v.thumbnailUrl).execute();
        convert.setOnClickListener(new View.OnClickListener() { public void onClick(View view) { listener.onVideoClick(v); } });
        return convert;
    }
    private static final class Holder {
        final TextView title, author, detail, duration;
        final ImageView thumbnail;
        Holder(View v) { title=(TextView)v.findViewById(R.id.title); author=(TextView)v.findViewById(R.id.author); detail=(TextView)v.findViewById(R.id.detail); duration=(TextView)v.findViewById(R.id.duration); thumbnail=(ImageView)v.findViewById(R.id.thumbnail); }
    }
    private static final class ThumbTask extends AsyncTask<Void,Void,Bitmap> {
        final ImageView view; final String url;
        ThumbTask(ImageView v,String u){view=v;url=u;}
        protected Bitmap doInBackground(Void... x){ try { HttpURLConnection c=(HttpURLConnection)new URL(url).openConnection(); c.setConnectTimeout(10000); c.setReadTimeout(15000); InputStream in=c.getInputStream(); Bitmap b=BitmapFactory.decodeStream(in); in.close(); c.disconnect(); return b; } catch(Exception e){ return null; } }
        protected void onPostExecute(Bitmap b){ if(b!=null) view.setImageBitmap(b); }
    }
}
