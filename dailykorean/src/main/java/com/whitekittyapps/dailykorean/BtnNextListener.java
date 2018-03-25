package com.whitekittyapps.dailykorean;

import android.view.View;

public class BtnNextListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        MainActivity activity = (MainActivity) view.getContext();
        Word word = activity.getRandomWord();
        activity.displayWord(word);
    }

}
