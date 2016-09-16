package com.freeraven.tutorialbuilder.dataprovider.retrieve;

import com.freeraven.tutorialbuilder.dataprovider.RowData;
import com.freeraven.tutorialbuilder.dataprovider.RowDataURI;

import java.io.IOException;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public interface RowDataRetrieve {
    RowData retrieve(RowDataURI dataURI) throws IOException;
}
