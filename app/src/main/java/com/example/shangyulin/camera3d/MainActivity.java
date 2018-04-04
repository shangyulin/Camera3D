package com.example.shangyulin.camera3d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Picture> picList = new ArrayList<>();
    private ListView listView;
    private ImageView image;
    private PictureAdapter adapter;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        inits();
        layout = findViewById(R.id.layout);
        listView = findViewById(R.id.pic_list_view);
        image = findViewById(R.id.picture);

        adapter = new PictureAdapter(this, 0, picList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                image.setImageResource(picList.get(i).getImage_id());

                float centerX = layout.getWidth() / 2f;
                float centerY = layout.getHeight() / 2f;
                Rotate3dAnimation rotation = new Rotate3dAnimation(0, 90, centerX, centerY,
                        0f, true);
                rotation.setDuration(1000);
                // 动画完成后保持完成的状态
                rotation.setFillAfter(true);
                rotation.setInterpolator(new AccelerateInterpolator());
                rotation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        listView.setVisibility(View.GONE);
                        image.setVisibility(View.VISIBLE);
                        image.requestFocus();
                        float centerX = layout.getWidth() / 2f;
                        float centerY = layout.getHeight() / 2f;
                        Rotate3dAnimation rotation = new Rotate3dAnimation(270, 360, centerX, centerY,
                                0f, true);
                        rotation.setDuration(1000);
                        // 动画完成后保持完成的状态
                        rotation.setFillAfter(true);
                        rotation.setInterpolator(new AccelerateInterpolator());
                        layout.startAnimation(rotation);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                layout.startAnimation(rotation);
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float centerX = layout.getWidth() / 2f;
                float centerY = layout.getHeight() / 2f;
                Rotate3dAnimation rotation = new Rotate3dAnimation(360, 270, centerX, centerY,
                        0f, true);
                rotation.setDuration(1000);
                // 动画完成后保持完成的状态
                rotation.setFillAfter(true);
                rotation.setInterpolator(new AccelerateInterpolator());
                rotation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        listView.setVisibility(View.VISIBLE);
                        image.setVisibility(View.GONE);
                        listView.requestFocus();
                        float centerX = layout.getWidth() / 2f;
                        float centerY = layout.getHeight() / 2f;
                        Rotate3dAnimation rotation = new Rotate3dAnimation(270, 360, centerX, centerY,
                                0f, true);
                        rotation.setDuration(1000);
                        // 动画完成后保持完成的状态
                        rotation.setFillAfter(true);
                        rotation.setInterpolator(new AccelerateInterpolator());
                        layout.startAnimation(rotation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                layout.startAnimation(rotation);
            }
        });
    }

    private void inits() {
        Picture bird = new Picture("apple", R.drawable.apple);
        picList.add(bird);
        Picture winter = new Picture("banana", R.drawable.banana);
        picList.add(winter);
        Picture autumn = new Picture("cherry", R.drawable.cherry);
        picList.add(autumn);
        Picture greatWall = new Picture("grape", R.drawable.grape);
        picList.add(greatWall);
        Picture waterFall = new Picture("mango", R.drawable.mango);
        picList.add(waterFall);
    }
}
