package com.freeraven.tutorialbuilder.data.provider.convert;

import com.freeraven.tutorialbuilder.data.RowData;
import com.freeraven.tutorialbuilder.pagemodel.PageListModel;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public interface PageListDataConverter {
    PageListModel convert(RowData rowData) throws RowPageListDataConvertException;
}
