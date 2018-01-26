package com.lipnus.gleam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class InformationActivity extends AppCompatActivity {

    ImageView backgroundIv;
    private int touchCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        touchCount = 0;

        backgroundIv = (ImageView)findViewById(R.id.infomation_background);
        Glide.with(this)
                .load( R.drawable.ccc1 )
                .into(backgroundIv);
        backgroundIv.setScaleType(ImageView.ScaleType.FIT_XY);

    }

    public void onClick_info(View v){
        if(touchCount == 0){

            Glide.with(this)
                    .load( R.drawable.ccc2 )
                    .into(backgroundIv);
            touchCount = 1;
        }else if(touchCount == 1){
            Glide.with(this)
                    .load( R.drawable.ccc1 )
                    .into(backgroundIv);
            touchCount = 0;
        }


        backgroundIv.setScaleType(ImageView.ScaleType.FIT_XY);

    }
}
