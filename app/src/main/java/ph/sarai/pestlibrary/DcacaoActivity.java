package ph.sarai.pestlibrary;

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
 * Created by User on 7/23/2016.
 */
public class DcacaoActivity extends AppCompatActivity implements ItemAllAdapter.ClickListener{

    private RecyclerView cacaoRecycler;
    private ItemAllAdapter cacaoAdapter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcacao);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerFragment drawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        drawerFragment.setUp(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        cacaoRecycler = (RecyclerView) findViewById(R.id.pest_items_all);
        cacaoRecycler.setHasFixedSize(true);
        LinearLayoutManager cacaoLinearLayout = new LinearLayoutManager(this);
        cacaoLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        cacaoRecycler.setLayoutManager(cacaoLinearLayout);
        cacaoAdapter = new ItemAllAdapter(this, new ItemData(this).getAllDcacaoItemData(), 2);
        cacaoAdapter.setClickListener(this);
        cacaoRecycler.setAdapter(cacaoAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cacao, menu);
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

    @Override
    public void itemClick(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity2.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "dcac_");
        startActivity(intent);
    }
}
