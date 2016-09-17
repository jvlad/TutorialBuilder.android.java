package com.freeraven.tutorialbuilder.data.provider;

import com.freeraven.tutorialbuilder.pagemodel.PageListModel;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public interface PageListModelProvider {
    PageListModel getPageListModel();
    void reset();
    void convertLastRetrievedRowData();
}
