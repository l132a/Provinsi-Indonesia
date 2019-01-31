package com.smartdev.provinsiindonesia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by L132A on 23/11/2017.
 */

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if (database !=null){
            this.database.close();
        }
    }

    public List<ProvinsiModel>getProvinsi(){
        List<ProvinsiModel>listProvinsi = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM provinsi",null);
        StringBuffer stringBuffer = new StringBuffer();
        ProvinsiModel provinsiModel = null;

        while (cursor.moveToNext()){
            provinsiModel = new ProvinsiModel();
            String provinsi = cursor.getString(cursor.getColumnIndexOrThrow("provinsi"));
            String kota = cursor.getString(cursor.getColumnIndexOrThrow("kota"));
            String pulau = cursor.getString(cursor.getColumnIndexOrThrow("pulau"));
            String julukan = cursor.getString(cursor.getColumnIndexOrThrow("julukan"));
            String semboyan = cursor.getString(cursor.getColumnIndexOrThrow("semboyan"));
            String lat = cursor.getString(cursor.getColumnIndexOrThrow("lat"));
            String lng = cursor.getString(cursor.getColumnIndexOrThrow("lng"));
            String keterangan = cursor.getString(cursor.getColumnIndexOrThrow("keterangan"));
            String zonaWaktu = cursor.getString(cursor.getColumnIndexOrThrow("provinsi"));
            String logo = cursor.getString(cursor.getColumnIndexOrThrow("logo"));
            //String luas = cursor.getString(cursor.getColumnIndexOrThrow("luas"));
            //String hariJadi = cursor.getString(cursor.getColumnIndexOrThrow("hariJadi"));

            provinsiModel.setProvinsi(provinsi);
            provinsiModel.setKota(kota);
            provinsiModel.setPulau(pulau);
            provinsiModel.setJulukan(julukan);
            provinsiModel.setSemboyan(semboyan);
            provinsiModel.setLat(lat);
            provinsiModel.setLng(lng);
            provinsiModel.setKeterangan(keterangan);
            provinsiModel.setLogo(logo);
            provinsiModel.setZonaWaktu(zonaWaktu);
            //provinsiModel.setLuas(luas);
            //provinsiModel.setHariJadi(hariJadi);
            stringBuffer.append(provinsiModel);
            listProvinsi.add(provinsiModel);
        }
        cursor.close();
        return listProvinsi;
    }

    public static String formatDateTime(Context context, String timeToFormat) {

        String finalDateTime = "";

        SimpleDateFormat iso8601Format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

        Date date = null;
        if (timeToFormat != null) {
            try {
                date = iso8601Format.parse(timeToFormat);
            } catch (ParseException e) {
                date = null;
            }

            if (date != null) {
                long when = date.getTime();
                int flags = 0;
                flags |= android.text.format.DateUtils.FORMAT_SHOW_TIME;
                flags |= android.text.format.DateUtils.FORMAT_SHOW_DATE;
                flags |= android.text.format.DateUtils.FORMAT_ABBREV_MONTH;
                flags |= android.text.format.DateUtils.FORMAT_SHOW_YEAR;

                finalDateTime = android.text.format.DateUtils.formatDateTime(context,
                        when + TimeZone.getDefault().getOffset(when), flags);
            }
        }
        return finalDateTime;
    }
}
