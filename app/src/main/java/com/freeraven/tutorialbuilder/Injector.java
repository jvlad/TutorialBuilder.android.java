package com.freeraven.tutorialbuilder;

import com.freeraven.tutorialbuilder.dataprovider.PageListModelProvider;
import com.freeraven.tutorialbuilder.dataprovider.stub.StubPageListModelProvider;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class Injector {
    public static PageListModelProvider getPageListProvider(){
        return StubPageListModelProvider.getInstance();
    }
}
