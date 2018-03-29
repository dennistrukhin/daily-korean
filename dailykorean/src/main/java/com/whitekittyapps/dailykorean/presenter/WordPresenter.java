package com.whitekittyapps.dailykorean.presenter;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.whitekittyapps.dailykorean.R;
import com.whitekittyapps.dailykorean.entities.Word;

public class WordPresenter {

    private Word w;
    private View v;

    public WordPresenter(View view, Word word)
    {
        w = word;
        v = view;
    }

    public void display()
    {
        Log.i("MSG", w.toString());
        ((TextView)v.findViewById(R.id.txtWord)).setText(w.getWord());
        ((TextView)v.findViewById(R.id.txtPronunciation)).setText(w.getPronunciation());
        ((TextView)v.findViewById(R.id.txtDefinitions)).setText(w.getDefinitions());
        if (w.isVoiced()) {
            ((ImageButton)v.findViewById(R.id.btnPlaySound)).setVisibility(View.VISIBLE);
        } else {
            ((ImageButton)v.findViewById(R.id.btnPlaySound)).setVisibility(View.INVISIBLE);
        }
    }

}
