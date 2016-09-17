package com.freeraven.tutorialbuilder.data.provider;

import com.freeraven.tutorialbuilder.data.RowData;
import com.freeraven.tutorialbuilder.data.RowDataURI;
import com.freeraven.tutorialbuilder.data.provider.convert.RowPageListDataConvertException;
import com.freeraven.tutorialbuilder.data.provider.convert.PageListDataConverter;
import com.freeraven.tutorialbuilder.data.provider.retrieve.DataDeliveryExceptionHandler;
import com.freeraven.tutorialbuilder.data.provider.retrieve.PageListDataRetrieve;
import com.freeraven.tutorialbuilder.pagemodel.PageListModel;

import java.io.IOException;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public class PageListModelProviderStrategy implements PageListModelProvider {
    private final RowDataURI rowDataURI;
    private final PageListDataRetrieve pageListDataRetrieve;
    private final PageListDataConverter converter;
    private DataDeliveryExceptionHandler exceptionHandler;
    private RowData rowData;
    private PageListModel parsedData;

    public PageListModelProviderStrategy(PageListDataRetrieve pageListDataRetrieve,
                                         RowDataURI rowDataURI,
                                         PageListDataConverter converter,
                                         DataDeliveryExceptionHandler exceptionHandler) {
        this.pageListDataRetrieve = pageListDataRetrieve;
        this.rowDataURI = rowDataURI;
        this.converter = converter;
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
    public void convertLastRetrievedRowData() {
        try {
            parsedData = converter.convert(rowData);
        } catch (RowPageListDataConvertException e) {
            exceptionHandler.handle(e);
        }
    }

    private void prepareNewData() {
        retrieveData();
        convertLastRetrievedRowData();
    }

    private void retrieveData() {
        try {
            rowData = pageListDataRetrieve.retrieve(rowDataURI);
        } catch (IOException e) {
            exceptionHandler.handle(e);
        }
    }
}
