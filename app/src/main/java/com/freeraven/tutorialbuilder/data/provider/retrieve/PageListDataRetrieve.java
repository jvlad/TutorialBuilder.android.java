package com.freeraven.tutorialbuilder.data.provider.retrieve;

import com.freeraven.tutorialbuilder.data.RowData;
import com.freeraven.tutorialbuilder.data.RowDataURI;

import java.io.IOException;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public interface PageListDataRetrieve {
    RowData retrieve(RowDataURI dataURI) throws IOException;
}
