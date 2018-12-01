package com.example.chiara.trythis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class QuestionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        SSS smartySmart = MainActivity.smartySmart;
        //EditText wordET = (EditText) findViewById(R.id.word_enter);

        TextView questionTV = (TextView) findViewById(R.id.question);

        //smartySmart.setQuestion("TEST");

        questionTV.setText("Here is your question" /*+ smartySmart.getQuestion()*/ );
    }


    public void checkAnswer( View v)
    {
        EditText wordET = (EditText) findViewById(R.id.answer_enter);
        String answer = wordET.getText().toString();
        if (answer.equals("hello"))
        {
            AlertDialog alertDialog = new AlertDialog.Builder(QuestionActivity.this).create();
            alertDialog.setTitle("Check");
            alertDialog.setMessage("Correct!");
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
            alertDialog.setTitle("Check");
            alertDialog.setMessage("Sorry that's wrong!");
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
