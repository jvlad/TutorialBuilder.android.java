package com.freeraven.tutorialbuilder.data.provider;

import android.content.Context;

import com.freeraven.tutorialbuilder.data.DataFormat;
import com.freeraven.tutorialbuilder.data.DataSourceType;
import com.freeraven.tutorialbuilder.data.RowDataURI;
import com.freeraven.tutorialbuilder.data.provider.convert.DataConverterResolver;
import com.freeraven.tutorialbuilder.data.provider.convert.PageListDataConverter;
import com.freeraven.tutorialbuilder.data.provider.retrieve.DataDeliveryExceptionHandler;
import com.freeraven.tutorialbuilder.data.provider.retrieve.DataRetrieverResolver;
import com.freeraven.tutorialbuilder.data.provider.retrieve.PageListDataRetrieve;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/13/16.
 */
public class ProviderFactory {
    public static PageListModelProvider getPageListProvider(RowDataURI rowDataURI, DataSourceType sourceType, DataFormat format, Context context){
        PageListDataRetrieve retriever = DataRetrieverResolver.resolve(sourceType, context);
        PageListDataConverter converter = DataConverterResolver.resolve(format);
        return new PageListModelProviderStrategy(retriever, rowDataURI, converter, new DataDeliveryExceptionHandler());
//        return StubPageListModelProvider.getInstance();
    }
}
