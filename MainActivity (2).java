package com.example.program;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String KEY = "key";

    ListView arrlistView;
    ImageView musicNote;
    ArrayList<Song> songs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrlistView = (ListView) findViewById(R.id.list_id);
        musicNote = findViewById(R.id.imageView);
        songs = new ArrayList<>();
        musicNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RotateAnimation spin = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                spin.setDuration(1000);
                musicNote.startAnimation(spin);
            }
        });



        if(savedInstanceState != null)
        {
            songs =  (ArrayList<Song>) savedInstanceState.getSerializable(KEY) ;
        }
        else
        {
            songs.add(new Song("Aasan Nahin", "A.Singh", R.drawable.album5, R.raw.s1));
            songs.add(new Song("Aashiqui", "A.Singh", R.drawable.album5, R.raw.s2));
            songs.add(new Song("Bhula Dena", "M.Zahid", R.drawable.album5, R.raw.s3));
            songs.add(new Song("Chahun Main Ya Naa", "A.Singh", R.drawable.album5, R.raw.s4));
            songs.add(new Song("Hum Mar Jayenge", "A.Singh", R.drawable.album5, R.raw.s5));
            songs.add(new Song("Meri Aashiqui", "A.Singh", R.drawable.album5, R.raw.s6));
            songs.add(new Song("Milne Hai Mujhse", "A.Singh", R.drawable.album5, R.raw.s7));
            songs.add(new Song("Piya Aaye Na", "KK", R.drawable.album5, R.raw.s8));
            songs.add(new Song("Sunn Raha Hai", "A.Tiwari", R.drawable.album5, R.raw.s9));
            songs.add(new Song("Tum Hi Ho", "A.Singh", R.drawable.album5, R.raw.s11));
            
        }

        CustomAdapter adapter = new CustomAdapter(this, R.layout.list_design, songs);
        arrlistView.setAdapter(adapter);

        arrlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, songs);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        songs = (ArrayList<Song>) savedInstanceState.getSerializable(KEY);
    }

}









