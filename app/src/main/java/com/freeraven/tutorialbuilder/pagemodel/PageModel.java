package com.freeraven.tutorialbuilder.pagemodel;

import com.freeraven.tutorialbuilder.pagecomponent.PageComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class PageModel implements Iterable {
    private List<PageComponent> itemList = new ArrayList<>();

    public PageModel add(PageComponent item){
        itemList.add(item);
        return this;
    }

    public PageComponent get(int index){
        return itemList.get(index);
    }

    @Override
    public Iterator<PageComponent> iterator() {
        return itemList.iterator();
    }
}
