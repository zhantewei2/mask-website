package com.ztwx.mask;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(String.valueOf(i));
        }
        for(String s:list){
            System.out.println(s);
        }
    }
}
