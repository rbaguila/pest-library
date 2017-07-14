package ph.sarai.pestlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        File myDir = new File(Environment.getExternalStorageDirectory()
                +  File.separator + "/Android/data/ph.sarai.pestlibrary/csv");
        File imgDir = new File(Environment.getExternalStorageDirectory()
                +  File.separator + "/Android/data/ph.sarai.pestlibrary/images");
        if (!myDir.exists()) {
            myDir.mkdirs();
        }
        if (!imgDir.exists()) {
            imgDir.mkdirs();
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void browsePest(View view){
        startActivity(new Intent(this, BrowseActivity.class));
    }

    public void browseDiseases(View view){
        startActivity(new Intent(this, BrowseDiseasesActivity.class));
    }
}
