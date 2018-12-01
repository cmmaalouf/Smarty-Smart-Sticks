package com.example.chiara.trythis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class QuestionActivity extends Activity {
    public static SSS smartySmart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TextView questionTV = (TextView) findViewById(R.id.question);

        smartySmart.setQuestion("TEST QUESTION");

        questionTV.setText("Here is your question" /*+ smartySmart.getQuestion() */);
    }

    public void checkAnswer( View v)
    {
        EditText wordET = (EditText) findViewById(R.id.answer_enter);
        String answer = wordET.getText().toString();
        if (answer.equals("hello"))
        {
            AlertDialog alertDialog = new AlertDialog.Builder(QuestionActivity.this).create();
            alertDialog.setTitle("You're Correct!");
            alertDialog.setMessage("You got the question correct.\nNow pass the phone to the other player.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else
        {
            AlertDialog alertDialog = new AlertDialog.Builder(QuestionActivity.this).create();
            alertDialog.setTitle("Incorrect!");
            alertDialog.setMessage("Don't worry, you'll have another chance!\nThe correct answer was: \nNow pass the phone to the other player.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

    }

}
