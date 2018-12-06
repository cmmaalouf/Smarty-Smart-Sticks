package com.example.chiara.trythis;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class winnerActivity extends Activity {
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPref;
    public static SSS smartySmart;
    int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);// this.getPreferences(MODE_PRIVATE);
        editor = sharedPref.edit();
        smartySmart = new SSS();
        setContentView(R.layout.activity_winning);
    }

    public SSS getGame() {
        return smartySmart;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (smartySmart.getPlay1Score() == 5 || smartySmart.getPlay2Score() == 5) {

            Log.w("MainActivity", "WINNING score = ");
            this.finish();
            overridePendingTransition(R.anim.fade_in_scale, 0);
        }

    }

    public void sendEmail(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public void goHome(View v) {
        this.finish();
    }

    public void updateBoardScores(View v)
    {
        EditText wordET = (EditText) findViewById(R.id.enterUsername);
        String username = wordET.getText().toString().toLowerCase().trim();
        editor.putInt(username, sharedPref.getInt(username, 1));
        editor.commit();
        Button submit = (Button) findViewById(R.id.submitUserName);
        submit.setEnabled(false);
        submit.setBackgroundColor(getResources().getColor(R.color.Gray));
    }

}