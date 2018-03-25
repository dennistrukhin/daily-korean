package com.whitekittyapps.dailykorean;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.whitekittyapps.dailykorean.databinding.ActivityMainBinding;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Word> words;
    private int currentWordId;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        words = new ArrayList<>();
        loadWords();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnNext.setOnClickListener(new BtnNextListener());
        binding.btnPlaySound.setOnClickListener(new BtnPlaySoundListener());

        Word word = getRandomWord();
        displayWord(word);
    }

    Word getRandomWord()
    {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    void displayWord(Word word)
    {
        binding.txtWord.setText(word.getWord());
        binding.txtPronunciation.setText(word.getPronunciation());
        binding.txtDefinitions.setText(word.getDefinitions());
        if (word.isVoiced()) {
            binding.btnPlaySound.setVisibility(View.VISIBLE);
        } else {
            binding.btnPlaySound.setVisibility(View.INVISIBLE);
        }
        this.currentWordId = word.getId();
    }

    private void loadWords()
    {
        Resources res = this.getResources();
        XmlResourceParser xmlParser = res.getXml(R.xml.words);
        try {
            int eventType = xmlParser.getEventType();
            Word word = new Word();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlParser.getName();
                if (!TextUtils.isEmpty(nodeName)) {
                    if (eventType == XmlPullParser.START_TAG) {
                        switch (nodeName) {
                            case "Word":
                                word = new Word();
                                break;
                            case "id":
                                word.setId(Integer.parseInt(xmlParser.nextText()));
                                break;
                            case "level":
                                word.setLevel(xmlParser.nextText());
                                break;
                            case "korean":
                                word.setWord(xmlParser.nextText());
                                break;
                            case "pronunciation":
                                word.setPronunciation(xmlParser.nextText());
                                break;
                            case "definitions":
                                word.setDefinitions(xmlParser.nextText());
                                break;
                            case "audio":
                                word.setVoiced(true);
                                break;
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                        if("Word".equalsIgnoreCase(nodeName)) {
                            words.add(word);
                        }
                    }
                }
                eventType = xmlParser.next();
            }
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    public int getCurrentWordId() {
        return currentWordId;
    }
}
