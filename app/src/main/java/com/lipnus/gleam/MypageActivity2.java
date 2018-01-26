package com.lipnus.gleam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MypageActivity2 extends AppCompatActivity {

    ImageView backgroundIv;

    ImageView my1, my2, my3, my4, my5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage2);

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backgroundIv = (ImageView) findViewById(R.id.mypage_up);

        my1 = (ImageView) findViewById(R.id.mypage_mylipstick1);
        my2 = (ImageView) findViewById(R.id.mypage_mylipstick2);
        my3 = (ImageView) findViewById(R.id.mypage_mylipstick3);
        my4 = (ImageView) findViewById(R.id.mypage_mylipstick4);
        my5 = (ImageView) findViewById(R.id.mypage_mylipstick5);

        Glide.with(this)
                .load(R.drawable.mypage_up)
                .into(backgroundIv);
        backgroundIv.setScaleType(ImageView.ScaleType.FIT_XY);

        inputDermyData();



    }


    public void inputDermyData(){
        Glide.with(this)
                .load(R.drawable.my1)
                .into(my1);
        my1.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(this)
                .load(R.drawable.my2)
                .into(my2);
        my2.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(this)
                .load(R.drawable.my3)
                .into(my3);
        my3.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(this)
                .load(R.drawable.my4)
                .into(my4);
        my4.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(this)
                .load(R.drawable.my5)
                .into(my5);
        my5.setScaleType(ImageView.ScaleType.FIT_XY);
    }


    public void onClick_mypage_select(View v){

        Intent intent = new Intent(getApplicationContext(),MypageActivity3.class);
        startActivity(intent);

    }
}
