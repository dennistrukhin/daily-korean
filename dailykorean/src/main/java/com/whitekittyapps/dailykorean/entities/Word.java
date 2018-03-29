package com.whitekittyapps.dailykorean.entities;


public class Word {

    private int id;
    private String level;
    private String word;
    private String pronunciation;
    private String definitions;
    private boolean voiced = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinitions() {
        return definitions;
    }

    public void setDefinitions(String definitions) {
        this.definitions = definitions;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String toString()
    {
        return id + " " + level + " " + word + " " + pronunciation + " " +  definitions;
    }

    public boolean isVoiced() {
        return voiced;
    }

    public void setVoiced(boolean voiced) {
        this.voiced = voiced;
    }
}
