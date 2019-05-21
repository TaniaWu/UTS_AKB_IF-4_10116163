package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Tanggan Pengerjaan : 18 Mei 2019
 * NIM : 10116163
 * Nama : Anastasia Tania
 * Kelas : IF-4
 */

public class ListViewAdapter extends BaseAdapter {

    //Variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    //Constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mNameTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.adapter_view_layout, null);

            //Locate the views in adapter_view_layout.xmml
            holder.mNameTv = view.findViewById(R.id.textview);
            holder.mIconIv = view.findViewById(R.id.image_icon);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }

        //Set the results into textviews
        holder.mNameTv.setText(modellist.get(position).getNama());

        //Set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(position).getIcon());

        //Listview item click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code later
                if (modellist.get(position).getNama().equals("Emma")){
                    //Start NewActivity with the title for ActionBar and text for TextView
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Emma");
                    intent.putExtra("contentTvId", "10110001");
                    intent.putExtra("contentTvName", "Emma");
                    intent.putExtra("contentTvKelas", "AKB-4");
                    intent.putExtra("contentTvPhone", "08997181891");
                    intent.putExtra("contentTvEmail", "emma@gmail.com");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getNama().equals("Tiffany")){
                    //Start NewActivity with the title for ActionBar and text for TextView
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Tiffany");
                    intent.putExtra("contentTvId", "10110002");
                    intent.putExtra("contentTvName", "Tiffany");
                    intent.putExtra("contentTvKelas", "AKB-4");
                    intent.putExtra("contentTvPhone", "08991237235");
                    intent.putExtra("contentTvEmail", "tiffany@gmail.com");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getNama().equals("Chloe")){
                    //Start NewActivity with the title for ActionBar and text for TextView
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTile", "Chloe");
                    intent.putExtra("contentTvId", "10110003");
                    intent.putExtra("contentTvName", "Chloe");
                    intent.putExtra("contentTvKelas", "AKB-4");
                    intent.putExtra("contentTvPhone", "089912372225");
                    intent.putExtra("contentTvEmail", "chloe@gmail.com");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getNama().equals("Yolan")){
                    //Start NewActivity with the title for ActionBar and text for TextView
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Yolan");
                    intent.putExtra("contentTvId", "10110004");
                    intent.putExtra("contentTvName", "Yolan");
                    intent.putExtra("contentTvKelas", "AKB-4");
                    intent.putExtra("contentTvPhone", "08991767235");
                    intent.putExtra("contentTvEmail", "yolan@gmail.com");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getNama().equals("Rani")){
                    //Start NewActivity with the title for ActionBar and text for TextView
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTile", "Rani");
                    intent.putExtra("contentTvId", "10110005");
                    intent.putExtra("contentTvName", "Rani");
                    intent.putExtra("contentTvKelas", "AKB-4");
                    intent.putExtra("contentTvPhone", "08991657235");
                    intent.putExtra("contentTvEmail", "rani@gmail.com");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getNama().equals("Siti")){
                    //Start NewActivity with the title for ActionBar and text for TextView
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Siti");
                    intent.putExtra("contentTvId", "10110006");
                    intent.putExtra("contentTvName", "Siti");
                    intent.putExtra("contentTvKelas", "AKB-4");
                    intent.putExtra("contentTvPhone", "08987237235");
                    intent.putExtra("contentTvEmail", "siti@gmail.com");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getNama().equals("Savira")){
                    //Start NewActivity with the title for ActionBar and text for TextView
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Savira");
                    intent.putExtra("contentTvId", "10110007");
                    intent.putExtra("contentTvName", "Savira");
                    intent.putExtra("contentTvKelas", "AKB-4");
                    intent.putExtra("contentTvPhone", "08998837235");
                    intent.putExtra("contentTvEmail", "savira@gmail.com");
                    mContext.startActivity(intent);
                }
            }
        });
        return view;
    }

    //Filter
    public void filter (String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length() == 0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getNama().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
