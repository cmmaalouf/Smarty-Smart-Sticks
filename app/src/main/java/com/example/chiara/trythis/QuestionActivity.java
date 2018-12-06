package com.example.chiara.trythis;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    private GameActivity game;
    public static SSS sss;

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
        hashMap.put("Test Q1", "1");
        hashMap.put("Test Q2", "2");
        hashMap.put("Test Q3", "3");
        hashMap.put("Test Q4", "4");
        hashMap.put("Test Q5", "5");

        //HashMap<String, HashMap> hashMapIndexed = new HashMap<String, String>();

        TextView questionTV = (TextView) findViewById(R.id.question);

        String tuple = getRandom(hashMap);
        String split[] = tuple.split(",");
        String question = split[0];
        String rightAnswer = split[1];

        sss.setAnswer(rightAnswer);
        sss.setQuestion(question);
        questionTV.setText("Here is your question: " +sss.getQuestion() );
    }

    public void checkAnswer( View v)
    {
        EditText wordET = (EditText) findViewById(R.id.answer_enter);
        //Log.w( "MainActivity", "score = " + sss.getScore());
        String answer = wordET.getText().toString();
        if (answer.equals(sss.getAnswer()))
        {
            if (sss.getTurn()%2 ==1)
            {
                sss.incPlay1Score();
            }
            else
            {
                sss.incPlay2Score();
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
            //Log.w( "MainActivity", "score stays = " + sss.getScore());
            AlertDialog alertDialog = new AlertDialog.Builder(QuestionActivity.this).create();
            alertDialog.setTitle("Incorrect!");
            alertDialog.setMessage("The right answer is: ");
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
        int n = rand.nextInt(map.size()) + 1;

        StringBuilder stringBuilder = new StringBuilder();

        int count = 0;
        for(Map.Entry<String, String> entry : map.entrySet())
        {
            if(count==n) {
                stringBuilder.append(entry.getKey() + "," + entry.getValue());
                return stringBuilder.toString();
            }
            count++;
        }
        return "";
    }
}