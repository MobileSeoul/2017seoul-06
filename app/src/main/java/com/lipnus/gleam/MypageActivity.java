package com.lipnus.gleam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.lipnus.gleam.etc.IVolleyResult;
import com.lipnus.gleam.etc.VolleyConnect;
import com.lipnus.gleam.model.Mypage;
import com.lipnus.gleam.model.Mypage_list;
import com.lipnus.gleam.mypage.ListViewAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MypageActivity extends AppCompatActivity {

    //내가 가진 화장품들을 보여주는 리스트
    ListView listview;
    ListViewAdapter adapter;

    //서버와의 통신(volley library이용)
    IVolleyResult mResultCallback = null;
    VolleyConnect volley;

    Mypage_list mypageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //리스트뷰와 어댑터
        adapter = new ListViewAdapter();
        listview = (ListView) findViewById(R.id.mypage_listview);
        listview.setAdapter(adapter);

        //volley 콜백
        initVolleyCallback();

        //서버에 접속
        connect();
    }


    public void inputData(String color, int count){
        adapter.addItem(color, count);
        adapter.notifyDataSetChanged();
    }


    public void onClick_mypage(View v){
        Intent intent = new Intent(getApplicationContext(),MypageActivity2.class);
        startActivity(intent);
    }




    public void connect(){

        String url = "http://lipnus.ivyro.net/app/gleam_mypage.php";

        //서버에서 유저아이디 정보에 해당하는 화장품 소지정볼르 가져온다
        Map<String, String> params = new HashMap<>();
        params.put("user_id", "test" );


        //값을 받아올 리스너, Context, url, post로 보낼 것들의 key와 value들을 담은 해쉬맵
        volley = new VolleyConnect(mResultCallback, this, url, params);
    }


    //callback
    void initVolleyCallback(){
        mResultCallback = new IVolleyResult() {
            @Override
            public void notifySuccess(String response) {
                //전송의 결과를 받는 부분
                Log.d("VOVO", "JSON: " + response);

                Gson gson = new Gson();
                mypageList = gson.fromJson(response, Mypage_list.class);

                for(int i=0; i<mypageList.mypage.size(); i++){
                    inputData( mypageList.mypage.get(i).color, mypageList.mypage.get(i).count );
                    Log.d("VOVO", mypageList.mypage.get(i).color + ", " +  mypageList.mypage.get(i).count);
                }

            }

            @Override
            public void notifyError(VolleyError error) {
                //전송 시 에러가 생겼을 때 받는 부분
                Log.d("VOVO", "에러: "+ error);
            }
        };
    }


}
