package com.example.yutengfei.easyeatccc.Information;

/**
 * Created by yutengfei on 11/05/16.
 */
public class RestaurantInfo {

    private String name;
    private String type;
    private String time;
    private String description;
    private Float distance;


    public RestaurantInfo(){
        this(null,null,null,null);
    }

    public RestaurantInfo(String name , String type ,String time, String description){
        this.name = name ;
        this.type = type ;
        this.time = time ;
        this.description = description ;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getDistance() {
        return distance;
    }
}
