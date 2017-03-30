package com.xiaobuzi.jccutilsdamo.mains;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xiaobuzi.jccutilsdamo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationBar mbottomBar;
    private RelativeLayout mlayout;
    private List<Fragment> mListFragment;
    private FragmentManager manager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initEvent();
    }

    private void initData() {
        if (mListFragment == null) {
            mListFragment = new ArrayList<>();
            mListFragment.add(new HomeFragment());
            mListFragment.add(new FootPrintFragment());
            mListFragment.add(new MineFragment());
        }

    }

    private void initEvent() {
        //底部导航的点击时间
        mbottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            //当按钮没有被选中时，点击按钮，调用该方法
            @Override
            public void onTabSelected(int position) {
//                TelephonyManager manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//                String szImei = manager.getDeviceId();
//                int type = manager.getPhoneType();
//                String country = manager.getSimCountryIso();
//                Log.d("JCC", "onTabSelected: Imei=" + szImei + " type = " + type + " country=" + country);
                initFragment(position);

            }

            @Override
            public void onTabUnselected(int position) {
                Log.d("JCC", "onTabUnselected: " + position);
            }

            //当按钮处于被选中状态，继续点击该按钮，则调用该方法
            @Override
            public void onTabReselected(int position) {
                Log.d("JCC", "onTabReselected: " + position);
            }
        });
    }

    private void initView() {
        //初始化控件
        mbottomBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mlayout = (RelativeLayout) findViewById(R.id.main_layout_contain);

        //初始化底部导航
        mbottomBar.setMode(BottomNavigationBar.MODE_DEFAULT);
        mbottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mbottomBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "主页").setActiveColor(R.color.colorAccent).setInActiveColor(R.color.colorYellow))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "足迹").setActiveColor(R.color.colorAccent).setInActiveColor(R.color.colorYellow))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "我的").setActiveColor(R.color.colorAccent).setInActiveColor(R.color.colorYellow))
                .setFirstSelectedPosition(0)
                .initialise();
        //初始化首页
        initFragment(0);

    }

    private void initFragment(int point) {

        FragmentTransaction transaction = manager.beginTransaction();
        if (mListFragment!=null) {
            if (!mListFragment.get(point).isAdded()) {
                transaction.add(R.id.main_layout_contain, mListFragment.get(point));
            }
            for(int i=0;i<mListFragment.size();i++){
                if(i!=point&&mListFragment.get(i).isAdded()){
                    transaction.hide(mListFragment.get(i));
                }
            }
            transaction.show(mListFragment.get(point));
        }
        transaction.commit();
    }
}
