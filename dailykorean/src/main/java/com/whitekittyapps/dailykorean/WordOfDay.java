package com.whitekittyapps.dailykorean;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.whitekittyapps.dailykorean.entities.User;
import com.whitekittyapps.dailykorean.entities.Word;
import com.whitekittyapps.dailykorean.presenter.WordPresenter;
import com.whitekittyapps.dailykorean.services.WordService;


public class WordOfDay extends Fragment {

    public WordOfDay() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_word_of_day, container, false);
        WordService wordService = WordService.get();
        Word word = wordService.getByIndex(0);
        (new WordPresenter(v, word)).display();
        User user = DailyKoreanApp.get().getUser();
        Toast.makeText(
                getContext(),
                Long.toString(user.getDtStart().getTime()) + " " + Long.toString(user.getDtLastVisit().getTime()),
                Toast.LENGTH_LONG).show();
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof OnFragmentInteractionListener)) {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argumen t type and name
        void onFragmentInteraction(Uri uri);
    }
}
