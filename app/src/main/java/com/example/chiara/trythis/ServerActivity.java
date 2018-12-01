package com.example.chiara.trythis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ServerActivity extends AppCompatActivity {

    public static String SERVER_LOYOLA = "http://jpirone.cs.loyola.edu/server/IOserver.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
    }

    public void serverComm(View v)
    {
        EditText ques = (EditText) findViewById(R.id.question);
        EditText ans = (EditText) findViewById(R.id.answer);
        EditText aut = (EditText) findViewById(R.id.author);
        String question = ques.getText().toString();
        String answer = ans.getText().toString();
        String author = aut.getText().toString();

        ServerTask st = new ServerTask( this, question, answer, author );
        st.execute( SERVER_LOYOLA );
    }

    public void update(String s)
    {
        TextView all = (TextView) findViewById(R.id.all);
        all.setText("From server: " + s);
    }
}
