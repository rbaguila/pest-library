package com.example.roinand.pestlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BrowseDiseasesActivity extends AppCompatActivity implements ItemAdapter.ClickListener{
    private RecyclerView driceRecycler; //for diseases
    private ItemAdapter driceAdapter;

    private RecyclerView dcornRecycler;
    private ItemAdapter dcornAdapter;

    private RecyclerView dbananaRecycler;
    private ItemAdapter dbananaAdapter;

    private RecyclerView dcacaoRecycler;
    private ItemAdapter dcacaoAdapter;

    private RecyclerView dcoffeeRecycler;
    private ItemAdapter dcoffeeAdapter;

    private RecyclerView dcocoRecycler;
    private ItemAdapter dcocoAdapter;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_diseases);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerFragment drawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        drawerFragment.setUp(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        driceRecycler = (RecyclerView) findViewById(R.id.rice_items);
        driceRecycler.setHasFixedSize(true);
        LinearLayoutManager driceLinearLayout = new LinearLayoutManager(this);
        driceLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        driceRecycler.setLayoutManager(driceLinearLayout);
        driceAdapter = new ItemAdapter(this, new ItemData(this).getDriceItemData(), 2);
        driceAdapter.setClickListenerRice(this);
        driceRecycler.setAdapter(driceAdapter);

        dcornRecycler = (RecyclerView) findViewById(R.id.corn_items);
        dcornRecycler.setHasFixedSize(true);
        LinearLayoutManager dcornLinearLayout = new LinearLayoutManager(this);
        dcornLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        dcornRecycler.setLayoutManager(dcornLinearLayout);
        dcornAdapter = new ItemAdapter(this, new ItemData(this).getDcornItemData(), 2);
        dcornAdapter.setClickListenerCorn(this);
        dcornRecycler.setAdapter(dcornAdapter);

        dbananaRecycler = (RecyclerView) findViewById(R.id.banana_items);
        dbananaRecycler.setHasFixedSize(true);
        LinearLayoutManager dbananaLinearLayout = new LinearLayoutManager(this);
        dbananaLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        dbananaRecycler.setLayoutManager(dbananaLinearLayout);
        dbananaAdapter = new ItemAdapter(this, new ItemData(this).getDbananaItemData(), 2);
        dbananaAdapter.setClickListenerBanana(this);
        dbananaRecycler.setAdapter(dbananaAdapter);

        dcacaoRecycler = (RecyclerView) findViewById(R.id.cacao_items);
        dcacaoRecycler.setHasFixedSize(true);
        LinearLayoutManager dcacaoLinearLayout = new LinearLayoutManager(this);
        dcacaoLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        dcacaoRecycler.setLayoutManager(dcacaoLinearLayout);
        dcacaoAdapter = new ItemAdapter(this, new ItemData(this).getDcacaoItemData(), 2);
        dcacaoAdapter.setClickListenerCacao(this);
        dcacaoRecycler.setAdapter(dcacaoAdapter);

        dcoffeeRecycler = (RecyclerView) findViewById(R.id.coffee_items);
        dcoffeeRecycler.setHasFixedSize(true);
        LinearLayoutManager dcoffeeLinearLayout = new LinearLayoutManager(this);
        dcoffeeLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        dcoffeeRecycler.setLayoutManager(dcoffeeLinearLayout);
        dcoffeeAdapter = new ItemAdapter(this, new ItemData(this).getDcoffeeItemData(), 2);
        dcoffeeAdapter.setClickListenerCoffee(this);
        dcoffeeRecycler.setAdapter(dcoffeeAdapter);

        dcocoRecycler = (RecyclerView) findViewById(R.id.coco_items);
        dcocoRecycler.setHasFixedSize(true);
        LinearLayoutManager dcocoLinearLayout = new LinearLayoutManager(this);
        dcocoLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        dcocoRecycler.setLayoutManager(dcocoLinearLayout);
        dcocoAdapter = new ItemAdapter(this, new ItemData(this).getDcocoItemData(), 2);
        dcocoAdapter.setClickListenerCoco(this);
        dcocoRecycler.setAdapter(dcocoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        //Set true if you want to see menu option
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void redirectRice(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/rfu0wgdofskpkve/diseases-rice.csv?dl=0","diseases-rice.csv");
        startActivity(new Intent(this, DriceActivity.class));
    }

    public void redirectCorn(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/oguj8tv7rooapgl/diseases-corn.csv?dl=0","diseases-corn.csv");
        startActivity(new Intent(this, DcornActivity.class));
    }

    public void redirectBanana(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/p4rf0q4o5oc1e1p/diseases-banana.csv?dl=0","diseases-banana.csv");
        startActivity(new Intent(this, DbananaActivity.class));
    }

    public void redirectCacao(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/59eijtse3s57ce7/diseases-cacao.csv?dl=0","diseases-cacao.csv");
        startActivity(new Intent(this, DcacaoActivity.class));
    }

    public void redirectCoffee(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/6akgkq98c3or9e0/diseases-coffee.csv?dl=0","diseases-coffee.csv");
        startActivity(new Intent(this, DcoffeeActivity.class));
    }

    public void redirectCoco(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/bd2u1jhtf83abpg/diseases-coconut.csv?dl=0","diseases-coconut.csv");
        startActivity(new Intent(this, DcocoActivity.class));
    }

    @Override
    public void itemClickRice(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "drice_");
        startActivity(intent);
    }

    @Override
    public void itemClickCorn(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "dcorn_");
        startActivity(intent);
    }

    @Override
    public void itemClickBanana(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "dban_");
        startActivity(intent);
    }

    @Override
    public void itemClickCacao(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "dcac_");
        startActivity(intent);
    }

    @Override
    public void itemClickCoffee(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "dcoff_");
        startActivity(intent);
    }

    @Override
    public void itemClickCoco(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "dcoco_");
        startActivity(intent);
    }

    public void downloadCSV() {
        try {

            //set the path where we want to save the file
            //in this case, going to save it on the root directory of the
            //sd card.
            //File SDCardRoot = Environment.getExternalStorageDirectory() + "/Android/data/com.projectsarai.pestlibrary/csv";

            String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
            String pathDir = baseDir + "/Android/data/com.projectsarai.pestlibrary/csv";
            //create a new file, specifying the path, and the filename
            //which we want to save the file as.
            File file = new File(pathDir,"diseases-rice.csv");

            //set the download URL, a url that points to a file on the internet
            //this is the file to be downloaded
            URL url = new URL("https://dl.dropboxusercontent.com/s/rfu0wgdofskpkve/diseases-rice.csv?dl=0");

            //create the new connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //set up some things on the connection
           // urlConnection.setRequestMethod("GET");
           // urlConnection.setDoOutput(true);

            //and connect!
           // urlConnection.connect();

            //this will be used to write the downloaded data into the file we created
            FileOutputStream fileOutput = new FileOutputStream(file);

            //this will be used in reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            //this is the total size of the file
            int totalSize = urlConnection.getContentLength();
            //variable to store total downloaded bytes
            int downloadedSize = 0;

            //create a buffer...
            byte[] buffer = new byte[1024];
            int bufferLength = 0; //used to store a temporary size of the buffer

            //now, read through the input buffer and write the contents to the file
            while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                //add the data in the buffer to the file in the file output stream (the file on the sd card
                fileOutput.write(buffer, 0, bufferLength);
                //add up the size so we know how much is downloaded
                downloadedSize += bufferLength;
                //this is where you would do something to report the prgress, like this maybe
                //updateProgress(downloadedSize, totalSize);

            }
            //close the output stream when done
            fileOutput.close();

        //catch some possible errors...
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            File dir = new File(Environment.getExternalStorageDirectory() + "/"
                    + "Android/data/com.projectsarai.pestlibrary/csv");
            if (dir.exists() == false) {
                dir.mkdirs();
            }

            URL url = new URL("https://dl.dropboxusercontent.com/s/oguj8tv7rooapgl/diseases-corn.csv?dl=0");
            File file = new File(dir, "diseases-corn.csv");

            URLConnection ucon = url.openConnection();
            InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            //We create an array of bytes
            byte[] data = new byte[50];
            int current = 0;

            while((current = bis.read(data,0,data.length)) != -1){
                buffer.write(data,0,current);
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(buffer.toByteArray());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
