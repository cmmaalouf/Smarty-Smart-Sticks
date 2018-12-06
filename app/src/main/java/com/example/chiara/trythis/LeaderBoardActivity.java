package com.example.chiara.trythis;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LeaderBoardActivity extends AppCompatActivity {
    private SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        TextView high_score = (TextView)(findViewById(R.id.first));
        String bestScore = "Best Score: "+sharedPref.getInt("chiara",0);
        high_score.setText(bestScore);
    }

    public void goHome(View view)
    {
        this.finish();
    }
}
