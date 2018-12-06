package com.example.chiara.trythis;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class LoadServer extends AsyncTask<String, Void, String> {

    private QuestionActivity qActivity;

    public LoadServer( QuestionActivity activity )
    {
        this.qActivity = activity;
    }

    public String doInBackground( String... urls )
    {
        String result = "";
        try
        {
            // create a URL
            URL url = new URL( urls[0] );
            // get a URLConnection
            URLConnection connection = url.openConnection();
            connection.setDoOutput( true );
            OutputStream os = connection.getOutputStream();
            // write
            OutputStreamWriter osw = new OutputStreamWriter( os );

            // should use URLEncoder class to encode data
            String data = "";
            //String data = "question=here&answer=hi&author=me";
            osw.write( data );
            osw.flush();

            // start reading
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader( is );
            BufferedReader br = new BufferedReader( isr );

            String line = "";
            while((line = br.readLine()) != null)
                result += line;


        }
        catch( Exception e )
        {
            Log.w( "MA", "inside catch: " +  e.getCause());
            result = e.getMessage();
        }
        return result;
    }

    public void onPostExecute( String result )
    {
        qActivity.update(result);
    }
}


