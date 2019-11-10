package com.Shirol.famcall;

public class CallDetails{
    private String name, callDuration, date;
    int user_id;

    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public String getCallname(){
        return name;
    }
    public void setCallName(String name){
        this.name = name;
    }

    public String getCallDuration(){
        return callDuration;
    }
    public void setCallDuration(String callDuration){
        this.callDuration = callDuration;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
}
