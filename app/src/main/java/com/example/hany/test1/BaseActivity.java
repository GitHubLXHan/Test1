package com.example.hany.test1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

/**
 * @author 6小h
 * @e-mail 1026310040@qq.com
 * @date 2018/10/19 21:48
 * @filName BaseActivity
 * @describe ...
 */
public class BaseActivity extends AppCompatActivity {

    // Toolbar
    private Toolbar mToolbar;

    // 标题
    private TextView mTitleTxt;

    // 内容布局
    private RelativeLayout mContentLayout;

    //侧边栏内容
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle saveInstancesState) {
        super.onCreate(saveInstancesState);
        setContentView(R.layout.activity_base);
        initView();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * 初始化Toolbar、标题、内容布局、侧边栏内容
     */
    private void initView() {
        mToolbar = findViewById(R.id.toolbar_all);
        mTitleTxt = findViewById(R.id.txt_all_title);
        mContentLayout = findViewById(R.id.layout_all_content);
        mDrawerLayout = findViewById(R.id.drawer_layout);
    }

    /**
     * 添加左上角导航按钮
     *
     * @param isDisplay 是否显示
     * @param picId 图标ID
     */
    public void setDisplayHomeAsUpEnabled(boolean isDisplay, int picId) {
        if (isDisplay) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(isDisplay);
            }
            if (picId != 0) {
                actionBar.setHomeAsUpIndicator(picId);
            }
        }
    }

    /**
     * 左上角导航菜单点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return true;
    }

    /**
     * 添加内容布局
     *
     * @param childLayoutId
     */
    public void setContentLayout(int childLayoutId) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(childLayoutId, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentLayout.addView(contentView, params);
    }


    /**
     * 设置标题内容
     *
     * @param title
     */
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            mTitleTxt.setText(title);
        }
    }

}
