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
import android.widget.Toast;

import com.example.yutengfei.easyeatccc.MainActivity;
import com.example.yutengfei.easyeatccc.R;

import java.util.List;

/**
 * Created by yutengfei on 11/05/16.
 */
public class MainArrayAdapter<T> extends ArrayAdapter<T> {

    private List<T> ListData;
    private int resource;
    private Context context;

    /*Constructor */
    public MainArrayAdapter(Context context ,int resource, List<T> objects){
        super(context,resource,objects);
        this.resource = resource;
        this.ListData = objects;
        this.context = context;
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }



    /*Array adapter everything here*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(this.resource, parent, false);
        }


        if(this.ListData.get(position) instanceof MainActivity.MainPageItems){

            MainActivity.MainPageItems item =
                    (MainActivity.MainPageItems)getItem(position);

            if(item.getTheType() == MainActivity.IS_ICONS){
                LinearLayout rootLayout = (LinearLayout)convertView.findViewById(R.id.listview_linear_layout);

                View child = LayoutInflater.from(getContext()).inflate(R.layout.icons_main, null);
                this.setIconsListeners(child);


                rootLayout.addView(child);
            }



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




}
