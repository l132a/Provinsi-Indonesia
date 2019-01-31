package com.smartdev.provinsiindonesia;

import java.util.Date;

/**
 * Created by L132A on 23/11/2017.
 */

public class ProvinsiModel {
    private String provinsi, kota, pulau, julukan, semboyan, zonaWaktu, lat, lng, hariJadi,  keterangan, logo, luas;

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public void setPulau(String pulau) {
        this.pulau = pulau;
    }

    public void setJulukan(String julukan) {
        this.julukan = julukan;
    }

    public void setSemboyan(String semboyan) {
        this.semboyan = semboyan;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setHariJadi(String hariJadi) {
        this.hariJadi = hariJadi;
    }

    public void setZonaWaktu(String zonaWaktu) {
        this.zonaWaktu = zonaWaktu;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getKota() {
        return kota;
    }

    public String getPulau() {
        return pulau;
    }

    public String getJulukan() {
        return julukan;
    }

    public String getSemboyan() {
        return semboyan;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getHariJadi() {
        return hariJadi;
    }

    public String getZonaWaktu() { return zonaWaktu;}

    public String getKeterangan() {
        return keterangan;
    }

    public String getLogo() {
        return logo;
    }

    public String getLuas() {
        return luas;
    }
}
