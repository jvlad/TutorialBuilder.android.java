package com.freeraven.tutorialbuilder.dataprovider;

import com.freeraven.tutorialbuilder.dataprovider.convert.RowDataToPageListModel;
import com.freeraven.tutorialbuilder.dataprovider.retrieve.DataRetrieveExceptionHandler;
import com.freeraven.tutorialbuilder.dataprovider.retrieve.RowDataRetrieve;
import com.freeraven.tutorialbuilder.pagemodel.PageListModel;

import java.io.IOException;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public class PageListModelProviderTemplate implements PageListModelProvider {
    private final RowDataURI rowDataURI;
    private final RowDataRetrieve rowDataRetrieve;
    private final RowDataToPageListModel parser;
    private DataRetrieveExceptionHandler exceptionHandler;
    private RowData rowData;
    private PageListModel parsedData;

    public PageListModelProviderTemplate(RowDataRetrieve rowDataRetrieve,
                                         RowDataToPageListModel parser,
                                         RowDataURI rowDataURI,
                                         DataRetrieveExceptionHandler exceptionHandler) {
        this.rowDataRetrieve = rowDataRetrieve;
        this.parser = parser;
        this.rowDataURI = rowDataURI;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public PageListModel getPageListModel() {
        if (parsedData == null) {
            prepareNewData();
        }
        return parsedData;
    }

    @Override
    public void reset() {
        parsedData = null;
        rowData = null;
    }

    @Override
    public void reparseLastRetrievedRowData() {
        parsedData = parser.parse(rowData);
    }

    private void prepareNewData() {
        try {
            rowData = rowDataRetrieve.retrieve(rowDataURI);
        } catch (IOException e) {
            exceptionHandler.handle(e);
        }
        parsedData = parser.parse(rowData);
    }
}
