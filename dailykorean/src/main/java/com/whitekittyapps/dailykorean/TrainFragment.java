package com.whitekittyapps.dailykorean;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.whitekittyapps.dailykorean.entities.Word;
import com.whitekittyapps.dailykorean.presenter.WordPresenter;
import com.whitekittyapps.dailykorean.services.WordService;
import com.whitekittyapps.dailykorean.train.BtnNextListener;
import com.whitekittyapps.dailykorean.train.BtnPlaySoundListener;

public class TrainFragment extends Fragment {

    public TrainFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        WordService wordService = WordService.get();

        View v = inflater.inflate(R.layout.fragment_train, container, false);
        Button btnNext = (Button) v.findViewById(R.id.btnKnownWord);
        ImageButton btnPlaySound = (ImageButton) v.findViewById(R.id.btnPlaySound);

        btnNext.setOnClickListener(new BtnNextListener(v, wordService));
        btnPlaySound.setOnClickListener(new BtnPlaySoundListener(v, wordService));

        Word word = wordService.getRandomWord();
        (new WordPresenter(v, word)).display();

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
        void onFragmentInteraction(Uri uri);
    }

}
