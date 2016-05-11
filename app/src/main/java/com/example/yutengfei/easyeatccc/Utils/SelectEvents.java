package com.example.yutengfei.easyeatccc.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.yutengfei.easyeatccc.R;


/**
 * Created by yutengfei on 13/04/16.
 */
public class SelectEvents {

    private Context context;
    private View view;

    public SelectEvents(View view, Context context){
        this.view = view;
        this.context = context;
    }

    public void setListener(){

        this.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectEvents.this.selectEvents(SelectEvents.this.context, v);
            }
        });
    }

    public void selectEvents(Context Context,View view){

        int id = view.getId();

        switch (id){

            default:
                Toast.makeText(context,"default Item",Toast.LENGTH_SHORT).show();
                break;
        }

        return;

    }


    public void startActivity(Context context,Class theClass, boolean finish){

        Intent intent = new Intent(context,theClass);
        Activity activity = (Activity)context;
        activity.startActivity(intent);
        if(finish)
            activity.finish();



    }
}