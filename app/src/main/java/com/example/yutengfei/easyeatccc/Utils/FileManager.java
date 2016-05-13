package com.example.yutengfei.easyeatccc.Utils;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import com.example.yutengfei.easyeatccc.Information.RestaurantInfo;
import com.example.yutengfei.easyeatccc.Information.StarterJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

import java.io.IOException;
import java.lang.Exception;


public  class FileManager extends Activity {

    private static final String APP_DIRNAME_DIR = "Easy Eat Ccc";
    private static final String APP_USER_INFO_DIR = APP_DIRNAME_DIR + File.separator +"User Information";
    private static final String APP_REST_INFO_DIR = APP_DIRNAME_DIR + File.separator + "Restaurant Information";

    private static final String APP_USER_INFO_FILE = APP_USER_INFO_DIR + File.separator + "userInfo.json";
    private static final String APP_REST_INFO_FILE = APP_REST_INFO_DIR + File.separator + "restInfo.json";

    private static final String APP_RECOMMEND = APP_REST_INFO_DIR + File.separator + "recommendInfo.txt";
    private static final String APP_DISTANCE = APP_REST_INFO_DIR + File.separator + "distanceInfo.txt";
    private static final String APP_PRICE =  APP_REST_INFO_DIR + File.separator + "priceInfo.txt";
    private static final String APP_TIME =  APP_REST_INFO_DIR + File.separator + "lunchTimeInfo.txt";

    public static final int RESTAURANT_RECOMMEND = 10;
    public static final int RESTAURAND_DISTANCE = 20;
    public static final int RESTAURANT_PRICE = 30;
    public static final int RESTAURANT_LUNCH_TIME = 40;

    private ObjectMapper mapper ;


    public FileManager(){
        this.mapper = new ObjectMapper();
    }


    public File getRestaurant( int key) throws Exception{



        switch (key){
            case RESTAURAND_DISTANCE:
                return this.getFile(APP_DISTANCE);
            case RESTAURANT_LUNCH_TIME:
                return this.getFile(APP_TIME);
            case RESTAURANT_RECOMMEND:
                return  this.getFile(APP_RECOMMEND);
            case RESTAURANT_PRICE:
                return this.getFile(APP_PRICE);

            default:
                throw new Exception("Not find the file");

        }

    }

    public void initFile(){
        this.createDirs(this.APP_DIRNAME_DIR);
        this.createDirs(this.APP_REST_INFO_DIR);

        this.createFile(APP_RECOMMEND,RestaurantInfo.class);
        Log.d("FileManager","initFile()");
    }

    private File getFile(String filePath){
        return  new File(Environment.getExternalStorageDirectory() + File.separator +  filePath);
    }





    /*Method for create the directory , normally is used just once */
    private void createDirs(String FileDir){


        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + File.separator + FileDir);
        Log.d("FileManager", "createDirs() Dir Path" + mediaStorageDir.getPath());

        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("FileManager", "failed to create directory");
                return ;
            }
        }else{
            Log.d("FileManager","createDirs() ");
        }

    }

    /*Method fo create Json files*/
    private File createFile(String fileName , Class<?> cls) {
        File info = new File(Environment.getExternalStorageDirectory() + File.separator +  fileName);
        try {
            if (!info.exists()) {
                if (!info.createNewFile() ) {
                    throw new IOException();
                }
                this.initInfoFile(cls);
            } else {}
        }catch (IOException e){}

        Log.d("FileManager","createFile()");
        return info;
    }


    /*Method that is used to initial JSON file for(RECOMMEND) restaurant  that is used in MAIN activity */

    private boolean initInfoFile(Class<?> cls){

        if(cls == RestaurantInfo.class) {
            try {
                /*create id identity*/
                StarterJson start = new StarterJson();
                this.mapper.writeValue(this.getRestaurant(RESTAURANT_RECOMMEND),start);

                /*now append 20 items*/
                for(int i = 0 ; i<10 ;i++)
                    this.appendNewMenuEntry(cls);


            } catch (Exception e) {
            }
        }
        Log.d("FileManager","initInfoFile() ");

        return  true ;
    }



    public void appendNewMenuEntry(Class<?> cls){

        if(cls == RestaurantInfo.class) {
            try {
                JsonNode newMenuTree = this.createNewEnteryJson(cls);
                JsonNode root = this.mapper.readTree(this.getRestaurant(RESTAURANT_RECOMMEND));

                /*get the next id*/
                int id = root.path(StarterJson.NEXT_Id).asInt();

                /*set new Items */
                ((ObjectNode)root).set(Integer.toString(id), newMenuTree);

                /*updata id*/
                ((ObjectNode)root).put(StarterJson.NEXT_Id,id+1);

                /*updata files */
                this.mapper.writeValue(this.getRestaurant(RESTAURANT_RECOMMEND), root);
            } catch (IOException e) {
            } catch (Exception e) {}

        }

        Log.d("FileManager","appendNewMenuEntry()");
    }



    private JsonNode createNewEnteryJson(Class<?> cls){

        JsonNode newJsonTree = null ;
        if(cls == RestaurantInfo.class) {
            try {
                RestaurantInfo rest = new RestaurantInfo();
                String newTree = this.mapper.writeValueAsString(rest);
                newJsonTree = this.mapper.readTree(newTree);

            } catch (Exception e) {
            }
            Log.d("FileManager", "createNewEnteryJson() ");
        }
        return  newJsonTree;

    }





}