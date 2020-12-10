package com.aaron.ren.zhuanxiang.java;


//单例模式
public class SingleInstance {

//单例模式
    private static  volatile  SingleInstance  instance;


    //私有构造
    private SingleInstance (){

    }

    public static SingleInstance getInstance(){


        if(instance==null){
            synchronized (SingleInstance.class){
                if(instance==null){
                    instance=new SingleInstance();
                }
            }
        }
        return instance;
    }
}
