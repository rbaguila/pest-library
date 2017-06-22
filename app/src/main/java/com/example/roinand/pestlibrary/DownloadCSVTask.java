package com.example.roinand.pestlibrary;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;

/**
 * Created by ics-user on 6/20/17.
 */
class DownloadCSVTask extends AsyncTask<String, Void, Boolean> {
    protected Boolean doInBackground(String... urls) {
        try {
            //check if there is an internet
            int timeoutMs = 1500;
            Socket sock = new Socket();
            SocketAddress sockaddr = new InetSocketAddress("8.8.8.8", 53);

            sock.connect(sockaddr, timeoutMs);
            sock.close();

            //no exception, means there is an internet
            String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
            String pathDir = baseDir + "/Android/data/com.projectsarai.pestlibrary/csv";
            File file = new File(pathDir,urls[1]);
            URL url = new URL(urls[0]);

            //create the new connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            FileOutputStream fileOutput = new FileOutputStream(file);

            //this will be used in reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            //create a buffer...
            byte[] buffer = new byte[1024];
            int bufferLength = 0; //used to store a temporary size of the buffer

            //now, read through the input buffer and write the contents to the file
            while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                //add the data in the buffer to the file in the file output stream (the file on the sd card
                fileOutput.write(buffer, 0, bufferLength);

            }
            //close the output stream when done
            fileOutput.close();

            return true;

        } catch (IOException e) { //no internet
            e.printStackTrace();
            return false;
        }
    }

    protected void onPostExecute() {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}
