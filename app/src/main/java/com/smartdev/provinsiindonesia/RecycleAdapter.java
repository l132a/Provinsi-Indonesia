package com.smartdev.provinsiindonesia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by L132A on 26/11/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ProvinsiHolder> {

    private List<ProvinsiModel> listProvinsi;
    private Context context;

    public RecycleAdapter(Context context){
        this.context = context;
    }

    public List<ProvinsiModel> getListProvinsi(){
        return listProvinsi;
    }


    public void setListProvinsi(List<ProvinsiModel> listProvinsi){
        this.listProvinsi = listProvinsi;
    }

    public class ProvinsiHolder extends RecyclerView.ViewHolder{
        TextView tvProvinsi, tvKota, tvPulau;
        ImageView imgLogo, imgFavorite;

        public ProvinsiHolder(View itemView){
            super(itemView);

            tvProvinsi = (TextView)itemView.findViewById(R.id.tv_item_provinsi);
            tvKota = (TextView)itemView.findViewById(R.id.tv_item_kota);
            imgLogo = (ImageView)itemView.findViewById(R.id.img_item);
        }
    }

    @Override
    public ProvinsiHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false );
        ProvinsiHolder holder = new ProvinsiHolder(view);
        view.setOnClickListener(clickListener);
        view.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProvinsiHolder holder, int position){
        final ProvinsiModel provinsiModel = listProvinsi.get(position);

        holder.tvProvinsi.setText(provinsiModel.getProvinsi());
        holder.tvKota.setText(provinsiModel.getKota());
        Glide.with(context)
                .load(provinsiModel.getLogo())
                .override(80,100)
                .centerCrop()
                .into(holder.imgLogo);
    }

    @Override
    public int getItemCount(){
        return listProvinsi.size();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ProvinsiHolder vholder = (ProvinsiHolder)view.getTag();
            int position = vholder.getPosition();

            Intent i = new Intent(context, DetailActivity.class);
            i.putExtra("logo",listProvinsi.get(position).getLogo());
            i.putExtra("keterangan",listProvinsi.get(position).getKeterangan());
            i.putExtra("provinsi",listProvinsi.get(position).getProvinsi());
            i.putExtra("kota",listProvinsi.get(position).getKota());
            i.putExtra("pulau",listProvinsi.get(position).getPulau());
            i.putExtra("julukan",listProvinsi.get(position).getJulukan());
            i.putExtra("semboyan",listProvinsi.get(position).getSemboyan());
            i.putExtra("zonawaktu",listProvinsi.get(position).getZonaWaktu());
            i.putExtra("harijadi",listProvinsi.get(position).getHariJadi());
            context.startActivity(i);
        }
    };
}
