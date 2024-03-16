package com.example.program;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivityLand extends AppCompatActivity {

    private static final String KEY = "key";
    private static final String buttonKEY = "buttonKEY";
    private static final String listKEY = "listKEY";
    private static final String AdptKey = "AdptKey";

    ListView arrlistView;
    ArrayList<Song> songs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrlistView = (ListView) findViewById(R.id.list_id);
             songs = new ArrayList<>();



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


    /*public ArrayList<File> findSong(File file) //to find a song to be played later once chosen
    {
        ArrayList<File> list = new ArrayList<>();

        File [] files = file.listFiles();

        for(File singlefile : files)
        {
            if(singlefile.isDirectory() && !singlefile.isHidden())
            {
                list.addAll(findSong(singlefile));
            }
            else
            {
                if(singlefile.getName().endsWith(".mp3") || singlefile.getName().endsWith(".wav"))
                {
                    list.add(singlefile);
                }
            }
        }
        return list;
    }

    void DisplaySongs()
    {
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());

        items = new String [mySongs.size()];
        for(int i = 0; i < mySongs.size(); i++)
        {
            items[i] = mySongs.get(i).getName().toString().replace(".mp3", "").replace(".wav", "");

        }

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(myAdapter);
    }*/

}









