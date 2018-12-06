package com.example.chiara.trythis;

import java.util.HashMap;

public class SSS {

    private String question;
    private int score1;
    private int score2;
    private boolean over;
    private int turn;
    private String answer;
    private HashMap<String, String> player1Questions;
    private HashMap<String, String> player2Questions;


    public SSS() {
        question = "Test";
        turn = 0;
        score1 =0;
        score2=0;
    }

    public void setQuestion(String newQuestion) {
        question = newQuestion;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String newAnswer)
    { answer=newAnswer;}

    public String getQuestion() {
        return question;
    }

    public void incPlay1Score() {
        score1 = score1 + 1;
    }

    public int getPlay1Score() {
        return score1;
    }

    public void incPlay2Score() {
        score2 = score2 + 1;
    }

    public int getPlay2Score() {
        return score2;
    }

    public int getTurn() {
        return turn;
    }


    public int nextTurn() {
        turn = turn + 1;
        return turn;
    }

    public void setPlayer1Questions(HashMap<String, String> map)
    {
        this.player1Questions = map;
    }

    public void setPlayer2Questions(HashMap<String, String> map)
    {
        this.player2Questions = map;
    }

    public HashMap<String, String> getPlayer1Questions() {
        return player1Questions;
    }

    public HashMap<String, String> getPlayer2Questions() {
        return player2Questions;
    }
}

