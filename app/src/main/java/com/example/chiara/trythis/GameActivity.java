package com.example.chiara.trythis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }

    public void getQuestion(View view) {
        Intent myIntent = new Intent( this,
                QuestionActivity.class );
        this.startActivity( myIntent );
        overridePendingTransition( R.anim.slide_from_right, 0 );

    }

}
