package com.bugmaker.utils;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
    /**
     * 将一个list均分成n个list,主要通过偏移量来实现的
     * @param source
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=source.size()%n;  //(先计算出余数)
        int number=source.size()/n;  //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < 13; i++){
            list.add("str" + i);
        }
        List<List<String>> lists = averageAssign(list, 2);

        for(List<String> list1 : lists){
            System.out.println(list1);
        }

    }
}
