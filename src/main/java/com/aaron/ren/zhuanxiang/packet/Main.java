package com.aaron.ren.zhuanxiang.packet;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/24 21:03
 */

public class Main {

    public static void main(String[] args) {

        int[] array={1,2,3,3,4};

        int [] res= getNum(array,5);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }


    public static int[] getNum(int[] array,int num){
        int left=0;
        int right=array.length-1;

        int index=-1;
        while(left<=right){
            int mid=left+right>>1;

            if(array[mid]==num){
                index=mid;
            }
            if(array[mid]<num){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }

        if(index==-1){
            return new int[]{-1,-1};
        }
        int tmp=index;
        while(array[tmp]==num){
            tmp++;
        }
        right=tmp-1;
        while(array[index]==num){
            index--;
        }
        left=index+1;

        return new int[]{left,right};


    }








}
