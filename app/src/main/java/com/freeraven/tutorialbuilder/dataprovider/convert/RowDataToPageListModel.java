package com.freeraven.tutorialbuilder.dataprovider.convert;

import com.freeraven.tutorialbuilder.dataprovider.RowData;
import com.freeraven.tutorialbuilder.pagemodel.PageListModel;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public interface RowDataToPageListModel {
    PageListModel parse(RowData rowData);
}
