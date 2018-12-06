package com.example.chiara.trythis;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeaderBoardActivity extends AppCompatActivity {
    private SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        Map<String, ?> keys = sharedPref.getAll();
        updateLeaderBoard();
    }
    public void updateLeaderBoard()
    {
        Map<String, ?> allScores = sharedPref.getAll();
        ArrayList<String> top5names = new ArrayList<>();
        top5names.add("       ");
        top5names.add("       ");
        top5names.add("       ");
        top5names.add("       ");
        top5names.add("       ");
        for(int i =0; i<5; i++)
        {
            if(allScores.size()>0) {
                String top = findMax(allScores);
                top5names.set(i, top);
                allScores.remove(top);
            }
        }
        if(top5names.get(0).trim()!="") {
            TextView high_score1 = (TextView) (findViewById(R.id.first));
            String bestScore1 = top5names.get(0) + "\t\t\t\t" + sharedPref.getInt(top5names.get(0), 0);
            high_score1.setText(bestScore1.toUpperCase());
        }
        if(top5names.get(1).trim()!="") {
            TextView high_score2 = (TextView) (findViewById(R.id.second));
            String bestScore2 = top5names.get(1) + "\t\t\t\t" + sharedPref.getInt(top5names.get(1), 0);
            high_score2.setText(bestScore2.toUpperCase());
        }
        if(top5names.get(2).trim()!="") {
            TextView high_score3 = (TextView) (findViewById(R.id.third));
            String bestScore3 = top5names.get(2) + "\t\t\t\t" + sharedPref.getInt(top5names.get(2), 0);
            high_score3.setText(bestScore3.toUpperCase());
        }
        if(top5names.get(3).trim()!="") {
            TextView high_score4 = (TextView) (findViewById(R.id.fourth));
            String bestScore4 = top5names.get(3) + "\t\t\t\t" + sharedPref.getInt(top5names.get(3), 0);
            high_score4.setText(bestScore4.toUpperCase());
        }
        if(top5names.get(4).trim()!="") {
            TextView high_score5 = (TextView) (findViewById(R.id.fifth));
            String bestScore5 = top5names.get(4) + "\t\t\t\t" + sharedPref.getInt(top5names.get(4), 0);
            high_score5.setText(bestScore5.toUpperCase());
        }
    }

    public String findMax(Map<String,? > map)
    {
        int max =0;
        String maxName = "";
        for( String key : map.keySet()) {
            if(map.get(key) instanceof Integer) {
                if ((Integer)(map.get(key)) > max) {
                    max = (Integer)(map.get(key));
                    maxName = key;
                }
            }
        }

        return maxName;
    }
    public void goHome(View view)
    {
        this.finish();
    }
}
