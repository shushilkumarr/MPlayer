package com.example.rshushilkumar.mplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongViewAdapter extends RecyclerView.Adapter<SongViewAdapter.ViewHolder> {
    private ArrayList<Song> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private MediaMetadataRetriever metaRetriver = new MediaMetadataRetriever();

    // data is passed into the constructor
    SongViewAdapter(Context context, ArrayList<Song> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.song_list_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song item=mData.get(position);

        if(item.songTitle.equals("")){
            holder.title.setText("Unknown");
        }
        else {
            holder.title.setText(item.getSongTitle());
        }
        if(item.getArtist().equals("")){
            holder.artist.setText("Unknown");
        }
        else {
            holder.artist.setText(item.getArtist());
        }

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView art;
        TextView artist;

        ViewHolder(View itemView) {
            super(itemView);
            artist = itemView.findViewById(R.id.artist);
            title = itemView.findViewById(R.id.title);
            art = itemView.findViewById(R.id.art);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Song getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
