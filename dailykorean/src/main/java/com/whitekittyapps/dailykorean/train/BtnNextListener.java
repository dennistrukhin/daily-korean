package com.whitekittyapps.dailykorean.train;

import android.view.View;

import com.whitekittyapps.dailykorean.entities.Word;
import com.whitekittyapps.dailykorean.presenter.WordPresenter;
import com.whitekittyapps.dailykorean.services.WordService;

public class BtnNextListener implements View.OnClickListener {

    private WordService ws;
    private View v;

    public BtnNextListener(View view, WordService wordService)
    {
        ws = wordService;
        v = view;
    }

    @Override
    public void onClick(View view) {
        Word word = ws.getRandomWord();
        (new WordPresenter(v, word)).display();
    }

}
