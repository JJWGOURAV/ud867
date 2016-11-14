package com.example;

/**
 * Created by GOURAV on 12-11-2016.
 */

public class Joke{

    private boolean isGood;
    private String desc;

    Joke(boolean isGood, String desc){
        this.isGood = isGood;
        this.desc = desc;
    }

    public boolean isGood(){
        return isGood;
    }

    public String getJoke(){
        return desc;
    }
}
