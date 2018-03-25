package com.whitekittyapps.dailykorean;


class Word {

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

    void setLevel(String level) {
        this.level = level;
    }

    String getWord() {
        return word;
    }

    void setWord(String word) {
        this.word = word;
    }

    String getDefinitions() {
        return definitions;
    }

    void setDefinitions(String definitions) {
        this.definitions = definitions;
    }

    String getPronunciation() {
        return pronunciation;
    }

    void setPronunciation(String pronunciation) {
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
