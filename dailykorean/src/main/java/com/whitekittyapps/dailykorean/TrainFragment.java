package com.whitekittyapps.dailykorean;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.whitekittyapps.dailykorean.databinding.FragmentTrainBinding;
import com.whitekittyapps.dailykorean.services.WordService;
import com.whitekittyapps.dailykorean.train.BtnNextListener;
import com.whitekittyapps.dailykorean.train.BtnPlaySoundListener;

public class TrainFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public TrainFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTrainBinding binding = FragmentTrainBinding.inflate(inflater);
        WordService wordService = new WordService(this.getResources().getXml(R.xml.words));
        Log.i("MSG", "Fragment view created");

//        binding.btnNext.setOnClickListener(new BtnNextListener(binding, wordService));
//        binding.btnPlaySound.setOnClickListener(new BtnPlaySoundListener());

        View v = inflater.inflate(R.layout.fragment_train, container, false);
        Button btnNext = (Button) v.findViewById(R.id.btnNext);
        ImageButton btnPlaySound = (ImageButton) v.findViewById(R.id.btnPlaySound);

        btnNext.setOnClickListener(new BtnNextListener(v, wordService));
        btnPlaySound.setOnClickListener(new BtnPlaySoundListener(v, wordService));

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
