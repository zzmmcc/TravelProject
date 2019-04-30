package com.zz.util;

import java.util.ArrayList;

public class PageUtil<T> {
    /**
     *  //当前页
     *  //每页显示的条数
     *  //总条数
     *装用于分页的数据
     */
    private ArrayList<T> list;
    private int pageNow =1;
    private int pageSize;
    private int pageCount;
    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }


    /***
     *首页
     */
    public int getIndex(){
        return 1;
    }
    /***
     *上一页
     */
    public int getUpPage(){
        int pageUp = pageNow -1;
        if(pageUp<1){
            pageUp=1;
        }
        return pageUp;
    }
    /***
     *总页数
     */
    public int getPageAll(){
        int countpage;
        if(pageCount%pageSize==0){
            countpage  =pageCount/pageSize;
        }else{
            countpage  =pageCount/pageSize+1;
        }
        return  countpage;
    }
    /***
     *下一页
     */
    public int getDownPage(){
        int pageDown = pageNow +1;
        if(pageDown>getPageAll()){
            pageDown=getPageAll();
        }
        return pageDown;
    }
    /***
     *尾页
     */
    public int getLastIndex(){
        return getPageAll();
    }
}