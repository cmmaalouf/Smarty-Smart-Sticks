package com.example.chiara.trythis;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static SSS smartySmart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hi

    }

    public void StartGame(View view) {
        Intent myIntent = new Intent( this,
                GameActivity.class );
        this.startActivity( myIntent );
        overridePendingTransition( R.anim.zoom_in, 0 );

    }

    public void addQuestion(View view) {
        Intent myIntent = new Intent( this,
                ServerActivity.class );
        this.startActivity( myIntent );
        overridePendingTransition( R.anim.zoom_in, 0 );

    }

    public void GiveInstructions(View view)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Instructions");
        alertDialog.setMessage("Each player gets 5 sticks\n\nPick a stick to get a queston\n\nAnswer Correctly: You get a point!\n\n" +
                "Answer Incorrectly: You are told the answer and will have another opportunity to win the point.\n\nThe player who gets all 5 points first wins!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
