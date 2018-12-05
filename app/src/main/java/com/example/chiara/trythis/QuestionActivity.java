package com.example.chiara.trythis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    private GameActivity game;
    private SSS sss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        game = new GameActivity();
        sss = game.getGame();

        TextView questionTV = (TextView) findViewById(R.id.question);
        sss.setQuestion("TEST QUESTION");
        questionTV.setText("Here is your question: " + sss.getQuestion() );
    }

    public void checkAnswer( View v)
    {
        EditText wordET = (EditText) findViewById(R.id.answer_enter);
        String answer = wordET.getText().toString();
        if (answer.equals("hello"))
        {
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
        sss.nextTurn();
        Log.w( "MainActivity", "turn = " + sss.getTurn());
        Intent myIntent = new Intent(this, GameActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.fade_in_scale, 0);
    }


}