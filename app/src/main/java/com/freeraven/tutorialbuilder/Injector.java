package com.freeraven.tutorialbuilder;

import com.freeraven.tutorialbuilder.dataprovider.PageListProvider;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class Injector {
    public static PageListProvider getPageListProvider(){
        return PageListProvider.getInstance();
    }
}
