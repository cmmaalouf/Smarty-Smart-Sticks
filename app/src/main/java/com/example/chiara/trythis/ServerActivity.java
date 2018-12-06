package com.example.chiara.trythis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ServerActivity extends AppCompatActivity {

    public static String SERVER_LOYOLA = "http://jpirone.cs.loyola.edu/server/IOserver.php";
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void serverComm(View v)
    {
        boolean correctInput = true;
        EditText ques = (EditText) findViewById(R.id.question);
        EditText ans = (EditText) findViewById(R.id.answer);
        EditText aut = (EditText) findViewById(R.id.author);
        String question = ques.getText().toString();
        String answer = ans.getText().toString();
        String author = aut.getText().toString();

        if(question == null || question.replaceAll("\\s+","").equals(""))
        {
            correctInput = false;
            Toast.makeText(this,"Please input a question", Toast.LENGTH_LONG).show();
        }
        else if(answer == null || answer.replaceAll("\\s+","").equals(""))
        {
            correctInput = false;
            Toast.makeText(this,"Please input an answer", Toast.LENGTH_LONG).show();
        }
        else if(author == null || author.replaceAll("\\s+","").equals(""))
        {
            correctInput = false;
            Toast.makeText(this,"Please input an author", Toast.LENGTH_LONG).show();
        }

        if(correctInput)
        {
            ServerTask st = new ServerTask(this, question, answer, author);
            st.execute(SERVER_LOYOLA);
        }
    }

    public void update(String s)
    {
        TextView all = (TextView) findViewById(R.id.all);
        all.setText("From server: " + s);

        String split[] = s.split("#");

        HashMap<String, String> hashMap = new HashMap<String, String>();
        String question = "";
        String answer = "";
        String author = "";

        int count = 1;
        for(String str : split)
        {
            //Log.w("MA", count + " " + str);
            String info[] = str.split(";");
            for(String string : info)
            {
                //Log.w("MA", count + " " + string);
                if(count == 1) {
                    question = string;
                    count++;
                }
                else if(count == 2) {
                    answer = string;
                    count++;
                }
                else
                {
                    author = string;
                    StringBuilder sb = new StringBuilder();
                    sb.append("From " + author + " " + question);
                    hashMap.put(sb.toString(), answer);
                    count = 1;
                }
            }
        }


        for(Map.Entry<String, String> entry : hashMap.entrySet())
        {
            Log.w("MA", "Entry: " + entry.getKey() + entry.getValue());
        }
    }



    public void goback(View v)
    {
       this.finish();
    }
}
