package com.smartdev.provinsiindonesia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by L132A on 26/11/2017.
 */

public class DetailActivity extends AppCompatActivity{

    String mLogo, mProvinsi, mKeterangan, mKota, mPulau, mJulukan, mSemboyan, mHarijadi, mLuas, mLat, mLng, mZonawaktu;

    ImageView imgLogo;
    TextView tvKeterangan,tvProvinsi, tvKota, tvPulau, tvJulukan, tvSemboyan, tvHarijadi, tvLuas, tvLat, tvLng, tvZonawaktu;
    Context context;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        context = this;
        Intent i = getIntent();
        mLogo = i.getStringExtra("logo");
        mProvinsi = i.getStringExtra("provinsi");
        mKota = i.getStringExtra("kota");
        mPulau = i.getStringExtra("pulau");
        mJulukan = i.getStringExtra("julukan");
        mSemboyan = i.getStringExtra("semboyan");
        mHarijadi = i.getStringExtra("harijadi");
        mLuas = i.getStringExtra("luas");
        mLat = i.getStringExtra("lat");
        mLng = i.getStringExtra("lng");
        mKeterangan = i.getStringExtra("keterangan");
        mZonawaktu = i.getStringExtra("zonawaktu");


        imgLogo = (ImageView)findViewById(R.id.img_detail);
        tvKeterangan = (TextView)findViewById(R.id.tv_item_keterangan);
        tvProvinsi = (TextView)findViewById(R.id.tv_provinsi);
        tvKota = (TextView)findViewById(R.id.tv_kota);
        tvPulau = (TextView)findViewById(R.id.tv_pulau);
        tvJulukan = (TextView)findViewById(R.id.tv_julukan);
        tvSemboyan = (TextView)findViewById(R.id.tv_julukan);
        //tvZonawaktu = (TextView)findViewById(R.id.tv_zonawaktu);

        tvProvinsi.setText(mProvinsi);
        tvKota.setText(mKota);
        tvPulau.setText(mPulau);
        tvJulukan.setText(mJulukan);
        tvSemboyan.setText(mSemboyan);
        //tvZonawaktu.setText(mKota);
        tvKeterangan.setText(mKeterangan);

        getSupportActionBar().setTitle(mProvinsi);
        Glide.with(context)
                .load(mLogo)
                .override(150,150)
                .into(imgLogo);

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
        inflater.inflate(R.menu.activity_detail, menu); //inflate our menu
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_kembali:
                finish();
                return true;
            case R.id.menu_home:
                finish();
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
