package com.example.chiara.trythis;

public class SSS {

    private String question;
    private int score1;
    private int score2;
    private boolean over;
    private int turn;
    private String answer;

    public SSS() {
        question = "Test";
        over = false;
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

    public boolean isOver() {
        if (score1 == 5 || score2 ==5)
            over = true;
        return true;
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
}

