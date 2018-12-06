package com.example.chiara.trythis;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    private GameActivity game;
    public static SSS sss;
    public static String SERVER_LOYOLA = "http://jpirone.cs.loyola.edu/server/readServer.php";
    private HashMap<String, String> map;

    public static void setGame(SSS smarty)
    {
        sss = smarty;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        //sss = game.getGame();

        HashMap<String, String> hashMap = new HashMap<String, String>();

        //LoadServer ls = new LoadServer(this);
        LoadServer ls = new LoadServer(this);
        ls.execute(SERVER_LOYOLA);


    }

    public void checkAnswer( View v)
    {
        EditText wordET = (EditText) findViewById(R.id.answer_enter);
        //Log.w( "MainActivity", "score = " + sss.getScore());
        String answer = wordET.getText().toString().toLowerCase().trim();

        if (answer.equals(sss.getAnswer()))
        {
            Button buttonSubmit = (Button) findViewById(R.id.submit);
            buttonSubmit.setBackgroundColor(Color.GRAY);
            buttonSubmit.setEnabled(false);
            if (sss.getTurn()%2 ==1)
            {
                sss.incPlay1Score();
                HashMap<String, String> map = sss.getPlayer1Questions();
                map.remove(sss.getQuestion());
                sss.setPlayer1Questions(map);
            }
            else
            {
                sss.incPlay2Score();
                HashMap<String, String> map = sss.getPlayer2Questions();
                Log.w("MainActivity", "Question: " + sss.getQuestion());
                map.remove(sss.getQuestion());
                sss.setPlayer2Questions(map);
            }

            if (sss.getPlay1Score() ==5 || sss.getPlay2Score() ==5)
            {
                Log.w( "MainActivity", "WINNING score = " );
                this.finish();
                overridePendingTransition(R.anim.fade_in_scale, 0);
            }
            //Log.w( "MainActivity", "increased score = " + sss.getScore());
            AlertDialog alertDialog = new AlertDialog.Builder(QuestionActivity.this).create();
            alertDialog.setTitle("You're Correct!");
            alertDialog.setMessage("Good work!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            Toast.makeText(this,"Pass the phone to the other player.", Toast.LENGTH_LONG).show();

        }
        else
        {
            Button buttonSubmit = (Button) findViewById(R.id.submit);
            buttonSubmit.setBackgroundColor(Color.GRAY);
            buttonSubmit.setEnabled(false);
            //Log.w( "MainActivity", "score stays = " + sss.getScore());
            AlertDialog alertDialog = new AlertDialog.Builder(QuestionActivity.this).create();
            alertDialog.setTitle("Incorrect!");
            alertDialog.setMessage("The right answer is: " + sss.getAnswer());
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            Toast.makeText(this,"Pass the phone to the other player.", Toast.LENGTH_LONG).show();

        }
    }

    public void moveon(View v)
    {
        //Intent myIntent = new Intent(this, GameActivity.class);
        //this.startActivity(myIntent);
        this.finish();
        overridePendingTransition(R.anim.fade_in_scale, 0);
    }

    public String getRandom(HashMap<String, String> map)
    {
        Random rand = new Random();
        int n = rand.nextInt(map.size());

        //HashMap<String, String> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        Log.w("MainActivity","Size: "+ map.size() + "N: " + n);
        int count = 0;
        for(Map.Entry<String, String> entry : map.entrySet())
        {
            if(count==n) {
                Log.w("MainActivity", "Entry: " + entry.getKey() + entry.getValue());
                stringBuilder.append(entry.getKey() + "," + entry.getValue());
                return stringBuilder.toString();
            }
            count++;
        }
        return stringBuilder.toString();
    }

    public void update(String s)
    {
        String split[] = s.split("#");

        //Log.w("MainActivity" , "Update: " + s);

        HashMap<String, String> hashMap = new HashMap<String, String>();
        String question = "";
        String answer = "";
        String author = "";

        int count = 1;
        for(String str : split)
        {
            //Log.w("MA", count + " " + str);
            String info[] = str.split(";");
            for(String string : info)
            {
                //Log.w("MA", count + " " + string);
                if(count == 1) {
                    question = string;
                    count++;
                }
                else if(count == 2) {
                    answer = string;
                    count++;
                }
                else
                {
                    author = string;
                    StringBuilder sb = new StringBuilder();
                    sb.append("From " + author + " " + question);
                    hashMap.put(sb.toString(), answer);
                    count = 1;
                }
            }
        }
        /*
        for(Map.Entry<String, String> entry : hashMap.entrySet())
        {
            Log.w("MainActivity", "Entry: " + entry.getKey() + entry.getValue());
        }
*/
        /*
        hashMap.put("Test Q1", "1");
        hashMap.put("Test Q2", "2");
        hashMap.put("Test Q3", "3");
        hashMap.put("Test Q4", "4");
        hashMap.put("Test Q5", "5");
        */
        //HashMap<String, HashMap> hashMapIndexed = new HashMap<String, String>();

        TextView questionTV = (TextView) findViewById(R.id.question);

        HashMap<String, String> player1Questions = loadQuestions(hashMap);
        sss.setPlayer1Questions(player1Questions);

        HashMap<String, String> player2Questions = loadQuestions(hashMap);
        sss.setPlayer2Questions(player2Questions);

        //HashMap<String, String> player2Questions = loadSecondQ(hashMap, player1Questions);

        String rightQuestion;
        String rightAnswer;

        if(sss.getTurn() % 2 == 1) {
            String tuple = getRandom(player1Questions);
            String tupleSplit[] = tuple.split(",");
            rightQuestion = tupleSplit[0];
            rightAnswer = tupleSplit[1];
        }
        else
        {
            String tuple = getRandom(player2Questions);
            String tupleSplit[] = tuple.split(",");
            rightQuestion = tupleSplit[0];
            rightAnswer = tupleSplit[1];
        }

        sss.setAnswer(rightAnswer);
        sss.setQuestion(rightQuestion);
        questionTV.setText(" " +sss.getQuestion() );
    }

    public HashMap<String, String> loadQuestions(HashMap<String, String> hashMap)
    {
        HashMap<String, String> questionMap = new HashMap<>();

        for(int i = 0; i < 5; i++)
        {
            String tuple = getRandom(hashMap);
            Log.w("MainActivity", "Tuple: " + tuple);
            String tupleSplit[] = tuple.split(",");
            String question = tupleSplit[0];
            String answer = tupleSplit[1];
            hashMap.remove(question);
            questionMap.put(question, answer);
        }
        return questionMap;
    }

    public HashMap<String, String> loadSecondQ(HashMap<String, String> hashMap, HashMap<String, String> oldQuestions)
    {
        for(Map.Entry<String, String> entry : oldQuestions.entrySet()) {
            hashMap.remove(entry.getKey());
        }

        HashMap<String, String> questionMap = new HashMap<>();

        for(int i = 0; i < 5; i++)
        {
            String tuple = getRandom(hashMap);

            String tupleSplit[] = tuple.split(",");
            String question = tupleSplit[0];
            String answer = tupleSplit[1];
            hashMap.remove(question);
            questionMap.put(question, answer);
        }
        return questionMap;
    }

}