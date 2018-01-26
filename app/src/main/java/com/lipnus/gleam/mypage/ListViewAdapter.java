package com.lipnus.gleam.mypage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lipnus.gleam.MypageActivity2;
import com.lipnus.gleam.R;

import java.util.ArrayList;

/**
 * Created by Sunpil on 2016-07-13.
 */

public class ListViewAdapter extends BaseAdapter {

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>() ;

    // ListViewAdapter의 생성자
    public ListViewAdapter() {

    }


    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }


    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // menulist.xml을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_mypage, parent, false);
        }

        //------------------------------------------------------------------------------------------
        // 화면에 표시될 View의 구성요소
        //------------------------------------------------------------------------------------------
        ImageView lipsticIv = (ImageView) convertView.findViewById(R.id.mypage_list_iv);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        //------------------------------------------------------------------------------------------
        // 터치 이벤트
        //------------------------------------------------------------------------------------------
        lipsticIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iT = new Intent(context, MypageActivity2.class); // 다음넘어갈 화면
//                iT.putExtra("res_name", listViewItem.getRes_name());
//                iT.putExtra("menu_name", listViewItem.getLeft_menu_name());
                context.startActivity(iT);
            }
        });


        //------------------------------------------------------------------------------------------
        // 아이템 내 각 위젯에 데이터 반영
        //------------------------------------------------------------------------------------------

        int color = 0;

        switch (listViewItem.color){
            case "red":
                color = R.drawable.red;
                break;

            case "pink":
                color = R.drawable.pink;
                break;

            case "coral":
                color = R.drawable.coral;
                break;

            case "nude":
                color = R.drawable.nude;
                break;

            case "etc":
                color = R.drawable.etc;
                break;
        }

        Glide.with(context)
                .load( color )
                .into(lipsticIv);

        return convertView;
    }


    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가
    public void addItem(String color, int count) {

        ListViewItem item = new ListViewItem();
        item.color = color;
        item.count = count;
        listViewItemList.add(item);
    }
}