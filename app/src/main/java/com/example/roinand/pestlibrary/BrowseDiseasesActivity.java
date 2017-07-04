package com.example.roinand.pestlibrary;

import android.content.Intent;
import android.os.AsyncTask;
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

    public void showNoConnection() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "false");
        startActivity(intent);
    }

    public void redirectRice(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/rfu0wgdofskpkve/diseases-rice.csv?dl=0","diseases-rice.csv");
    }

    public void redirectCorn(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/oguj8tv7rooapgl/diseases-corn.csv?dl=0","diseases-corn.csv");
    }

    public void redirectBanana(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/p4rf0q4o5oc1e1p/diseases-banana.csv?dl=0","diseases-banana.csv");
    }

    public void redirectCacao(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/59eijtse3s57ce7/diseases-cacao.csv?dl=0","diseases-cacao.csv");
    }

    public void redirectCoffee(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/6akgkq98c3or9e0/diseases-coffee.csv?dl=0","diseases-coffee.csv");
    }

    public void redirectCoco(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/bd2u1jhtf83abpg/diseases-coconut.csv?dl=0","diseases-coconut.csv");
    }

    public void callRice() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "drice");
        startActivity(intent);
    }

    public void callCorn() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "dcorn");
        startActivity(intent);
    }

    public void callBanana() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "dbanana");
        startActivity(intent);
    }

    public void callCacao() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "dcacao");
        startActivity(intent);
    }

    public void callCoffee() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "dcoffee");
        startActivity(intent);
    }

    public void callCoconut() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "dcoconut");
        startActivity(intent);
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

    private class CSVTask extends AsyncTask<String, Void, Boolean> {
        String filename, baseDir, pathDir;

        protected Boolean doInBackground(String... urls) {
            try {
                baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
                pathDir = baseDir + "/Android/data/com.projectsarai.pestlibrary/csv";
                filename = urls[1];

                if (!new File(pathDir,urls[1]).exists()) {
                    URL url1 = new URL("http://dropbox.com");   // Change to "http://google.com" for www  test.
                    HttpURLConnection urlc = (HttpURLConnection) url1.openConnection();
                    urlc.setConnectTimeout(1500);
                    urlc.connect();
                }
                else return false;

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

        @Override
        protected void onPostExecute(Boolean result) {
            File csvFile = new File(pathDir,filename);

            if ((result && filename.equals("diseases-rice.csv")) || filename.equals("diseases-rice.csv") && csvFile.exists()) {
                callRice();
            }
            else if ((result && filename.equals("diseases-corn.csv")) || filename.equals("diseases-corn.csv") && csvFile.exists()) {
                callCorn();
            }
            else if ((result && filename.equals("diseases-banana.csv")) || filename.equals("diseases-banana.csv") && csvFile.exists()) {
                callBanana();
            }
            else if ((result && filename.equals("diseases-coffee.csv")) || filename.equals("diseases-coffee.csv") && csvFile.exists()) {
                callCoffee();
            }
            else if ((result && filename.equals("diseases-cacao.csv")) || filename.equals("diseases-cacao.csv") && csvFile.exists()) {
                callCacao();
            }
            else if ((result && filename.equals("diseases-coconut.csv")) || filename.equals("diseases-coconut.csv") && csvFile.exists()) {
                callCoconut();
            }
            else {
                showNoConnection();
            }
        }
    }

}
