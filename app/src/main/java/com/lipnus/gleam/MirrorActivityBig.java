package com.lipnus.gleam;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;


public class MirrorActivityBig extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirror_big);

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        if (null == savedInstanceState) {

            getFragmentManager().beginTransaction()
                    .replace(R.id.container, MirrorActivity.newInstance())
                    .commit();
        }

    }
}
