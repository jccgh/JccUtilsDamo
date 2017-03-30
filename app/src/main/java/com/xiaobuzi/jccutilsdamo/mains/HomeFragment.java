package com.xiaobuzi.jccutilsdamo.mains;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.xiaobuzi.jccutilsdamo.R;
import com.xiaobuzi.jccutilsdamo.base.BaseFragment;
import com.xiaobuzi.jccutilsdamo.carousel.CycleViewPager;
import com.xiaobuzi.jccutilsdamo.carousel.Info;
import com.xiaobuzi.jccutilsdamo.load.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JCC on 2017/3/23.
 */

public class HomeFragment extends BaseFragment {

    private View mView;
    private List<Info> mList;
    private CycleViewPager mPager;
    private LoadingDialog mDialog;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            //收到消息，关闭dialog
            if (msg.what == 1) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
            return true;
        }
    });
    private Button mNetBt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.home_fragment_layout, container, false);
        initData();
        initView();
        initEvent();
        return mView;
    }

    private void initEvent() {
        mNetBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    private void initView() {
        mDialog = LoadingDialog.show(getActivity(), "正在加载");
        //3秒后发送广播关掉dialog
        mHandler.sendEmptyMessageDelayed(1, 3000);

        mPager = (CycleViewPager) mView.findViewById(R.id.home_cycleViewPager);
        mNetBt = (Button) mView.findViewById(R.id.home_net_bt);
        assert mPager != null;
        mPager.setIndicators(R.drawable.ad_select, R.drawable.ad_unselect);
        mPager.setDelay(2000);
        Log.d("JCC", "initView: 长度=" + mList.size());
        mPager.setData(mList, mAdCycleViewListener);

    }

    private void initData() {
        if (mList != null) {
            mList.clear();
            mList = null;
        }
        mList = new ArrayList<>();
        mList.add(new Info("标题1", "http://img2.3lian.com/2014/c7/25/d/40.jpg"));
        mList.add(new Info("标题2", "http://img2.3lian.com/2014/c7/25/d/41.jpg"));
        mList.add(new Info("标题3", "http://imgsrc.baidu.com/forum/pic/item/b64543a98226cffc8872e00cb9014a90f603ea30.jpg"));
        mList.add(new Info("标题4", "http://imgsrc.baidu.com/forum/pic/item/261bee0a19d8bc3e6db92913828ba61eaad345d4.jpg"));

    }

    /**
     * 轮播图点击监听
     */
    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

        @Override
        public void onImageClick(Info info, int position, View imageView) {

            if (mPager.isCycle()) {
                position = position - 1;
            }
            Toast.makeText(getActivity(), info.getTitle() + "选择了--" + position, Toast.LENGTH_LONG).show();
        }
    };

    /**
     * 得到轮播图的View
     *
     * @param context
     * @param url
     * @return
     */
    public static View getImageView(Context context, String url) {
        RelativeLayout rl = new RelativeLayout(context);
        //添加一个ImageView，并加载图片
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        //使用Picasso来加载图片
        Glide.with(context).load(url).into(imageView);
        //在Imageview前添加一个半透明的黑色背景，防止文字和图片混在一起
        ImageView backGround = new ImageView(context);
        backGround.setLayoutParams(layoutParams);
        backGround.setBackgroundResource(R.color.cycle_image_bg);
        rl.addView(imageView);
        rl.addView(backGround);
        return rl;
    }
}
