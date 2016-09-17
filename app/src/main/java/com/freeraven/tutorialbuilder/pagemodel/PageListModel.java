package com.freeraven.tutorialbuilder.pagemodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class PageListModel {
    private List<PageModel> itemList = new ArrayList<>();

    public void add(PageModel item){
        itemList.add(item);
    }

    public PageModel get(int index){
        return itemList.get(index);
    }

    public int size() {
        return itemList.size();
    }
}
