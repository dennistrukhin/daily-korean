package com.whitekittyapps.dailykorean.train;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;

import com.whitekittyapps.dailykorean.R;
import com.whitekittyapps.dailykorean.services.WordService;

public class BtnPlaySoundListener implements View.OnClickListener {

    private WordService ws;
    private View v;

    public BtnPlaySoundListener(View view, WordService wordService)
    {
        ws = wordService;
        v = view;
    }

    @Override
    public void onClick(View view) {
        int wordId = ws.getCurrentWordId();
        try {
            int resourceId = R.raw.class.getField("sound" + wordId).getInt(null);
            MediaPlayer mp = MediaPlayer.create(v.getContext(), resourceId);
            mp.start();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.e("error", e.toString());
        }

    }
}
