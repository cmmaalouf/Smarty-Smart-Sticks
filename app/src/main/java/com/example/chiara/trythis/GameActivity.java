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
    protected void onResume() {
        super.onResume();
        Log.w( "MainActivity", "turn = " + smartySmart.getTurn());
        if (smartySmart.getTurn()%2 ==1)
        {
            Log.w( "MainActivity", "in odd player turn = " + smartySmart.getTurn());
            Button buttonID1 = (Button) findViewById(R.id.stick1);
            buttonID1.setBackgroundResource(R.drawable.redbutton);
            Button buttonID2 = (Button) findViewById(R.id.stick2);
            buttonID2.setBackgroundResource(R.drawable.redbutton);
            Button buttonID3 = (Button) findViewById(R.id.stick3);
            buttonID3.setBackgroundResource(R.drawable.redbutton);
            Button buttonID4 = (Button) findViewById(R.id.stick4);
            buttonID4.setBackgroundColor(Color.RED);
            Button buttonID5 = (Button) findViewById(R.id.stick5);
            buttonID5.setBackgroundColor(Color.RED);
        }
        else
        {
            Log.w( "MainActivity", "in even player turn = " + smartySmart.getTurn());
            Button buttonID1 = (Button) findViewById(R.id.stick1);
            buttonID1.setBackgroundColor(Color.BLUE);
            Button buttonID2 = (Button) findViewById(R.id.stick2);
            buttonID2.setBackgroundColor(Color.BLUE);
            Button buttonID3 = (Button) findViewById(R.id.stick3);
            buttonID3.setBackgroundColor(Color.BLUE);
            Button buttonID4 = (Button) findViewById(R.id.stick4);
            buttonID4.setBackgroundColor(Color.BLUE);
            Button buttonID5 = (Button) findViewById(R.id.stick5);
            buttonID5.setBackgroundColor(Color.BLUE);
        }
        setContentView(R.layout.activity_game);
    }

    public void getQuestion(View view) {

        Intent myIntent = new Intent( this,
                QuestionActivity.class );
        this.startActivity( myIntent );
        overridePendingTransition( R.anim.slide_from_right, 0 );
    }

}