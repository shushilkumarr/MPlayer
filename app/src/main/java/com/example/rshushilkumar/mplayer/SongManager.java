package com.example.rshushilkumar.mplayer;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SongManager {
    final String MEDIA_PATH = Environment.getExternalStorageDirectory() + "";
    Cursor cursor;
    private ArrayList<Song> songs = new ArrayList<>();

    public SongManager() {

    }

    public ArrayList<Song> findFiles(Context app) {
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.ALBUM
        };
        cursor = app.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null);
        while (cursor.moveToNext()) {
            songs.add(new Song(Integer.parseInt(cursor.getString(0)),cursor.getString(1) ,cursor.getString(2) , cursor.getString(3) ,cursor.getString(4) ,Integer.parseInt( cursor.getString(5)),cursor.getString(6)));
        }
        Log.d("file", String.valueOf(songs));
        return songs;
    }

}

