package com.example.chiara.trythis;

public class SSS {

    private String question = "TEST";
    private int score;
    private boolean over = false;

    public void setQuestion( String newQuestion ) {
        question = newQuestion;
    }
    public String getQuestion( ) {
        return question ;
    }

    public boolean isOver()
    {
        if (score == 5)
            over = true;
        return true;
    }

    public void incScore() {
        score = score + 1;
    }
    public String getScore( ) {
        return question ;
    }

}
