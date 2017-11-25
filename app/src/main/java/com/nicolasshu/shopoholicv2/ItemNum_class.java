package com.nicolasshu.shopoholicv2;

/**
 * Created by nickshu on 11/18/17.
 * This will be used to send messages from one activity to the next.
 * It will store the item number in which the [num] variable and the
 * item one wants to search in [searchQuery] variable.
 *
 * HOW TO USE IT
 * 1) To use it in another activity, declare this class
 *      ItemNum_class itemVariable = MainActivity.itemVariable;
 *
 * 2) To set a new var_Number (int)
 *      itemVariable.setNum(var_Number)
 *
 * 3) To set a new var_searchQuery (String)
 *      itemVariable.setSearchQuery(var_searchQuery)
 *
 * 4) To get the stored number
 *      itemVariable.getNum()
 *
 * 5) To get the stored search query
 *      itemVariable.getSearchQuery()
 */

import android.util.Log;

import java.text.DecimalFormat;

public class ItemNum_class {
    public final DecimalFormat NUM = new DecimalFormat("#");
    private int num;
    private String searchQuery;

    public ItemNum_class(){
        setNum(0);
        setSearchQuery("");
    }

    public void setNum(int newNum){
        if (newNum >=0)
            num = newNum;
    }
    public void setSearchQuery(String newSearchQuery){
        searchQuery = newSearchQuery;
    }
    public int getNum(){
        Log.d("myTag","getNum 1");
        return num;
    }
    public String getSearchQuery(){
        Log.d("mtag","getSearch");
        return searchQuery;
    }
}
