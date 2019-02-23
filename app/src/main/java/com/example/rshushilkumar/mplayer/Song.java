package com.example.rshushilkumar.mplayer;

import java.util.ArrayList;
import java.util.List;

public class Song {
    int songId;
    String artist;
    String songTitle;
    String path;
    String dispName;
    int duration;
    String album;
    public Song(int songId,String artist, String songTitle,String path,String dispName,int duration,String album){
        this.songId=songId;
        this.artist=artist;
        this.songTitle=songTitle;
        this.path=path;
        this.dispName=dispName;
        this.duration=duration;
        this.album=album;
    }

    public int getDuration() {
        return duration;
    }

    public int getSongId() {
        return songId;
    }

    public String getArtist() {
        return artist;
    }

    public String getDispName() {
        return dispName;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getPath() {
        return path;
    }

    public String getAlbum() {
        return album;
    }
}
