package com.whitekittyapps.dailykorean;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.whitekittyapps.dailykorean.databinding.ActivityMainBinding;
import com.whitekittyapps.dailykorean.entities.Word;
import com.whitekittyapps.dailykorean.train.BtnNextListener;
import com.whitekittyapps.dailykorean.train.BtnPlaySoundListener;
import com.whitekittyapps.dailykorean.services.WordService;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        WordService wordService = new WordService(this.getResources().getXml(R.xml.words));
//
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        binding.btnNext.setOnClickListener(new BtnNextListener());
//        binding.btnPlaySound.setOnClickListener(new BtnPlaySoundListener());
//
//        Word word = wordService.getRandomWord();
//        displayWord(word);
    }
}
