package com.whitekittyapps.dailykorean.services;

import android.content.res.XmlResourceParser;
import android.text.TextUtils;

import com.whitekittyapps.dailykorean.entities.Word;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordService {

    private List<Word> words;
    private XmlResourceParser xmlParser;
    private int currentWordId;

    public WordService(XmlResourceParser xmlResourceParser)
    {
        xmlParser = xmlResourceParser;
        words = new ArrayList<>();
        loadWords();
    }

    public Word getRandomWord()
    {
        Random random = new Random();
        Word word = words.get(random.nextInt(words.size()));
        currentWordId = word.getId();
        return word;
    }

    public int getCurrentWordId() {
        return currentWordId;
    }

    private void loadWords()
    {
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

}
