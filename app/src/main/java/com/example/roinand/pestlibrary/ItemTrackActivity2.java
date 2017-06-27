package com.example.roinand.pestlibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

/**
 * Created by User on 7/23/2016.
 */
public class ItemTrackActivity2 extends AppCompatActivity{

    private Toolbar toolbar;
    private List<ItemAll> items;
    private ItemAll current;
    private static final String TAG = ">";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_track2);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerFragment drawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        drawerFragment.setUp(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        if (getIntent().getStringExtra("type").equals("drice_")) {
            items = new ItemData(this).getAllDriceItemData();
            for (ItemAll item: items) {
                if (getIntent().getStringExtra("pestName").equals(item.name)) {
                    current = item;
                }
            }
        }
        //TODO: Add else ifs for all crops

        setActivityContents(getStringArrayName(getIntent().getStringExtra("pestName")));
    }

    public String getStringArrayName(String name){
        return name.replaceAll("[\\s-]","");
    }

    public void setActivityContents(String stringArrayName){
        File file = ImageStorage.getImage(stringArrayName + ".jpg");
        String path = file.getAbsolutePath();
        Bitmap b = BitmapFactory.decodeFile(path);

        ((ImageView) findViewById(R.id.item_image)).setImageBitmap(b);
        ((TextView) findViewById(R.id.item_name)).setText(current.name.equals("")? "Not available" : current.name);
        ((TextView) findViewById(R.id.item_common_name)).setText(current.commonNames.equals("")? "Not available" : current.commonNames);
        ((TextView) findViewById(R.id.item_filipino_name)).setText(current.filName.equals("")? "Not available" : current.filName);
        ((TextView) findViewById(R.id.item_scientific_name)).setText(current.sciName.equals("")? "Not available" : current.sciName);
        ((TextView) findViewById(R.id.item_identification_signs)).setText(current.signs.equals("")? "Not available" : current.signs);
        ((TextView) findViewById(R.id.item_management_practice)).setText(current.mgt.equals("")? "Not available" : current.mgt);

        ((TextView) findViewById(R.id.visit_site)).setMovementMethod(LinkMovementMethod.getInstance());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_track, menu);
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
}
