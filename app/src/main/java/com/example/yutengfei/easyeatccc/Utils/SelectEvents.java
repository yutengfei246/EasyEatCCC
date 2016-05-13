package com.example.yutengfei.easyeatccc.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.yutengfei.easyeatccc.DisplayRestaurants.RestaurantsListSActivity;
import com.example.yutengfei.easyeatccc.R;
import com.example.yutengfei.easyeatccc.SelectMenu.ShopOrderDishesActivity;


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
                view.startAnimation(AnimationUtils.loadAnimation(SelectEvents.this.context, R.anim.click_anim));
                SelectEvents.this.selectEvents(SelectEvents.this.context, v);
            }
        });
    }

    public void selectEvents(Context Context,View view){

        int id = view.getId();
        Bundle key ;

        switch (id){
            case R.id.icon_1:
                key = this.initDRSB(RestaurantsListSActivity.SHOW_DEALS);
                this.startActivity(context,RestaurantsListSActivity.class,key,false);
                break;
            case R.id.icon_2:
                key = this.initDRSB(RestaurantsListSActivity.SHOW_DESSERT);
                this.startActivity(context,RestaurantsListSActivity.class,key,false);
                break;
            case R.id.icon_3:
                key = this.initDRSB(RestaurantsListSActivity.SHOW_MENU);
                this.startActivity(context,RestaurantsListSActivity.class,key,false);
                break;
            case R.id.icon_4:
                key = this.initDRSB(RestaurantsListSActivity.SHOW_PASTA);
                this.startActivity(context,RestaurantsListSActivity.class,key,false);
                break;
            case R.id.icon_5:
                key = this.initDRSB(RestaurantsListSActivity.SHOW_PIZZA);
                this.startActivity(context,RestaurantsListSActivity.class,key,false);
                break;
            case R.id.icon_6:
                key = this.initDRSB(RestaurantsListSActivity.SHOW_SEAFOOD);
                this.startActivity(context,RestaurantsListSActivity.class,key,false);
                break;
            case R.id.icon_7:
                key = this.initDRSB(RestaurantsListSActivity.SHOW_SPECIAL_OFFER);
                this.startActivity(context,RestaurantsListSActivity.class,key,false);
                break;
            case R.id.icon_8:
                key = this.initDRSB(RestaurantsListSActivity.SHOW_VEGERABLE);
                this.startActivity(context,RestaurantsListSActivity.class,key,false);
                break;

            case R.id.details_rest_wrap:
                Toast.makeText(context,"default tem",Toast.LENGTH_SHORT).show();
                this.startActivity(context, ShopOrderDishesActivity.class,null,false);
                break;

            default:
                Toast.makeText(context,"default Item",Toast.LENGTH_SHORT).show();
                break;
        }

        return;

    }


    private void startActivity(Context context,Class theClass,Bundle key, boolean finish){


        if( theClass == RestaurantsListSActivity.class) {

            Intent intent = new Intent(context, theClass);

            if(key != null)
                intent.putExtras(key);

            Activity activity = (Activity) context;
            activity.startActivity(intent);

            if (finish)
                activity.finish();
        }

        return ;

    }

    /*init Display Restaurants liSt Bundle*/
    private Bundle initDRSB(String string){
        Bundle key = new Bundle();
        key.putString(RestaurantsListSActivity.ACTION_SHOW_LIST,string);

        return key;


    }

}