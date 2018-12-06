package com.example.chiara.trythis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends Activity {
    public static SSS smartySmart;
    int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        smartySmart = new SSS( );
        setContentView(R.layout.activity_game);
    }

    public SSS getGame()
    {
        return smartySmart;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (smartySmart.getPlay1Score() ==5 || smartySmart.getPlay2Score() ==5)
        {
            Log.w( "MainActivity", "WINNING score = " );
            this.finish();
            overridePendingTransition(R.anim.fade_in_scale, 0);
        }
        smartySmart.nextTurn();
        //setContentView(R.layout.activity_game);
        Log.w( "MainActivity", "turn = " + smartySmart.getTurn());
        if (smartySmart.getTurn()%2 ==1)
        {
            Log.w( "MainActivity", "in odd player turn = " + smartySmart.getTurn());
            Button buttonID1 = (Button) findViewById(R.id.stick1);
            buttonID1.setBackgroundResource(R.drawable.redbutton);
            if (smartySmart.getPlay1Score() <=4)
            {
                Button buttonID2 = (Button) findViewById(R.id.stick2);
                buttonID2.setBackgroundResource(R.drawable.redbutton);
            }
            if (smartySmart.getPlay1Score() <=3)
            {
                Button buttonID3 = (Button) findViewById(R.id.stick3);
                buttonID3.setBackgroundResource(R.drawable.redbutton);
            }
            Button buttonID4 = (Button) findViewById(R.id.stick4);
            buttonID4.setBackgroundResource(R.drawable.redbutton);
            Button buttonID5 = (Button) findViewById(R.id.stick5);
            buttonID5.setBackgroundResource(R.drawable.redbutton);
        }
        else
        {
            Log.w( "MainActivity", "in even player turn = " +smartySmart.getTurn());
            Button buttonID1 = (Button) findViewById(R.id.stick1);
            buttonID1.setBackgroundResource(R.drawable.bluebutton);
            Button buttonID2 = (Button) findViewById(R.id.stick2);
            buttonID2.setBackgroundResource(R.drawable.bluebutton);
            Button buttonID3 = (Button) findViewById(R.id.stick3);
            buttonID3.setBackgroundResource(R.drawable.bluebutton);
            Button buttonID4 = (Button) findViewById(R.id.stick4);
            buttonID4.setBackgroundResource(R.drawable.bluebutton);
            Button buttonID5 = (Button) findViewById(R.id.stick5);
            buttonID5.setBackgroundResource(R.drawable.bluebutton);
        }
    }

    public void getQuestion(View view) {

        Intent myIntent = new Intent( this,
                QuestionActivity.class );
        QuestionActivity.setGame(getGame());
        this.startActivity( myIntent );
        overridePendingTransition( R.anim.slide_from_right, 0 );
    }

}