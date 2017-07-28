package com.lty.uidemo.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.lty.uidemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lty on 2017-7-28.
 */

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewpager = null;
    private int[] mImgIds = new int[]{R.mipmap.b1,
            R.mipmap.b2, R.mipmap.b3};
    private List<ImageView> mImageViews = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewpager);
        initData();

        viewpager = (ViewPager) findViewById(R.id.viewpager);


        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(mImageViews.get(position));
                return mImageViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {

                container.removeView(mImageViews.get(position));
            }


            @Override
            public int getCount() {
                return mImgIds.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });

        viewpager.setPageTransformer(true, new DepthPageTransformer());

    }

    private void initData() {
        for (int imgId : mImgIds) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setLayoutParams(new ViewPager.LayoutParams());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imgId);
            mImageViews.add(imageView);
        }
    }
}
