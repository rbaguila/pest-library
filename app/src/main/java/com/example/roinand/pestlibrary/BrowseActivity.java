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

    public void redirectRice(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/f258pyh6q4o4t7j/pests-rice.csv?dl=0","pests-rice.csv");
        startActivity(new Intent(this, RiceActivity.class));
    }

    public void redirectCorn(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/ytmllcaezwrkl95/pests-corn.csv?dl=0","pests-corn.csv");
        startActivity(new Intent(this, CornActivity.class));
    }

    public void redirectBanana(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/9u8l4q4szb35kmb/pests-banana.csv?dl=0","pests-banana.csv");
        startActivity(new Intent(this, BananaActivity.class));
    }

    public void redirectCacao(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/n8q01n563msq3rz/pests-cacao.csv?dl=0","pests-cacao.csv");
        startActivity(new Intent(this, CacaoActivity.class));
    }

    public void redirectCoffee(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/ob0q0cati9nx4lr/pests-coffee.csv?dl=0","pests-coffee.csv");
        startActivity(new Intent(this, CoffeeActivity.class));
    }

    public void redirectCoco(View view){
        new DownloadCSVTask().execute("https://dl.dropboxusercontent.com/s/40cccr06p2o92o7/pests-coconut.csv?dl=0","pests-coconut.csv");
        startActivity(new Intent(this, CocoActivity.class));
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
}
