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

/**
 * Created by User on 7/21/2016.
 */
public class BrowseActivity extends AppCompatActivity implements ItemAdapter.ClickListener{
    private RecyclerView riceRecycler;
    private ItemAdapter riceAdapter;

    private RecyclerView cornRecycler;
    private ItemAdapter cornAdapter;

    private RecyclerView bananaRecycler;
    private ItemAdapter bananaAdapter;

    private RecyclerView cacaoRecycler;
    private ItemAdapter cacaoAdapter;

    private RecyclerView coffeeRecycler;
    private ItemAdapter coffeeAdapter;

    private RecyclerView cocoRecycler;
    private ItemAdapter cocoAdapter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerFragment drawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        drawerFragment.setUp(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        riceRecycler = (RecyclerView) findViewById(R.id.rice_items);
        riceRecycler.setHasFixedSize(true);
        LinearLayoutManager riceLinearLayout = new LinearLayoutManager(this);
        riceLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        riceRecycler.setLayoutManager(riceLinearLayout);
        riceAdapter = new ItemAdapter(this, new ItemData(this).getRiceItemData(), 1);
        riceAdapter.setClickListenerRice(this);
        riceRecycler.setAdapter(riceAdapter);

        cornRecycler = (RecyclerView) findViewById(R.id.corn_items);
        cornRecycler.setHasFixedSize(true);
        LinearLayoutManager cornLinearLayout = new LinearLayoutManager(this);
        cornLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        cornRecycler.setLayoutManager(cornLinearLayout);
        cornAdapter = new ItemAdapter(this, new ItemData(this).getCornItemData(), 1);
        cornAdapter.setClickListenerCorn(this);
        cornRecycler.setAdapter(cornAdapter);

        bananaRecycler = (RecyclerView) findViewById(R.id.banana_items);
        bananaRecycler.setHasFixedSize(true);
        LinearLayoutManager bananaLinearLayout = new LinearLayoutManager(this);
        bananaLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        bananaRecycler.setLayoutManager(bananaLinearLayout);
        bananaAdapter = new ItemAdapter(this, new ItemData(this).getBananaItemData(), 1);
        bananaAdapter.setClickListenerBanana(this);
        bananaRecycler.setAdapter(bananaAdapter);

        cacaoRecycler = (RecyclerView) findViewById(R.id.cacao_items);
        cacaoRecycler.setHasFixedSize(true);
        LinearLayoutManager cacaoLinearLayout = new LinearLayoutManager(this);
        cacaoLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        cacaoRecycler.setLayoutManager(cacaoLinearLayout);
        cacaoAdapter = new ItemAdapter(this, new ItemData(this).getCacaoItemData(), 1);
        cacaoAdapter.setClickListenerCacao(this);
        cacaoRecycler.setAdapter(cacaoAdapter);

        coffeeRecycler = (RecyclerView) findViewById(R.id.coffee_items);
        coffeeRecycler.setHasFixedSize(true);
        LinearLayoutManager coffeeLinearLayout = new LinearLayoutManager(this);
        coffeeLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        coffeeRecycler.setLayoutManager(coffeeLinearLayout);
        coffeeAdapter = new ItemAdapter(this, new ItemData(this).getCoffeeItemData(), 1);
        coffeeAdapter.setClickListenerCoffee(this);
        coffeeRecycler.setAdapter(coffeeAdapter);

        cocoRecycler = (RecyclerView) findViewById(R.id.coco_items);
        cocoRecycler.setHasFixedSize(true);
        LinearLayoutManager cocoLinearLayout = new LinearLayoutManager(this);
        cocoLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        cocoRecycler.setLayoutManager(cocoLinearLayout);
        cocoAdapter = new ItemAdapter(this, new ItemData(this).getCocoItemData(), 1);
        cocoAdapter.setClickListenerCoco(this);
        cocoRecycler.setAdapter(cocoAdapter);
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
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/f258pyh6q4o4t7j/pests-rice.csv?dl=0","pests-rice.csv");
    }

    public void redirectCorn(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/ytmllcaezwrkl95/pests-corn.csv?dl=0","pests-corn.csv");
    }

    public void redirectBanana(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/9u8l4q4szb35kmb/pests-banana.csv?dl=0","pests-banana.csv");
    }

    public void redirectCacao(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/n8q01n563msq3rz/pests-cacao.csv?dl=0","pests-cacao.csv");
    }

    public void redirectCoffee(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/ob0q0cati9nx4lr/pests-coffee.csv?dl=0","pests-coffee.csv");
    }

    public void redirectCoco(View view){
        new CSVTask().execute("https://dl.dropboxusercontent.com/s/40cccr06p2o92o7/pests-coconut.csv?dl=0","pests-coconut.csv");
    }

    public void callRice() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "rice");
        startActivity(intent);
    }

    public void callCorn() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "corn");
        startActivity(intent);
    }

    public void callBanana() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "banana");
        startActivity(intent);
    }

    public void callCacao() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "cacao");
        startActivity(intent);
    }

    public void callCoffee() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "coffee");
        startActivity(intent);
    }

    public void callCoconut() {
        Intent intent = new Intent(this, LoadActivity.class);
        intent.putExtra("status", "true");
        intent.putExtra("type", "coconut");
        startActivity(intent);
    }

    @Override
    public void itemClickRice(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "rice_");
        startActivity(intent);
    }

    @Override
    public void itemClickCorn(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "corn_");
        startActivity(intent);
    }

    @Override
    public void itemClickBanana(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "ban_");
        startActivity(intent);
    }

    @Override
    public void itemClickCacao(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "cac_");
        startActivity(intent);
    }

    @Override
    public void itemClickCoffee(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "coff_");
        startActivity(intent);
    }

    @Override
    public void itemClickCoco(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "coco_");
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

            if ((result && filename.equals("pests-rice.csv")) || filename.equals("pests-rice.csv") && csvFile.exists()) {
                callRice();
            }
            else if ((result && filename.equals("pests-corn.csv")) || filename.equals("pests-corn.csv") && csvFile.exists()) {
                callCorn();
            }
            else if ((result && filename.equals("pests-banana.csv")) || filename.equals("pests-banana.csv") && csvFile.exists()) {
                callBanana();
            }
            else if ((result && filename.equals("pests-coffee.csv")) || filename.equals("pests-coffee.csv") && csvFile.exists()) {
                callCoffee();
            }
            else if ((result && filename.equals("pests-cacao.csv")) || filename.equals("pests-cacao.csv") && csvFile.exists()) {
                callCacao();
            }
            else if ((result && filename.equals("pests-coconut.csv")) || filename.equals("pests-coconut.csv") && csvFile.exists()) {
                callCoconut();
            }
            else {
                showNoConnection();
            }
        }
    }

}
