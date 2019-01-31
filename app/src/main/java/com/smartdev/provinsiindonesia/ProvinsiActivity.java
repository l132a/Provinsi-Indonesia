package com.smartdev.provinsiindonesia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class ProvinsiActivity extends AppCompatActivity {

    private RecyclerView rvProvinsi;
    private RecycleAdapter recycler;
    List<ProvinsiModel> listProvinsi;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provinsi);

        getSupportActionBar().setLogo(R.drawable.idlogo);

        rvProvinsi = (RecyclerView)findViewById(R.id.rv_provinsi);
        rvProvinsi.setHasFixedSize(true);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        listProvinsi = databaseAccess.getProvinsi();
        databaseAccess.close();
        showRecyclerCardView();

        String IdApp = getString(R.string.admob_app_id);
        MobileAds.initialize(this,IdApp);

        String IdInter = getString(R.string.inter_ad_unit_id);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(IdInter);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_provinsi, menu); //inflate our menu
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showRecyclerCardView(){
        rvProvinsi.setLayoutManager(new LinearLayoutManager(this));
        RecycleAdapter recycleAdapter = new RecycleAdapter(this);
        recycleAdapter.setListProvinsi(listProvinsi);
        rvProvinsi.setItemAnimator(new DefaultItemAnimator());
        rvProvinsi.setAdapter(recycleAdapter);

    }
}
