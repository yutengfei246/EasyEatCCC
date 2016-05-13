package com.example.yutengfei.easyeatccc.Utils;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yutengfei.easyeatccc.DisplayRestaurants.RestaurantFragmentS;
import com.example.yutengfei.easyeatccc.Information.StarterJson;
import com.example.yutengfei.easyeatccc.MainActivity;
import com.example.yutengfei.easyeatccc.R;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by yutengfei on 11/05/16.
 */
public class MainArrayAdapter<T> extends ArrayAdapter<T> {

    private List<T> ListData;
    private int resource;
    private Context context;
    private ObjectMapper mapper;

    /*Constructor */
    public MainArrayAdapter(Context context ,int resource, List<T> objects ){
        super(context,resource,objects);

        this.resource = resource;
        this.ListData = objects;
        this.context = context;

    }

    /*Array adapter everything here*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutViewHolder layoutViewHolder = new LayoutViewHolder();
        RetRestViewHolder retRestViewHolder = new RetRestViewHolder();
        Object item = this.ListData.get(position);


        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(this.resource, parent, false);

            if (item instanceof  MainActivity.MainPageItems) {
                layoutViewHolder.linearLayout = (LinearLayout) convertView.findViewById(R.id.listview_linear_layout);
                convertView.setTag(layoutViewHolder);
            }

            if(item instanceof  RestaurantFragmentS.RetRestS){
                retRestViewHolder.Discription = (TextView)convertView.findViewById(R.id.restaurant_dis_1);
                retRestViewHolder.location = (TextView)convertView.findViewById(R.id.restaurant_location_1);
                retRestViewHolder.time = (TextView)convertView.findViewById(R.id.restaurant_time_1);
                retRestViewHolder.theName = (TextView)convertView.findViewById(R.id.restaurant_name_1);
                retRestViewHolder.iv = (ImageView)convertView.findViewById(R.id.image_1);

                convertView.setTag(retRestViewHolder);
            }



        }else{

            if (item instanceof  MainActivity.MainPageItems) {
                layoutViewHolder = (LayoutViewHolder) convertView.getTag();
            }

            if(item instanceof RestaurantFragmentS.RetRestS){
                retRestViewHolder = (RetRestViewHolder) convertView.getTag();
            }
        }


        if (item instanceof MainActivity.MainPageItems) {

            MainActivity.MainPageItems cItem = (MainActivity.MainPageItems) item;


            if (cItem.getTheType() == MainActivity.IS_ICONS) {

                if (layoutViewHolder.linearLayout.findViewById(R.id.icons_wrap) == null) {
                    View child = LayoutInflater.from(getContext()).inflate(R.layout.icons_main, null);
                    this.setIconsListeners(child);
                    layoutViewHolder.linearLayout.addView(child);
                }

            }

            if(cItem.getTheType() == MainActivity.IS_RECOMMAND_RESTAURANT){
                /*Dynamic create Text View */

                File file = cItem.getMenuFile();
                try {
                    JsonNode root = this.mapper.readTree(file);
                    /*parser the root*/
                    int lengths = root.path(StarterJson.NEXT_Id).asInt();

                    for(int i= 1 ;i<lengths ; i++){
                        JsonNode node = root.path(""+i);
                        Iterator iterator  = node.iterator();

                        while(iterator.hasNext()){
                            String str = iterator.next().toString();
                            Log.d("TheIterator", "String + + " + str );
                        }
                    }


                }catch (Exception e){}


                if(layoutViewHolder.linearLayout.findViewById(R.id.listview_wrap) == null){
                    View child = LayoutInflater.from(getContext()).inflate(R.layout.listview_main,null);
                    this.setRestaurantsListeners(child);
                    layoutViewHolder.linearLayout.addView(child);

                }

            }

        }

        if(item instanceof RestaurantFragmentS.RetRestS){

            RestaurantFragmentS.RetRestS cItem =
                    (RestaurantFragmentS.RetRestS)item;

            retRestViewHolder.iv.setImageResource(R.drawable.ii);
            retRestViewHolder.location.setText("LOCATION");
            retRestViewHolder.Discription.setText("DISCRIPTION");
            retRestViewHolder.theName.setText("NAME");
            retRestViewHolder.time.setText("TIME");


        }

        return convertView;

    }


    private void setIconsListeners(View view){
        this.setIconListner ( (ImageView)view.findViewById(R.id.icon_1) ) ;
        this.setIconListner ( (ImageView)view.findViewById(R.id.icon_2) ) ;
        this.setIconListner ( (ImageView)view.findViewById(R.id.icon_3) ) ;
        this.setIconListner ( (ImageView)view.findViewById(R.id.icon_4) ) ;
        this.setIconListner ( (ImageView)view.findViewById(R.id.icon_5) ) ;
        this.setIconListner ( (ImageView)view.findViewById(R.id.icon_6) ) ;
        this.setIconListner ( (ImageView)view.findViewById(R.id.icon_7) ) ;
        this.setIconListner ( (ImageView)view.findViewById(R.id.icon_8) ) ;


    }

    private void setIconListner(ImageView iv){

        SelectEvents selectBuilder = new SelectEvents(iv, this.context);
        selectBuilder.setListener();

    }

    private void setRestaurantsListeners(View view){
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_1));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_2));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_3));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_4));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_5));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_6));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_7));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_8));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_9));
        this.setRestaurantListeners((LinearLayout) view.findViewById(R.id.layout_10));

        this.setRestaurantMoreListener((TextView) view.findViewById(R.id.more));

    }

    private void setRestaurantMoreListener(TextView view){

        SelectEvents selectEvents = new SelectEvents(view,this.context);
        selectEvents.setListener();

    }

    /**************************************************/
    /*should set id in the file */
    private void setRestaurantListeners(LinearLayout linearLayout){

        SelectEvents selectBuilder = new SelectEvents(linearLayout, this.context);
        selectBuilder.setListener();

    }

    static class LayoutViewHolder{

        public LinearLayout linearLayout;
    }

    static class RetRestViewHolder{

        public ImageView iv;
        public TextView theName;
        public TextView time;
        public TextView location;
        public TextView Discription;

    }




}
