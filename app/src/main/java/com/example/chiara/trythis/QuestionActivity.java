package com.example.chiara.trythis;

import android.app.Activity;
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
}
