package com.example.roinand.pestlibrary;

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
        /*String itemType = getIntent().getStringExtra("type");
        ((ImageView) findViewById(R.id.item_image)).setImageResource(getResources().getIdentifier(itemType + stringArrayName.toLowerCase(),"drawable", getPackageName()));

        String[] details = getResources().getStringArray(getResources().getIdentifier(stringArrayName,"array", getPackageName()));
        ((TextView) findViewById(R.id.item_name)).setText(details[0].equals("")? "Not available" : details[0]);
        ((TextView) findViewById(R.id.item_common_name)).setText(details[1].equals("")? "Not available" : details[1]);
        ((TextView) findViewById(R.id.item_filipino_name)).setText(details[2].equals("")? "Not available" : details[2]);
        ((TextView) findViewById(R.id.item_scientific_name)).setText(details[3].equals("")? "Not available" : details[3]);
        ((TextView) findViewById(R.id.item_identification_signs)).setText(details[4].equals("")? "Not available" : details[4]);
        ((TextView) findViewById(R.id.item_management_practice)).setText(details[5].equals("")? "Not available" : details[5]);

        ((TextView) findViewById(R.id.visit_site)).setMovementMethod(LinkMovementMethod.getInstance());*/
        (ImageView) findViewById(R.id.item_image).

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
