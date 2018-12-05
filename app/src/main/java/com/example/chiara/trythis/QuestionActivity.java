package com.example.chiara.trythis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends Activity {
    public static SSS smartySmart;
    private GameActivity game = new GameActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        smartySmart = game.getGame();
        setContentView(R.layout.activity_question);

        TextView questionTV = (TextView) findViewById(R.id.question);

        smartySmart.setQuestion("TEST QUESTION");

        questionTV.setText("Here is your question: " + smartySmart.getQuestion() );
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
        Intent myIntent = new Intent(this, GameActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.slide_from_right, 0);
    }


}
