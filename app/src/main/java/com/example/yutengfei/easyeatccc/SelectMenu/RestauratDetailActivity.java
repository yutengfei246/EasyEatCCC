package com.example.yutengfei.easyeatccc.SelectMenu;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yutengfei.easyeatccc.R;

public class RestauratDetailActivity extends Activity implements View.OnClickListener {

    private RelativeLayout shopDetailsToplayout;
    private ImageView shopDetailsBack;
    private ImageView shopDetailsFavourite;
    private ImageView shopDetailsPhoto;
    private LinearLayout l1;
    private TextView shopDetailsName;
    private ImageView shopDetailsStar;
    private RelativeLayout shopDetailsAddress;
    private ImageView imgOpeningTime;
    private TextView shopOpeningTime;
    private RelativeLayout shopDetailsAddr;
    private ImageView shopAddr;
    private TextView shopAddress;
    private RelativeLayout shopDetailsPhone;
    private ImageView shopPhone;
    private TextView shopPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurat_detail);
        initViwes();
        shopDetailsBack.setOnClickListener(this);
    }

    private void initViwes() {
        shopDetailsToplayout = (RelativeLayout) findViewById(R.id.Shop_details_toplayout);
        shopDetailsBack = (ImageView) findViewById(R.id.Shop_details_back);
        shopDetailsFavourite = (ImageView) findViewById(R.id.Shop_details_favourite);
        shopDetailsPhoto = (ImageView) findViewById(R.id.Shop_details_photo);
        l1 = (LinearLayout) findViewById(R.id.l1);
        shopDetailsName = (TextView) findViewById(R.id.Shop_details_name);
        shopDetailsStar = (ImageView) findViewById(R.id.Shop_details_star);
        shopDetailsAddress = (RelativeLayout) findViewById(R.id.shop_details_address);
        imgOpeningTime = (ImageView) findViewById(R.id.img_opening_time);
        shopOpeningTime = (TextView) findViewById(R.id.shop_openingTime);
        shopDetailsAddr = (RelativeLayout) findViewById(R.id.shop_details_addr);
        shopAddr = (ImageView) findViewById(R.id.shop_addr);
        shopAddress = (TextView) findViewById(R.id.shop_address);
        shopDetailsPhone = (RelativeLayout) findViewById(R.id.shop_details_phone);
        shopPhone = (ImageView) findViewById(R.id.shop_phone);
        shopPhoneNumber = (TextView) findViewById(R.id.shop_phone_number);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Shop_details_back :
                Intent intent = new Intent();
                intent.setClass(RestauratDetailActivity.this, ShopOrderDishesActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Shop_details_favourite://add to favourite restaurant
                // TODO: 13/05/16
                break;
            default:
                break;

        }
    }
}
