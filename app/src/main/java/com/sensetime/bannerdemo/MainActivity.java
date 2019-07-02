package com.sensetime.bannerdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Banner vp_banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp_banner = findViewById(R.id.vp_banner);

        ArrayList<BannerBean> images = new ArrayList<>();
        images.add(new BannerBean(10,R.drawable.image1));
        images.add(new BannerBean(5,R.drawable.image2));
        images.add(new BannerBean(10,R.drawable.image3));

        MyPageAdapter myPageAdapter = new MyPageAdapter(this,images);
        vp_banner.setAdapter(myPageAdapter);
        vp_banner.setBannerCallback(new Banner.BannerCallback() {
            @Override
            public void playEnd() {
                Toast.makeText(MainActivity.this,"已经到最后",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void click(View view) {
        vp_banner.start(1000);
    }

    class MyPageAdapter extends PagerAdapter{

        public ArrayList<BannerBean> images;
        private Context mContext;

        public MyPageAdapter(Context context,ArrayList<BannerBean> images) {
            this.images = images;
            mContext = context;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            ImageView imageView = new ImageView(mContext);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images.get(position).getImage());
            imageView.setImageBitmap(bitmap);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ImageView)object);
        }
    }
}
