package ph.sarai.pestlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class LoadActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);


        spinner = (ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerFragment drawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        drawerFragment.setUp(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        if (getIntent().getStringExtra("status").equals("false")) {
            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    noData();
                }
            }.start();
        }
        else {
            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    if (getIntent().getStringExtra("type").equals("rice")) {
                        callRice();
                    }

                    else if (getIntent().getStringExtra("type").equals("corn")) {
                        callCorn();
                    }

                    else if (getIntent().getStringExtra("type").equals("banana")) {
                        callBanana();
                    }

                    else if (getIntent().getStringExtra("type").equals("coffee")) {
                        callCoffee();
                    }

                    else if (getIntent().getStringExtra("type").equals("cacao")) {
                        callCacao();
                    }

                    else if (getIntent().getStringExtra("type").equals("coconut")) {
                        callCoconut();
                    }

                    else if (getIntent().getStringExtra("type").equals("drice")) {
                        callDrice();
                    }

                    else if (getIntent().getStringExtra("type").equals("dcorn")) {
                        callDcorn();
                    }

                    else if (getIntent().getStringExtra("type").equals("dbanana")) {
                        callDbanana();
                    }

                    else if (getIntent().getStringExtra("type").equals("dcoffee")) {
                        callDcoffee();
                    }

                    else if (getIntent().getStringExtra("type").equals("dcacao")) {
                        callDcacao();
                    }

                    else if (getIntent().getStringExtra("type").equals("dcoconut")) {
                        callDcoconut();
                    }
                }
            }.start();
        }
    }

    public void noData() {
        startActivity(new Intent(this, NoDataActivity.class));
        finish();
    }

    public void callRice() {
        startActivity(new Intent(this, RiceActivity.class));
        finish();
    }

    public void callCorn() {
        startActivity(new Intent(this, CornActivity.class));
        finish();
    }

    public void callBanana() {
        startActivity(new Intent(this, BananaActivity.class));
        finish();
    }

    public void callCoffee() {
        startActivity(new Intent(this, CoffeeActivity.class));
        finish();
    }

    public void callCacao() {
        startActivity(new Intent(this, CacaoActivity.class));
        finish();
    }

    public void callCoconut() {
        startActivity(new Intent(this, CocoActivity.class));
        finish();
    }

    public void callDrice() {
        startActivity(new Intent(this, DriceActivity.class));
        finish();
    }

    public void callDcorn() {
        startActivity(new Intent(this, DcornActivity.class));
        finish();
    }

    public void callDbanana() {
        startActivity(new Intent(this, DbananaActivity.class));
        finish();
    }

    public void callDcoffee() {
        startActivity(new Intent(this, DcoffeeActivity.class));
        finish();
    }

    public void callDcacao() {
        startActivity(new Intent(this, DcacaoActivity.class));
        finish();
    }

    public void callDcoconut() {
        startActivity(new Intent(this, DcocoActivity.class));
        finish();
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
}
