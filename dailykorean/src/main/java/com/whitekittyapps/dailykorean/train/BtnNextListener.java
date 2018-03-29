package com.whitekittyapps.dailykorean.train;

import android.util.Log;
import android.view.View;

import com.whitekittyapps.dailykorean.entities.Word;
import com.whitekittyapps.dailykorean.presenter.WordPresenter;
import com.whitekittyapps.dailykorean.services.WordService;

public class BtnNextListener implements View.OnClickListener {

    private WordService ws;
    private View v;

    public BtnNextListener(View view, WordService wordService)
    {
        Log.i("MSG", "btnNext listerner created");
        ws = wordService;
        v = view;
    }

    @Override
    public void onClick(View view) {
        Log.i("MSG", "btnNext clicked");
        Log.i("MSG", Integer.toString(view.getId()));
        Word word = ws.getRandomWord();
        (new WordPresenter(v, word)).display();
    }

}
