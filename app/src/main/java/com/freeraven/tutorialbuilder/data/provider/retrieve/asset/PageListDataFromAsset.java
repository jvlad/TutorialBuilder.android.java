package com.freeraven.tutorialbuilder.data.provider.retrieve.asset;

import android.content.res.AssetManager;

import com.freeraven.tutorialbuilder.data.RowData;
import com.freeraven.tutorialbuilder.data.provider.retrieve.PageListDataRetrieve;
import com.freeraven.tutorialbuilder.data.RowDataURI;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Vlad Zamskoi (v.zamskoi@gmail.com) on 9/16/16.
 */
public class PageListDataFromAsset implements PageListDataRetrieve {
    private final AssetManager assets;

    public PageListDataFromAsset(AssetManager assets) {
        this.assets = assets;
    }

    @Override
    public RowData retrieve(RowDataURI dataURI) throws IOException {
        InputStream is = assets.open(dataURI.getValue());
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        return composeRowDataResult(new String(buffer, "UTF-8"));
    }

    private RowData composeRowDataResult(String s) {
        RowData rowData = new RowData();
        rowData.setValue(s);
        return rowData;
    }
}
