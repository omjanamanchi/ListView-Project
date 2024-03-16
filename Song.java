package com.example.program;

import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.Serializable;

public class Song implements Serializable
{
    String songName;
    String artist;
    Integer album;
    Integer songFile;

    public Song (String songName, String artist, Integer album, Integer songFile)
    {

        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.songFile = songFile;

    }



    public String getSongName() {
        return songName;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getAlbum() { return album; }

    public Integer getSongFile() { return songFile; }
}
