package com.example.chiara.trythis;

public class SSS {

    private String question;
    private int score;
    private boolean over;
    private int turn;

    public SSS() {
        question = "Test";
        over = false;
        turn = 1;
    }

    public void setQuestion(String newQuestion) {
        question = newQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isOver() {
        if (score == 5)
            over = true;
        return true;
    }

    public void incScore() {
        score = score + 1;
    }

    public String getScore() {
        return question;
    }

    public int getTurn() {
        return turn;
    }

    public int nextTurn() {
        turn = turn + 1;
        return turn;
    }
}

