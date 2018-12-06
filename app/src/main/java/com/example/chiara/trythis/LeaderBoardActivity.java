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
        TextView high_score = (TextView)(findViewById(R.id.first));
        String bestScore = top5names.get(0)+"\t"+sharedPref.getInt(top5names.get(0),0);
        high_score.setText(bestScore);
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
