package com.example.hany.test1;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 6小h
 * @e-mail 1026310040@qq.com
 * @date 2018/10/20 14:26
 * @filName ExpandActivity
 * @describe ...
 */
public class ExpandActivity extends BaseActivity {

    private List<Country> mCountryList = new ArrayList<>();

    protected void onCreate(Bundle saveInstancesState) {
        super.onCreate(saveInstancesState);
        setContentLayout(R.layout.activity_expand);

        setDisplayHomeAsUpEnabled(true, R.drawable.btn_profile); // 调用基类方法，添加左上角导航菜单按钮
        setTitle("拓展页"); // 调用基类setTitle()方法，设置本活动标题

        initCountry();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CountryAdapter adapter = new CountryAdapter(mCountryList);
        recyclerView.setAdapter(adapter);
    }


    // 初始化子项数据内容
    private void initCountry() {
        for (int i=0; i < 30; i++) {
            Country china = new Country("中国", R.drawable.btn_china);
            mCountryList.add(china);
            Country paKistan = new Country("巴基斯坦", R.drawable.btn_pakistan);
            mCountryList.add(paKistan);
            Country argetina = new Country("阿根廷", R.drawable.btn_argentina);
            mCountryList.add(argetina);
            Country unitedState = new Country("美国", R.drawable.btn_unitedstate);
            mCountryList.add(unitedState);
        }
    }



}
