package com.example.mygenius;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mygenius.Services.LyricsService;

import java.util.ArrayList;

public class LyricsAdapter extends BaseAdapter {
    private ArrayList<Lyrics> lyrics;
    private Context context;

    public LyricsAdapter(Context context, ArrayList<Lyrics> lyrics) {
        this.lyrics = lyrics;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lyrics.size();
    }

    @Override
    public Object getItem(int i) {
        return lyrics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lyrics.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_lyrics, viewGroup, false);
        }
        TextView artist = view.findViewById(R.id.textViewItemName);
        artist.setText(lyrics.get(i).getName());
        TextView title = view.findViewById(R.id.textViewItemTitle);
        title.setText(lyrics.get(i).getTitle());

        //ImageView imageView= view.findViewById(R.id.imageViewItemMusic);
        //LyricsService.loadImage(context, musics.get(i).getImage(), imageView);

        //ImageView imageViewFav = view.findViewById(R.id.imageViewItemFavoris);
        //if(FavoriteRepository.getInstance(context).isFavorite(musics.get(i))){
        //    imageViewFav.setImageResource(android.R.drawable.btn_star_big_on);
        //} else {
        //    imageViewFav.setImageResource(android.R.drawable.btn_star_big_off);
        //}
        return view;
    }
}
