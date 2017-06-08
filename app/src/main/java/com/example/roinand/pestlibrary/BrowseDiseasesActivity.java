package com.example.roinand.pestlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BrowseDiseasesActivity extends AppCompatActivity implements ItemAdapter.ClickListener{
    private RecyclerView driceRecycler; //for diseases
    private ItemAdapter driceAdapter;

    private RecyclerView cornRecycler;
    private ItemAdapter cornAdapter;

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

        cornRecycler = (RecyclerView) findViewById(R.id.corn_items);
        cornRecycler.setHasFixedSize(true);
        LinearLayoutManager cornLinearLayout = new LinearLayoutManager(this);
        cornLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        cornRecycler.setLayoutManager(cornLinearLayout);
        cornAdapter = new ItemAdapter(this, new ItemData(this).getCornItemData(), 1);
        cornAdapter.setClickListenerCorn(this);
        cornRecycler.setAdapter(cornAdapter);
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
        startActivity(new Intent(this, DriceActivity.class));
    }

    public void redirectCorn(View view){
        startActivity(new Intent(this, CornActivity.class));
    }

    @Override
    public void itemClickRice(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("pestType", "rice_");
        startActivity(intent);
    }

    @Override
    public void itemClickCorn(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity.class);
        intent.putExtra("pestName", name);
        intent.putExtra("pestType", "corn_");
        startActivity(intent);
    }
}
