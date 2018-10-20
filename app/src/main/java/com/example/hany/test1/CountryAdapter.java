package com.example.hany.test1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * @author 6小h
 * @e-mail 1026310040@qq.com
 * @date 2018/10/20 17:18
 * @filName CountryAdapter
 * @describe ...
 */
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private List<Country> mCountryList;


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView countryName;
        ImageView countryImage;

        public ViewHolder(View view) {
            super(view);
            countryName = view.findViewById(R.id.txt_country_name);
            countryImage = view.findViewById(R.id.iv_country_image);
        }
    }

    public CountryAdapter(List<Country> list) {
        mCountryList = list;
    }

    /**
     * 用于缓存所有控件用例
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_expand_country, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.countryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Country country = mCountryList.get(position);
                Toast.makeText(view.getContext(), "你点击了" + country.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.countryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positoin = holder.getAdapterPosition();
                Country country = mCountryList.get(positoin);
                Toast.makeText(view.getContext(), "你点击了" + country.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    /**
     * 当子项滚到屏幕内执行
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country country = mCountryList.get(position);
        holder.countryName.setText(country.getName());
        holder.countryImage.setImageResource(country.getImageId());
    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }
}
