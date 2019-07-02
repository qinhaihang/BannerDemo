package com.sensetime.bannerdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * @author qinhaihang_vendor
 * @version $Rev$
 * @time 2019/7/2 16:19
 * @des
 * @packgename com.sensetime.bannerdemo
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes
 */
public class Banner extends ViewPager {

    private BannerCallback mBannerCallback;

    private Runnable player = new Runnable() {
        @Override
        public void run() {
            play();
        }
    };

    public Banner(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

    }

    public void start(long showTime) {
        stop();
        postDelayed(player, showTime);
    }

    private synchronized void play() {
        PagerAdapter pagerAdapter = getAdapter();

        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();

            int currentItem = getCurrentItem();

            if (currentItem < count - 1) {
                currentItem++;
                setCurrentItem(currentItem);
            } else {
                //回调
                currentItem = 0;
                if(mBannerCallback != null) mBannerCallback.playEnd();
            }

        }
    }

    public void stop() {
        removeCallbacks(player);
    }

    public void setBannerCallback(BannerCallback bannerCallback) {
        mBannerCallback = bannerCallback;
    }

    interface BannerCallback {
        void playEnd();
    }

}
