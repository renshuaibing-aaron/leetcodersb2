package com.aaron.ren.leet20200913;

public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }

    public static  int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int i=0,j=0;
        while(i<split1.length&&j<split2.length){
            Integer integer1 = Integer.valueOf(split1[i]);
            Integer integer2 = Integer.valueOf(split2[j]);

            System.out.println("====1==="+integer1);
            System.out.println("====2===="+integer2);
            if(integer1>integer2){
              return 1;
            }else if(integer1 <integer2){
                return  -1;
            }else{
               i++;
               j++;
            }

        }

        if(i!=split1.length){
            return -1;
        }
        if(j!=split1.length){
            return 1;
        }
        return  0;
    }
}
