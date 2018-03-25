package com.whitekittyapps.dailykorean;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;

public class BtnPlaySoundListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        MainActivity activity = (MainActivity) view.getContext();
        int wordId = activity.getCurrentWordId();
        try {
            int resourceId = R.raw.class.getField("sound" + wordId).getInt(null);
            MediaPlayer mp = MediaPlayer.create(activity, resourceId);
            mp.start();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.e("error", e.toString());
        }

    }
}
