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
        startActivity(new Intent(this, DriceActivity.class));
    }

    public void redirectCorn(View view){
        startActivity(new Intent(this, DcornActivity.class));
    }

    public void redirectBanana(View view){
        startActivity(new Intent(this, DbananaActivity.class));
    }

    public void redirectCacao(View view){
        startActivity(new Intent(this, DcacaoActivity.class));
    }

    public void redirectCoffee(View view){
        startActivity(new Intent(this, DcoffeeActivity.class));
    }

    public void redirectCoco(View view){
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
}
