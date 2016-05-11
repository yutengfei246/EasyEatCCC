package com.example.yutengfei.easyeatccc.Utils;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yutengfei on 19/04/16.
 *  used to create FileDir File
 */


public  class FileManager extends Activity {

    public static final String APP_DIRNAME_DIR = "Easy Eat";
    public static final String APP_USER_INFO_DIR = APP_DIRNAME_DIR + File.separator +"User Information";
    public static final String APP_REST_INFO_DIR = APP_DIRNAME_DIR + File.separator + "Restaurant Information";

    public static final String APP_USER_INFO_FILE = APP_USER_INFO_DIR + File.separator + "userInfo.json";
    public static final String APP_REST_INFO_FILE = APP_REST_INFO_DIR + File.separator + "restInfo.json";
    public static final String APP_MEU = APP_REST_INFO_DIR + File.separator + "menuInfo.txt";

    public static final String NAME_NEW_MENU = "new menu";

    private ObjectMapper mapper ;


    public FileManager(){
        this.mapper = new ObjectMapper();
    }

    /*

    public boolean initDirs(){
        this.createDirs(APP_DIRNAME_DIR);
        this.createDirs(APP_USER_INFO_DIR);
        this.createDirs(APP_REST_INFO_DIR);

        return true;
    }

    public File getUserFile() {

        return this.getFile(APP_USER_INFO_FILE, UerInfo.class);

    }

    public File getRestFile(){
        return this.getFile(APP_REST_INFO_FILE, UerInfo.class);
    }

    public InputStream getStreamUserFile(){

        FileInputStream fs = null;
        try {
            fs = new FileInputStream(this.getFile(APP_USER_INFO_FILE, UerInfo.class)) ;
        }catch (IOException e){

        }

        return  fs;
    }

    public OutputStream getStreamRestFile(){

        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(this.getFile(APP_REST_INFO_FILE, UerInfo.class)) ;
        }catch (IOException e){

        }
        return  fs;
    }


    public File getMenu(){

        return this.getFile(APP_MEU, FragmentNewMenu.NewMenu.class);
    }

    private void createEmptyMenuEntry(){


        try{

            ObjectNode menus = this.mapper.createObjectNode();
            JsonNode newMenuTree = this.createEmptyEntry();
            menus.set(NAME_NEW_MENU,newMenuTree);
            this.mapper.writeValue(this.getMenu(), menus);

        }catch (IOException e){}

    }



    public void appendNewMenuEntry(){
        try {
            JsonNode newMenuTree = this.createEmptyEntry();
            JsonNode menus = this.mapper.readTree(this.getMenu());
            ((ObjectNode)menus).set(NAME_NEW_MENU,newMenuTree);
            this.mapper.writeValue(this.getMenu(), menus);
        }catch (IOException e){}

    }

    private JsonNode createEmptyEntry(){

        JsonNode newMenuTree = null;

        try{

            FragmentNewMenu builder = new FragmentNewMenu();
            FragmentNewMenu.NewMenu ob = builder.getInstanceNewMenu();
            String newMenuString = this.mapper.writeValueAsString(ob);
            newMenuTree = this.mapper.readTree(newMenuString);

        }catch (IOException e){}

        return newMenuTree;
    }

    private File getFile(String fileName , Class<?> cls) {
        File info = new File(Environment.getExternalStorageDirectory() + File.separator +  fileName);
        try {

            if (!info.exists()) {
                if (!info.createNewFile() ) {
                    throw new IOException();
                }

                this.initInfoFile(cls);
            } else {
            }
        }catch (IOException e){

        }
        return info;

    }

    private void createDirs(String FileDir){


        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + File.separator + FileDir);
        Log.d("FileUtil", "Dir Path" + mediaStorageDir.getPath());

        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("FileUtil", "failed to create directory");
                return ;
            }
        }else{
            Log.d("FileUtil","Dir Eixt");
        }

    }

    private boolean initInfoFile(Class<?> cls){

        ObjectMapper om = new ObjectMapper();

        if(cls == UerInfo.class) {

            try {
                UerInfo ob = new UerInfo();
                om.writeValue(this.getUserFile(), ob);
            } catch (IOException e) {
                Log.d("FileUtil", "InitInfoFile Exception");

            }
        }

        if(cls == FragmentNewMenu.NewMenu.class){
            this.createEmptyMenuEntry();
        }
        Log.d("FileUtil","InitInfoFile done");

        return  true ;
    }

    */

}