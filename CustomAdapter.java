package com.example.program;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Song> implements Serializable
{
    List list;
    Context context;
    int xmlResource;
    MediaPlayer player = null;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull  List<Song> objects)
    {
        super(context, resource, objects);
        xmlResource = resource;
        list = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View adapterLayout = layoutInflater.inflate(xmlResource, null);

        TextView songNumber = adapterLayout.findViewById(R.id.songNumber);
        ImageView album = adapterLayout.findViewById(R.id.album);
        TextView songName = adapterLayout.findViewById(R.id.songName);
        TextView artist = adapterLayout.findViewById(R.id.artist);
        Button removeButton = adapterLayout.findViewById(R.id.removeButton);
        Button playButton = adapterLayout.findViewById(R.id.playButton);
        RatingBar ratingBar = adapterLayout.findViewById(R.id.ratingBar);

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                player.stop();
                notifyDataSetChanged();
            }
        });

        for (int x = 0; x < list.size(); x++)
        {
            String num = "" + Integer.toString(position + 1);
            songNumber.setText(num);
            album.setImageResource(((Song) list.get(position)).getAlbum());
            songName.setText(((Song) list.get(position)).getSongName());
            artist.setText(((Song) list.get(position)).getArtist());

            playButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if( player != null && player.isPlaying())
                        player.stop();

                    Song mySong = ((Song) list.get(position));

                    if (mySong.getSongFile()== R.raw.s1)
                        player = MediaPlayer.create(getContext(), R.raw.s1);
                    else if (mySong.getSongFile()== R.raw.s2)
                        player = MediaPlayer.create(getContext(), R.raw.s2);
                    else if (mySong.getSongFile()== R.raw.s3)
                        player = MediaPlayer.create(getContext(), R.raw.s3);
                    else if (mySong.getSongFile()== R.raw.s4)
                        player = MediaPlayer.create(getContext(), R.raw.s4);
                    else if (mySong.getSongFile()== R.raw.s5)
                        player = MediaPlayer.create(getContext(), R.raw.s5);
                    else if (mySong.getSongFile()== R.raw.s6)
                        player = MediaPlayer.create(getContext(), R.raw.s6);
                    else if (mySong.getSongFile()== R.raw.s7)
                        player = MediaPlayer.create(getContext(), R.raw.s7);
                    else if (mySong.getSongFile()== R.raw.s8)
                        player = MediaPlayer.create(getContext(), R.raw.s8);
                    else if (mySong.getSongFile()== R.raw.s9)
                        player = MediaPlayer.create(getContext(), R.raw.s9);
                    else if (mySong.getSongFile()== R.raw.s11)
                        player = MediaPlayer.create(getContext(), R.raw.s11);

                    player.start();

                }
            });
        }

        return adapterLayout;
    }

}
