package com.freeraven.tutorialbuilder.data.provider.retrieve;

import android.content.Context;

import com.freeraven.tutorialbuilder.data.DataSourceType;
import com.freeraven.tutorialbuilder.data.provider.retrieve.asset.PageListDataFromAsset;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/17/16.
 */
public class DataRetrieverResolver {
    public static PageListDataRetrieve resolve(DataSourceType sourceType, Context context) {
        switch (sourceType) {
            case ASSETS:
                return new PageListDataFromAsset(context.getAssets());
            default: throw new UnsupportedDataSourceTypeException();
        }
    }
}
