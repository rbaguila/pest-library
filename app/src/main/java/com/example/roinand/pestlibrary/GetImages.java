package com.example.roinand.pestlibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

public class GetImages extends AsyncTask<ImageView, Object, Bitmap> {
    private String requestUrl, imgName;
    private Bitmap bitmap;
    private static final String TAG = ">";
    private ImageView view;

    public GetImages(String requestUrl, String imgName) {
        this.requestUrl = requestUrl;
        this.imgName = imgName;
    }

    @Override
    protected Bitmap doInBackground(ImageView... imgview) {
        try {
            //check if there is an internet
            int timeoutMs = 1500;
            Socket sock = new Socket();
            SocketAddress sockaddr = new InetSocketAddress("8.8.8.8", 53);

            sock.connect(sockaddr, timeoutMs);
            sock.close();

            view = imgview[0];

            Log.d(TAG, "Downloading image...");
            URL url = new URL(requestUrl);
            URLConnection conn = url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());

            Log.d(TAG, "Download success! Saving...");
            ImageStorage.saveToSdCard(bitmap, imgName);

            return bitmap;
        }
        catch (Exception ex) {
            Log.d(TAG, "Download failed! No internet");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            view.setImageBitmap(result);
        }
    }
}